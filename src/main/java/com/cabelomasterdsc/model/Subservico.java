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
public class Subservico implements Serializable{

    public Subservico() {
    }

    public Subservico(String nome, Float valor) {
        this.nome = nome;
        this.valor = valor;
    }
    
    @Column(name = "TXT_NOME", nullable = false)
    private String nome;
    
    @Column(name = "NUM_VALOR", nullable = false)
    private Float valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
