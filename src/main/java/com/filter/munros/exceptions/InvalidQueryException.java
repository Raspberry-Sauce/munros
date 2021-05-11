package com.filter.munros.exceptions;

public class InvalidQueryException extends Exception {
  public InvalidQueryException(String error){
    super(error);
  }
}
