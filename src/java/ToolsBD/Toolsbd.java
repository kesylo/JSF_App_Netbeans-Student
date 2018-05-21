/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolsBD;

import beanPackage.Client;
import beanPackage.LigneReservation;
import beanPackage.Porter;
import beanPackage.Reservation;
import beanPackage.Voiture;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CHEUKINHO
 */
public class Toolsbd {

    public static boolean verifyLogin(Connection con, String login,
            String password) {
        boolean ok = false;
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            login = "'" + login + "'";
            password = "'" + password + "'";
            ResultSet rs = stmt.executeQuery("Select * "
                    + "from CLIENT where LOGIN=" + login
                    + " and PASSWORD=" + password);
            ok = rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ok;
    }

    public static Client findClient(Connection con, String login) {
        Client p = new Client();
        PreparedStatement prep;
        try {
            prep = con.prepareStatement("Select * from"
                    + " client where login=?");
            prep.setString(1, login);
            ResultSet rs = prep.executeQuery();
            if (!rs.next()) {
                return null;
            }
            p.setId_client(rs.getInt("id_client"));
            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));
            p.setEmail(rs.getString("email"));
            p.setCode_postal(rs.getInt("code_postal"));
            p.setRue(rs.getString("rue"));
            p.setVille(rs.getString("ville"));
            if(rs.getString("sexe") != null)
                p.setSexe(rs.getString("sexe").charAt(0));
            p.setLogin(rs.getString("login"));
            p.setPassword(rs.getString("password"));
            p.setGsm(rs.getString("gsm"));

        } catch (SQLException ex) {
        }
        return p;
    }

    
    public static boolean findEmail(Connection con, String email) {

        boolean existe = true;
        PreparedStatement prep;
        try {
            prep = con.prepareStatement("select * from client where email=?");

            prep.setString(1, email);
            ResultSet rs = prep.executeQuery();
            if (!rs.next()) {
                existe = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }
    
    
    public static boolean findLogin(Connection con, String login) {

        boolean existe = true;
        PreparedStatement prep;
        try {
            prep = con.prepareStatement("select * from client where login=?");

            prep.setString(1, login);
            ResultSet rs = prep.executeQuery();
            if (!rs.next()) {
                existe = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }
    
    
    public static void storeClient(Connection con, Client C) {
        try {
            PreparedStatement prep
                    = con.prepareStatement("Insert into CLIENT "
                            + "(NOM, PRENOM,EMAIL, CODE_POSTAL, RUE, VILLE ,SEXE, LOGIN, PASSWORD,GSM) values (?,?,?,?,?,?,?,?,?,?)");
            prep.setString(1, C.getNom());
            prep.setString(2, C.getPrenom());
            prep.setString(3, C.getEmail());
            prep.setInt(4, C.getCode_postal());
            prep.setString(5, C.getRue());
            prep.setString(6, C.getVille());
            prep.setString(7, String.valueOf(C.getSexe()));
            prep.setString(8, C.getLogin());
            prep.setString(9, C.getPassword());
            prep.setString(10, C.getGsm());
            prep.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateClient(Connection con, Client C) {
        try {
            PreparedStatement prep = con.prepareStatement("UPDATE client SET NOM= ?, PRENOM= ?,EMAIL= ?,CODE_POSTAL=?,RUE=?, VILLE=?, SEXE= ?,   LOGIN=?, PASSWORD=?, GSM=? WHERE ID_CLIENT =?");
            prep.setString(1, C.getNom());
            prep.setString(2, C.getPrenom());
            prep.setString(3, C.getEmail());
            prep.setInt(4, C.getCode_postal());
            prep.setString(5, C.getRue());
            prep.setString(6, C.getVille());
            prep.setString(7, String.valueOf(C.getSexe()));
            prep.setString(8, C.getLogin());
            prep.setString(9, C.getPassword());
            prep.setString(10, C.getGsm());
            prep.setInt(11, C.getId_client());
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList findAllClients(Connection con) {
        ArrayList L = new ArrayList();
        try {
            PreparedStatement prep = con.prepareStatement("Select * from Client");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                Client C = new Client();
                C.setId_client(rs.getInt("id_client"));
                C.setNom(rs.getString("nom"));
                C.setPrenom(rs.getString("prenom"));
                C.setEmail(rs.getString("email"));
                C.setCode_postal(rs.getInt("code_postal"));
                C.setSexe(rs.getString("sexe").charAt(0));
                C.setPassword(rs.getString("password"));
                C.setLogin(rs.getString("login"));
                C.setVille(rs.getString("ville"));
                C.setGsm(rs.getString("gsm"));
                L.add(C);
            }
        } catch (SQLException ex) {
            System.out.println("erreur connexion!!!!!");
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L;
    }

    public static boolean updateLocClient(Connection con, String login, String gsm) {
        boolean ok;
        Client C = Toolsbd.findClient(con, login);
        if (C == null) {
            ok = false;
        } else {
            ok = true;
            try {
                PreparedStatement prep = con.prepareStatement("UPDATE Client SET loc=" + gsm + " WHERE login = ?");
                prep.setString(1, login);
                prep.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ok;
    }

    public static boolean deleteClient(Connection con, String login) {
        int result = 0;

        try {
            PreparedStatement prep = con.prepareStatement("DELETE from Client WHERE login = ?");
            prep.setString(1, login);
            result = prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result != 0; // si result est <> de 0 --> la supression a eu lieu
    }

    public static Voiture findVoiure(Connection con, String num_immatriculation) {
        Voiture v = new Voiture();
        PreparedStatement prep;
        try {
            prep = con.prepareStatement("Select * from"
                    + " voiture where num_immatriculation=?");
            prep.setString(1, num_immatriculation);
            ResultSet rs = prep.executeQuery();
            if (!rs.next()) {
                return null;
            }
            v.setMarque(rs.getString("Marque"));
            v.setType(rs.getString("type"));
            v.setModele(rs.getString("modele"));
            v.setPrix_jour(rs.getInt("Prix_jour"));

        } catch (SQLException ex) {
        }
        return v;
    }

    public static ArrayList<Voiture> getListVoituresByMarque(Connection con, String marque) {
        try {
            ArrayList<Voiture> voitureList = new ArrayList<>();
            PreparedStatement prep = con.prepareStatement("select * from VOITURE where marque=?");
            prep.setString(1, marque);
            ResultSet rs = prep.executeQuery();
            boolean found = false;
            while (rs.next()) {
                Voiture ad = new Voiture();
                ad.setNum_immatriculation(rs.getString("Num_immatriculation"));
                ad.setType(rs.getString("type"));
                ad.setPrix_jour(rs.getInt("prix_jour"));
                ad.setModele(rs.getString("modele"));
                voitureList.add(ad);
                found = true;

            }
            rs.close();
            if (found) {
                return voitureList;
            } else {
                return null; // no entires found
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static ArrayList<Voiture> getListVoitures(Connection con) {
        try {
            ArrayList<Voiture> voitureList = new ArrayList<>();
            PreparedStatement prep = con.prepareStatement("select * from VOITURE where dispo=?");
            prep.setString(1, 'O' + "");
            ResultSet rs = prep.executeQuery();
            boolean found = false;
            while (rs.next()) {
                Voiture ad = new Voiture();
                //System.out.println("*************** Entrer dans getListVoitures ******************");
                ad.setNum_immatriculation(rs.getString("Num_immatriculation"));
                ad.setType(rs.getString("type"));
                ad.setPrix_jour(rs.getInt("prix_jour"));
                ad.setModele(rs.getString("modèle"));
                voitureList.add(ad);
                found = true;

            }
            rs.close();
            if (found) {
                return voitureList;
            } else {
                return null; // no entires found
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void updateVoitureDispo(Connection con, String immatricule, char disponib) {

        try {
            PreparedStatement prep = con.prepareStatement("UPDATE voiture SET dispo=? WHERE NUM_IMMATRICULATION = ?");
            prep.setString(1, disponib + "");
            prep.setString(2, immatricule);
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public static int findNumReser(Connection con, Timestamp date_reservation, int id_client) {

        int id_reserv = 0;
        PreparedStatement prep;
        try {
            prep = con.prepareStatement("select * from RESERVATION where ID_CLIENT=? AND DATE_RESERVATION=?");
            prep.setInt(1, id_client);
            prep.setTimestamp(2, date_reservation);

            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                id_reserv = rs.getInt("ID_RESERVATION");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return id_reserv;
    }
    
    
    public static void storeReservation(Connection con, Reservation r, ArrayList<LigneReservation> l) {
        
        int id_reserv = 0;
        try {
            PreparedStatement prep = null;
            prep = con.prepareStatement("Insert into RESERVATION "
                    + "(id_client, date_reservation, montant_reservation) values (?,?,?)");
            prep.setInt(1, r.getId_client());
            prep.setTimestamp(2, r.getDate_reservation());

            prep.setDouble(3, r.getMontant_reservation());

            prep.execute();
            
            id_reserv = findNumReser(con, r.getDate_reservation(), r.getId_client());
            System.out.println("*************** id_reservation = "+id_reserv+" ******************");
            
            
            prep = con.prepareStatement("Insert into PORTER "
                    + "(id_reservation,num_immatriculation, date_debut_reservation, date_fin_reservation) values (?,?,?,?)");
            for (LigneReservation pt : l) {
                System.out.println("***************"+pt.getNum_immatriculation()+" ******************");
                prep.setInt(1, id_reserv);
                prep.setString(2, pt.getNum_immatriculation());
                prep.setDate(3, pt.getDate_debut_reservation());
                prep.setDate(4, pt.getDate_fin_reservation());
                prep.execute();
            }
        } catch (SQLException ex) {
            System.out.println("*************** EXCEPTION ******************");
        }
    }

    public static ArrayList<Reservation> getListReservation(Connection con, int id_client) {
        try {
            ArrayList<Reservation> reservationList = new ArrayList<>();
            PreparedStatement prep = con.prepareStatement("select * from RESERVATION where ID_CLIENT=?");
            prep.setInt(1, id_client);
            ResultSet rs = prep.executeQuery();
            boolean found = false;
            while (rs.next()) {
                Reservation re = new Reservation();
                //System.out.println("*************** Entrer dans getListVoitures ******************");
                re.setId_client(rs.getInt("ID_CLIENT"));
                re.setDate_reservation(rs.getTimestamp("DATE_RESERVATION"));
                re.setId_reservation(rs.getInt("ID_RESERVATION"));
                re.setMontant_reservation(rs.getFloat("MONTANT_RESERVATION"));
                
                reservationList.add(re);
                found = true;

            }
            rs.close();
            if (found) {
                return reservationList;
            } else {
                return null; // no entires found
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public static ArrayList<Porter> getListReservationPorter(Connection con, int id_reservation) {
        try {
            ArrayList<Porter> reservationPorterList = new ArrayList<>();
            PreparedStatement prep = con.prepareStatement("select * from PORTER where ID_RESERVATION=?");
            prep.setInt(1, id_reservation);
            ResultSet rs = prep.executeQuery();
            boolean found = false;
            while (rs.next()) {
                Porter reP = new Porter();
                //System.out.println("*************** Entrer dans getListVoitures ******************");
                reP.setNum_immatriculation(rs.getString("NUM_IMMATRICULATION"));
                reP.setDate_debut_reservation(rs.getDate("DATE_DEBUT_RESERVATION"));
                reP.setDate_fin_reservation(rs.getDate("DATE_FIN_RESERVATION"));
                
                reservationPorterList.add(reP);
                found = true;

            }
            rs.close();
            if (found) {
                return reservationPorterList;
            } else {
                return null; // no entires found
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toolsbd.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
