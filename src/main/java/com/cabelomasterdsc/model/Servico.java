/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cabelomasterdsc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author athos.carmo
 */
@Entity
@Table(name = "TB_SERVICO")
public class Servico implements Serializable{

    public Servico() {
    }

    public Servico(String nomeServico, String descricao, Date tempoMedioAtendimento, Date pausa, Date tempoRestanteAtendimento) {
        this.nomeServico = nomeServico;
        this.descricao = descricao;
        this.tempoMedioAtendimento = tempoMedioAtendimento;
        this.pausa = pausa;
        this.tempoRestanteAtendimento = tempoRestanteAtendimento;
    }
    
    
    
    @Id
    @SequenceGenerator(name = "SEQ_ID", allocationSize = 20, initialValue = 1)
    @GeneratedValue(generator = "SEQ_ID")
    private Integer id;
    
    @Column(name = "TXT_NOME_SERVICO", nullable = false)
    private String nomeServico;
    
    @Column(name = "TXT_DESCRICAO", nullable = false)
    private String descricao;
    
    @Column(name = "DT_MEDIO_ATENDIMENTO", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date tempoMedioAtendimento;
    
    @Column(name = "DT_PAUSA", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date pausa;
    
    @Column(name = "DT_RESTANTE_ATENDIMENTO", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date tempoRestanteAtendimento;
    
    @ElementCollection
    @CollectionTable(name = "TB_SUBSERVICO", joinColumns = @JoinColumn(name = "ID_SERVICO", nullable = false))
    @Column(name = "SUBSERVICOS")
    private List<Subservico> subServ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getTempoMedioAtendimento() {
        return tempoMedioAtendimento;
    }

    public void setTempoMedioAtendimento(Date tempoMedioAtendimento) {
        this.tempoMedioAtendimento = tempoMedioAtendimento;
    }

    public Date getPausa() {
        return pausa;
    }

    public void setPausa(Date pausa) {
        this.pausa = pausa;
    }

    public Date getTempoRestanteAtendimento() {
        return tempoRestanteAtendimento;
    }

    public void setTempoRestanteAtendimento(Date tempoRestanteAtendimento) {
        this.tempoRestanteAtendimento = tempoRestanteAtendimento;
    }

    public List<Subservico> getSubServ() {
        return subServ;
    }

    public void setSubServ(Subservico subServ) {
        if(this.subServ == null){
            this.subServ = new ArrayList<>();
        }
        this.subServ.add(subServ);
    }
}
