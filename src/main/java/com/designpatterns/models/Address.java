package com.designpatterns.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    private String cep;
    private String street;
    private String complement;
    private String neighborhood;
    private String location;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getComplement() {
        return complement;
    }
    public void setComplement(String complement) {
        this.complement = complement;
    }
    public String getNeighborhood() {
        return neighborhood;
    }
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public String getIbge() {
        return ibge;
    }
    public void setIbge(String ibge) {
        this.ibge = ibge;
    }
    public String getGia() {
        return gia;
    }
    public void setGia(String gia) {
        this.gia = gia;
    }
    public String getDdd() {
        return ddd;
    }
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
    public String getSiafi() {
        return siafi;
    }
    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }
}
