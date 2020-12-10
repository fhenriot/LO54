package fr.utbm.lo54.servlets;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.database.Database;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.plugins.PluginFolder;
import org.pentaho.di.core.plugins.PluginRegistry;
import org.pentaho.di.core.plugins.StepPluginType;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.www.AddTransServlet;
import org.pentaho.di.core.encryption.KettleTwoWayPasswordEncoder;

import java.sql.ResultSet;

public class PentahoDI  {
    public static void main(String[] args) {
            try {
                System.setProperty("KETTLE_PLUGIN_CLASSES", "org.pentaho.di.core.encryption.KettleTwoWayPasswordEncoder");

                KettleEnvironment.init();

                DatabaseMeta dbm = new DatabaseMeta();

                dbm.setDatabaseInterface(DatabaseMeta.getDatabaseInterface("MySQL"));

                dbm.setName("lo54");

                dbm.setHostname("localhost");
                dbm.setDBName("lo54");
                dbm.setDBPort("3306");

                Database db = new Database(null, dbm);

                db.connect();

                ResultSet rs = db.openQuery("select * from course");

                if(rs != null) {
                    System.out.println("");
                    System.out.println("");

                    int colCount = rs.getMetaData().getColumnCount();

                    for(int i = 1; i < colCount; i++) {
                        System.out.print(rs.getMetaData().getColumnName(i));
                    }
                    System.out.println("");

                    while(rs.next()) {
                        // Do something with your data
                    }

                    db.closeQuery(rs);
                }
                db.disconnect();

            } catch(Throwable e) {
                e.printStackTrace();
            }
        }
    }

