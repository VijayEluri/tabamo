package com.tabamo.core.airvideo;

public class AVResource {
	public AVClient server;
	public String name;
	public String location;

	public AVClient getServer() {
		return server;
	}

	public void setServer(AVClient server) {
		this.server = server;
	}

	public AVResource() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}