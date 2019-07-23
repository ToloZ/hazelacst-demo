package com.hazelcast.demo.repository;

import com.hazelcast.demo.entity.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {

    @Query("SELECT p FROM Provincia p where p.pais.cPais = :cPais")
    List<Provincia> findBycPais(@Param("cPais") Short cPais);
}
