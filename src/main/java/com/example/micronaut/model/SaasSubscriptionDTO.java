package com.example.micronaut.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Serdeable
@Introspected
public record SaasSubscriptionDTO(Long id,
                                  @NotNull(message = "Name is required") @NonNull @NotEmpty(message = "Name cannot be empty") @NotBlank(message = "Name cannot be blank") String name,
                                  @NotNull(message = "Cents is required") @NonNull Integer cents) {

    public SaasSubscriptionDTO(SaasSubscriptionEntity s) {
        this(s.id(), s.name(), s.cents());
    }

    public SaasSubscriptionDTO(String name, Integer cents) {
        this(null, name, cents);
    }
}
