package com.groupdocs.ui.common.exception;

/**
 * The type Api exception.
 */
public class ApiException extends TotalGroupDocsException {

    /**
     * Instantiates a new Api exception.
     *
     * @param message the message
     */
    public ApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Api exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
