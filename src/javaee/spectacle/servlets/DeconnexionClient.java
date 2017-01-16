package javaee.spectacle.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Permet de déconnecter un client
/**
 * Servlet implementation class Deconnexion
 */
@WebServlet("/DeconnexionClient")
public class DeconnexionClient extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public static final String URL_REDIRECTION = "index.jsp";

  /**
   * @see HttpServlet#HttpServlet()
   */
  public DeconnexionClient() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // On récupére la session si elle existe
    final HttpSession session = request.getSession();
    // On y met fin
    session.invalidate();
    // Met à jour le nombre de clients connectés
    if (this.getServletContext().getAttribute("nombreClientsConnectés") == null) {
      this.getServletContext().setAttribute("nombreClientsConnectés", new Integer(0));
    } else {
      this.getServletContext().setAttribute("nombreClientsConnectés", new Integer(
          (Integer) this.getServletContext().getAttribute("nombreClientsConnectés") - 1));
    }
    // On redirige vers la page d'accueil
    response.sendRedirect(URL_REDIRECTION);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // On récupére la session si elle existe
    final HttpSession session = request.getSession();
    // On y met fin
    session.invalidate();
    // Met à jour le nombre de clients connectés
    if (this.getServletContext().getAttribute("nombreClientsConnectés") == null) {
      this.getServletContext().setAttribute("nombreClientsConnectés", new Integer(0));
    } else {
      this.getServletContext().setAttribute("nombreClientsConnectés", new Integer(
          (Integer) this.getServletContext().getAttribute("nombreClientsConnectés") - 1));
    }
    // On redirige vers la page d'accueil
    response.sendRedirect(URL_REDIRECTION);
  }

}
