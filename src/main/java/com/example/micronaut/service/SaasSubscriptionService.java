package com.example.micronaut.service;

import com.example.micronaut.error.NotFoundException;
import com.example.micronaut.model.SaasSubscriptionDTO;
import com.example.micronaut.model.SaasSubscriptionEntity;
import com.example.micronaut.repository.SaasSubscriptionRepository;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Sort;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class SaasSubscriptionService {

    private final SaasSubscriptionRepository repository;

    private static final Sort CENTS = Sort.of(Sort.Order.asc("cents"));

    SaasSubscriptionService(SaasSubscriptionRepository repository) {
        this.repository = repository;
    }

    public SaasSubscriptionDTO findById(Long id) {
        return this.repository.findById(id).map(SaasSubscriptionDTO::new).orElseThrow(() -> new NotFoundException("Subscription Not Found Exception"));

    }

    public SaasSubscriptionDTO save(SaasSubscriptionDTO saasDTO) {
        var e = this.repository.save(new SaasSubscriptionEntity(saasDTO.name(), saasDTO.cents()));
        return new SaasSubscriptionDTO(e);
    }

    public SaasSubscriptionDTO update(SaasSubscriptionDTO saasDTO) {
        var e = this.repository.update(new SaasSubscriptionEntity(saasDTO));
        return new SaasSubscriptionDTO(e);
    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    public List<SaasSubscriptionDTO> findAll(Pageable pageable) {
       var page =  this.repository.findAll(pageable.isSorted() ? pageable : Pageable.from(pageable.getNumber(), pageable.getSize(), CENTS));
       return page.getContent().stream().map(SaasSubscriptionDTO::new).toList();
    }
}
