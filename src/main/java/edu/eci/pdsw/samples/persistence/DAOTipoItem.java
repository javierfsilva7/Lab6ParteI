/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.persistence;

import edu.eci.pdsw.samples.entities.TipoItem;

/**
 *
 * @author hcadavid
 */
public interface DAOTipoItem {

    public TipoItem load(int id) throws PersistenceException;
    
    public void save(TipoItem it) throws PersistenceException;
    
    public void update(TipoItem it) throws PersistenceException;
    
    public void delete(int it) throws PersistenceException;

    
}
