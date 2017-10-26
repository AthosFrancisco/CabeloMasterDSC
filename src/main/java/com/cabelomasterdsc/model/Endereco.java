/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cabelomasterdsc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author athos.carmo
 */

@Embeddable
public class Endereco implements Serializable{

    public Endereco() {
    }

    public Endereco(String cep, String logradouro, String bairro, Integer numero, String complemento, String cidade, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }
 
    
    
    @Column(name = "TXT_CEP", nullable = false)
    private String cep;
    
    @Column(name = "TXT_LOGRADOURO", nullable = false)
    private String logradouro;
    
    @Column(name = "TXT_BAIRRO", nullable = false)
    private String bairro;
    
    @Column(name = "NUM_NUMERO", nullable = true)
    private Integer numero;
    
    @Column(name = "TXT_COMPLEMENTO", nullable = true)
    private String complemento;
    
    @Column(name = "TXT_CIDADE", nullable = false)
    private String cidade;
    
    @Column(name = "TXT_ESTADO", nullable = false)
    private String estado;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
