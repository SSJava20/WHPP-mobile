/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.courses.RestAPI.Backend;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.courses.R;

/**
 *
 * @author stvad
 */
/**
 * An AsyncTask implementation for performing POSTs on the Hypothetical REST
 * APIs.
 */
public class PostTask extends AsyncTask<String, String, String>
{

    private String mRestUrl;
    private RestTaskCallback mCallback;
    private String mRequestBody;
    private Context mContext;

    /**
     * Creates a new instance of PostTask with the specified URL, callback, and
     * request body.
     *
     * @param restUrl The URL for the REST API.
     * @param callback The callback to be invoked when the HTTP request
     * completes.
     * @param requestBody The body of the POST request.
     *
     */
    public PostTask(String restUrl, String requestBody, Context vcontext, RestTaskCallback callback)
    {
        this.mRestUrl = restUrl;
        this.mRequestBody = requestBody;
        this.mCallback = callback;
        this.mContext = vcontext;
    }

    @Override
    protected String doInBackground(String... arg0)
    {
    	android.os.Debug.waitForDebugger();
        String response = null;
        try
        {
            //create url...
            //String url;

            response = RestBase.httpPost(mRestUrl, mRequestBody);
        } catch (IOException ex)
        {
            Toast.makeText(mContext, R.string.sent_message_failed, Toast.LENGTH_LONG).show();
            Logger.getLogger(PostTask.class.getName()).log(Level.SEVERE, null, ex);
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
