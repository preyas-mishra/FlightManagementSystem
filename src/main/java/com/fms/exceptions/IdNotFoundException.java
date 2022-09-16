package com.fms.exceptions;

/**
 * This Class is used to handle the exception will be raised
 * when the id of the user doesn't gets fetched.
 **/

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String msg)
    {
        super(msg);
    }

}
