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
 * Servlet implementation class AnnulerSpectacle
 */
@WebServlet("/AnnulerReservationChoix")
public class AnnulerReservationChoix extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String VUE_DEBUT = "index.jsp";
  private static final String VUE_CONFIRMATION = "/annulerReservation.jsp";

  /**
   * @see HttpServlet#HttpServlet()
   */
  public AnnulerReservationChoix() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.sendRedirect(VUE_DEBUT);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    final HttpSession session = request.getSession();
    final Client client = (Client) session.getAttribute("client");
    final GestionSpectaclesService service = new GestionSpectaclesService();
    final WSGestionSpectacles port = service.getGestionSpectaclesPort();
    List<Reservation> reservations = null;
    try {
      reservations = port.recupererReservation(client.getIdClient());
      session.setAttribute("reservations", reservations);
    } catch (final Exception e) {
      e.printStackTrace();
    }
    final String stringChoix = request.getParameter("Choisir").toString();
    final int choix = Integer.parseInt(stringChoix.substring(6)) - 1;
    final int intChoisi = reservations.get(choix).getIdReservation();

    if (stringChoix == null || reservations == null || reservations == null) {
      // Pas de reservation à annuler, redirection vers le début
      response.sendRedirect(VUE_DEBUT);
    } else {
      try {
        final Spectacle spectacle = new Spectacle();
        spectacle.setId(intChoisi);
        session.setAttribute("numeroReservationASupprimer", intChoisi);
        session.setAttribute("spectacleASupprimer", port.trouverSpectacle(spectacle).get(0));
        this.getServletContext().getRequestDispatcher(VUE_CONFIRMATION).forward(request, response);
      } catch (final Exception e) {
        // Si le client à volontairement passé un choix incorrect,
        // retour au début
        response.sendRedirect(VUE_DEBUT);
      }
    }
  }

}
