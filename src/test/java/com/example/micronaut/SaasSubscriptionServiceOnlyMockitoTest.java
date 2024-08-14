package com.example.micronaut;


import com.example.micronaut.model.SaasSubscriptionEntity;
import com.example.micronaut.repository.SaasSubscriptionRepository;
import com.example.micronaut.service.SaasSubscriptionService;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Sort;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@MicronautTest
@ExtendWith(MockitoExtension.class)
class SaasSubscriptionServiceOnlyMockitoTest {

    @InjectMocks
    SaasSubscriptionService service;

    @Mock
    SaasSubscriptionRepository repository;


    @Test
    void findAll() {

        var pageable = Pageable.from(0, 20, Sort.of(Sort.Order.asc("name")));
        var page = Page.of(Arrays.asList(new SaasSubscriptionEntity(1L, "a",1), new SaasSubscriptionEntity(1L, "a",2)), pageable, 2L);
        when(this.repository.findAll(pageable)).thenReturn(page);

        var saas  = this.service.findAll(pageable);

        Assertions.assertNotNull(saas);
        Assertions.assertEquals(2, saas.size());
        Assertions.assertEquals(1L, saas.getFirst().id());

    }
}
