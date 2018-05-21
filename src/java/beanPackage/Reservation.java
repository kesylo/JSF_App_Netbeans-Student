/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanPackage;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author CHEUKINHO
 */
public class Reservation {
    
    private int id_reservation, id_client;
    private Timestamp date_reservation;
    private float  montant_reservation;

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }


    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public float getMontant_reservation() {
        return montant_reservation;
    }

    public void setMontant_reservation(float montant_reservation) {
        this.montant_reservation = montant_reservation;
    }

    public Timestamp getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(Timestamp date_reservation) {
        this.date_reservation = date_reservation;
    }





    
    
}
