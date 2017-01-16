package javaee.spectacle.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaee.spectacle.bdd.ClientBDD;
import javaee.spectacle.beans.Client;
import javaee.spectacle.beans.PasswordStorage;
import javaee.spectacle.beans.PasswordStorage.CannotPerformOperationException;
import javaee.spectacle.beans.PasswordStorage.InvalidHashException;

// Servlet permettant de connecter un client
/**
 * Servlet implementation class ConnexionClient
 */
@WebServlet("/connexion")
public class ConnexionClient extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String VUE = "/Connexion.jsp";
  private static final String VUE_PRINCIPALE = "MenuPrincipal.jsp";

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ConnexionClient() {
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
    final StringBuilder erreurMDP = new StringBuilder("-1");
    final StringBuilder erreurLogin = new StringBuilder("-1");
    final Client client = this.authentifierClient(request, erreurLogin, erreurMDP);
    // Si erreur de mot de passe
    if (!erreurMDP.toString().equals("-1")) {
      request.setAttribute("erreurMDP", erreurMDP.toString());
    }
    // Si erreur de login
    if (!erreurLogin.toString().equals("-1")) {
      request.setAttribute("erreurLogin", erreurLogin.toString());
    }
    // Si une des erreurs trouvée on revient à la vue de connexion
    if (!erreurMDP.toString().equals("-1") || !erreurLogin.toString().equals("-1")) {
      this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

      // Sinon on va au menu principal
    } else {
      final HttpSession session = request.getSession();
      session.setAttribute("client", client);
      // Met à jour le nombre de clients connectés
      this.getServletContext().setAttribute("nombreClientsConnectés", new Integer(
          (Integer) this.getServletContext().getAttribute("nombreClientsConnectés") + 1));
      response.sendRedirect(VUE_PRINCIPALE);
    }
  }

  /**
   * Permet de verifier l'authentification du client, return le client s'il existe, sinon null.
   */
  public Client authentifierClient(HttpServletRequest request, StringBuilder erreurLogin,
      StringBuilder erreurMDP) {
    final String login = request.getParameter("login");
    final String motDePasse = request.getParameter("motDePasse");
    Client client = null;
    Boolean test = true;
    final ClientBDD clientbdd = new ClientBDD();
    // Recherche du client dans la base de donnée
    client = clientbdd.chercherClient(login);
    if (client != null) {
      try {
        test = PasswordStorage.verifyPassword(motDePasse, client.getMotDePasse());
      } catch (CannotPerformOperationException | InvalidHashException e) {
        e.printStackTrace();
      }
      if (test == true) {
        return client;
      } else {
        erreurMDP.replace(0, erreurMDP.length(), "Mot de passe éronné!");
        return null;
      }
    }
    erreurLogin.replace(0, erreurMDP.length(), "Login incorrect!");
    return null;
  }

}
