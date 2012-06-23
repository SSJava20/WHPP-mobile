package org.courses;

import org.courses.RestAPI.Backend.GetResponseCallback;
import org.courses.RestAPI.Backend.PostResponceCallback;
import org.courses.RestAPI.Backend.RestBase;
import org.courses.RestAPI.TestApi.AzureAPI;
import org.courses.RestAPI.TestApi.SomeApi;
import org.courses.RestAPI.WorkerApi.WorkerApi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.courses.whpp_mobile_nb.R;

/**
 * Created with IntelliJ IDEA.
 * User: stvad
 * Date: 16.06.12
 * Time: 13:32
 * To change this template use File | Settings | File Templates.
 */
public class Messages extends Activity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages);
    }

    public void sendTrackMessage(View view)
    {
        //if Send message
    	WorkerApi wapi = WorkerApi.getInstance();
    	wapi.postPoint(null, 
    			new PostResponceCallback<String>() 
    			{
					@Override
					public void onPostSuccess(String responce) 
					{
						// TODO Auto-generated method stub
						
					}    		
    			});
    }

    public void sendWarningMessage(View view)
    {
        Intent i = new Intent(this, InputWarningMessage.class);
        startActivity(new Intent(getApplicationContext(), InputWarningMessage.class));

    }
}