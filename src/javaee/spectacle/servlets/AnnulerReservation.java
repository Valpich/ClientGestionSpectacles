package javaee.spectacle.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaee.spectacle.beans.Client;
import javaee.spectacle.webservices.GestionSpectaclesService;
import javaee.spectacle.webservices.WSGestionSpectacles;

/**
 * Servlet implementation class AnnulerSpectacle
 */
@WebServlet("/AnnulerReservation")
public class AnnulerReservation extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String VUE_DEBUT = "index.jsp";
  private static final String VUE_CONFIRMATION = "/resultatAnnulerReservation.jsp";

  /**
   * @see HttpServlet#HttpServlet()
   */
  public AnnulerReservation() {
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
    final Integer numeroReservation = (Integer) session.getAttribute("numeroReservationASupprimer");
    // S'il y a un problème sur la récupération du numéro de reservation ou
    // du client, retour au début
    if (client == null || numeroReservation == null) {
      response.sendRedirect(VUE_DEBUT);
      // Sinon on supprime la réservation
    } else {
      final GestionSpectaclesService service = new GestionSpectaclesService();
      final WSGestionSpectacles port = service.getGestionSpectaclesPort();
      System.out.println("Numero res" + numeroReservation);
      port.annulerSpectacle(numeroReservation);

      // On affiche la vue de confirmation de la suppression du spectacle
      this.getServletContext().getRequestDispatcher(VUE_CONFIRMATION).forward(request, response);
    }
  }

}
