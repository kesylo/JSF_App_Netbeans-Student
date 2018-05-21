/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanPackage;

/**
 *
 * @author CHEUKINHO
 */
public class Voiture {
    private String num_immatriculation, marque, type,modele;
    private int  prix_jour;

    public String getNum_immatriculation() {
        return num_immatriculation;
    }

    public void setNum_immatriculation(String num_immatriculation) {
        this.num_immatriculation = num_immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getPrix_jour() {
        return prix_jour;
    }

    public void setPrix_jour(int prix_jour) {
        this.prix_jour = prix_jour;
    }

   
}
