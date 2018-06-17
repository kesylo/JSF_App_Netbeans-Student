
package beanPackage;


public class ViewModel {

    private String titre;
    private Object donnees;
    
    public ViewModel(String titre, Object obj) {
        this.titre = titre;
        this.donnees = obj;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Object getDonnees() {
        return donnees;
    }

    public void setDonnees(Object donnees) {
        this.donnees = donnees;
    }
    
    
}
