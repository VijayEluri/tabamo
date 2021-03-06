package chapter04.naver;

import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import chapter04.searchengine.SearchEngine;

public class Activator implements BundleActivator {
	private SearchEngine service;
	private ServiceRegistration registration;
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		Dictionary props = new Properties();
		
		props.put(org.osgi.framework.Constants.SERVICE_VENDOR, "Naver");
		props.put("searchble", "Text,Image,Code");
		props.put(org.osgi.framework.Constants.SERVICE_RANKING, 5);
		
		service = new Naver();
		
		registration = context.registerService(SearchEngine.class.getName(), service, props);
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		
	}

}
