package zandi.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

@Getter
@ToString
@AllArgsConstructor
public class AlarmReqDto {

    @ApiModelProperty(example = "{stationName: '공릉', route: 7호선}")
    private HashMap<String, String> startStation;

    @ApiModelProperty(example = "{stationName: '강남', route: 2호선}")
    private HashMap<String, String> endStation;

    @ApiModelProperty(example = "{stationName: '건대입구'}")
    private HashMap<String, String> transferStation;

    @ApiModelProperty(example = "12:42")
    private String startTime;
}
