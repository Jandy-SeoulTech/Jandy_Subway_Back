package zandi.server.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import zandi.server.api.ApiParse;
import zandi.server.api.ApiParseImpl;
import zandi.server.dto.*;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {

    private final ApiParse apiParse;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public RouteResDto routeInfo(String route, String stationName) {
        JSONArray arriveData = apiParse.getSubwayPosByName(route, stationName);
        JSONArray routeData = apiParse.getSubwayPosByNum(route);
        RouteResDto resultDto = new RouteResDto();
        ArrayList<HashMap<String, String>> arriveResult = new ArrayList<>();
        ArrayList<HashMap<String, String>> routeResult = new ArrayList<>();
        JSONObject obj = new JSONObject();
        JSONObject temp;
        for (Object arriveDatum : arriveData) {
            temp = (JSONObject) arriveDatum;
            obj.put("statNm", temp.get("statnNm"));
            obj.put("updnLine", temp.get("updnLine"));
            obj.put("arriveTime", temp.get("barvlDt"));
            obj.put("congestion", "null");
            obj.put("statTnm", temp.get("bstatnNm"));
            obj.put("btrainSttus", temp.get("btrainSttus"));
            obj.put("trainNo", temp.get("btrainNo"));
            arriveResult.add(objectMapper.convertValue(obj, HashMap.class));
        }
        resultDto.setArriveInfo(arriveResult);
        obj.clear();
        for (Object routeDatum : routeData) {
            temp = (JSONObject) routeDatum;
            obj.put("statnNm", temp.get("statnNm"));
            obj.put("trainNo", temp.get("trainNo"));
            obj.put("updnLine", temp.get("updnLine"));
            switch (temp.get("trainSttus").toString()) {
                case "0":
                    obj.put("trainSttus", "진입");
                    break;
                case "1":
                    obj.put("trainSttus", "도착");
                    break;
                default:
                    obj.put("trainSttus", "출발");
            }
            obj.put("directAt", temp.get("directAt"));
            obj.put("lstcarAt", temp.get("lstcarAt"));
            routeResult.add(objectMapper.convertValue(obj, HashMap.class));
        }
        resultDto.setRouteInfo(routeResult);
        return resultDto;
    }

    @Override
    public TrainResDto trainPos(int trainNum) {
        return null;
    }

    @Override
    public AlarmResDto alarmInit(AlarmReqDto alarmReqDto) {
        return null;
    }

    @Override
    public StationResDto stationInfo(String route) {
        StationResDto stationResDto = new StationResDto();
        ArrayList<HashMap<String, String>> returnArray = new ArrayList<>();
        JSONArray jsonArray = apiParse.getStationList(route);
        for (Object station : jsonArray) {
            returnArray.add(objectMapper.convertValue(station, HashMap.class));
        }
        stationResDto.setStationInfo(returnArray);
        return stationResDto;
    }
}
