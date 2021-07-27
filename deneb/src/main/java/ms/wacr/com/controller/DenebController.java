package ms.wacr.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ms.wacr.com.model.PingRequest;
import ms.wacr.com.model.PingResponse;
import ms.wacr.com.service.SadrClient;

@Api
@RestController
@RequestMapping("deneb/")
public class DenebController {
	private static Logger logger = LoggerFactory.getLogger(DenebController.class);

    @Autowired
    private SadrClient sadrClient;

    @RequestMapping(method=RequestMethod.POST, value="pingSadr")
    @ApiOperation(value = "pingSadr", nickname = "pingSadr",response = PingResponse.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 500, message = "Failure") 
            })
    public PingResponse pingSadr(@ApiParam(value = "request", required = true) @RequestBody(required=true) PingRequest request) {

        logger.debug("--> ping received - id: {} - content: {}", request.getId(), request.getMessage());
        return sadrClient.pingSadr(request);
    }
}