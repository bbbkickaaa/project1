package com.olaenmanijo.weatherbasedtravelplanner.MainPage;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainPageController {
	
	@Autowired
	GetNowWeatherService service;
	
	@Autowired
	ProudConetentService service2;
	
	
	@GetMapping("/main")
	public String main(Model model, HttpSession session) {
		
	    Object user = session.getAttribute("user");
	    model.addAttribute("isLoggedIn", user != null);
	    
	    
	    String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	    String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH00"));
        
        model.addAttribute("currentDate", currentDate);
        model.addAttribute("currentTime", currentTime);
	    
	    List<GetNowWeatherDTO> list = service.getNowWeatherMap();
	    String weatherList = service.getNowWeather();
	    String weatherList2 = service.getMediumWeather();
	    model.addAttribute("weatherList", weatherList);
	    model.addAttribute("weatherList2", weatherList2);
	    model.addAttribute("list",list);
	    
	    System.out.println(list);
	    
	    List<GetRecommendDTO> list2 = service2.community();
	    model.addAttribute("list2",list2);
	    
	    return "mainPage/main";
	}
	
	
	
	
	

}
