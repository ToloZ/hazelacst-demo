package com.hazelcast.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "provincia")
public class Provincia implements Serializable {

    @Id
    @Column(name = "c_provincia")
    private Short cProvincia;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY) // , optional = true)
    @JoinColumn(name = "c_pais") // , nullable = false)
    @JsonIgnore()
    private Pais pais;

    public Short getcProvincia() {
        return cProvincia;
    }

    public void setcProvincia(Short cProvincia) {
        this.cProvincia = cProvincia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
