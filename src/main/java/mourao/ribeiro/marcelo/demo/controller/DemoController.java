package mourao.ribeiro.marcelo.demo.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DemoController {
	
	@Value("${microservices.other:http://localhost:8080/demo/sum}")
	private String other;
	
	private final static Logger logger = LoggerFactory.getLogger(DemoController.class);

	@CircuitBreaker(name = "other", fallbackMethod = "fallbackForOther")
	@GetMapping(value="other", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> other() {
		RestTemplate rest = new RestTemplate();
		
		final int min = 1;
		
		final int max = 20;
		
		Integer a = min + new Random().nextInt(max - min + 1);
		
		Integer b = new Random().nextInt(2) + 5;
		
		logger.info("Calling " + this.other+"?a="+a+"&b="+b);
		
		String body = rest.getForEntity(this.other+"?a="+a+"&b="+b, String.class).getBody();
		
		return ResponseEntity.ok(Integer.parseInt(body));
	}
	
	public ResponseEntity<String> fallbackForOther(Throwable t) {
        logger.error("Inside fallbackForGetSeller, cause - {}", t.toString());
        return ResponseEntity.ok("Sorry ... Service not available!!!");
    }
	
	@GetMapping(value="sum", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> sum(@RequestParam(required = true) Integer a, @RequestParam(required = true) Integer b) {
		logger.info("Summing " + a + " + " + b);
		
		return ResponseEntity.ok(a + b);
	}
}
