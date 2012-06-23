package org.courses.RestAPI.WorkerApi;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.courses.R;
import org.courses.RestAPI.Backend.GetResponseCallback;
import org.courses.RestAPI.Backend.GetTask;
import org.courses.RestAPI.Backend.PostResponceCallback;
import org.courses.RestAPI.Backend.PostTask;
import org.courses.RestAPI.Backend.RestTaskCallback;

public class WorkerApi 
{
	private static WorkerApi instance;

	public static WorkerApi getInstance()
	{
		if(instance == null)
			instance = new WorkerApi();
		return instance;
	}
	
	public void getMap(String userName, String userPassHash, final GetResponseCallback<String> callback)
    {
        String restUrl = "http://ssfirsttest.cloudapp.net/WHPP-worker/rest/mobile/get_route";
        Map<String, String> hparams = new HashMap<String, String>();
        hparams.put("user_login", userName);
        hparams.put("user_pass", userPassHash);
        
        new GetTask(restUrl, hparams, new RestTaskCallback ()
        {
            @Override
            public void onTaskComplete(String response)
            {
                callback.onDataReceived(response);
            }
        }).execute();
    }
	
	public void postPoint(stubs.PointToSend point, final PostResponceCallback<String> callback)
	{
		String restUrl = "http://ssfirsttest.cloudapp.net/WHPP-worker/rest/mobile/put_point";
//		JAXBElement<stubs.PointToSend> pt = JAXBElement<>
		String requestBody =  "";//Utils.serializeProfileAsString(profile);
		new PostTask(restUrl, requestBody, 
		new RestTaskCallback()
		{
			public void onTaskComplete(String response)
			{
				callback.onPostSuccess(response);
			}
		}).execute();
	}
}
