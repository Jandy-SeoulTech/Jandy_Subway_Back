package zandi.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

@Getter
@ToString
@AllArgsConstructor
public class SubwayReqDto {

    private int requestType;
    private HashMap<String, String> startStation;
    private HashMap<String, String> endStation;
    private int trainNum;
    private String transferStation;
    private String startTime;
}
