package managedBeanPackage;

import ToolsBD.Tools;
import beanPackage.Autorisation;
import beanPackage.Groupe_menu;
import beanPackage.Role;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import java.util.HashSet;
import java.util.Map;

public class LoginBean extends AppBean {
    
    @Resource(name = "ds")
    private DataSource ds;

    private Role role;
    private ArrayList<Autorisation> autorisations;
    private String compte, mot_de_passe;
    private Connection con;
    private MenuModel menu_source;

    public LoginBean() { }
    
    
    @PostConstruct
    private void init() {
        
        try {
            con = ds.getConnection();
//            this.utilisateur = new Utilisateur();
//            this.role = new Role();
//            this.autorisations = new ArrayList<Autorisation>();
        } catch (SQLException ex) {

        }
        
    }

    public void loginProcess() {

        // -- Définition de la clé de page -- //
        //String cle = "acceuil";
        if (Tools.verifyLogin(con, compte, mot_de_passe)) {
            utilisateur = Tools.findUser(con, compte);

            // On est connecté
            System.out.println("connecté");

            // -- Réccupération du context -- //
            FacesContext context = FacesContext.getCurrentInstance();

            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            session.setAttribute("utilisateur", utilisateur);

            try {
                context.getExternalContext().redirect("examen.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            System.out.println("echec de login");
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage();
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            fm.setSummary("Mauvais email et/ou password");
            fm.setDetail("Encoder une valeur correcte pour l'E-mail et/ou Password");
            fc.addMessage("form:valider", fm);

            fc.renderResponse();
        }
//        try {
//
//            // -- Vérifier l'authentification de l'utilisateur -- //
//            if (getCompte() == null || getCompte() == "" || getMot_de_passe() == null || getMot_de_passe() == "") {
//                // -- Notifier l'echec de l'authentification -- //
//                context.addMessage(null, new FacesMessage("Echec", "Authentification refusée!"));
//            } else {
//                // Définition de la clé de la page à rediriger -- //
//                cle = "acceuil";
//            }
//
//            // -- Définition du rendu de la réponse -- //
//            context.renderResponse();
//        } catch (Exception ex) {
//
//        }

        //return cle;
    }

    public void authentification() {

        // -- Définition de la clé de page -- //
        String cle_page = "";
        // -- Réccupération du context -- //
        FacesContext context = FacesContext.getCurrentInstance();

        try {

            // -- Vérifier l'authentification de l'utilisateur -- //
            if (!Tools.verifyLogin(con, compte, mot_de_passe)) {
                // -- Notifier l'echec de l'authentification -- //
                context.addMessage(null, new FacesMessage("Echec", "Authentification refusée!"));
            } 
            else {
                // Définition de la clé de la page à rediriger -- //
                cle_page = "acceuil";
                // -- Mise à jour des informations de l'utilisateur connecté user, role et autorisations-- //
                utilisateur = Tools.findUser(con, compte);
                // -- Réccupération de la session -- //
                HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
                //session.setAttribute("client", c);
                session.setAttribute("utilisateur", utilisateur);
                // -- Definition du titre de la page dans la session -- //
                context.getExternalContext().getSessionMap().put("titre", "Acceuil");
                // -- Redirection vers la page d'application -- //
                context.getExternalContext().redirect("acceuil.xhtml");
            }

            // -- Définition du rendu de la réponse -- //
            context.renderResponse();
        } catch (Exception ex) {

        }

        //return cle_page;
    }

    public void deconnexion() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            context.getExternalContext().redirect("authentification.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void test() {
//
//        try {
//
//            FacesContext context = FacesContext.getCurrentInstance();
//
//            context.getExternalContext().redirect("newjsf.xhtml");
//
//        } catch (IOException ex) {
//            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    
    
    
    
    
    
    
    
    
    // Getters et setters
    


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public ArrayList<Autorisation> getAutorisations() {
        return autorisations;
    }

    public void setAutorisations(ArrayList<Autorisation> autorisations) {
        this.autorisations = autorisations;
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

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public MenuModel getMenu_source() {
        
        // -- Initialisation du model -- //
        this.menu_source = new DefaultMenuModel();
        
        // -- Liste des menus -- //
        ArrayList<DefaultMenuItem> menus = new ArrayList();
        Map<String, String> refs = new HashMap<>();
        
        // create a new hashtable
        HashSet<Groupe_menu> groupes_menu = new HashSet<>();
        
        // -- Parcours des autorisation de l'utilisateur -- //
        for(Autorisation autorisation : this.utilisateur.getAutorisations())
        {
            // -- Creation du menu -- //
            DefaultMenuItem menu = new DefaultMenuItem(autorisation.getMenu().getLibelle());
            // -- Définition de son action -- //
            menu.setCommand("#{menuBean.page}");
            //menu.setHref("https://www.google.com/");
            // -- Ajout de son icone - //
            menu.setIcon("ui-icon-home");
            // -- Réccupération de son id_groupe -- //
            menu.setId(autorisation.getId_menu() + "");
            refs.put(autorisation.getId_menu() + "", autorisation.getMenu().getId_groupe_menu() + "");
            
            // -- AJout dans la liste des menus -- //
            menus.add(menu);
            
            // -* Autorisateur d'ajout -- //
            Boolean autorise = true;
            // -- Check l'autorisation -- //
            for(Groupe_menu gp : groupes_menu)
            {
                if (gp.getId_groupe_menu() == autorisation.getMenu().getId_groupe_menu())
                {
                    autorise = false;
                    break;
                }
            }
            // -- AJout à la liste des groupes menus -- //
            if (autorise){
                groupes_menu.add(autorisation.getMenu().getGroupe_menu());
            }
        }
        
        // -- Creation des sous menus -- //
        for(Groupe_menu goupe_menu : groupes_menu)
        {
            // -- Creation du sous menu -- //
            DefaultSubMenu sous_menu = new DefaultSubMenu(goupe_menu.getLibelle_groupe_menu());
            
            // -- AJout de ses menus -- //
            for(DefaultMenuItem menu : menus){
                // -- Teste si celui possède le id_groupe -- //
                if (goupe_menu.getId_groupe_menu() == Integer.parseInt(refs.get(menu.getId())))
                {
                    // ** AJout du menu dans le sous menu -- //
                    sous_menu.addElement(menu);
                }
            }
            
            // -- Ajout des groupes de menu dans la source -- //
            menu_source.addElement(sous_menu);
        }      
                
        return menu_source;
    }

    public void setMenu_source(MenuModel menu_source) {
        this.menu_source = menu_source;
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
   


    
    
    
    
    

}
