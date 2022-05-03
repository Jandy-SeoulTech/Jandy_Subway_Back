package zandi.server.api;

import org.json.simple.JSONArray;

public interface ApiParse {

    JSONArray getSubwayPosByName(String route, String statNm);

    JSONArray getSubwayPosByNum(String route);

    JSONArray getTimeTable(String route, String statNm);
}
