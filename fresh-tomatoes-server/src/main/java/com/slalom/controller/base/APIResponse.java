package com.slalom.controller.base;

import java.io.Serializable;

/**
 * Created by tara
 * Response Object
 * 
 * @param <T>
 */
public class APIResponse<T> implements Serializable {

    private T data;
    private String apiPath;
    private String errorMessage;
    private Integer status = 200;

    public Object getData()
    {
        return data;
    }

    public void setData( T data )
    {
        this.data = data;
    }

    public String getApiPath()
    {
        return apiPath;
    }

    public void setApiPath( String apiPath )
    {
        this.apiPath = apiPath;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage( String errorMessage )
    {
        this.errorMessage = errorMessage;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus( Integer status )
    {
        this.status = status;
    }
}
