/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.courses.RestAPI.Backend;

import android.os.AsyncTask;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetTask extends AsyncTask<String, String, String>
{

    private String mRestUrl;
    private RestTaskCallback mCallback;

    /**
     * Creates a new instance of GetTask with the specified URL and callback.
     *
     * @param restUrl The URL for the REST API.
     * @param callback The callback to be invoked when the HTTP request
     * completes.
     *
     */
    public GetTask(String restUrl, RestTaskCallback callback)
    {
        this.mRestUrl = restUrl;
        this.mCallback = callback;
    }

    @Override
    protected String doInBackground(String... params)
    {
    	
    	android.os.Debug.waitForDebugger();
    	//android.os.Debug.waitingForDebugger()
        String response = null;
        try
        {
            //create url...
            //String url;

            response = RestBase.httpGet(mRestUrl);
        } catch (IOException ex)
        {
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