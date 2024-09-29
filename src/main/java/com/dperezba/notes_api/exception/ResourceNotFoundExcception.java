package com.dperezba.notes_api.exception;

public class ResourceNotFoundExcception extends RuntimeException{

    public ResourceNotFoundExcception(){
        super();
    }

    public ResourceNotFoundExcception(String message){
        super(message);
    }
}
