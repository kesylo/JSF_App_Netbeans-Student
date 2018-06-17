
package ToolsBD;

import beanPackage.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;



public final class Tools {
    
    
    public static void updateUtilisateur(Connection con, Utilisateur obj) {
        
        try {
            
            PreparedStatement prep = con.prepareStatement(
                                        "UPDATE UTILISATEUR " + 
                                        "SET " + 
                                        "MATRICULE=" + parameter(obj.getMatricule()) + "," + 
                                        "NOM=" + parameter(obj.getNom()) + "," + 
                                        "PRENOM=" + parameter(obj.getPrenom()) + "," +
                                        "EMAIL=" + parameter(obj.getEmail()) + "," + 
                                        "RUE=" + parameter(obj.getRue()) + "," +
                                        "LOCALITE=" + parameter(obj.getLocalite()) + "," + 
                                        "COMPTE=" + parameter(obj.getNom()) + "," +
                                        "MOT_DE_PASSE=" + parameter(obj.getMot_de_passe()) + "," + 
                                        "URL_PHOTO=" + parameter(obj.getUrl_photo()) + "," + 
                                        "NUMERO_TELEPHONE=" + parameter(obj.getNumero_telephone()) + "," +
                                        "NUMERO_RUE=" + parameter(obj.getNumero_rue()) + "," + 
                                        "CODE_POSTAL=" + parameter(obj.getCode_postal()) + "," +
                                        "DATE_NAISSANCE=" + parameter(obj.getDate_naissance()) + "," + 
                                        "EST_MASCULIN=" + parameter(obj.isEst_masculin()) + "," +
                                        "WHERE ID_PERSONNE=" + parameter(obj.getId_personne())+
                                        "AND ID_ROLE=" + parameter(obj.getId_role()));
            
            prep.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateRole(Connection con, Role obj) {
        
        try {
            
            PreparedStatement prep = con.prepareStatement(
                                        "UPDATE ROLE " + 
                                        "SET " + 
                                        "CODE=" + parameter(obj.getCode()) + "," + 
                                        "INTITULE=" + parameter(obj.getIntitule()) + "," + 
                                        "WHERE ID_ROLE=" + parameter(obj.getId_role()));
            
            prep.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateMenu(Connection con, Menu obj) {
        
        try {
            
            PreparedStatement prep = con.prepareStatement(
                                        "UPDATE MENU " + 
                                        "SET " + 
                                        "CODE=" + parameter(obj.getCode()) + "," + 
                                        "LIBELLE=" + parameter(obj.getLibelle()) + "," + 
                                        "WHERE ID_MENU=" + parameter(obj.getId_menu()));
            
            prep.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateAutorisation(Connection con, Autorisation obj) {
        
        try {
            
            PreparedStatement prep = con.prepareStatement(
                                        "UPDATE AUTORISATION " + 
                                        "SET " + 
                                        "AJOUTER=" + parameter(obj.isAjouter()) + "," +
                                        "MODIFIER=" + parameter(obj.isModifier()) + "," +
                                        "SUPPRIMER=" + parameter(obj.isSupprimer()) + "," +
                                        "WHERE ID_ROLE=" + parameter(obj.getId_role()) +
                                        "AND ID_MENU=" + parameter(obj.getId_menu()));
            
            prep.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void storeMenu(Connection con, Menu obj) {
        
        try {
            
            PreparedStatement prep
                    = con.prepareStatement(
                                        "INSERT INTO MENU " + 
                                        "CODE=" + parameter(obj.getCode()) + "," + 
                                        "LIBELLE=" + parameter(obj.getLibelle()) + "," + 
                                        "WHERE ID_MENU=" + parameter(obj.getId_menu()));
            
            prep.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void storeRole(Connection con, Role obj) {
        
        try {
            
            PreparedStatement prep
                    = con.prepareStatement(
                                        "INSERT INTO ROLE " + 
                                        "CODE=" + parameter(obj.getCode()) + "," + 
                                        "INTITULE=" + parameter(obj.getIntitule()) + "," + 
                                        "WHERE ID_ROLE=" + parameter(obj.getId_role()));
            
            prep.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static void storeAutorisation (Connection con, Autorisation obj) {
        
        try {
            
            PreparedStatement prep
                    = con.prepareStatement(
                                        "INSERT INTO AUTORISATION " + 
                                        "AJOUTER=" + parameter(obj.isAjouter()) + "," + 
                                        "MODIFIER=" + parameter(obj.isModifier()) + "," + 
                                        "SUPPRIMER=" + parameter(obj.isSupprimer()) + "," + 
                                        "WHERE ID_ROLE=" + parameter(obj.getId_role()) +
                                        "AND ID_MENU=" + parameter(obj.getId_menu()));
            
            prep.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void storeUtilisateur (Connection con, Utilisateur obj) {
        
        try {
            
            PreparedStatement prep
                    = con.prepareStatement(
                                        "INSERT INTO UTILISATEUR " + 
                                        "MATRICULE=" + parameter(obj.getMatricule()) + "," + 
                                        "NOM=" + parameter(obj.getNom()) + "," + 
                                        "PRENOM=" + parameter(obj.getPrenom()) + "," +
                                        "EMAIL=" + parameter(obj.getEmail()) + "," + 
                                        "RUE=" + parameter(obj.getRue()) + "," +
                                        "LOCALITE=" + parameter(obj.getLocalite()) + "," + 
                                        "COMPTE=" + parameter(obj.getNom()) + "," +
                                        "MOT_DE_PASSE=" + parameter(obj.getMot_de_passe()) + "," + 
                                        "URL_PHOTO=" + parameter(obj.getUrl_photo()) + "," + 
                                        "NUMERO_TELEPHONE=" + parameter(obj.getNumero_telephone()) + "," +
                                        "NUMERO_RUE=" + parameter(obj.getNumero_rue()) + "," + 
                                        "CODE_POSTAL=" + parameter(obj.getCode_postal()) + "," +
                                        "DATE_NAISSANCE=" + parameter(obj.getDate_naissance()) + "," + 
                                        "EST_MASCULIN=" + parameter(obj.isEst_masculin()) + "," +
                                        "WHERE ID_PERSONNE=" + parameter(obj.getId_personne())+
                                        "AND ID_ROLE=" + parameter(obj.getId_role()));
            
            prep.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
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
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return L;
    }
    
    
    public static ArrayList<Autorisation> findAutorisations (Connection con, int id_role) {
        

        ArrayList<Autorisation> L = new ArrayList();
        
        try {
            
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(
                                "SELECT * " + 
                                "FROM APP.AUTORISATION " + 
                                "WHERE ID_ROLE=" + id_role);
            
            while (rs.next()) {
                
                Autorisation p = new Autorisation();
                
                p.setId_role(rs.getInt("ID_ROLE"));
                p.setId_menu(rs.getInt("ID_MENU"));
                p.setAjouter(rs.getBoolean("AJOUTER"));
                p.setModifier(rs.getBoolean("MODIFIER"));
                p.setSupprimer(rs.getBoolean("SUPPRIMER"));
                p.setRole(Tools.findRole(con, rs.getInt("ID_ROLE")));
                p.setMenu(Tools.findMenu(con, rs.getInt("ID_MENU")));
                
                L.add(p);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur connexion!!!!!");
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return L;
    }
    
    public static Utilisateur findUser(Connection con, String Compte) {
        
        ArrayList L = new ArrayList();
        
        try {
            
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(
                                "SELECT * " + 
                                "FROM APP.UTILISATEUR " + 
                                "WHERE COMPTE=" + parameter(Compte));
            
            while (rs.next()) {
                
                Utilisateur p = new Utilisateur();
                
                p.setId_role(rs.getInt("ID_ROLE"));
                p.setId_personne(rs.getInt("ID_UTILISATEUR"));
                p.setCode_postal(rs.getInt("CODE_POSTAL"));
                p.setCompte(rs.getString("COMPTE"));
                p.setDate_naissance(rs.getDate("DATE_NAISSANCE"));
                p.setEmail(rs.getString("EMAIL"));
                //p.setEst_masculin(rs.getBoolean("EST_MASCULIN"));
                p.setLocalite(rs.getString("LOCALITE"));
                p.setMatricule(rs.getString("MATRICULE"));
                p.setMot_de_passe(rs.getString("MOT_DE_PASSE"));
                p.setNom(rs.getString("NOM"));
                p.setNumero_rue(rs.getInt("NUMERO_RUE"));
                p.setNumero_telephone(rs.getInt("NUMERO_TELEPHONE"));
                p.setPrenom(rs.getString("PRENOM"));
                p.setRue(rs.getString("RUE"));
                p.setUrl_photo(rs.getString("URL_PHOTO"));
                
                p.setRole(findRole(con, p.getId_role()));
                p.setAutorisations(findAutorisations(con,p.getId_role()));
                
                L.add(p);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur connexion!!!!!");
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return (L.size() > 0) ? (Utilisateur)L.get(0) 
                              : null;
    }
    
    
    public static Role findRole(Connection con, int id_role) {
        
        ArrayList L = new ArrayList();
        
        try {
            
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(
                                "SELECT * " + 
                                "FROM APP.ROLE " + 
                                "WHERE ID_ROLE=" + id_role);
            
            while (rs.next()) {
                
                Role p = new Role();
                
                p.setId_role(rs.getInt("ID_ROLE"));
                p.setCode(rs.getString("CODE_ROLE"));
                p.setIntitule(rs.getString("INTITULLE_ROLE"));
                
                
                L.add(p);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur connexion!!!!!");
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (L.size() > 0) ? (Role)L.get(0) 
                              : null;
    }
    
    
    public static Menu findMenu(Connection con, int id_menu) {
        
        ArrayList L = new ArrayList();
        
        try {
            
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(
                                "SELECT * " + 
                                "FROM APP.MENU " + 
                                "WHERE ID_MENU=" + id_menu);
            
            while (rs.next()) {
                
                Menu p = new Menu();
                
                p.setId_menu(rs.getInt("ID_MENU"));
                p.setId_groupe_menu(rs.getInt("ID_GROUPE_MENU"));
                p.setCode(rs.getString("CODE_MENU"));
                p.setLibelle(rs.getString("LIBELLE_MENU"));
                p.setPage(rs.getString("PAGE"));
                p.setGroupe_menu(Tools.findGroupe_Menu(con, rs.getInt("ID_GROUPE_MENU")));
                
                L.add(p);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur connexion!!!!!");
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (L.size() > 0) ? (Menu)L.get(0) 
                              : null;
    }
    
    public static Groupe_menu findGroupe_Menu(Connection con, int id_groupe_menu) {
        
        ArrayList L = new ArrayList();
        
        try {
            
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(
                                "SELECT * " + 
                                "FROM APP.GROUPE_MENU " + 
                                "WHERE ID_GROUPE_MENU=" + id_groupe_menu);
            
            while (rs.next()) {
                
                Groupe_menu p = new Groupe_menu();
                
                p.setId_groupe_menu(rs.getInt("ID_GROUPE_MENU"));
                p.setCode_groupe_menu(rs.getString("CODE_GROUPE_MENU"));
                p.setLibelle_groupe_menu(rs.getString("LIBELLE_GROUPE_MENU"));
                
                
                L.add(p);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur connexion!!!!!");
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (L.size() > 0) ? (Groupe_menu)L.get(0) 
                              : null;
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
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return L;
    }
    
    public static boolean verifyLogin(Connection con, String compte, String mot_de_passe) {
        
        boolean ok = false;
        Statement stmt = null;
        
        try 
        {
//            stmt = con.createStatement();
//            
//            ResultSet rs = stmt.executeQuery(
//                "SELECT * "         +
//                "FROM Utilisateur " + 
//                "WHERE "            + 
//                "COMPTE="           + parameter(compte) + " " + 
//                "AND "              + 
//                "MOT_DE_PASSE="     + parameter(mot_de_passe));
            
            
            stmt = con.createStatement();
            compte = "'" + compte + "'";
            mot_de_passe = "'" + mot_de_passe + "'";
            ResultSet rs = stmt.executeQuery("Select * "
                    + "from APP.UTILISATEUR where COMPTE=" + compte
                    + " and MOT_DE_PASSE=" + mot_de_passe);
            
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
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result != 0; 
        // si result est <> de 0 --> la supression a eu lieu
    }
    
    private static String parameter(Object value){
        
        return 
            "'" + value.toString() + "'";
        
    }

    public static Utilisateur findUtilisateur(Connection con, String compte) {
        
        Utilisateur p = new Utilisateur();
        
        compte = "'" + compte + "'";
        
        PreparedStatement prep;
        
        try {
            prep = con.prepareStatement("SELECT * FROM"
                    + " UTILISATEUR WHERE COMPTE=?");
            
            prep.setString(1, compte);
            
            ResultSet rs = prep.executeQuery();
            
            if (!rs.next()) {
                return null;
            }
            
            p.setId_personne(rs.getInt("ID_UTILISATEUR"));
            p.setCode_postal(rs.getInt("CODE_POSTAL"));
            p.setCompte(rs.getString("COMPTE"));
            p.setDate_naissance(rs.getDate("DATE_NAISSANCE"));
            p.setEmail(rs.getString("EMAIL"));
            //p.setEst_masculin(rs.getBoolean("EST_MASCULIN"));
            p.setLocalite(rs.getString("LOCALITE"));
            p.setMatricule(rs.getString("MATRICULE"));
            p.setMot_de_passe(rs.getString("MOT_DE_PASSE"));
            p.setNom(rs.getString("NOM"));
            p.setNumero_rue(rs.getInt("NUMERO_RUE"));
            p.setNumero_telephone(rs.getInt("NUMERO_TELEPHONE"));
            p.setPrenom(rs.getString("PRENOM"));
            p.setRue(rs.getString("RUE"));
            p.setUrl_photo(rs.getString("URL_PHOTO"));
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return p;
    }
    
}