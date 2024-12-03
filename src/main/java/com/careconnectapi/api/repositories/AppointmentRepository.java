package com.careconnectapi.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.careconnectapi.api.entity.AppointmentEntity;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Integer> {

    @Query(value = "SELECT * FROM selva_appointments", nativeQuery = true)
    Page<AppointmentEntity> findAll(Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM selva_appointments", nativeQuery = true)
    long count();
}