package javaee.spectacle.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaee.spectacle.beans.Client;

/**
 * Permet d'annuler le fait d'annuler une réservation
 */
@WebServlet("/NePasAnnulerReservation")
public class NePasAnnulerReservation extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String VUE_DEBUT = "index.jsp";
  private static final String VUE_CHOIX = "afficherCompte.jsp";

  /**
   * @see HttpServlet#HttpServlet()
   */
  public NePasAnnulerReservation() {
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
    if (client == null) {
      response.sendRedirect(VUE_DEBUT);
    } else {
      response.sendRedirect(VUE_CHOIX);
    }
  }

}
