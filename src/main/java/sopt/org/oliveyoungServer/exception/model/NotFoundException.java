package sopt.org.oliveyoungServer.exception.model;

import sopt.org.oliveyoungServer.exception.Error;

public class NotFoundException extends SoptException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}
