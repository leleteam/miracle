package com.dream.common.dto.file;

public class StorageException extends Exception {
    public StorageException(Throwable cause) {
        super(cause);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}

