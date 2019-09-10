package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Help {

	// inject via application.properties
	@Value("${config.app.name}")
	private String appName = "";
	@Value("${config.app.version}")
	private String appVersion = "1";

	public String html(String mensagem) {
		String header = "API REST - " + appName + " v" + appVersion + "<br>Acesso em " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		String html = "<!DOCTYPE html><html style=\"height:100%;\">";
		html += "<head><meta charset=\"UTF-8\"><title>" + appName + " v" + appVersion + "</title></head>";
		html += "<body style=\"background-color:#e7f0eb; padding:0; margin:0; height:100%;\">";
		html += "<div style=\"background-color:white; display:block; max-width:800px; margin: 0 auto; height:100%; text-align:center; font-size:110%; font-family:'Courier New'; padding-top:20px;\">";
		html += "<div>" + header + "</div>";
		html += "<div style=\"margin-top:10px;\"><b>" + mensagem + "</b></div>";
		html += "</div></body></html>";
		return html;
	}

}
