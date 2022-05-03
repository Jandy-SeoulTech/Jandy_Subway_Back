package zandi.server.api;

import org.json.simple.JSONArray;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ApiParseImpl implements ApiParse {

    private final String realTimeKey ="565753674a656e6a3830575555667a";
    private final String generalKey = "7862756769656e6a3130386b44566854";
    private StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088");

    private URL buildURL(String key, String service, String option) {
        try {
            urlBuilder.append("/" + URLEncoder.encode(realTimeKey, "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode("json", "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(service, "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode("100", "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(option, "UTF-8"));
            return new URL(urlBuilder.toString());
        } catch (UnsupportedEncodingException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public JSONArray getSubwayPosByName(String route, String statNm) {

        return null;
    }

    @Override
    public JSONArray getSubwayPosByNum(String route) {
        return null;
    }

    @Override
    public JSONArray getTimeTable(String route, String statNm) {
        return null;
    }
}
