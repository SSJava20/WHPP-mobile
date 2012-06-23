package org.courses.RestAPI.TestApi;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.courses.RestAPI.Backend.PostResponceCallback;
import org.courses.RestAPI.Backend.PostTask;
import org.courses.RestAPI.Backend.RestTaskCallback;

public class AzureAPI 
{
	private static AzureAPI instance;
	
	public static AzureAPI getInstance()
	{
		if(instance == null)
			instance = new AzureAPI();
		return instance;
	}
	
	public String getAuthorizationToken(String serviceNamespace, String issuerName, 
			  String issuerPassword, final PostResponceCallback<String> callback)
	{
		String authorizationToken = null;
		String acsBaseAddress = "https://" + serviceNamespace + "-sb.accesscontrol.windows.net";
		String relyingPartyAddress = "http://" + serviceNamespace + ".servicebus.windows.net";
		
		try 
		{
			String postData = "wrap_scope=" + URLEncoder.encode(relyingPartyAddress, "UTF-8") +
							  "&wrap_name=" + URLEncoder.encode(issuerName, "UTF-8") +
							  "&wrap_password=" + URLEncoder.encode(issuerPassword, "UTF-8");
			
			new PostTask(acsBaseAddress, postData, new RestTaskCallback() 
				{
		            public void onTaskComplete(String response)
		            {
		                callback.onPostSuccess(response);
		            }
		        }).execute();    
			
			
		} catch (UnsupportedEncodingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return authorizationToken;
	}
}
