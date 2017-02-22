package com.dream.common.dto.file;

import java.io.InputStream;

public interface Storage {
    /**
     * @param key
     * @param input
     * @param length
     * @param contentType
     * @return
     */
    void save(String bucket, String key, InputStream input, int length, String contentType) throws StorageException;

    /**
     * @param key
     * @return
     */
    InputStream download(String bucket, String key) throws StorageException;
}

