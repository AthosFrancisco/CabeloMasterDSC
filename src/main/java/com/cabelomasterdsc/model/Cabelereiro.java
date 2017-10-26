/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cabelomasterdsc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author athos.carmo
 */
@Entity
@Table(name = "TB_CABELEREIRO")
@DiscriminatorValue(value = "CABELEREIRO")
@PrimaryKeyJoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
public class Cabelereiro extends Usuario implements Serializable{

    public Cabelereiro() {
    }

    public Cabelereiro(String nome, String cpf, String email, String senha, Date dtNascimento, char sexo, Endereco endereco) {
        super(nome, cpf, email, senha, dtNascimento, sexo, endereco);
    }
    
    @Column(nullable = true, name = "DISPONIVEL")
    private Boolean disponivel;
    
    @OneToMany(mappedBy = "cabelereiro", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Atendimento> atendimento;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Gerente gerente;

    public List<Atendimento> getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(List<Atendimento> atendimento) {
        this.atendimento = atendimento;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
