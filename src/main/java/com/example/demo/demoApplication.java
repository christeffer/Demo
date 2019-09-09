package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.util.Help;
import com.example.demo.util.Const;

@Controller
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableScheduling
@RequestMapping(Const.ROOT)
public class demoApplication {
	

	@Autowired
	private Help help;
	

	public static void main(String[] args) {
		SpringApplication.run(demoApplication.class, args);
	}

	@GetMapping(value = "/", headers = "Accept=text/html")
	public ResponseEntity<String> serviceIndex() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("api", "true");
		return new ResponseEntity<String>(help.html("Acesso Restrito"), responseHeaders, HttpStatus.OK);
	}

	@PostConstruct
	public void init() {
				
		
	}

}
