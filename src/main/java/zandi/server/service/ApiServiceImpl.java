package zandi.server.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import zandi.server.domain.Subway;
import zandi.server.dto.SubwayReqDto;
import zandi.server.dto.SubwayResDto;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService{

    private final Subway subway;

    private ObjectMapper objectMapper = new ObjectMapper();
    private SubwayResDto subwayResDto;

    @Override
    public SubwayResDto routeInfo(SubwayReqDto subwayReqDto) {

        try {
            subwayResDto = new SubwayResDto();
            subwayResDto = objectMapper.readValue(subway.getArriveInfoByName(subwayReqDto.getStartStation().get("stationNum")).toJSONString(), SubwayResDto.class);
            return subwayResDto;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SubwayResDto trainPos(SubwayReqDto subwayReqDto) {
        return null;
    }

    @Override
    public SubwayReqDto alarmInit(SubwayReqDto subwayReqDto) {
        return null;
    }
}
