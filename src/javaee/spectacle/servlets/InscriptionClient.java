package javaee.spectacle.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

/**
 * Servlet implementation class InscriptionClient
 */
@WebServlet("/inscription")
public class InscriptionClient extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String VUE = "/Inscription.jsp";
  private static final String VUE_PRINCIPALE = "MenuPrincipal.jsp";

  /**
   * @see HttpServlet#HttpServlet()
   */
  public InscriptionClient() {
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
    final Client client = this.inscrireClient(request, erreurLogin, erreurMDP);
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

      // Sinon on va au menu principal et on connecte le client
    } else {
      final HttpSession session = request.getSession();
      session.setAttribute("client", client);
      response.sendRedirect(VUE_PRINCIPALE);
    }
  }

  /**
   * Permet d'inscrire le client, retourne le client ajouté a la BDD s'il exist.
   */
  public Client inscrireClient(HttpServletRequest request, StringBuilder erreurLogin,
      StringBuilder erreurMDP) {
    final String login = request.getParameter("login");
    final String motDePasse = request.getParameter("motDePasse");
    final String confirmation = request.getParameter("confirmation");
    final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
      date = format.parse(request.getParameter("dateDeNaissance"));
    } catch (final ParseException e1) {
      erreurMDP.replace(0, erreurMDP.length(), "Merci de ne pas modifier le format de la date ...");
    }
    Timestamp dateDeNaissance = new Timestamp(new Date().getTime());
    try {
      dateDeNaissance = new Timestamp(date.getTime());
    } catch (final NullPointerException npe) {

    }
    final String nom = request.getParameter("nom");
    final String prenom = request.getParameter("prenom");
    final String mail = request.getParameter("mail");
    final Client client = new Client();
    client.setPrenom(prenom);
    client.setNom(nom);
    client.setDateDeNaissance(dateDeNaissance.getTime());
    // Validation du mail du client avant l'ajout
    try {
      this.validationMail(mail);
      client.setMail(mail);
    } catch (final Exception e) {
      erreurMDP.replace(0, erreurMDP.length(), e.getMessage());
    }
    final ClientBDD clientbdd = new ClientBDD();
    erreurMDP.replace(0, erreurMDP.length(),
        this.traiterMotsDePasse(motDePasse, confirmation, client));
    erreurLogin.replace(0, erreurLogin.length(), this.traiterLogin(login, client));
    if (erreurMDP.toString().equals("-1") && erreurLogin.toString().equals("-1")) {
      try {
        final String hashMDP = PasswordStorage.createHash(client.getMotDePasse());
        Boolean testCrypt = false;
        try {
          testCrypt = PasswordStorage.verifyPassword(client.getMotDePasse(), hashMDP);
        } catch (final InvalidHashException e) {
          e.printStackTrace();
        }
        if (testCrypt == true) {
          try {
            clientbdd.ajouterClient(client, hashMDP);
          } catch (final Exception e) {
            e.printStackTrace();
            erreurMDP.replace(0, erreurMDP.length(),
                "Impossible d'ajouter le client dans notre base de donnees");
          }
        } else {
          erreurMDP.replace(0, erreurMDP.length(),
              "Impossible d'ajouter le client dans notre base de donnees");
        }
      } catch (final CannotPerformOperationException e) {
        e.printStackTrace();
        erreurMDP.replace(0, erreurMDP.length(),
            "Impossible d'ajouter le client e notre base de donnees");
      }
    }
    return client;
  }

  /** Verification du login. */
  public String traiterLogin(String login, Client client) {
    final ClientBDD clientbdd = new ClientBDD(); // A remplacer
    if (login == null) {
      return "Saisir un login!";
    }
    if (login.length() < 5) {
      return "Saisir un login superieur a 5 caracteres!";
    }
    if (clientbdd.chercherClient(login) != null) {
      return "Ce login est deja utilise, veuillez en saisir un nouveau!";
    }
    client.setLogin(login);
    return "-1";
  }

  /** Verification du mot de passe. */
  private String traiterMotsDePasse(String motDePasse, String confirmation, Client client) {
    if (motDePasse == null) {
      return "Saisir un mot de passe!";
    }
    if (!motDePasse.equals(confirmation)) {
      return "Vos mots de passe ne sont pas identiques, reessayer!";
    }
    if (motDePasse.length() < 5) {
      return "Saisir un mot de passe superieur a 5 caracteres!";
    }
    client.setMotDePasse(motDePasse);
    return "-1";
  }

  /** Vérification du mail. */
  private void validationMail(String mail) throws Exception {
    if (mail != null && !mail.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
      throw new Exception("Merci de saisir une adresse mail valide !");
    }
  }

}
