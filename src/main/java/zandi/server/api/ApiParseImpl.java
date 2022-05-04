package zandi.server.api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ApiParseImpl implements ApiParse {

    private final String realTimeKey = "565753674a656e6a3830575555667a";
    private final String generalKey = "7862756769656e6a3130386b44566854";
    private StringBuilder urlBuilder;
    private JSONParser jsonParser = new JSONParser();

    private JSONArray routeInfo;

    public ApiParseImpl() {
        try {
            routeInfo = (JSONArray) jsonParser.parse(new FileReader("src/main/resources/routeInfo.json"));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpURLConnection buildURL(String key, String service, String option) {
        try {
            urlBuilder = new StringBuilder("http://swopenAPI.seoul.go.kr/api/subway");
            urlBuilder.append("/" + URLEncoder.encode(key, "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(service, "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode("100", "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(option, "UTF-8"));

            HttpURLConnection conn = (HttpURLConnection) (new URL(urlBuilder.toString())).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            return conn;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private StringBuilder getData(HttpURLConnection conn) {
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();
            return sb;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public JSONArray getSubwayPosByName(String route, String statNm) {
        StringBuilder data = getData(buildURL(realTimeKey, "realtimeStationArrival", statNm));
        JSONArray returnArray = new JSONArray();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(data.toString());
            JSONArray jsonArray = (JSONArray) jsonObject.get("realtimeArrivalList");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject object = (JSONObject) jsonArray.get(i);
                String temp = object.get("ordkey").toString();
                String endStation = temp.substring(5, temp.length() - 1);
                for (Object o : routeInfo) {
                    JSONObject info = (JSONObject) o;
                    String infoRoute = info.get("호선").toString();
                    if(infoRoute.startsWith("0")) {
                        infoRoute = infoRoute.substring(1);
                    }
                    if(endStation.equals(statNm)) continue;
                    if (endStation.equals(info.get("전철역명")) && route.equals(infoRoute) && (object.get("barvlDt") != "0")) {
                        System.out.println(infoRoute);
                        System.out.println(info.get("전철역명"));
                        returnArray.add(object);
                    }
                }
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return returnArray;
    }

    @Override
    public JSONArray getSubwayPosByNum(String route) {
        StringBuilder data = getData(buildURL(realTimeKey, "realtimePosition", route));
        JSONArray returnArray = new JSONArray();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(data.toString());
            returnArray = (JSONArray) jsonObject.get("realtimePositionList");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnArray;
    }

    @Override
    public JSONArray getTimeTable(String route, String statNm) {
        return null;
    }
}
