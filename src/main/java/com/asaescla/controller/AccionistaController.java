/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asaescla.controller;

import com.asaescla.ejb.AccionistasFacadeLocal;
import com.asaescla.entity.Accionistas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Alicia Fernández
 */

@Named(value = "accionista")
@SessionScoped 
public class AccionistaController implements Serializable{
    
    @EJB 
    private AccionistasFacadeLocal facadeaccionistas;
    
    private List<Accionistas> list_DataObject;
    private Accionistas model;
    private Boolean isEdit;
    
     // <editor-fold defaultstate="collapsed" desc="get/set">
    // Se puede autogenerar metodos get/set por medio de netbeans, click derecho, y selecionar "Insert Code", luego "Getter/Setter" y seleccionar los atributos que se necesaitan

    public Accionistas getModel() {
        return model;
    }
    
    public void setModel(Accionistas model) {
        this.model = model;
    }
     
       public Boolean getIsEdit() {
        return isEdit;
    }

       public void setIsEdit(Boolean isEdit) {
        this.isEdit = isEdit;
    }
    public AccionistasFacadeLocal getFacadeaccionistas() {
        return facadeaccionistas;
    }

    public void setFacadeaccionistas(AccionistasFacadeLocal facadeaccionistas) {
        this.facadeaccionistas = facadeaccionistas;
    }

    public List<Accionistas> getList_DataObject() {
        return list_DataObject;
    }

    public void setList_DataObject(List<Accionistas> list_DataObject) {
        this.list_DataObject = list_DataObject;
    }

    // </editor-fold>
    
    // Este es un constructor de los controladores, se debe anotar con  @PostConstruct y por lo tanto importanse como libreria
    @PostConstruct
    public void init() { 
        try { 
            cleanAll();
            load_listAccionista(); 
        } catch (Exception e) {}
    }
    
    // Limpia las variables e inicializa atributos
    private void cleanAll(){
        try { // Es bueno siempre encerrar su codigo en un try / catch
            isEdit = false;
            model = new Accionistas();
        } catch (Exception e) {}
    }
    
    // Carga los registros de la base
    private void load_listAccionista(){
        try { // Es bueno siempre encerrar su codigo en un try / catch
            list_DataObject = facadeaccionistas.findAll(); // Por medio de la facade consultamos todos los registros que contiene la tabla, y nos devuelve una lista con elementos "Prueba": esa clase se autogenero
        } catch (Exception e) {
            System.out.println("error en load_listAccionista " + e.getMessage());
        }
    }
    
    // Evento click cuando se elimina un registro de la tabla
    public void onClickDeleteAccionista(Accionistas item){
        try { 
            facadeaccionistas.remove(item);
            //list_DataObject.remove(item);
            load_listAccionista(); // Igual se puede llamar a este metodo, para que consulte de nuevo la base, seria casi lo mismo
            
            String sms = "Se elimino correctamente";
            FacesContext.getCurrentInstance().addMessage("msj", new FacesMessage(FacesMessage.SEVERITY_INFO, sms, ""));
        } catch (Exception e) {}
    } 
    
    // Evento click para abrir la modal, y que este sea para editar un registro seleccionado de la tabla
    public void onClickOpenModelEditAccionista(Accionistas item) {
        try { 
            isEdit = true;
            model = item;
        } catch (Exception e) {}
    }
    
    // Evento click para abrir la modal, en modo agregar nuevo registro
    public void onClickOpenModelNewAccionista2() {
        try { 
            isEdit = false;
            model = new Accionistas();
        } catch (Exception e) {}
    }
    
    // Evento click cuando se guarda/actualiza un registro desde la modal
    public void onClickProcessAccionista(){
        try {
            String sms = "";
            if(isEdit) {
                facadeaccionistas.edit(model);
                sms = "Se edito correctamente";
            } else {
                facadeaccionistas.create(model);
                sms = "Se guardo correctamente";
            }
            
            cleanAll();
            load_listAccionista(); // Se actualizara la lista desde la base
            FacesContext.getCurrentInstance().addMessage("msj", new FacesMessage(FacesMessage.SEVERITY_INFO, sms, ""));
        } catch (Exception e) {}

    }
}
    
