package zandi.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zandi.server.dto.AlarmReqDto;
import zandi.server.dto.AlarmResDto;
import zandi.server.dto.RouteResDto;
import zandi.server.dto.TrainResDto;


@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService{

    @Override
    public RouteResDto routeInfo(String route, String stationName) {
        return null;
    }

    @Override
    public TrainResDto trainPos(int trainNum) {
        return null;
    }

    @Override
    public AlarmResDto alarmInit(AlarmReqDto alarmReqDto) {
        return null;
    }
}
