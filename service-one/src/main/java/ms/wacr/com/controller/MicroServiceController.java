package ms.wacr.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicroServiceController {
	@Value("${microservice-one.value}")
	private String value;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/endpoint")
	public String retrieveLimits() {
		logger.info("inicio de metodo endpoint");
		return this.value;
	}
}
