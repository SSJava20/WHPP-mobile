//package org.courses.RestAPI.Backend;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//
//public class RESTHelper
//{
//	public static String GetToken(String serviceNamespace, String issuerName, String issuerSecret)
//	{
//		String acsHostName = "";//...//
//		String sbHostName = "";//..//
//		String acsEndpoint = "https://"+serviceNamespace+"-sb."+acsHostName+"/WRAPv0.9/";
//	    //var acsEndpoint = String.Format(@"https://{0}-sb.{1}/WRAPv0.9/", serviceNamespace, acsHostName);
//	    
//	    // Note that the realm used when requesting a token uses the HTTP scheme, even though
//	    // calls to the service are always issued over HTTPS
//	    String realm = "http://"+serviceNamespace+"."+sbHostName+"/";
////		var realm = String.Format(@"http://{0}.{1}/", serviceNamespace, sbHostName);
//	    
//	    Map<String, String> values = new HashMap<String, String>(); 
//	    //var values = new NameValueCollection();
//	    values.put("wrap_name", issuerName);
//	    values.Add("wrap_name", issuerName);
//	    values.Add("wrap_password", issuerSecret);
//	    values.Add("wrap_scope", realm);
//	    WebClient webClient = new WebClient();
//	    
//	    URL rurl = new URL(acsEndpoint);
//	    HttpURLConnection restConnection = (HttpURLConnection) rurl.openConnection();
////	    restConnection.
//	    
//	   
//	    
//	    byte[] response = webClient.UploadValues(acsEndpoint, values);
//	    String responseString = Encoding.UTF8.GetString(response);
//	    var responseProperties = responseString.Split('&');
//	    var tokenProperty = responseProperties[0].Split('=');
//	    var token = Uri.UnescapeDataString(tokenProperty[1]);
//	    return "WRAP access_token=\"" + token + "\"";
//	}
//
//}
