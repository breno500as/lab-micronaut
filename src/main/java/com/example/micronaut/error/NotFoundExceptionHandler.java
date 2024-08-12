package com.example.micronaut.error;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Produces
@Singleton
@Requires(classes = {NotFoundException.class, ExceptionHandler.class})
public class NotFoundExceptionHandler implements ExceptionHandler<NotFoundException, HttpResponse<BaseException>>  {

    private static final Logger LOG = LoggerFactory.getLogger(NotFoundExceptionHandler.class);

    @Override
    public HttpResponse<BaseException> handle(HttpRequest request, NotFoundException exception) {
        var error = new BaseException(exception.getMessage(), request.getPath(), LocalDateTime.now());
        LOG.info("Not found exception: {}", error.message());
        return HttpResponse.status(HttpStatus.NOT_FOUND).body(error);
    }
}
