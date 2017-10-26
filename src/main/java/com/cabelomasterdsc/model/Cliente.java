/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cabelomasterdsc.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author athos.carmo
 */
@Entity
@Table(name = "TB_CLIENTE")
@DiscriminatorValue(value = "CLIENTE")
@PrimaryKeyJoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
public class Cliente extends Usuario{

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String email, String senha, Date dtNascimento, char sexo, Endereco endereco) {
        super(nome, cpf, email, senha, dtNascimento, sexo, endereco);
    }
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Atendimento> atendimento;

    public List<Atendimento> getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(List<Atendimento> atendimento) {
        this.atendimento = atendimento;
    }
}
