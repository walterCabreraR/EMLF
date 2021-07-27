package sadr.wacr.com.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel(value="PingResponse", description="response data")
@Data
@AllArgsConstructor
public class PingResponse {
	@ApiModelProperty(required=true, notes="The response message")
    private String responseMessage;
}
