package zandi.server.api;

import org.assertj.core.api.Assertions;
import org.json.simple.JSONArray;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.*;

class ApiParseImplTest {

    ApiParse apiParse = new ApiParseImpl();

    @Test
    void API_연결_테스트() {
        try {
            Method method = apiParse.getClass().getDeclaredMethod("buildURL", String.class, String.class, String.class);
            method.setAccessible(true);

            HttpURLConnection testConnection = (HttpURLConnection) method.invoke(apiParse, "565753674a656e6a3830575555667a", "realtimeStationArrival", "서울");
            System.out.println(testConnection.getResponseCode());
            assertTrue(testConnection.getResponseCode() >= 200 && testConnection.getResponseCode() <= 300);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getSubwayPosByName() {
        JSONArray resultArray = apiParse.getSubwayPosByName("7호선", "태릉입구");
        System.out.println(resultArray.size());
    }

    @Test
    void getSubwayPosByNum() {
    }

    @Test
    void getTimeTable() {
    }
}