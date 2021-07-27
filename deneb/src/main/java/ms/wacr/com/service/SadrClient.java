package ms.wacr.com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ms.wacr.com.model.PingRequest;
import ms.wacr.com.model.PingResponse;

@Service
public class SadrClient {
	 private static Logger logger = LoggerFactory.getLogger(SadrClient.class);

	    private String pingUrl;

	    private RestTemplate restTemplate;

	    @HystrixCommand(fallbackMethod="retrieveFallbackPingSadr")
	    public PingResponse pingSadr(PingRequest pingRequest){

	        logger.debug("--> pingSadr received - id: {} - content: {}", pingRequest.getId(), pingRequest.getMessage());
	        logger.debug("--> sadr endpoint: {}",pingUrl);
	        return restTemplate.postForObject(pingUrl, pingRequest, PingResponse.class);
	    }

	    public PingResponse retrieveFallbackPingSadr(PingRequest pingRequest){
	        return new PingResponse("Error pinging sadr. This is a fallback message");
	    }
}