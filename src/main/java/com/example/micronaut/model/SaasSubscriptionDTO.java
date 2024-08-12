package com.example.micronaut.model;

import io.micronaut.data.annotation.Id;
import io.micronaut.serde.annotation.Serdeable;


@Serdeable
public record SaasSubscriptionDTO(@Id Long id, String name, Integer cents) {

    public SaasSubscriptionDTO(SaasSubscriptionEntity s) {
        this(s.id(), s.name(), s.cents());
    }
}
