package org.courses;

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
        //EditText edittext = (EditText) findViewById(R.layout.);
        //if Send message
//        try
//        {
//            AzureMessageManager.sendMessage("warning wheee");
//            Toast.makeText(getApplicationContext(), R.string.sent_warning_message, Toast.LENGTH_LONG).show();
//        } catch (ServiceException e)
//        {
//            Toast.makeText(getApplicationContext(), R.string.sent_message_failed, Toast.LENGTH_LONG).show();
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }

    }
}