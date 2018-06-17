
package managedBeanPackage;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

public class AcceuilBean extends AppBean {

    public AcceuilBean() { }
    
    @PostConstruct
    protected void init() {
        try {
            con = ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AppBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
