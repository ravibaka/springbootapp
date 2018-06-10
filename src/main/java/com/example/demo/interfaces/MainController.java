package com.example.demo.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = "/springboot", method = RequestMethod.GET)
	public String home() {
		return "index.html";
	}
}
