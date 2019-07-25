package com.hazelcast.demo.service;

import com.hazelcast.demo.entity.Pais;

import java.util.List;

public interface PaisService {

    public List<Pais> getPaises();
    
    public Pais updatePais(Short idPais, String descripcion);
    
    public Boolean deletePais(Short idPais);
}
