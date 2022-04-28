package zandi.server.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import zandi.server.dto.SubwayReqDto;
import zandi.server.dto.SubwayResDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class SubwayImpl implements Subway {

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
    public JSONArray getArriveInfoByName(String stationName) throws IOException, ParseException {
        StringBuilder urlBuilder = new StringBuilder("http://swopenAPI.seoul.go.kr/api/subway"); /*URL*/
        urlBuilder.append("/" + URLEncoder.encode(realTimeKey, "UTF-8")); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
        urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8")); /*요청파일타입 (xml,xmlf,xls,json) */
        urlBuilder.append("/" + URLEncoder.encode("realtimePosition", "UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
        urlBuilder.append("/" + URLEncoder.encode("0", "UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
        urlBuilder.append("/" + URLEncoder.encode("100", "UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
        // 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.
        urlBuilder.append("/" + URLEncoder.encode(stationName, "UTF-8"));
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
        BufferedReader rd;

        // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(sb.toString());
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray jsonObjects = (JSONArray) jsonObject.get("realtimePositionList");
        System.out.println(jsonObject.toString());
        JSONArray resultObjects = new JSONArray();
        for (Object object : jsonObjects) {
            JSONObject temp = (JSONObject) object;
            JSONObject temp1 = new JSONObject();
            temp1.put("statnNm", temp.get("statnNm"));
            temp1.put("trainNo", temp.get("trainNo"));
            temp1.put("statnTnm", temp.get("statnTnm"));
            temp1.put("trainSttus", temp.get("trainSttus"));
            temp1.put("directAt", temp.get("directAt"));
            temp1.put("updnLine", temp.get("updnLine"));
            temp1.put("lstcarAt", temp.get("lstcarAt"));
            resultObjects.add(temp1);
        }
        return resultObjects;
    }
}
