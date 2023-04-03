package com.example.final_take_it.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String msg){
        super(msg);
    }
}
