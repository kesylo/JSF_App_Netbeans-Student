
package managedBeanPackage;

import beanPackage.Menu;
import beanPackage.Utilisateur;
import beanPackage.ViewModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.sql.DataSource;

public class MenuBean {

    private Menu menu;
    private ViewModel viewmodel;
    private Utilisateur utilisateur;
    
    @Resource(name = "ds")
    private DataSource ds;
    private Connection con = null;

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
    
    public MenuBean() {
    }
    
    @PostConstruct
    private void init() {
        
        // -- Réccupération du context -- //
        FacesContext context = FacesContext.getCurrentInstance();
        
        try {
            con = ds.getConnection();   
            
            // -- Réccupération du titre de la page -- //
            this.viewmodel = new ViewModel(
                                (String)context.getExternalContext().getSessionMap().get("titre"),
                                null
                            );
            // -- Mise à jour des menus et rol de l'utilisateur connecté -- //
            this.menu = new Menu(this.utilisateur.getId_role());
        } catch (SQLException ex) {
            Logger.getLogger(AppBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void page (){
   
        // -- Définition de la clé de page -- //
        String cle_page = "", page_name = "utilisateur.xhtml";
        // -- Réccupération du context -- //
        FacesContext context = FacesContext.getCurrentInstance();

        try {

            // -- Réccupération des paraètres -- //
            //int id_menu = (int) context.getAttributes().get("id_menu");
          
            
            // Définition de la clé de la page à rediriger -- //
            cle_page = "page";
            // -- Definition du titre de la page dans la session -- //
            context.getExternalContext().getSessionMap().put("titre", page_name);
            // -- Redirection vers la page d'application -- //
            context.getExternalContext().redirect(page_name);
              
            // -- Notifier l'echec de l'authentification -- //
            //context.addMessage(null, new FacesMessage("Echec", "Autorisation refusée!"));
        } catch (Exception ex) {
            // -- Notifier l'echec de l'authentification -- //
            context.addMessage(null, new FacesMessage("Echec", ex.getMessage()));
        }

        //return cle_page;
        
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ViewModel getViewmodel() {
        return viewmodel;
    }

    public void setViewmodel(ViewModel viewmodel) {
        this.viewmodel = viewmodel;
    }
    
    
}
