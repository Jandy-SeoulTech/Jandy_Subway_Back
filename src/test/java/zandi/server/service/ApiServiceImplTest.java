package zandi.server.service;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestExecutionListeners;
import zandi.server.api.ApiParseImpl;
import zandi.server.dto.RouteResDto;
import zandi.server.dto.TrainResDto;


import static org.junit.jupiter.api.Assertions.*;

class ApiServiceImplTest {

    private final ApiService apiService = new ApiServiceImpl(new ApiParseImpl());

    @Test
    void routeInfo() {
        RouteResDto test = apiService.routeInfo("우이신설선", "보문");
        assertNotNull(test.getArriveInfo());
        assertNotNull(test.getRouteInfo());
    }

    @Test
    void arriveInfo() {
        TrainResDto test = apiService.trainPos("7호선", "공릉", "7133");
        assertTrue(test.getStatus().equals("접근중"));
    }
}