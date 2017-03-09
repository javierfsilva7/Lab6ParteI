/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.persistence;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;

/**
 *
 * @author hcadavid
 */
public interface DAOCliente {

    public Cliente load(int id) throws PersistenceException;
    
    public void save(Cliente it) throws PersistenceException;
    
    public void update(Cliente it) throws PersistenceException;
    
    public void delete(int it) throws PersistenceException;

    
}
