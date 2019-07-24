package com.hazelcast.demo.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pais_tipo")
public class Pais implements Serializable {

    @Id
    @Column(name = "c_pais")
    private Short cPais;

    @Column(name = "descripcion", length = 250, nullable = false)
    private String descripcion;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_pais", referencedColumnName = "c_pais")
    private List<Provincia> provincias;

    public Short getcPais() {
        return cPais;
    }

    public void setcPais(Short cPais) {
        this.cPais = cPais;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }
}
