package com.groupdocs.ui.comparison.spring.common.exception;

import com.groupdocs.comparison.common.exceptions.PasswordProtectedFileException;
import com.groupdocs.ui.comparison.spring.common.entity.web.ExceptionEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GroupDocsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TotalGroupDocsException.class)
    protected ResponseEntity<ExceptionEntity> handleTotalGroupDocsException(TotalGroupDocsException exception) {
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        String message = exception.getMessage();
        exceptionEntity.setMessage(message);
        if (logger.isDebugEnabled()) {
            exception.printStackTrace();
            exceptionEntity.setException(exception);
        }
        logger.error(exception.getCause() != null ? exception.getCause().getLocalizedMessage() : message);
        return new ResponseEntity<>(exceptionEntity, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PasswordProtectedFileException.class)
    protected ResponseEntity<ExceptionEntity> handlePasswordProtectedFileException(PasswordProtectedFileException exception) {
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        String message = exception.getMessage();
        exceptionEntity.setMessage(message);
        return new ResponseEntity<>(exceptionEntity, HttpStatus.FORBIDDEN);
    }

}
