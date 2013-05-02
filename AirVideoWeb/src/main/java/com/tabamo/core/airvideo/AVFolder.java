package com.tabamo.core.airvideo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class AVFolder extends AVResource {
	public AVFolder(AVClient server, String name, String location) {
		this.server = server;
		this.name = name;
		if (location == null) {
			this.location = null;
		} else {
			this.location = "/" + location;			
		}
		
		
	}
	
	public AVFolder cd () {
		return this.server.cd(this);
	}
	
	public ArrayList<AVResource> ls () {
		return this.server.ls(this);
	}
	
	
}
