/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asaescla.ejb;

import com.asaescla.entity.Accionistas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alicia Fernández
 */
@Local
public interface AccionistasFacadeLocal {

    void create(Accionistas accionistas);

    void edit(Accionistas accionistas);

    void remove(Accionistas accionistas);

    Accionistas find(Object id);

    List<Accionistas> findAll();

    List<Accionistas> findRange(int[] range);

    int count();
    
}
