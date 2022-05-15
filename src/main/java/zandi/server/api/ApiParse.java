package zandi.server.api;

import org.json.simple.JSONArray;

import java.util.ArrayList;

public interface ApiParse {

    JSONArray getSubwayPosByName(String route, String statNm);

    JSONArray getSubwayPosByNum(String route);

    JSONArray getTimeTable(String route, String statNm);

    JSONArray getStationList(String route);
}
