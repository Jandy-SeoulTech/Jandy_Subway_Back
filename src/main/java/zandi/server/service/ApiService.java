package zandi.server.service;

import zandi.server.dto.SubwayReqDto;
import zandi.server.dto.SubwayResDto;

public interface ApiService {

    SubwayResDto routeInfo(SubwayReqDto subwayReqDto);

    SubwayResDto trainPos(SubwayReqDto subwayReqDto);

    SubwayReqDto alarmInit(SubwayReqDto subwayReqDto);
}
