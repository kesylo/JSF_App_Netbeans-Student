
package ToolsBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProgramTest {
    
    @Resource(name = "ds")
    private static DataSource ds;
    
    
    
    
    
    private static Connection con = null;
    
    @PostConstruct
    private static void init() {

        try {
            con = ds.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    
    
    
    
    
    public static void main(String[] args) throws NamingException {
        
        init();
        
        ArrayList value = Tools.findAllAutorisations(con);
    }

    
    
    public static DataSource getDs() {
        return ds;
    }

    public static void setDs(DataSource ds) {
        ProgramTest.ds = ds;
    }
}
