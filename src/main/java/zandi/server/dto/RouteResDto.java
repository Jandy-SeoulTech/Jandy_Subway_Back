package zandi.server.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
public class RouteResDto {

    private ArrayList<HashMap<String, String>> routeInfo;

    private ArrayList<HashMap<String, String>> arriveInfo;

}
