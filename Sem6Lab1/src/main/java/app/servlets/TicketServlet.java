package app.servlets;

import app.db.ClientDAO;
import app.db.TicketDAO;
import app.entities.Client;
import app.entities.Flight;
import app.db.FlightDAO;
import app.entities.Ticket;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
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

@WebServlet(name = "ticket", value = "/ticket")
public class TicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println("----------------GET TICKETS request------------");
        List<Ticket> tickets = TicketDAO.getAll();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(new Gson().toJson(tickets));
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

        Ticket ticket = new Gson().fromJson(jb.toString(), Ticket.class);
        System.err.println(ticket.toString());
        TicketDAO.insert(ticket);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(new Gson().toJson(TicketDAO.findById(ticket.getId())));
        out.flush();
        System.err.println("----------------POST TICKET request------------");
    }
}
