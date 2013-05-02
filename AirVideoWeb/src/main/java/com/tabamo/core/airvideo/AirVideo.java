package com.tabamo.core.airvideo;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class AirVideo {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//		// TODO Auto-generated method stub
//		Initializer.init();
//
//	    LoggerManager.getInstance().setDebug(true);
//	    
//		ClassRegistry.getInstance().registerClass(Request.class);
//		ClassRegistry.getInstance().registerClass(Response.class);
//
//		HttpClient httpclient = new DefaultHttpClient();
//
//		HttpPost httppost = new HttpPost("http://localhost:45631/service");
//
//		httppost.addHeader("User-Agent",
//				"AirVideo/2.2.4 CFNetwork/459 Darwin/10.0.0d3");
//		httppost.addHeader("Accept", "*/*");
//		httppost.addHeader("Accept-Language", "en-us");
//		httppost.addHeader("Accept-Encoding", "gzip, deflat");
//
//		Request req = new Request();
//		List<Object> param = new ArrayList();
//		param.add(null);
//
//		req.setPasswordDigest("9E8709DFEA8CA68B333650150B3398914D124927");
//		req.setRequestURL("http://127.0.0.1:45631/service");
//		req.setServiceName("browseService");
//		req.setClientIdentifier("89eae483355719f119d698e8d11e8b356525ecfb");
//		req.setClientVersion(221);
//		req.setMethodName("getItems");
//		req.setParameters(param);
//
//		// methodNamegetItemsclientVersion221requestURLhttp://127.0.0.1:45631/serviceclientIdentifier89eae483355719f119d698e8d11e8b356525ecfbserviceNamebrowseServiceparameterspasswordDigest9E8709DFEA8CA68B333650150B3398914D124927
//
//		ByteArrayOutputStream out = serialize(req);
//
//		httppost.setEntity(new ByteArrayEntity(out.toByteArray()));
//
//		DefaultHttpClient client = new DefaultHttpClient();
//		try {
//			HttpResponse response = client.execute(httppost);
//
//			System.out.println(response);
//			System.out.println(response.getEntity().getContentLength());
//			//System.out.println(EntityUtils.toString(response.getEntity()));
//
//			ByteArrayInputStream in = new ByteArrayInputStream(
//					EntityUtils.toByteArray(response.getEntity()));
//
//			DataInputStream inputStream = new DataInputStream(in);
//			ObjectDeserializer deserializer = new ObjectDeserializer(
//					inputStream);
//			Response svrResponse = (Response) deserializer.deserialize();
//
//			System.out.println(svrResponse.getErrorMessage());
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		AVClient client = new AVClient("air.onlink.kr",10011,"0543");
		
		
		AVFolder pwd = new AVFolder(client, "root", "6b95f36b-fc26-4e3f-bb53-819e06501d4d\1. íë\1. ë°©ìì¤").cd();
		ArrayList <AVResource> items = pwd.ls();
		
		System.out.println(items.size());
		AVFolder folder = (AVFolder)items.get(0);
		ArrayList <AVResource> items1 = folder.ls();
		
		System.out.println(folder.location);
		System.out.println(folder.name);
	}

}
