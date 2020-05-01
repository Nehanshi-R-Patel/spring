package com.xworkz.logging.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoggerController {

	private static final Logger logger = Logger.getLogger(LoggerController.class);

	public LoggerController() {
		logger.warn("Created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("/msg.do")
	public String getMessage(ModelMap map) {
		System.out.println("SOUT :: Inside getMessage()");

		logger.info("This is an Info Log Entry...!");
		logger.error("This is an Error Log Entry...!");
		
		try {
			new Throwable("Custom Exception");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		map.addAttribute("message", "Hello All....");
		return "Welcome";
	}
}
