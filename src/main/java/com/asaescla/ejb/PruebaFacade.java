/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asaescla.ejb;

import com.asaescla.entity.Prueba;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alicia Fernández
 */
@Stateless
public class PruebaFacade extends AbstractFacade<Prueba> implements PruebaFacadeLocal {

    @PersistenceContext(unitName = "asaescla_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PruebaFacade() {
        super(Prueba.class);
    }
    
}
