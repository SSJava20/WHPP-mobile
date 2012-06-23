package org.courses.RestAPI.TestApi;

import org.courses.RestAPI.Backend.GetResponseCallback;
import org.courses.RestAPI.Backend.GetTask;
import org.courses.RestAPI.Backend.PostResponceCallback;
import org.courses.RestAPI.Backend.PostTask;
import org.courses.RestAPI.Backend.RestTaskCallback;

public class SomeApi 
{
	private static SomeApi instance;
	
	public static SomeApi getInstance()
	{
		if(instance == null)
			instance = new SomeApi();
		return instance;
	}
	
	/**
     * Request a User Profile from the REST server.
     * @param userName The user name for which the profile is to be requested.
     * @param callback Callback to execute when the profile is available.
     */
    public void getUserProfile(String userName, final GetResponseCallback<String> callback)
    {
//        String restUrl = Utils.constructRestUrlForProfile(userName);
//        new GetTask("https://www.google.com/search?hl=en&q=ol", new RestTaskCallback ()
//        {
//            @Override
//            public void onTaskComplete(String response)
//            {
////                Profile profile = Utils.parseResponseAsProfile(response);
//                callback.onDataReceived(response);
//            }
//        }).execute();
    }

    /**
     * Submit a user profile to the server.
     * @param profile The profile to submit
     * @param callback The callback to execute when submission status is available.
     */
//    public void postUserProfile(Profile profile, final PostCallback callback){
//        String restUrl = Utils.constructRestUrlForProfile(profile);
//        String requestBody = Utils.serializeProfileAsString(profile);
//        new PostTask(restUrl, requestBody, new RestTaskCallback(){
//            public void onTaskComplete(String response){
//                callback.onPostSuccess();
//            }
//        });
//    }

}
