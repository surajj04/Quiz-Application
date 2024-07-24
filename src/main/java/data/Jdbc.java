package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {
    private Connection con;
    private String url = "jdbc:mysql://localhost:3306/quiz";
    private String user = "root";
    private String password = "root";

    public Jdbc() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection getCon() {
        return con;
    }
}
