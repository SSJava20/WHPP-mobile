/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.courses.RestAPI.Backend;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.courses.R;

public class GetTask extends AsyncTask<String, String, String>
{

    private String mRestUrl;
    private RestTaskCallback mCallback;
    private Map<String, String> mHparams;
     private Context mContext;

    /**
     * Creates a new instance of GetTask with the specified URL and callback.
     *
     * @param restUrl The URL for the REST API.
     * @param callback The callback to be invoked when the HTTP request
     * completes.
     *
     */
    public GetTask(String restUrl, Context vcontext, Map<String, String> hparams, RestTaskCallback callback)
    {
        this.mRestUrl = restUrl;
        this.mCallback = callback;
        this.mHparams = hparams;
        this.mContext = vcontext;
    }

    @Override
    protected String doInBackground(String... params)
    {
    	
    	android.os.Debug.waitForDebugger();
    	String response = null;
        try
        {
            //create url...
            //String url;

            response = RestBase.httpGet(mRestUrl, mHparams);
        } catch (IOException ex)
        {
            response = ex.getMessage();
//            Toast.makeText(mContext, R.string.sent_message_failed, Toast.LENGTH_LONG).show();
            Logger.getLogger(GetTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Use HTTP Client APIs to make the call.
        //Return the HTTP Response body here.
        return response;
    }

    @Override
    protected void onPostExecute(String result)
    {
        mCallback.onTaskComplete(result);
        super.onPostExecute(result);
    }
}