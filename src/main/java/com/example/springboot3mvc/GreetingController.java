package com.example.springboot3mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class GreetingController {

	@GetMapping("/greeting")
	public ResponseEntity<String> greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		log.info("Greeting Called");
		model.addAttribute("name", name);

		if("fail".equals(name)) {
			throw new IllegalArgumentException("Greeting Failed");
		}

		return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
	}
}
