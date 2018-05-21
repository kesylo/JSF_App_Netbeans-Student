/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolsBD;

import beanPackage.*:
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Toolsbd {

    public static boolean verifyLogin(Connection con, String login, String password) {
        
        boolean ok = false;
        Statement stmt = null;
        
        try 
        {
            stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(
                "SELECT * "         +
                "FROM Utilisateur " + 
                "WHERE "            + 
                "COMPTE="           + parameter(login) + " " + 
                "AND "              + 
                "MOT_DE_PASSE="     + parameter(password));
            ok = rs.next();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ok;
        
    }
    
    private static String parameter(Object value){
        
        return 
            "'" + value.toString() + "'";
        
    }
    
}