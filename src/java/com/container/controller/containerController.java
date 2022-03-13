/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.container.controller;
import com.container.model.containerModel;
import com.container.repository.containerRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class containerController {

    private containerModel containerModel;
    private containerRepository containerRepository;
    private List<containerModel> listaDeContainer;
    
    public containerController() {
        this.containerModel = new containerModel();
        this.containerRepository = new containerRepository();
        this.listaDeContainer = new ArrayList<>();
    }

    public String salvar(){
        this.containerRepository.salvar(this.containerModel);
        return "/view/container/buscarContainer.xhtml";
    }
    
    public String salvarEdicao() {
        this.containerRepository.salvar(this.containerModel);
        return "buscarContainer.xhtml?faces-redirect=true";
    }
    
    public void remover(long idContainer) {
        
        this.containerRepository.remover(idContainer);
    }
    
    public String editar(long idContainer) {
        return "editarContainer.xhtml?faces-redirect=true&idContainer=" + idContainer;
    }
   
    public void buscarContainer() {
        this.containerModel = this.containerRepository.buscarPorId(this.containerModel.getIdPessoa());
    }
    public void getContainer() {
        this.containerModel = this.containerRepository.buscarPorId(this.containerModel.getIdPessoa());
    }


    public List<SelectItem> getContainers() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<containerModel> listaDeContainers = this.containerRepository.buscarTodos();
        for (containerModel container : listaDeContainers) {
            itens.add(new SelectItem(container.getIdPessoa(), container.getPessoaNome()));
        }
        return itens;
    }
    
    public void buscarTodosContainers() {
        this.listaDeContainer = this.containerRepository.buscarTodos();
    }

    public containerModel getContainerModel() {
        return containerModel;
    }

    public void setContainerModel(containerModel containerModel) {
        this.containerModel = containerModel;
    }

    public containerRepository getContainerRepository() {
        return containerRepository;
    }

    public void setContainerRepository(containerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public List<containerModel> getListaDeContainer() {
        return listaDeContainer;
    }

    public void setListaDeContainer(List<containerModel> listaDeContainer) {
        this.listaDeContainer = listaDeContainer;
    }


    
}
