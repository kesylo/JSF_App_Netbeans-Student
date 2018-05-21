
package beanPackage;

import java.util.Date;

public class Session {
    
    private Utilisateur utilisateur;
    private long session_id;
    
    public Session(){
        this.session_id = new Date().getTime();
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public long getSession_id() {
        return session_id;
    }
    
    
    
}
