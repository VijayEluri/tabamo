package com.tabamo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tabamo.core.airvideo.AVClient;
import com.tabamo.core.airvideo.AVFolder;
import com.tabamo.core.airvideo.AVResource;

@Controller
@RequestMapping("/")
public class AirvideoController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message",
				"Maven Web Project + Spring 3 MVC - welcome()");

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";
	}
	
	@RequestMapping(value = "/airvideo", method = RequestMethod.GET)
	public String airvideo(ModelMap model) {

		
		//AVClient client = new AVClient("127.0.0.1",10011,"0543");
		AVClient client = new AVClient("127.0.0.1",45631,"1234");
		
		
		AVFolder pwd = new AVFolder(client, "root", null);
		ArrayList <AVResource> items = client.ls(pwd);
		
		System.out.println(items.get(0) instanceof AVFolder);
		
		System.out.println(items.size());
		AVFolder folder = (AVFolder)items.get(0);
		
		System.out.println(folder.location);
		System.out.println(folder.name);
		
		model.addAttribute("message",
				folder.location + folder.name + 
				" 한글이 깨지");
		
		model.addAttribute("message1",
				" 테트트스스 xxxx 깨지");
		
		for(int i=0;i<items.size();i++) {
			
		}

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";
	}
	
	
}
