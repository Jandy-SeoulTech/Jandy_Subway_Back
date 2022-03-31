package zandi.server.domain;

import org.json.simple.JSONObject;

public class SubwayImpl implements Subway{

    private final String realTimeKey = "6a49796e7a656e6a37376b6d676a4f";
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
        return null;
    }
}
