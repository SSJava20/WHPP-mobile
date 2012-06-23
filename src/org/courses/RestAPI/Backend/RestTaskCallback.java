/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.courses.RestAPI.Backend;

/**
 *
 * @author stvad
 */
public abstract class RestTaskCallback
{

    /**
     * Called when the HTTP request completes.
     *
     * @param result The result of the HTTP request.
     */
    public abstract void onTaskComplete(String result);
}
