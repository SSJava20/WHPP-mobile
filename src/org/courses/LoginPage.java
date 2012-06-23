package org.courses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        //FIXME:IMPLEMENT
        return true;

    }
}
