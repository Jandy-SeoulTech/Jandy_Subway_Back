package zandi.server.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainResDto {

    @ApiModelProperty(example = "접근중")
    private String status;

}
