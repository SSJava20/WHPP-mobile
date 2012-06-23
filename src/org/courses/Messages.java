package org.courses;

import org.courses.RestAPI.Backend.GetResponseCallback;
import org.courses.RestAPI.Backend.PostResponceCallback;
import org.courses.RestAPI.Backend.RestBase;
import org.courses.RestAPI.TestApi.AzureAPI;
import org.courses.RestAPI.TestApi.SomeApi;

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
    	AzureAPI.getInstance().getAuthorizationToken("WHPPServiceBus", "owner", "OTUSJ7fJBhEqWGwFdunLLbZA/45AeMxeDcSkH+4O418=",
    			new PostResponceCallback<String>() 
    			{
					
					@Override
					public void onPostSuccess(String responce) 
					{
						Toast.makeText(getApplicationContext(), responce, Toast.LENGTH_LONG).show();
						
					}
				});
    	
//		SomeApi myApi = SomeApi.getInstance();
//		myApi.getUserProfile("techie.curious", new GetResponseCallback<String>() 
//				{
//
//		    @Override
//			public
//		    void onDataReceived(String data) 
//		    {
//		    	Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
//		        //Use the profile to display it on screen, etc.
//		    }
//
//		});
//                String res = RestBase.httpGet("https://www.google.com/search?hl=en&q=ol");
//                Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
    }

    public void sendWarningMessage(View view)
    {
        Intent i = new Intent(this, InputWarningMessage.class);
        startActivity(new Intent(getApplicationContext(), InputWarningMessage.class));

    }
}