package stat.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ModelManager {

    private Connection connection;

    public static ModelManager manager = new ModelManager();

    public ModelManager() {
    }

    public void accessDB() {
        String url = "jdbc:oracle:thin:@oracle11g.cin.ufpe.br:1521:Instance01";
        try {
            connection = DriverManager.getConnection(url, "g181if685cc_eq03", "mriknlwk");

        } catch (SQLException e) {
            System.out.println("PASSEI AQUI, DOIDERA");
        }
    }

}
