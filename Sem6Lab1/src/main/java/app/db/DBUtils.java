package app.db;

import app.Config;

import java.sql.*;

public class DBUtils {
    private DBUtils(){}

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(Config.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  DriverManager.getConnection(Config.getConnectionUrl(),
                Config.getUserName(), Config.getPassword());
    }

    public static void deleteById(String sql, long id){
        try {
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setLong(1, id);

            st.executeUpdate();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
