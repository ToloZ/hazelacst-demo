package com.hazelcast.demo.service;

import com.hazelcast.demo.entity.Pais;
import com.hazelcast.demo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
    
    //beforeInvocation, allEntries
    @CacheEvict(value = "pais")
    public Boolean deletePais(Short idPais) {
    	System.out.println("Borre el servicio con id " + idPais);
    	Long total = paisRepository.count();
    	paisRepository.deleteById(idPais);
    	return total.equals(Long.valueOf(paisRepository.count() - 1));
    }
    
    @CachePut(value = "pais", condition="#idPais > 5")
    public Pais updatePais(Short idPais, String descripcion) {
    	if (paisRepository.findById(idPais).isPresent()) {
    		Pais p = paisRepository.findById(idPais).get();
    		p.setDescripcion(descripcion);
    		return paisRepository.save(p);
    	} else {
    		return null;
    	}
    }
}
