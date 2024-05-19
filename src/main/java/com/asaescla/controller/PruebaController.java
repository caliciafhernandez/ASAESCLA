/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asaescla.controller;

import com.asaescla.ejb.PruebaFacadeLocal;
import com.asaescla.entity.Prueba;
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
@Named(value = "prueba") // Para la vista pueda acceder al controlador, este debe ser nombrado, por medio de esta anotacion
@SessionScoped  // Esta anotacion significa que los valores de las variables se mantienen entre cada recarga de la pagina, eso quiere decir que si en un formulario no se perderan los datos si recarga la pagina
public class PruebaController implements Serializable{
    
    @EJB    // La facades son para editar, crear, eliminar y consultar registros de una tabla particular, deben ser anotadas con @EJB, este debe ser importada
    private PruebaFacadeLocal facadePrueba;    
    
    private List<Prueba> list_DataObject; // Solo aquellos atributos que sean privados y que tangan metodos get/set podran ser visibles desde la vista

    private Prueba model; // El modelo para guardar/actualizar los datos
    private Boolean isEdit; // Indicador para determinar si el formulario va a guardar o actualizar, true = actualizar
    
    // <editor-fold defaultstate="collapsed" desc="get/set">
    // Se puede autogenerar metodos get/set por medio de netbeans, click derecho, y selecionar "Insert Code", luego "Getter/Setter" y seleccionar los atributos que se necesaitan

    public Prueba getModel() {
        return model;
    }

    public void setModel(Prueba model) {
        this.model = model;
    }

    public Boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(Boolean isEdit) {
        this.isEdit = isEdit;
    }

    public PruebaFacadeLocal getFacadePrueba() {
        return facadePrueba;
    }

    public void setFacadePrueba(PruebaFacadeLocal facadePrueba) {
        this.facadePrueba = facadePrueba;
    }
    
    
    public List<Prueba> getList_DataObject() {
        return list_DataObject;
    }

    public void setList_DataObject(List<Prueba> list_DataObject) {
        this.list_DataObject = list_DataObject;
    }

    // </editor-fold>
    
    // Este es un constructor de los controladores, se debe anotar con  @PostConstruct y por lo tanto importanse como libreria
    @PostConstruct
    public void init() { // Este metodo solo se ejecuta una sola vez, al principio cuando se crea una instancia de este controlador desde la vista
        try { // Es bueno siempre encerrar su codigo en un try / catch
            cleanAll();
            load_listPrueba(); 
        } catch (Exception e) {}
    }
    
    // Limpia las variables e inicializa atributos
    private void cleanAll(){
        try { // Es bueno siempre encerrar su codigo en un try / catch
            isEdit = false;
            model = new Prueba();
        } catch (Exception e) {}
    }
    
    // Carga los registros de la base
    private void load_listPrueba(){
        try { // Es bueno siempre encerrar su codigo en un try / catch
            list_DataObject = facadePrueba.findAll(); // Por medio de la facade consultamos todos los registros que contiene la tabla, y nos devuelve una lista con elementos "Prueba": esa clase se autogenero
        } catch (Exception e) {
            System.out.println("erroe en load_listPrueba " + e.getMessage());
        }
    }
    
    // Evento click cuando se elimina un registro de la tabla
    public void onClickDeletePrueba(Prueba item){
        try { 
            facadePrueba.remove(item);
            //list_DataObject.remove(item);
            load_listPrueba(); // Igual se puede llamar a este metodo, para que consulte de nuevo la base, seria casi lo mismo
            
            String sms = "Se elimino correctamente";
            FacesContext.getCurrentInstance().addMessage("msj", new FacesMessage(FacesMessage.SEVERITY_INFO, sms, ""));
        } catch (Exception e) {}
    } 
    
    // Evento click para abrir la modal, y que este sea para editar un registro seleccionado de la tabla
    public void onClickOpenModelEditPrueba(Prueba item) {
        try { 
            isEdit = true;
            model = item;
        } catch (Exception e) {}
    }
    
    // Evento click para abrir la modal, en modo agregar nuevo registro
    public void onClickOpenModelNewPrueba() {
        try { 
            isEdit = false;
            model = new Prueba();
        } catch (Exception e) {}
    }
    
    // Evento click cuando se guarda/actualiza un registro desde la modal
    public void onClickProcessPrueba(){
        try {
            String sms = "";
            if(isEdit) {
                facadePrueba.edit(model);
                sms = "Se edito correctamente";
            } else {
                facadePrueba.create(model);
                sms = "Se guardo correctamente";
            }
            
            cleanAll();
            load_listPrueba(); // Se actualizara la lista desde la base
            FacesContext.getCurrentInstance().addMessage("msj", new FacesMessage(FacesMessage.SEVERITY_INFO, sms, ""));
        } catch (Exception e) {}
    }
    
    
    
    
    
    // Si se modifica el controlador o alguna clase de java, debe de ejcutar el boton Run, para ver los cambios
}
