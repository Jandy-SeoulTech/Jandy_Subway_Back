package zandi.server.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zandi.server.dto.*;
import zandi.server.service.ApiService;

@RestController
@RequiredArgsConstructor
public class SubwayController {

    private final ApiService apiService;

    @ApiOperation(value = "지하철 역 목록 가져오기", notes = "요청한 호선의 역 목록을 알려준다.")
    @GetMapping(value = "/station/{route}")
    public @ResponseBody
    ResponseEntity<StationResDto> stationInfo(@PathVariable String route) {
        return ResponseEntity.ok(apiService.stationInfo(route));
    }

    @ApiOperation(value = "해당 역과 호선의 운행정보 가져오기", notes = "요청한 역과 호선의 운행정보를 알려준다.")
    @GetMapping(value = "/subway/{route}/{stationName}")
    public @ResponseBody ResponseEntity<RouteResDto> routeInfo(@PathVariable String route, @PathVariable String stationName) {

        return ResponseEntity.ok(apiService.routeInfo(route, stationName));
    }

    @ApiOperation(value = "열차 위치정보 가져오기", notes = "열차 번호로 현재 열차가 목적지에 도착하는지 알려준다.")
    @GetMapping(value = "/subway/{route}/{stationName}/{trainNum}")
    public @ResponseBody ResponseEntity<TrainResDto> trainPosition(@PathVariable String route, @PathVariable String stationName, @PathVariable String trainNum) {

        return ResponseEntity.ok(apiService.trainPos(route, stationName, trainNum));
    }

    @ApiOperation(value = "알람 생성에 필요한 정보 가져오기", notes = "출발역과 도착역, 환승역(옵션), 출발시간으로 알람 생성에 필요한 정보를 가져온다.")
    @PostMapping(value = "/subway/alarm")
    public @ResponseBody ResponseEntity<AlarmResDto> alarmInfo(@RequestBody AlarmReqDto alarmReqDto) {

        return ResponseEntity.ok(new AlarmResDto());
    }

}
