package zandi.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class RouteResDto {

    private ArrayList<HashMap<String, String>> routeInfo;

    private ArrayList<HashMap<String, String>> arriveInfo;

}
