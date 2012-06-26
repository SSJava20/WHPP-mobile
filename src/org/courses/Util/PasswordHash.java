package org.courses.Util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash 
{
	public static String getHash(String pass)
	{
		return bin2hex(getBinaryHash(pass));
	}
	
	static byte[] getBinaryHash(String password) 
	{
	       MessageDigest digest=null;
	    try 
	    {
	        digest = MessageDigest.getInstance("MD5");
	    } catch (NoSuchAlgorithmException e1) 
	    {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    }
	       digest.reset();
	       return digest.digest(password.getBytes());
	 }
	
	static String bin2hex(byte[] data) 
	{
	    return String.format("%0" + (data.length*2) + "X", new BigInteger(1, data));
	}
}
