/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanPackage;

import java.sql.Date;

/**
 *
 * @author Henchiri
 */
public class LigneReservation {
    private Date date_debut_reservation, date_fin_reservation;
    private String num_immatriculation;

    public Date getDate_debut_reservation() {
        return date_debut_reservation;
    }

    public void setDate_debut_reservation(Date date_debut_reservation) {
        this.date_debut_reservation = date_debut_reservation;
    }

    public Date getDate_fin_reservation() {
        return date_fin_reservation;
    }

    public void setDate_fin_reservation(Date date_fin_reservation) {
        this.date_fin_reservation = date_fin_reservation;
    }

    public String getNum_immatriculation() {
        return num_immatriculation;
    }

    public void setNum_immatriculation(String num_immatriculation) {
        this.num_immatriculation = num_immatriculation;
    }
    
    
}
