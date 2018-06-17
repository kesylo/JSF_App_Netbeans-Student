
package beanPackage;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;


public class Menu {
   
    private int id_menu, id_groupe_menu;
    private String code, libelle;
    private Role role;
    private Groupe_menu groupe_menu;
    private MenuModel source;
    private String page;
    
    public Menu (){}
    
    public Menu (int id_role){
        
        this.role = new Role();
        this.role.setId_role(id_role);
        this.role.setCode("001");
        this.role.setIntitule("role_admin");
        
        this.source = new DefaultMenuModel();
         
        // -- Gestion de la sécurité -- //
        DefaultSubMenu groupe_menu_1 = new DefaultSubMenu("Securité");
        // -- Gestion du personnel -- //
        DefaultSubMenu groupe_menu_2 = new DefaultSubMenu("Personnel");
         
        // -- Utilisateur -- //
        DefaultMenuItem menu_1 = new DefaultMenuItem("Utilisateurs");
        menu_1.setCommand("#{menuBean.page(3)}");
        menu_1.setIcon("ui-icon-home");
        
        // -- Role -- //
        DefaultMenuItem menu_2 = new DefaultMenuItem("Roles");
        menu_2.setCommand("#{menuBean.page(2)}");
        menu_2.setIcon("ui-icon-home");
        //menu_2.setParam("id_menu", 1);
        //menu_2.setUpdate("notification");
        //menu_2.setUrl("role.xhtml");
        
        // -- Menu -- //
        DefaultMenuItem menu_3 = new DefaultMenuItem("Menu");
        menu_3.setCommand("#{menuBean.page(1)}");
        menu_3.setIcon("ui-icon-home");
        
        // -- Autorisations -- //
        DefaultMenuItem menu_4 = new DefaultMenuItem("Autorisations");
        menu_4.setCommand("#{menuBean.page(1)}");
        menu_4.setIcon("ui-icon-home");
        
        // -- Ajout des menus dans le groupe - //
        groupe_menu_1.addElement(menu_1);
        groupe_menu_1.addElement(menu_2);
        groupe_menu_1.addElement(menu_3);
        groupe_menu_1.addElement(menu_4);
        
        // -- Enseignants -- //
        DefaultMenuItem menu_5 = new DefaultMenuItem("Enseignants");
        menu_5.setCommand("#{menuBean.page(1)}");
        menu_5.setIcon("ui-icon-home");
        
        // -- AJout des menus dans le groupe -- //
        groupe_menu_2.addElement(menu_5);
        
        // -- Ajout des groupes de menu dans la source -- //
        this.source.addElement(groupe_menu_1);
        this.source.addElement(groupe_menu_2);
        
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public String getCode() {
        return code;
    }

    public Groupe_menu getGroupe_menu() {
        return groupe_menu;
    }

    public void setGroupe_menu(Groupe_menu groupe_menu) {
        this.groupe_menu = groupe_menu;
    }

    public int getId_groupe_menu() {
        return id_groupe_menu;
    }

    public void setId_groupe_menu(int id_groupe_menu) {
        this.id_groupe_menu = id_groupe_menu;
    }
    
    

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
    
    

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public MenuModel getSource() {
        return source;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }    
    
    
}
