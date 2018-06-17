package managedBeanPackage;

import beanPackage.Utilisateur;
import java.sql.Connection;
import javax.annotation.Resource;
import javax.sql.DataSource;

public class AppBean {

    protected Utilisateur utilisateur;
    
    @Resource(name = "ds")
    protected DataSource ds;
    protected Connection con = null;

    public DataSource getDs() {
        return ds;
    }

    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }    
    
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
