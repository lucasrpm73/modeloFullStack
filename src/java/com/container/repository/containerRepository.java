/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.repository;
import com.container.model.containerModel;
import com.container.util.HibernateConector;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class containerRepository {
    private Session session;
    private Transaction transaction;

    public void salvar(containerModel container){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        this.session.saveOrUpdate(container);
        
        this.transaction.commit();
        this.session.close();
    }
    
    public List<containerModel> buscarTodos(){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<containerModel> listaDeContainer = this.session.createQuery("from containerModel").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeContainer;
    }
    
    public void remover(long idContainer){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        containerModel container = (containerModel) this.session.get(containerModel.class, idContainer);
        this.session.delete(container);
        
        this.transaction.commit();
        this.session.close();
    }
    
    public containerModel buscarPorId(long idContainer){
        this.session = HibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        containerModel container;
        container = (containerModel) this.session.get(containerModel.class, idContainer);
        
        this.transaction.commit();
        this.session.close();
        return container;
    }
}
