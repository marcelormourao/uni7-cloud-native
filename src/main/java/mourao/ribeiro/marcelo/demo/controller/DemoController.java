package mourao.ribeiro.marcelo.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping(value="sum", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> sum(@RequestParam(required = true) Integer a, @RequestParam(required = true) Integer b) {
		return ResponseEntity.ok(a + b);
	}
}
