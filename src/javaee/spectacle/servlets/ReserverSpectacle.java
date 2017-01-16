package javaee.spectacle.servlets;

import java.io.IOException;
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
import javaee.spectacle.webservices.Spectacle;
import javaee.spectacle.webservices.WSGestionSpectacles;

/**
 * Servlet implementation class ReserverSpectacle
 */
@WebServlet("/ReserverSpectacle")
public class ReserverSpectacle extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ReserverSpectacle() {}

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.sendRedirect("VUE_DEBUT");
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    final HttpSession session = request.getSession();
    // on récupère le spectacle qu'on veut réserver
    final Spectacle spectacleReserve = (Spectacle) session.getAttribute("spectacleChoisi");
    // on récupère le client qui fait la reservation
    final Client client = (Client) session.getAttribute("client");
    // on créée la base de donnée des réservations
    final GestionSpectaclesService service = new GestionSpectaclesService();
    final WSGestionSpectacles port = service.getGestionSpectaclesPort();
    // on récupère le nombre de places de la réservation
    Integer nombreDePlaces = new Integer(0);
    try {
      nombreDePlaces = Integer.parseInt(request.getParameter("Nombre de places"));
    } catch (final Exception e) {
      e.printStackTrace();
    }
    // on récupère le fait que le paiement se fait maintenant ou non
    String payerMaintenant = "";
    try {
      payerMaintenant = (request.getParameter("choix"));
    } catch (final Exception e) {
      e.printStackTrace();
    }
    // on créée la réservation et on l'intègre à la base de données
    final Reservation reservation = new Reservation();
    reservation.setNombrePlaces(nombreDePlaces);
    reservation.setIdSpectacle(spectacleReserve.getId());
    reservation.setIdReservation(null);
    reservation.setPaiement(false);
    reservation.setIdClient(client.getIdClient());
    int codeReservation = 0;
    try {
      codeReservation = port.reserverSpectacle(reservation);
      reservation.setIdReservation(codeReservation);
    } catch (final Exception e) {
      e.printStackTrace();
    }
    // on réinitialise toutes les réservations du client dans la session
    try {
      final List<Reservation> reservations = port.recupererReservation(client.getIdClient());
      session.setAttribute("reservations", reservations);
      session.setAttribute("reservation", reservation);
    } catch (final Exception e) {
      e.printStackTrace();
    }
    if (payerMaintenant.equals("Payer maintenant")) {
      request.getRequestDispatcher("payerSpectacle.jsp").forward(request, response);;
    } else {
      request.getRequestDispatcher("voirPanier.jsp").forward(request, response);;
    }
  }

}
