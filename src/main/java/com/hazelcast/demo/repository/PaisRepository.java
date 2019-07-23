package com.hazelcast.demo.repository;

import com.hazelcast.demo.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Short> {
}
