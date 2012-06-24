package org.courses.RestAPI.WorkerApi;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.courses.R;
import org.courses.RestAPI.Backend.GetResponseCallback;
import org.courses.RestAPI.Backend.GetTask;
import org.courses.RestAPI.Backend.PostResponceCallback;
import org.courses.RestAPI.Backend.PostTask;
import org.courses.RestAPI.Backend.RestTaskCallback;
import org.courses.mobileentity.entity.RouteXML;
import org.courses.mobileentity.entity.RoutepointXML;

import android.content.Context;

public class WorkerApi 
{
	private static WorkerApi instance;

	public static WorkerApi getInstance()
	{
		if(instance == null)
			instance = new WorkerApi();
		return instance;
	}
	
	public void getMap(String userName, Context vcontext, String userPassHash, final GetResponseCallback<String> callback)
    {
        String restUrl = "http://ssfirsttest.cloudapp.net/WHPP-worker/rest/mobile/get_route";
        Map<String, String> hparams = new HashMap<String, String>();
        hparams.put("user_login", userName);
        hparams.put("user_pass", userPassHash);
        
        new GetTask(restUrl, vcontext , hparams, new RestTaskCallback ()
        {
            @Override
            public void onTaskComplete(String response)
            {
                callback.onDataReceived(response);
            }
        }).execute();
    }
	
	public void postPoint(RoutepointXML point, Context vcontext, final PostResponceCallback<String> callback)
	{
		String restUrl = "http://ssfirsttest.cloudapp.net/WHPP-worker/rest/mobile/put_point";

		try 
		{
			
			JAXBContext context = JAXBContext.newInstance(RoutepointXML.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			m.marshal(point, baos);
		
//		m.marshal(point, System.out);
		
			String requestBody =  baos.toString();//Utils.serializeProfileAsString(profile);
			new PostTask(restUrl, requestBody, vcontext, 
					new RestTaskCallback()
			{
				public void onTaskComplete(String response)
				{
					callback.onPostSuccess(response);
				}
			}).execute();
		
		} catch (JAXBException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void postWarningMessage(String message, Context vcontext, final PostResponceCallback<String> callback)
	{
		String restUrl = "http://ssfirsttest.cloudapp.net/WHPP-worker/rest/mobile/put_warning_msg";

		String requestBody =  message;//Utils.serializeProfileAsString(profile);
		new PostTask(restUrl, requestBody, vcontext, 
				new RestTaskCallback()
		{
			public void onTaskComplete(String response)
			{
				callback.onPostSuccess(response);
			}
		}).execute();
		
	}
}
