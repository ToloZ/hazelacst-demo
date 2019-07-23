package com.hazelcast.demo.service;

import com.hazelcast.demo.entity.Provincia;

import java.util.List;

public interface ProvinciaService {

    public List<Provincia> getProvincias();

    public List<Provincia> getProvinciasById(short pais);
}
