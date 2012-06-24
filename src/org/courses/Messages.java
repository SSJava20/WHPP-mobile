package org.courses;

import org.courses.RestAPI.Backend.GetResponseCallback;
import org.courses.RestAPI.Backend.PostResponceCallback;
import org.courses.RestAPI.Backend.RestBase;
import org.courses.RestAPI.TestApi.AzureAPI;
import org.courses.RestAPI.TestApi.SomeApi;
import org.courses.RestAPI.WorkerApi.WorkerApi;
import org.courses.mobileentity.entity.RouteXML;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
//import org.courses.whpp_mobile_nb.R;
import javax.xml.bind.JAXBException;

/**
 * Created with IntelliJ IDEA.
 * User: stvad
 * Date: 16.06.12
 * Time: 13:32
 * To change this template use File | Settings | File Templates.
 */
public class Messages extends Activity
{
	public static final String ROUTE = "whee";
	private RouteXML activeRoute;
	
    public void onCreate(Bundle savedInstanceState)
    {
    	try 
        {
    		super.onCreate(savedInstanceState);
    		setContentView(R.layout.messages);
    		Bundle extras = getIntent().getExtras();
    		String routeString = extras.getString(ROUTE);
        
			JAXBContext context = JAXBContext.newInstance(RouteXML.class);
			Unmarshaller handler = context.createUnmarshaller();
			// Get the object

			InputStream bais = new ByteArrayInputStream(routeString.getBytes());
			activeRoute = (RouteXML) handler.unmarshal(bais);
			
			if(!(activeRoute == null) && !activeRoute.getRoutepointList().isEmpty())
				changeName(activeRoute.getRoutepointList().get(0).getName());
			else
				arrive();
		} catch (JAXBException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
    protected void arrive() 
    {
		Button btn = (Button) findViewById(R.id.btSendTrackMsg);
		btn.setActivated(false);
		Toast.makeText(getApplicationContext(), R.string.arrived, Toast.LENGTH_LONG).show();
	} 
    
    protected void changeName(String name)
    {
    	TextView tw = (TextView) findViewById(R.id.pointName);
    	tw.setText(name);
    }

    public void sendTrackMessage(View view)
    {
        //if Send message
    	WorkerApi wapi = WorkerApi.getInstance();
    	if(!(activeRoute == null) && !activeRoute.getRoutepointList().isEmpty())
    	{
    		wapi.postPoint(activeRoute.getRoutepointList().get(0), getApplicationContext(), 
    				new PostResponceCallback<String>() 
    				{
    					@Override
    					public void onPostSuccess(String responce) 
    					{
    						Toast.makeText(getApplicationContext(), R.string.sent_message, Toast.LENGTH_LONG).show();
    						activeRoute.getRoutepointList().remove(0);
    						
    						if(activeRoute.getRoutepointList().isEmpty())
    						{
    							arrive();
    						}
    					}

						   		
    				});
    	} else
    		arrive();
    }

    public void sendWarningMessage(View view)
    {
        Intent intent = new Intent(this, InputWarningMessage.class);
        startActivity(intent);

    }
}