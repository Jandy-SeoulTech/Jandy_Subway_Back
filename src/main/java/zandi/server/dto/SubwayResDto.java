package zandi.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
public class SubwayResDto {

    private ArrayList<HashMap<String, String>> routeInfo;
    private String transferStation;
}
