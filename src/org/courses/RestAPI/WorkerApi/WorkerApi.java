package org.courses.RestAPI.WorkerApi;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.courses.R;
import org.courses.RestAPI.Backend.GetResponseCallback;
import org.courses.RestAPI.Backend.GetTask;
import org.courses.RestAPI.Backend.PostResponceCallback;
import org.courses.RestAPI.Backend.PostTask;
import org.courses.RestAPI.Backend.RestTaskCallback;
import org.courses.mobileentity.entity.RouteXML;
import org.courses.mobileentity.entity.RoutepointXML;

import android.content.Context;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class WorkerApi
{

    private static WorkerApi instance;

    public static WorkerApi getInstance()
    {
        if (instance == null)
        {
            instance = new WorkerApi();
        }
        return instance;
    }

    public void getMap(String userName, String userPassHash, Context vcontext, final GetResponseCallback<String> callback)
    {
        String restUrl = "http://ssfirsttest.cloudapp.net/WHPP-worker-web/rest/mobile/get_route";
        Map<String, String> hparams = new HashMap<String, String>();
        hparams.put("user_login", userName);
        hparams.put("user_pass", userPassHash);

        new GetTask(restUrl, vcontext, hparams, new RestTaskCallback()
        {

            @Override
            public void onTaskComplete(String response)
            {
                callback.onDataReceived(response);
            }
        }).execute();
    }

    public void postPoint(String userName, String userPassHash, RoutepointXML point, Context vcontext, final PostResponceCallback<String> callback)
    {
        try
        {
            String restUrl = "http://ssfirsttest.cloudapp.net/WHPP-worker-web/rest/mobile/put_point";


            Map<String, String> hparams = new HashMap<String, String>();
            hparams.put("user_login", userName);
            hparams.put("user_pass", userPassHash);
            Serializer serializer = new Persister();
            //            File result = new File("example.xml");

            OutputStream baos = new ByteArrayOutputStream();

            serializer.write(point, baos);

            //		m.marshal(point, System.out);

            String requestBody = baos.toString();//Utils.serializeProfileAsString(profile);
            new PostTask(restUrl, requestBody, hparams, vcontext,
                    new RestTaskCallback()
                    {

                        public void onTaskComplete(String response)
                        {
                            callback.onPostSuccess(response);
                        }
                    }).execute();
        } catch (Exception ex)
        {
            Logger.getLogger(WorkerApi.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public void postWarningMessage(String userName, String userPassHash, String message, Context vcontext, final PostResponceCallback<String> callback)
    {
        String restUrl = "http://ssfirsttest.cloudapp.net/WHPP-worker-web/rest/mobile/put_warning_msg";

        Map<String, String> hparams = new HashMap<String, String>();
        hparams.put("user_login", userName);
        hparams.put("user_pass", userPassHash);

        String requestBody = message;//Utils.serializeProfileAsString(profile);
        new PostTask(restUrl, requestBody, hparams, vcontext,
                new RestTaskCallback()
                {

                    public void onTaskComplete(String response)
                    {
                        callback.onPostSuccess(response);
                    }
                }).execute();

    }
}
