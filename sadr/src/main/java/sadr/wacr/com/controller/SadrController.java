package sadr.wacr.com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import sadr.wacr.com.model.PingRequest;
import sadr.wacr.com.model.PingResponse;

@Api
@RestController
@RequestMapping("sadr/")
@Slf4j
public class SadrController {

	@Value("${user.role}")
	private String role;

	//private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST, value = "ping/")
	@ApiOperation(value = "ping", nickname = "ping", response = PingResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public PingResponse ping(
			@ApiParam(value = "request", required = true) @RequestBody(required = true) PingRequest request) {

		log.debug("--> ping received");
		log.debug("--> id: {}", request.getId());
		log.debug("--> content: {}", request.getMessage());

		return new PingResponse("Hello from Sadr - " + request.getId() + " - " + request.getMessage());
	}
}