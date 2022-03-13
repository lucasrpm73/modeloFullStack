/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.repository;

import com.container.model.pessoaModel;
import com.container.model.tipoMovi;
import com.container.util.HibernateConector;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lucas Santos
 */
public class pessoaRepository {
     private Session session;
    private Transaction transaction;

    public List<pessoaModel> buscar(){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<pessoaModel> listaDePessoas = this.session.createQuery("from pessoaModel").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDePessoas;
    }

    public void salvar(pessoaModel pessoa) {
         this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        this.session.saveOrUpdate(pessoa);
        
        this.transaction.commit();
        this.session.close();
    }

    public void remover(long idPessoa) {
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        pessoaModel pessoa = (pessoaModel) this.session.get(pessoaModel.class, idPessoa);
        this.session.delete(pessoa);
        
        this.transaction.commit();
        this.session.close();
    }
    
    
     public List<pessoaModel> buscarTodos(){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<pessoaModel> listaDePessoas = this.session.createQuery("from pessoa").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDePessoas;
    }
    

    public tipoMovi buscarPorId(long idTipoMovi) {
          this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        tipoMovi movimentacao = (tipoMovi) this.session.get(tipoMovi.class, idTipoMovi);
        Hibernate.initialize(movimentacao.getIdTipoMovi());
        
        this.transaction.commit();
        this.session.close();
        return movimentacao;
    }

    
}
