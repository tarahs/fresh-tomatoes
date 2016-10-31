/**
 * 
 */
package com.slalom.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by tara
 * This exception will be thrown in conditions where the error is a recoverable one i.e. the
 * application does not need to be frozen
 */
public class ActionFailureException extends Exception {

    private Object value;
    private Integer status = HttpStatus.INTERNAL_SERVER_ERROR.value();
    public ActionFailureException()
    {
        super();
    }


    public ActionFailureException( String message)
    {
        super(message);
    }

    public ActionFailureException( String message, Object value )
    {
        super(message);
        this.value = value;
    }

    public ActionFailureException( Throwable nested )
    {
        super(nested);
    }

    public ActionFailureException( String message, Throwable nested )
    {
        super(message, nested);
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue( Object value )
    {
        this.value = value;
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
