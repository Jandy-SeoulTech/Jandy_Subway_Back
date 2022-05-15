package zandi.server.service;

import zandi.server.dto.*;

public interface ApiService {

    RouteResDto routeInfo(String route, String stationName);

    TrainResDto trainPos(int trainNum);

    AlarmResDto alarmInit(AlarmReqDto alarmReqDto);

    StationResDto stationInfo(String route);
}
