package zandi.server.service;

import org.junit.jupiter.api.Test;
import zandi.server.api.ApiParseImpl;
import zandi.server.dto.RouteResDto;


import static org.junit.jupiter.api.Assertions.*;

class ApiServiceImplTest {

    private final ApiService apiService = new ApiServiceImpl(new ApiParseImpl());

    @Test
    void routeInfo() {
        RouteResDto test = apiService.routeInfo("우이신설선", "보문");
        assertNotNull(test.getArriveInfo());
        assertNotNull(test.getRouteInfo());
    }
}