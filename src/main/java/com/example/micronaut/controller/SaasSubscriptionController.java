package com.example.micronaut.controller;


import com.example.micronaut.model.SaasSubscriptionDTO;
import com.example.micronaut.model.SaasSubscriptionEntity;
import com.example.micronaut.repository.SaasSubscriptionRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;

@Controller("/api/subscriptions")
public class SaasSubscriptionController {


    private final SaasSubscriptionRepository repository;

    SaasSubscriptionController(SaasSubscriptionRepository repository) {
        this.repository = repository;
    }


    @Post
    HttpResponse<SaasSubscriptionDTO> create(@Body SaasSubscriptionDTO saasDTO) {
        var e = this.repository.save(new SaasSubscriptionEntity(saasDTO));
        return  HttpResponse.status(HttpStatus.CREATED).body(new SaasSubscriptionDTO(e));
    }


    @Get("/{id}")
    HttpResponse<SaasSubscriptionDTO> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(SaasSubscriptionDTO::new)
                .map(HttpResponse::ok)
                .orElseGet(HttpResponse::notFound);
    }
}
