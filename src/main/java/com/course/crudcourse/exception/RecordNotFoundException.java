package com.course.crudcourse.exception;

public class RecordNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1l;

    public RecordNotFoundException(Long id){
        super("Registro não encontrado com id: " + id);
    }

}
