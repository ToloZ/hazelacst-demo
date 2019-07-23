package com.hazelcast.demo.service;

import com.hazelcast.demo.entity.Pais;
import com.hazelcast.demo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    @Cacheable(value = "pais")
    public List<Pais> getPaises() {
        System.out.println("Yo soy: " + Thread.currentThread() + "entre al servicio de pais");
        return paisRepository.findAll();
    }
}
