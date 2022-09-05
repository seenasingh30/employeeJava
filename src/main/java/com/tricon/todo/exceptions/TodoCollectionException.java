package com.tricon.todo.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class TodoCollectionException extends Exception{
    public static final long serialVersionUId = 1L;

    public TodoCollectionException(String message){
        super(message);
    }
    public static String NotFoundException(String id){
        return "Todo with id: " + id + "not found";
    }
    public static String TodoExists(){
        return "Todo with name already exists!";
    }

}
