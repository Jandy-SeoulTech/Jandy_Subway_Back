package zandi.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import zandi.server.dto.SubwayDto;

@RestController
public class SubwayController {



    @PostMapping(value = "/subway")
    public @ResponseBody ResponseEntity<SubwayDto> findSubwayInfo(@RequestBody SubwayDto subwayDto) {
        return ResponseEntity.ok(subwayDto);
    }
}
