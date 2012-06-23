package org.courses;

import org.courses.RestAPI.Backend.GetResponseCallback;
import org.courses.RestAPI.WorkerApi.WorkerApi;
import org.courses.Util.PasswordHash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void checkLogin(View view)
    {
        if(auth())
        {
            Intent i = new Intent(this, Messages.class);
		    startActivity(new Intent(getApplicationContext(), Messages.class));
        }
        //view.getLayoutParams().
    }

    protected Boolean auth()
    {
    	EditText  edLog = (EditText) findViewById(R.id.loginEdit);
    	EditText  edPass = (EditText) findViewById(R.id.passEdit);
    	
        WorkerApi wapi = WorkerApi.getInstance();
        wapi.getMap(edLog.getText().toString(), PasswordHash.getHash(edPass.getText().toString()), 
        new GetResponseCallback<String>() 
       	{
			
			@Override
			public void onDataReceived(String data) 
			{
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
			}
		});
        
        return true;

    }
}
