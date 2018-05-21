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

    public static ArrayList findAllRoles(Connection con) {
        
        ArrayList L = new ArrayList();
        
        try {
            
            PreparedStatement prep = con.prepareStatement(
                                        "SELECT * " + 
                                        "FROM Role");
            
            ResultSet rs = prep.executeQuery();
            
            while (rs.next()) {
                
                Role obj = new Role();
                
                obj.setCode(rs.getString("CODE"));
                obj.setIntitule(rs.getString("LIBELLE"));
                
                L.add(obj);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur connexion!!!!!");
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return L;
    }
    
    public static ArrayList findAllMenus(Connection con) {
        
        ArrayList L = new ArrayList();
        
        try {
            
            PreparedStatement prep = con.prepareStatement(
                                        "SELECT * " + 
                                        "FROM Menu");
            
            ResultSet rs = prep.executeQuery();
            
            while (rs.next()) {
                
                Menu obj = new Menu();
                
                obj.setCode(rs.getString("CODE"));
                obj.setLibelle(rs.getString("LIBELLE"));
                
                L.add(obj);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur connexion!!!!!");
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return L;
    }
    
    public static ArrayList findAllAutorisations(Connection con) {
        
        ArrayList L = new ArrayList();
        
        try {
            
            PreparedStatement prep = con.prepareStatement(
                                        "SELECT * " + 
                                        "FROM Autorisation");
            
            ResultSet rs = prep.executeQuery();
            
            while (rs.next()) {
                
                Autorisation obj = new Autorisation();
                
                obj.setId_role(rs.getInt("ID_ROLE"));
                obj.setId_menu(rs.getInt("ID_MENU"));
                obj.setAjouter(rs.getBoolean("AJOUTER"));
                obj.setAjouter(rs.getBoolean("MODIFIER"));
                obj.setAjouter(rs.getBoolean("SUPPRIMER"));
                
                L.add(obj);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur connexion!!!!!");
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return L;
    }
    
    public static ArrayList findAllUtilisateurs(Connection con) {
        
        ArrayList L = new ArrayList();
        
        try {
            
            PreparedStatement prep = con.prepareStatement(
                                        "SELECT * " + 
                                        "FROM Utilisateur");
            
            ResultSet rs = prep.executeQuery();
            
            while (rs.next()) {
                
                Utilisateur obj = new Utilisateur();
                
                obj.setMatricule(rs.getString("MATRICULE"));
                obj.setNom(rs.getString("NOM"));
                obj.setPrenom(rs.getString("PRENOM"));
                obj.setEmail(rs.getString("EMAIL"));
                obj.setRue(rs.getString("RUE"));
                obj.setLocalite(rs.getString("LOCALITE"));
                obj.setCompte(rs.getString("COMPTE"));
                obj.setMot_de_passe(rs.getString("MOT_DE_PASSE"));
                obj.setUrl_photo(rs.getString("ULR_PHOTO"));
                
                obj.setId_personne(rs.getInt("ID_PERSONNE"));
                obj.setId_role(rs.getInt("ID_ROLE"));
                obj.setNumero_telephone(rs.getInt("NUMERO_TELEPHONE"));
                obj.setNumero_rue(rs.getInt("NUMERO_RUE"));
                obj.setCode_postal(rs.getInt("CODE_POSTAL"));
                
                L.add(obj);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur connexion!!!!!");
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return L;
    }
    
    public static boolean verifyLogin(Connection con, String compte, String mot_de_passe) {
        
        boolean ok = false;
        Statement stmt = null;
        
        try 
        {
            stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(
                "SELECT * "         +
                "FROM Utilisateur " + 
                "WHERE "            + 
                "COMPTE="           + parameter(compte) + " " + 
                "AND "              + 
                "MOT_DE_PASSE="     + parameter(mot_de_passe));
            
            ok = rs.next();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ok;
        
    }

    public static boolean deleteUtilisateur(Connection con, String compte) {
        
        int result = 0;

        try {
            
            PreparedStatement prep = con.prepareStatement(
                                        "DELETE " + 
                                        "FROM Utilisateur " + 
                                        "WHERE " + 
                                        "COMPTE=" + parameter(compte)
                                    );
            
            result = prep.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result != 0; 
        // si result est <> de 0 --> la supression a eu lieu
    }

    public static boolean deleteRole(Connection con, String code) {
        
        int result = 0;

        try {
            
            PreparedStatement prep = con.prepareStatement(
                                        "DELETE " + 
                                        "FROM Role " + 
                                        "WHERE " + 
                                        "CODE=" + parameter(code)
                                    );
            
            result = prep.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result != 0; 
        // si result est <> de 0 --> la supression a eu lieu
    }

    public static boolean deleteMenu(Connection con, String code) {
        
        int result = 0;

        try {
            
            PreparedStatement prep = con.prepareStatement(
                                        "DELETE " + 
                                        "FROM Menu " + 
                                        "WHERE " + 
                                        "CODE=" + parameter(code)
                                    );
            
            result = prep.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result != 0; 
        // si result est <> de 0 --> la supression a eu lieu
    }

    public static boolean deleteAutorisation(Connection con, int id_role, int id_menu) {
        
        int result = 0;

        try {
            
            PreparedStatement prep = con.prepareStatement(
                                        "DELETE " + 
                                        "FROM Autorisation " + 
                                        "WHERE " + 
                                        "ID_ROLE=" + parameter(id_role) + " " + 
                                        "AND" +
                                        "ID_MENU=" + parameter(id_role)
                                    );
            
            result = prep.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result != 0; 
        // si result est <> de 0 --> la supression a eu lieu
    }

    public static boolean deleteAutorisation(Connection con, int id_role) {
        
        int result = 0;

        try {
            
            PreparedStatement prep = con.prepareStatement(
                                        "DELETE " + 
                                        "FROM Autorisation " + 
                                        "WHERE " + 
                                        "ID_ROLE=" + parameter(id_role)
                                    );
            
            result = prep.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result != 0; 
        // si result est <> de 0 --> la supression a eu lieu
    }
    
    private static String parameter(Object value){
        
        return 
            "'" + value.toString() + "'";
        
    }
    
}