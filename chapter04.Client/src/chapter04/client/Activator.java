package chapter04.client;

import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import chapter04.searchengine.SearchEngine;

public class Activator implements BundleActivator {

	ServiceReference reference;
	SearchEngine engine;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		reference = context.getServiceReference(SearchEngine.class.getName());
		
		engine = (SearchEngine) context.getService(reference);
		
		List result = engine.search("query string");
		
		System.out.println(result);
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		context.ungetService(reference);
		
		engine = null;
	}

}
