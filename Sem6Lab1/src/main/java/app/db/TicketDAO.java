package app.db;

import app.entities.Ticket;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TicketDAO {
    private static List<Ticket> parseFromRS(ResultSet rs) throws SQLException {
        LinkedList<Ticket> tickets = new LinkedList<>();
        while (rs.next()) {
            Long id = rs.getLong("idticket");
            Long flightId = rs.getLong("idflight");
            Long clientId = rs.getLong("idclient");
            Boolean luggage = rs.getBoolean("isluggage");
            Boolean fastLane = rs.getBoolean("isfastlane");
            Timestamp datePurchased = rs.getTimestamp("datepurchased");
            Integer price = rs.getInt("price");

            Ticket nextTicket = new Ticket(id, flightId, clientId, luggage, fastLane, datePurchased, price);
            tickets.add(nextTicket);
        }
        return tickets;
    }

    public static Long insert(Ticket ticket) {
        String sql = "INSERT INTO ticket(idflight, idclient, isluggage, isfastlane, datepurchased, price) VALUES(?,?,?,?,?,?) RETURNING idticket";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setLong(1, ticket.getFlightId());
            statement.setLong(2, ticket.getClientId());
            statement.setBoolean(3, ticket.getLuggage());
            statement.setBoolean(4, ticket.getFastLane());
            statement.setTimestamp(5, ticket.getDatePurchased());
            statement.setInt(6, ticket.getPrice());

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

    public static List<Ticket> getAll() {
        String sql = "SELECT * FROM ticket";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            List<Ticket> res = parseFromRS(rs);
            st.close();
            con.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Ticket findById(Long id){
        String sql = "SELECT * FROM ticket WHERE idclient = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setLong(1, id);

            ResultSet rs = st.executeQuery();
            Ticket res = parseFromRS(rs).get(0);
            st.close();
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void update(Ticket ticket){
        String sql = "UPDATE ticket SET idflight=?, idclient=?, isluggage=?, isfastlane=?, datepurchased=?, price=? WHERE idticket=?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setLong(1, ticket.getFlightId());
            statement.setLong(2, ticket.getClientId());
            statement.setBoolean(3, ticket.getLuggage());
            statement.setBoolean(4, ticket.getFastLane());
            statement.setTimestamp(5, ticket.getDatePurchased());
            statement.setInt(6, ticket.getPrice());
            statement.setLong(7, ticket.getId());

            statement.executeUpdate();
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteById(Long id){
        DBUtils.deleteById("DELETE FROM ticket WHERE idclient = ?", id);
    }

}
