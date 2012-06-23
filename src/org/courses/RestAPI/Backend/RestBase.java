package org.courses.RestAPI.Backend;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class RestBase
{

    public static String httpGet(String urlStr) throws IOException
    {
        URL url = new URL(urlStr);
        HttpURLConnection conn =
                (HttpURLConnection) url.openConnection();

        if (conn.getResponseCode() != 200)
        {
            throw new IOException(conn.getResponseMessage());
        }

        // Buffer the result into a string
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null)
        {
            sb.append(line);
        }
        rd.close();

        conn.disconnect();
        return sb.toString();
    }

    public static String httpPost(String restURL, String dataToPost) throws Exception
    //, String[] paramName, String[] paramVal) throws Exception
    {
        URL url = new URL(restURL);
        HttpURLConnection conn =
                (HttpURLConnection) url.openConnection();
//        conn.
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setAllowUserInteraction(false);
        conn.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        
        // Create the form content
//        OutputStream out = conn.getOutputStream();
//        Writer writer = new OutputStreamWriter(out, "UTF-8");
//        writer.write(dataToPost);
//        
////        for (int i = 0; i < paramName.length; i++)
////        {
////            writer.write(paramName[i]);
////            writer.write("=");
////            writer.write(URLEncoder.encode(paramVal[i], "UTF-8"));
////            writer.write("&");
////        }
////        writer.write(str)
//        
//        writer.close();
//        out.close();

        if (conn.getResponseCode() != 200)
        {
            throw new IOException(conn.getResponseMessage());
        }

        // Buffer the result into a string
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null)
        {
            sb.append(line);
        }
        rd.close();

        conn.disconnect();
        return sb.toString();
    }
}