package org.courses.RestAPI.WorkerApi;

import org.courses.R;
import org.courses.RestAPI.Backend.GetResponseCallback;
import org.courses.RestAPI.Backend.GetTask;
import org.courses.RestAPI.Backend.RestTaskCallback;

public class api 
{
	private static api instance;

	public static api getInstance()
	{
		if(instance == null)
			instance = new api();
		return instance;
	}
	
	public void getMap(String userName, final GetResponseCallback<String> callback)
    {
        String restUrl = 
        new GetTask(restUrl, new RestTaskCallback ()
        {
            @Override
            public void onTaskComplete(String response)
            {
                callback.onDataReceived(response);
            }
        }).execute();
    }
}
