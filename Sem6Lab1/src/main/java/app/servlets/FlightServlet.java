package app.servlets;

import app.db.ClientDAO;
import app.db.FlightDAO;
import app.entities.Client;
import app.entities.Flight;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "flight", value = "/flight")
public class FlightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println("----------------GET FLIGHTS request------------");
        List<Flight> flights = FlightDAO.getAll();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(new Gson().toJson(flights));
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer jb = new StringBuffer();
        String line;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            System.err.println("Couldn't parse post request: " + e.getMessage());
        }

        Flight flight = new Gson().fromJson(jb.toString(), Flight.class);
        System.err.println(flight.toString());
        FlightDAO.insert(flight);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(new Gson().toJson(FlightDAO.findById(flight.getId())));
        out.flush();
        System.err.println("----------------POST FLIGHT request------------");
    }
}
