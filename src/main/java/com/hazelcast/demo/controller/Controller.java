package com.hazelcast.demo.controller;

import com.hazelcast.demo.entity.Pais;
import com.hazelcast.demo.entity.Provincia;
import com.hazelcast.demo.service.PaisService;
import com.hazelcast.demo.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hz")
public class Controller {

    @Autowired
    private PaisService paisService;

    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping("paises")
    public ResponseEntity<List<Pais>> getPaises() {
        return ResponseEntity.ok().body(paisService.getPaises());
    }

    @GetMapping("provincias")
    public ResponseEntity<List<Provincia>> getProvinciasByPais(@RequestParam("idPais") Short idPais) {
        return ResponseEntity.ok().body(provinciaService.getProvinciasById(idPais));
    }
    
    @GetMapping("deletePais")
    public ResponseEntity<Boolean> deletePais(@RequestParam("idPais") Short idPais) {
        return ResponseEntity.ok().body(paisService.deletePais(idPais));
    }
    
    @GetMapping("updatePais")
    public ResponseEntity<Pais> updatePais(@RequestParam("idPais") Short idPais, @RequestParam("descripcion") String descripcion) {
        return ResponseEntity.ok().body(paisService.updatePais(idPais, descripcion));
    }
    
}
