package zandi.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import zandi.server.dto.SubwayReqDto;
import zandi.server.dto.SubwayResDto;
import zandi.server.service.ApiService;

@RestController
@RequiredArgsConstructor
public class SubwayController {

    private final ApiService apiService;

    @PostMapping(value = "/subway")
    public @ResponseBody ResponseEntity<SubwayResDto> findSubwayInfo(@RequestBody SubwayReqDto subwayDto) {

        switch(subwayDto.getRequestType()) {
            case 1:
                return ResponseEntity.ok(apiService.routeInfo(subwayDto));
            case 2:
                apiService.trainPos(subwayDto);
                break;
            case 3:
                apiService.alarmInit(subwayDto);
                break;
            default:
                return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(new SubwayResDto());
    }
}
