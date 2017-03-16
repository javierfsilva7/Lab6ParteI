/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.persistence.jdbcimpl;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.persistence.DAOCliente;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.eci.pdsw.samples.persistence.DAOItem;
import java.util.ArrayList;

/**
 *
 * @author hcadavid
 */
public class JDBCDaoCliente implements DAOCliente {

    Connection con;

    public JDBCDaoCliente(Connection con) {
        this.con = con;
    }
        



    @Override
    public void delete(int ident) throws PersistenceException {
        PreparedStatement ps;
        /*try {
            
        } catch (SQLException ex) {
            throw new PersistenceException("An error ocurred while updating Usuario.",ex);
        } */
        throw new RuntimeException("No se ha implementado el metodo 'update' del DAOPAcienteJDBC");

    }

    @Override
    public void save(Cliente it) throws PersistenceException {
        PreparedStatement ps;
        /*try {
            
        } catch (SQLException ex) {
            throw new PersistenceException("An error ocurred while updating Usuario.",ex);
        } */
        throw new RuntimeException("No se ha implementado el metodo 'save' ");

    }

    @Override
    public void update(Cliente it) throws PersistenceException {
                PreparedStatement ps;
        /*try {
            
        } catch (SQLException ex) {
            throw new PersistenceException("An error ocurred while updating Usuario.",ex);
        } */
        throw new RuntimeException("No se ha implementado el metodo 'update' ");

    }

    @Override
    public Cliente load(int id) throws PersistenceException {
        
        PreparedStatement ps;
        String c_nombre, c_telefono, c_direccion, c_correo;
        boolean c_vetado= false;
        ArrayList<ItemRentado> rentados= new ArrayList<ItemRentado>();
        
        
        try {
            
            ps=con.prepareStatement("select nombre, documento, telefono, direccion, email, vetado from VI_CLIENTES where documento=?");
            ps.setInt(1, id);
            
                        
            ResultSet clientes = ps.executeQuery();
            clientes.absolute(1);
            
            c_nombre=clientes.getString(1);
            id= clientes.getInt(2);
            c_telefono= clientes.getString(3);
            c_direccion= clientes.getString(4);
            c_correo=clientes.getString(5);
            c_vetado=clientes.getBoolean(6);
            rentados=null;
                                   
            
        } catch (SQLException ex) {
        
            throw new PersistenceException("No se ha podido cargar el cliente" + id, ex);
        }
                
        return new Cliente(c_nombre, id, c_telefono, c_direccion, c_correo, c_vetado, rentados);   
           
    }

}


