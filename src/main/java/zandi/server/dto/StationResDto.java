package zandi.server.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
public class StationResDto {

    ArrayList<HashMap<String, String>> stationInfo;
}
