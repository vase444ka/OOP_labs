package app.db;

import app.Config;
import app.entities.Flight;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class FlightDAO {
    private static List<Flight> parseFromRS(ResultSet rs) throws SQLException {
        LinkedList<Flight> flights = new LinkedList<>();
        while (rs.next()) {
            String origin = rs.getString("origin");
            String destination = rs.getString("destination");
            Timestamp date = rs.getTimestamp("date");
            int duration = rs.getInt("duration");
            int capacity = rs.getInt("capacity");
            int baseprice = rs.getInt("baseprice");
            Flight nextFlight = new
                    Flight(origin, destination, date, duration, capacity, baseprice);
            flights.add(nextFlight);

        }
        return flights;
    }

    public static Long insert(Flight flight) {
        String sql = "INSERT INTO flight(idcompany, origin, destination, date, duration, capacity, baseprice) VALUES (?,?,?,?,?,?,?) RETURNING idflight";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setLong(1, Config.getCompanyId());//TODO config
            statement.setString(2, flight.getOrigin());
            statement.setString(3, flight.getDestination());
            statement.setTimestamp(4, flight.getDate());
            statement.setInt(5, flight.getDuration());
            statement.setInt(6, flight.getCapacity());
            statement.setInt(7, flight.getBasePrice());

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

    public static List<Flight> getAll() {
        String sql = "SELECT * FROM flight";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            List<Flight> res = parseFromRS(rs);
            st.close();
            con.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Flight findById(Long id){
        String sql = "SELECT * FROM flight WHERE idflight = ?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement st = con.prepareStatement(sql);

            st.setLong(1, id);

            ResultSet rs = st.executeQuery();
            Flight res = parseFromRS(rs).get(0);
            st.close();
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void update(Flight flight){
        String sql = "UPDATE flight SET origin=?, destination=?, date=?, duration=?, capacity=?, baseprice=? WHERE idflight=?";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, flight.getOrigin());
            statement.setString(2, flight.getDestination());
            statement.setTimestamp(3, flight.getDate());
            statement.setInt(4, flight.getDuration());
            statement.setInt(5, flight.getCapacity());
            statement.setInt(6, flight.getBasePrice());

            statement.executeUpdate();
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteById(Long id){
        DBUtils.deleteById("DELETE FROM flight WHERE idflight = ?", id);
    }
}
