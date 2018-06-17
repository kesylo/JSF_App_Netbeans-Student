
package beanPackage;

import java.sql.Date;
import java.util.ArrayList;


public class Utilisateur {
    
    private String matricule, nom, prenom, email, rue, localite, compte, mot_de_passe, url_photo;
    private int id_personne, id_role, numero_telephone, numero_rue, code_postal;
    private Date date_naissance;
    private boolean est_masculin;
    private Role role;
    private ArrayList<Autorisation> autorisations;
    

    public Role getRole() {
        return role;
    }

    public ArrayList<Autorisation> getAutorisations() {
        return autorisations;
    }

    public void setAutorisations(ArrayList<Autorisation> autorisations) {
        this.autorisations = autorisations;
    }



    public void setRole(Role role) {
        this.role = role;
    }
    
    
    public String getMatricule() {
        return matricule;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }

    public int getNumero_telephone() {
        return numero_telephone;
    }

    public void setNumero_telephone(int numero_telephone) {
        this.numero_telephone = numero_telephone;
    }

    public int getNumero_rue() {
        return numero_rue;
    }

    public void setNumero_rue(int numero_rue) {
        this.numero_rue = numero_rue;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public boolean isEst_masculin() {
        return est_masculin;
    }

    public void setEst_masculin(boolean est_masculin) {
        this.est_masculin = est_masculin;
    }
    
    
}
