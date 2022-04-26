package zandi.server.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;

@Getter
@ToString
public class SubwayDto {

    private HashMap<String, String> startStation;
    private HashMap<String, String> endStation;
    private int trainNum;
    private String transferStation;
    private String startTime;
}
