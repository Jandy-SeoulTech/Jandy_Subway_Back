package zandi.server.service;

import zandi.server.dto.AlarmReqDto;
import zandi.server.dto.AlarmResDto;
import zandi.server.dto.RouteResDto;
import zandi.server.dto.TrainResDto;

public interface ApiService {

    RouteResDto routeInfo(String route, String stationName);

    TrainResDto trainPos(int trainNum);

    AlarmResDto alarmInit(AlarmReqDto alarmReqDto);
}
