package com.example.micronaut.repository;


import com.example.micronaut.model.SaasSubscriptionEntity;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.H2)
public interface SaasSubscriptionRepository extends CrudRepository<SaasSubscriptionEntity, Long> {
}
