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

    private String uid;
    private String uPassHash;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void checkLogin(View view)
    {
        EditText edLog = (EditText) findViewById(R.id.loginEdit);
        EditText edPass = (EditText) findViewById(R.id.passEdit);

        Toast.makeText(getApplicationContext(), R.string.try_login, Toast.LENGTH_LONG).show();
        authAndGetMap(edLog.getText().toString(), edPass.getText().toString());
        //view.getLayoutParams().
    }

    protected void authAndGetMap(String userId, String userPass)
    {
        WorkerApi wapi = WorkerApi.getInstance();
        uid = userId;
        uPassHash = PasswordHash.getHash(userPass);
        wapi.getMap(userId, uPassHash, getApplicationContext(),
                new GetResponseCallback<String>()
                {

                    @Override
                    public void onDataReceived(String data)
                    {
                        if(data.equals("Received authentication challenge is null"))
                        {
                            Toast.makeText(getApplicationContext(), R.string.unauthorized, Toast.LENGTH_LONG).show();
                            return;
                        }else if(data.equals("400"))
                        {
                            Toast.makeText(getApplicationContext(), R.string.no_data, Toast.LENGTH_LONG).show();
                            return;
                        }
                        // TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), Messages.class);

                        intent.putExtra(Messages.ROUTE, data);
                        intent.putExtra(Messages.UID, uid);
                        intent.putExtra(Messages.UPASSH, uPassHash);

                        startActivity(intent);
                    }
                });

    }
}
