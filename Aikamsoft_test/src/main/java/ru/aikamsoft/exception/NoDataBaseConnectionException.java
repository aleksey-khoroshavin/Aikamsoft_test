package ru.aikamsoft.exception;

public class NoDataBaseConnectionException extends Exception{

    public NoDataBaseConnectionException(String message){
        super(message);
    }
}
