package sadr.wacr.com.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel(value="PingRequest", description="request data")
@Data
@AllArgsConstructor
public class PingRequest {
	@ApiModelProperty(required=true, notes="The request id")
	private long id;
	@ApiModelProperty(required=true, notes="The request message")
    private String message;
}
