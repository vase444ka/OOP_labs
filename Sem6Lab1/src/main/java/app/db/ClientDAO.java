package app.db;

import app.entities.Client;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClientDAO {
    private static List<Client> parseFromRS(ResultSet rs) throws SQLException {
        LinkedList<Client> clients = new LinkedList<>();
        while (rs.next()) {
            Long id = rs.getLong("idclient");
            String firstName = rs.getString("fname");
            String lastName = rs.getString("lname");
            String userName = rs.getString("username");
            String password = rs.getString("password");
            Client nextClient = new Client(id, firstName, lastName, userName, password);
            clients.add(nextClient);
        }
        return clients;
    }

    public static Long insert(Client client) {
        String sql = "INSERT INTO client(fname, lname, username, password) VALUES (?,?,?,?) RETURNING idclient";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1,client.getFirstName());
            statement.setString(2,client.getLastName());
            statement.setString(3,client.getUserName());
            statement.setString(4,client.getPassword());

            ResultSet rs = statement.executeQuery();
            Long res = rs.getLong(1);
            statement.close();
            con.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Client> getAll() {
        String sql = "SELECT * FROM client";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            List<Client> res = parseFromRS(rs);
            st.close();
            con.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Client findById(Long id){
        String sql = "SELECT * FROM client WHERE idclient = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setLong(1, id);

            ResultSet rs = st.executeQuery();
            Client res = parseFromRS(rs).get(0);
            st.close();
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void update(Client client){
        String sql = "UPDATE client SET fname=?, lname=?, username=?, password=? WHERE idclient=?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1,client.getFirstName());
            statement.setString(2,client.getLastName());
            statement.setString(3,client.getUserName());
            statement.setString(4,client.getPassword());
            statement.setLong(5, client.getId());

            statement.executeUpdate();
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteById(Long id){
        DBUtils.deleteById("DELETE FROM client WHERE idclient = ?", id);
    }
}
