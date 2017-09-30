package com.davidcryer.common.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ApiException extends RuntimeException {

    public ApiException() {}

    public ApiException(Throwable cause) {
        super(cause);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public static class BadRequest extends ApiException {

        public BadRequest() {}

        public BadRequest(final Exception e) {
            super(e);
        }
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class NotFound extends ApiException {

        public NotFound() {}
    }
}
