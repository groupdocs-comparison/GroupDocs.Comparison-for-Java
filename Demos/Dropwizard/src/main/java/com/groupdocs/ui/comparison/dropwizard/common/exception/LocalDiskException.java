package com.groupdocs.ui.comparison.dropwizard.common.exception;

/**
 * The type Api exception.
 */
public class LocalDiskException extends TotalGroupDocsException {

    /**
     * Instantiates a new Api exception.
     *
     * @param message the message
     */
    public LocalDiskException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Api exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public LocalDiskException(String message, Throwable cause) {
        super(message, cause);
    }
}
