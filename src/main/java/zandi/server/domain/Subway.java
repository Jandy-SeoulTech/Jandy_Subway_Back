package zandi.server.domain;


import org.json.simple.JSONObject;

public interface Subway {
    JSONObject getStationCdByName(String stationName);

    JSONObject getStationTimeTableByCd(JSONObject requestData);

    JSONObject getArriveInfoByName(String stationName);
}
