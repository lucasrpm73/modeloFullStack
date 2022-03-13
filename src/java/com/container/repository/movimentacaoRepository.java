/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.repository;

import com.container.model.movimentacaoModel;
import com.container.util.HibernateConector;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import com.container.model.pessoaModel;

/**
 *
 * @author Lucas Santos
 */
public class movimentacaoRepository {
    private Session session;
    private Transaction transaction;

    public void salvar(movimentacaoModel movimentacao){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        this.session.saveOrUpdate(movimentacao);
        
        this.transaction.commit();
        this.session.close();
    }
    
    public List<movimentacaoModel> buscarTodos(){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<movimentacaoModel> listaDeMovimentacao = this.session.createQuery("from movimentacaoModel").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeMovimentacao;
    }
    
    public List<movimentacaoModel> buscarSumarioEx(){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<movimentacaoModel> listaSumario = this.session.createQuery("SELECT count(containercategoria) as Total_Registros FROM containerModel WHERE containercategoria= 'Exportação'").list();
        
        this.transaction.commit();
        this.session.close();
        return listaSumario;
    }
    public List<movimentacaoModel> buscarSumarioImport(){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<movimentacaoModel> listaSumario = this.session.createQuery("SELECT count(containercategoria) as Total_Registros FROM containerModel WHERE containercategoria= 'Importação'").list();
        
        this.transaction.commit();
        this.session.close();
        return listaSumario;
    }
    
    
    
     public List<movimentacaoModel> buscarOrdenarCliente(){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        movimentacaoModel pessoa = new movimentacaoModel();
        
        String nome = null;
        
        if(nome != null){
         Query query = session.createQuery("from movimentacaoModel Where pessoa= :pessoa");
         query.setParameter("pessoa", nome);
        List<movimentacaoModel> listaDeMovimentacao = query.list();
        this.transaction.commit();
        this.session.close();
        return listaDeMovimentacao;
        
        }
        else{
         Query query = session.createQuery("from movimentacaoModel order by pessoa");
        List<movimentacaoModel> listaDeMovimentacao = query.list();
        this.transaction.commit();
        this.session.close();
        return listaDeMovimentacao;
        
        }
        
    }
    
    public void remover(long idMovimentacao){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        movimentacaoModel movimentacao = (movimentacaoModel) this.session.get(movimentacaoModel.class, idMovimentacao);
        this.session.delete(movimentacao);
        
        this.transaction.commit();
        this.session.close();
    }
    
    public movimentacaoModel buscarPorId(long idMovimentacao){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        movimentacaoModel movimentacao;
        movimentacao = (movimentacaoModel) this.session.get(movimentacaoModel.class, idMovimentacao);
        
        this.transaction.commit();
        this.session.close();
        return movimentacao;
    }
    
}

