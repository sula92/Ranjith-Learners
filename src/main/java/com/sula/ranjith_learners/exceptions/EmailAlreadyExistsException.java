package com.sula.ranjith_learners.exceptions;

import com.sula.ranjith_learners.model.Exam;

public class EmailAlreadyExistsException extends Exception {

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
