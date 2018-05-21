/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanPackage;

import java.util.Date;

/**
 *
 * @author Henchiri
 */
public class VoiturePanier {
    private Voiture voiture;
    private Date dateDebut;
    private Date dateFin;
    private int numberOfDays;

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }


    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public VoiturePanier(Voiture voiture, Date dateDebut, Date dateFin, int numberOfDays) {
        this.voiture = voiture;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.numberOfDays = numberOfDays;
    }

    
    
    
    
}
