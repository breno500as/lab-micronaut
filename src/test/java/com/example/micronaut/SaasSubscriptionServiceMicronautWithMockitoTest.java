package com.example.micronaut;

import com.example.micronaut.model.SaasSubscriptionDTO;
import com.example.micronaut.model.SaasSubscriptionEntity;
import com.example.micronaut.repository.SaasSubscriptionRepository;
import com.example.micronaut.service.SaasSubscriptionService;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.mockito.Mockito.when;


@MicronautTest
class SaasSubscriptionServiceMicronautWithMockitoTest {


    @Inject
    SaasSubscriptionService service;

    @Inject
    SaasSubscriptionRepository repository;

    @MockBean(SaasSubscriptionRepository.class)
    SaasSubscriptionRepository repository() {
        return Mockito.mock(SaasSubscriptionRepository.class);
    }

    @Test
    void save() {

        var sassSubEntity = new SaasSubscriptionEntity("testando", 1);
        var sassSubEntityPersisted = new SaasSubscriptionEntity(1L,"testando", 1);

        var sassSubDTO = new SaasSubscriptionDTO("testando", 1);

        when(this.repository.save(sassSubEntity)).thenReturn(sassSubEntityPersisted);


        var sassSubDTOPersisted =  this.service.save(sassSubDTO);

        Assertions.assertNotNull(sassSubDTOPersisted);
        Assertions.assertEquals(1L , sassSubDTOPersisted.id());
    }



}
