package zandi.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class AlarmResDto {

    @ApiModelProperty(example = "62")
    private int durTime;

    @ApiModelProperty(example = "14:22")
    private int arriveTime;

    @ApiModelProperty(example = "2-2")
    private String quickLeft;

    @ApiModelProperty(example = "4-4")
    private String quickTransfer;

    @ApiModelProperty(example = "혼잡")
    private String congestion;

    @ApiModelProperty(example = "2")
    private int transTime;

    @ApiModelProperty(example = "건대입구")
    private String transStationNm;

    private ArrayList<HashMap<String, String>> timeTable;
}
