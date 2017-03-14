/*
 * Copyright (C) 2016 hcadavid
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
package edu.eci.pdsw.samples.view;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.persistence.DAOCliente;
import edu.eci.pdsw.samples.persistence.DAOItem;
import edu.eci.pdsw.samples.persistence.DAOTipoItem;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.jdbcimpl.JDBCDaoCliente;
import edu.eci.pdsw.samples.persistence.jdbcimpl.JDBCDaoItem;
import edu.eci.pdsw.samples.persistence.jdbcimpl.JDBCDaoTipoItem;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author hcadavid
 */
public class TextView {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, PersistenceException, ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://HOST:3306/BD";
        String driver = "com.mysql.jdbc.Driver";
        String user = "USER";
        String pwd = "PWD";

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, pwd);
        con.setAutoCommit(false);
        
        //Consulta de un cliente:
        
        DAOCliente daoc=new JDBCDaoCliente(con);
        
        Cliente c=daoc.load(1);
        
        System.out.println("Detalle del cliente:"+c);
        

    }

}
