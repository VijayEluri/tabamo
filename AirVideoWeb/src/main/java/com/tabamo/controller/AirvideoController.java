package com.tabamo.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tabamo.core.airvideo.AVClient;
import com.tabamo.core.airvideo.AVFolder;
import com.tabamo.core.airvideo.AVResource;
import com.tabamo.core.airvideo.AVVideo;

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
	public String airvideo(@RequestParam("location") String location, ModelMap model) {
		AVClient client = new AVClient("127.0.0.1",10011,"0543");
		AVFolder dir = null;
		AVFolder pwd = null;
		
		if(location.length() == 0)
		{
			pwd = new AVFolder(client, "root", null);
		}
		else 
		{
			dir = new AVFolder(client, "root", location);
			pwd = client.cd(dir);
		}
		
		ArrayList <AVResource> items = client.ls(pwd);
		
		ArrayList<AVFolder> folderList = new ArrayList<AVFolder>();
		ArrayList<AVVideo> videoList = new ArrayList<AVVideo>();
		ArrayList<String> videoUrlList = new ArrayList<String>();
		
		for(int i=0;i<items.size();i++) {
			if(items.get(i) instanceof AVFolder) {
				AVFolder folder = (AVFolder)items.get(i);
				folderList.add(folder);

			} else if(items.get(i) instanceof AVVideo) {
				AVVideo video = (AVVideo)items.get(i);
				videoList.add(video);
			}
		}
		
		model.addAttribute("folderList", folderList);
		model.addAttribute("videoList", videoList);
		
		return "index";
	}
	
	@RequestMapping(value = "/airvideolocation", method = RequestMethod.GET)
	public @ResponseBody String test(@RequestParam("location") String location) {
		AVClient client = new AVClient("air.onlink.kr",10011,"0543");
		
		URL url = null;
		try {
			url = client.getUrl(location, false);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url.getPath();
	}
	
	
}
