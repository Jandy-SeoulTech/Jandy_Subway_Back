package zandi.server.domain;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface Subway {
    JSONObject getStationCdByName(String stationName);

    JSONObject getStationTimeTableByCd(JSONObject requestData);

    JSONArray getArriveInfoByName(String stationName) throws IOException, ParseException;
}
