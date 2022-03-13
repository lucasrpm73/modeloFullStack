/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 *
 * @author Lucas Santos
 */
@Entity
@Table(name = "movimentacao")
public class movimentacaoModel implements Serializable {

  @Id
    @GeneratedValue
    private long idMovimentacao;

/*
    @Column(nullable = false, length = 80)
    private String clienteNome;
*/
    @Column(nullable = false, length = 80)
    private String movimentacaoTipo;
     
    @Column(nullable = false, length = 80)
    private String pessoa;
     
    @Column(nullable = false, length = 80)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHoraInicio;
      
    
    @Column(nullable = false, length = 80)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHoraFim;
    
    
    private String busca;

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }
    
    public long getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(long idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }
    
    public void setMovimentacaoTipo(String movimentacaoTipo) {
        this.movimentacaoTipo = movimentacaoTipo;
    }

    public String getMovimentacaoTipo() {
        return movimentacaoTipo;
    }
    

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }
       
}
