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
@Table(name = "TB_ATENDIMENTO")
@Access(AccessType.FIELD)
public class Atendimento implements Serializable{
    
    @Id
    @SequenceGenerator(name = "SEQ_ID", allocationSize = 20, initialValue = 1)
    @GeneratedValue(generator = "SEQ_ID")
    private Integer id;
    
    @Column(name = "DT_DIA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dia;
    
    @Column(name = "DT_INICIO", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaInicioAtendimento;
    
    @Column(name = "DT_FINAL", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaFinalAtendimento;
    
    @Transient
    private List<Subservico> subServ;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "ID_SERVICO", referencedColumnName = "ID")
    private Servico servico;
    
    private Float valorTotal;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Cabelereiro cabelereiro;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Cliente cliente;

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Date getHoraInicioAtendimento() {
        return horaInicioAtendimento;
    }

    public void setHoraInicioAtendimento(Date horaInicioAtendimento) {
        this.horaInicioAtendimento = horaInicioAtendimento;
    }

    public Date getHoraFinalAtendimento() {
        return horaFinalAtendimento;
    }

    public void setHoraFinalAtendimento(Date horaFinalAtendimento) {
        this.horaFinalAtendimento = horaFinalAtendimento;
    }

    public List<Subservico> getSubServ() {
        return subServ;
    }

    public void setSubServ(List<Subservico> subServ) {
        this.subServ = subServ;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Cabelereiro getCabelereiro() {
        return cabelereiro;
    }

    public void setCabelereiro(Cabelereiro cabelereiro) {
        this.cabelereiro = cabelereiro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
