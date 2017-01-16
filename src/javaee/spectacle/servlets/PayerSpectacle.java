package javaee.spectacle.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaee.spectacle.beans.Client;
import javaee.spectacle.webservices.GestionSpectaclesService;
import javaee.spectacle.webservices.Reservation;
import javaee.spectacle.webservices.WSGestionSpectacles;

/**
 * Servlet implementation class payerSpectacle
 */
@WebServlet("/PayerSpectacle")
public class PayerSpectacle extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String VUE = "/payerSpectacle.jsp";

  /**
   * @see HttpServlet#HttpServlet()
   */
  public PayerSpectacle() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    final HttpSession session = request.getSession();
    Timestamp datePaiement = null;
    Timestamp dateValidite = null;
    final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date datetest = null;
    final Client client = (Client) request.getSession().getAttribute("client");
    // Vérification de la date
    try {
      datePaiement = new Timestamp(new Date().getTime());
      if (!request.getParameter("dateValidite").equals("")) {
        try {
          datetest = format.parse(request.getParameter("dateValidite"));
          dateValidite = new Timestamp(datetest.getTime());
        } catch (final ParseException e) {
          e.printStackTrace();
        }
      } else {
        throw new Exception("Vous avez fait une erreur de date, ou votre carte n'est plus valide");
      }
      if (!dateValidite.after(datePaiement)) {
        throw new Exception("La date n'est pas correcte");
      }
      // Vérification du numero de carte
      final String numCarte = request.getParameter("numeroCarte");
      if (numCarte.length() != 16) {
        throw new Exception("Le numéro de votre carte n'est pas correct");
      } else {
        Long.parseLong(request.getParameter("numeroCarte"));
      }
      // Vérification du cryptogramme
      final String cryptoCarte = request.getParameter("cryptogramme");
      if (cryptoCarte.length() != 3) {
        throw new Exception("Votre cryptogramme n'est pas correct");
      } else {
        Integer.parseInt(request.getParameter("cryptogramme"));
      }
      final GestionSpectaclesService service = new GestionSpectaclesService();
      final WSGestionSpectacles port = service.getGestionSpectaclesPort();
      // Paiement de la réservation
      port.payerSpectacle(((Reservation) session.getAttribute("reservation")).getIdReservation());
      // Récupération des réservations du client
      final List<Reservation> reservations = port.recupererReservation(client.getIdClient());
      session.setAttribute("reservations", reservations);
      // Tri des réservations payées et non payées
      final ArrayList<Reservation> reservationsNonPayées = new ArrayList<Reservation>();
      if (reservations != null) {
        for (int i = 0; i < reservations.size(); i++) {
          if (reservations.get(i).isPaiement() == false) {
            reservationsNonPayées.add(reservations.get(i));
          }
        }
        session.setAttribute("listesSpectaclesNonPayées", reservationsNonPayées);
      }
      // Renvoie vers le menu principal
      request.getRequestDispatcher("MenuPrincipal.jsp").forward(request, response);
    } catch (final Exception e) {
      request.setAttribute("exception", e.getMessage());
      request.getRequestDispatcher("ErreurPayerSpectacle.jsp").forward(request, response);
    }

  }

}
