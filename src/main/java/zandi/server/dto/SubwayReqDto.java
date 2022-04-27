package zandi.server.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

@Getter
@Setter
@ToString
public class SubwayReqDto {

    private HashMap<String, String> startStation;
    private HashMap<String, String> endStation;
    private int trainNum;
    private String transferStation;
    private String startTime;
}
