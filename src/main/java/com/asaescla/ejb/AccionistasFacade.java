/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asaescla.ejb;

import com.asaescla.entity.Accionistas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alicia Fernández
 */
@Stateless
public class AccionistasFacade extends AbstractFacade<Accionistas> implements AccionistasFacadeLocal {

    @PersistenceContext(unitName = "asaescla_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccionistasFacade() {
        super(Accionistas.class);
    }
    
}
