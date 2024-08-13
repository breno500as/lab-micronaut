package com.example.micronaut.controller;


import com.example.micronaut.model.SaasSubscriptionDTO;
import com.example.micronaut.service.SaasSubscriptionService;
import io.micronaut.context.annotation.Value;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import jakarta.validation.Valid;

import java.util.List;

@Controller("/api/subscriptions")
@Validated
public class SaasSubscriptionController {


    @Value("${TESTE_ABC:teste}")
    private String myEnvVariable;


    private final SaasSubscriptionService service;

    SaasSubscriptionController(SaasSubscriptionService service) {
        this.service = service;
    }


    @Post
    HttpResponse<SaasSubscriptionDTO> create(@Valid @Body SaasSubscriptionDTO saasDTO) {
        return HttpResponse.status(HttpStatus.CREATED).body(this.service.save(saasDTO));
    }

    @Put
    HttpResponse<SaasSubscriptionDTO> update(@Valid @Body SaasSubscriptionDTO saasDTO) {
        return HttpResponse.ok(this.service.update(saasDTO));
    }

    @Delete("/{id}")
    HttpResponse<Void> deleteById(@PathVariable Long id) {
        this.service.deleteById(id);
        return HttpResponse.noContent();
    }

    @Get
    HttpResponse<List<SaasSubscriptionDTO>> findAll(Pageable pageable) {
        return HttpResponse.ok(this.service.findAll(pageable));
    }

    @Get("/{id}")
    HttpResponse<SaasSubscriptionDTO> findById(@PathVariable Long id) {
        return HttpResponse.ok(service.findById(id));

    }
}
