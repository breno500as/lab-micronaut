package com.example.micronaut.error;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BaseException(String message, String uri, java.time.LocalDateTime date) {
}
