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
import javaee.spectacle.webservices.WSGestionSpectacles;

/**
 * Servlet implementation class MonCompte
 */
@WebServlet("/MonCompte")
public class MonCompte extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String VUE_CONNEXION = "Connexion.jsp";
  private static final String VUE_COMPTE = "afficherCompte.jsp";

  /**
   * @see HttpServlet#HttpServlet()
   */
  public MonCompte() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    final HttpSession session = request.getSession();

    // Si aucun client dans la session on renvoie sur la page de connexion sinon on recupere ses
    // réservations
    if (session.getAttribute("client") == null) {
      response.sendRedirect(VUE_CONNEXION);
      // Sinon on charge les reservations et on affiche au client son compte
    } else {
      final Client client = (Client) session.getAttribute("client");
      final GestionSpectaclesService service = new GestionSpectaclesService();
      final WSGestionSpectacles port = service.getGestionSpectaclesPort();
      try {
        final List<Reservation> reservations = port.recupererReservation(client.getIdClient());
        session.setAttribute("reservations", reservations);
      } catch (final Exception e) {
        e.printStackTrace();
      }
      request.getRequestDispatcher(VUE_COMPTE).forward(request, response);
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.doGet(request, response);
  }

}
