/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asaescla.ejb;

import com.asaescla.entity.Prueba;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alicia Fernández
 */
@Local
public interface PruebaFacadeLocal {

    void create(Prueba prueba);

    void edit(Prueba prueba);

    void remove(Prueba prueba);

    Prueba find(Object id);

    List<Prueba> findAll();

    List<Prueba> findRange(int[] range);

    int count();
    
}
