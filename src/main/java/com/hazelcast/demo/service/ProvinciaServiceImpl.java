package com.hazelcast.demo.service;


import com.hazelcast.demo.entity.Provincia;
import com.hazelcast.demo.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProvinciaServiceImpl implements ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public List<Provincia> getProvincias() {
        return null;
    }

    @Override
    @Cacheable(value = "provincia")
    public List<Provincia> getProvinciasById(short pais) {
        System.out.println("Yo soy: " + Thread.currentThread() + "entre al servicio de provincia");
        return provinciaRepository.findBycPais(pais);
    }
}
