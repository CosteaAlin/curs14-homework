package ro.fasttrackit.exceptions;

public class InvalidIdException extends RuntimeException{
    public InvalidIdException(String msg){
        super(msg);
    }
}
