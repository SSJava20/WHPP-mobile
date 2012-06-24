package org.courses;

import org.courses.RestAPI.Backend.PostResponceCallback;
import org.courses.RestAPI.WorkerApi.WorkerApi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: stvad
 * Date: 16.06.12
 * Time: 13:35
 * To change this template use File | Settings | File Templates.
 */
public class InputWarningMessage extends Activity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputwarningmessage);
    }

    public void sendWarningMessage(View view)
    {
    	EditText msgEdit = (EditText) findViewById(R.id.inputWarning);
    	
    	WorkerApi wapi = WorkerApi.getInstance();
    	wapi.postWarningMessage(msgEdit.getText().toString(), getApplicationContext(), 
    			new PostResponceCallback<String>() 
    			{
			
					@Override
					public void onPostSuccess(String responce) 
					{
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), R.string.sent_warning_message, Toast.LENGTH_LONG).show();
					}
    			});
    }
}