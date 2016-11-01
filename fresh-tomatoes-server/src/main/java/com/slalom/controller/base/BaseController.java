package com.slalom.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.slalom.exception.ActionFailureException;

/**
 * Created by tara.
 * Base Controller which has build response implementation which can be
 * inherited from all Controllers
 */
public class BaseController {

    protected <T> ResponseEntity<APIResponse> buildResponse( T t )
    {

        APIResponse response = new APIResponse();
        response.setData(t);
        response.setApiPath(getRequest().getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    protected ResponseEntity<APIResponse> buildError( ActionFailureException e )
    {
        APIResponse response = new APIResponse();
        response.setErrorMessage(e.getMessage());
        response.setApiPath(getRequest().getRequestURI());

        if( e.getStatus() != null )
        {
            response.setStatus(e.getStatus());
            return new ResponseEntity<>(response, HttpStatus.valueOf(e.getStatus()));
        }

        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<APIResponse> buildGlobalError( Exception e )
    {
        return buildError(new ActionFailureException(e.getMessage()));
    }

    protected HttpServletRequest getRequest()
    {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

    }

}
