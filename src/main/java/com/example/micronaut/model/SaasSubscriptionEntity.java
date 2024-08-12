package com.example.micronaut.model;


import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@MappedEntity
public record SaasSubscriptionEntity(@Id @GeneratedValue(value = GeneratedValue.Type.IDENTITY ) Long id,
                                     String name,
                                     Integer cents) {

    public SaasSubscriptionEntity(String name, Integer cents) {
        this(null, name, cents);
    }

    public SaasSubscriptionEntity(SaasSubscriptionDTO saasSubscriptionDTO) {
        this(saasSubscriptionDTO.id(), saasSubscriptionDTO.name(), saasSubscriptionDTO.cents());
    }
}
