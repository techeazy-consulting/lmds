package com.techeazy.lmds.adviseControllers;

public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);
    }

    public ApiException() {
        super();

    }
}
