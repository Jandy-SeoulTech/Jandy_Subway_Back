package zandi.server.domain;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SubwayImpl implements Subway{

    private final String realTimeKey = "565753674a656e6a3830575555667a";
    private final String generalKey = "7862756769656e6a3130386b44566854";

    @Override
    public JSONObject getStationCdByName(String stationName) {
        return null;
    }

    @Override
    public JSONObject getStationTimeTableByCd(JSONObject requestData) {
        return null;
    }

    @Override
    public JSONObject getArriveInfoByName(String stationName) {
        try {
            URL url = new URL("http://swopenAPI.seoul.go.kr/api/subway/"+realTimeKey+"/json/realtimePosition/0/5/7호선");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); // http 메서드
            connection.setRequestProperty("Content-Type", "application/json"); // header Content-Type 정보

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = br.readLine()) != null) { // 읽을 수 있을 때 까지 반복
                sb.append(line);
            }

            JSONParser parser = new JSONParser();
            Object object = parser.parse(sb.toString());
            JSONObject obj = (JSONObject) object; // json으로 변경 (역직렬화)
            System.out.println(sb);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
