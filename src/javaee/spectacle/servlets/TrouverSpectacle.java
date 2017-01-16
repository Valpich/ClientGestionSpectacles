package javaee.spectacle.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaee.spectacle.webservices.GestionSpectaclesService;
import javaee.spectacle.webservices.Spectacle;
import javaee.spectacle.webservices.WSGestionSpectacles;

/**
 * Servlet implementation class TrouverSpectacle
 */
@WebServlet("/TrouverSpectacle")
public class TrouverSpectacle extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public TrouverSpectacle() {
    super();
  }

  /**
   * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    final HttpSession session = request.getSession();
    final Integer id = null;
    String type = null;
    String titre = null;
    String ville = null;
    Timestamp date = null;
    Integer prix = null;
    final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date datetest = null;
    // Remplissage des paramètres d'un spectacle si les champs renseignés sont non vides
    if (!request.getParameter("typespectacle").equals("choixType")) {
      type = request.getParameter("typespectacle").toString();
    }
    if (!request.getParameter("titrespectacle").equals("")) {
      titre = request.getParameter("titrespectacle").toString();
    }
    if (!request.getParameter("villespectacle").equals("")) {
      ville = request.getParameter("villespectacle").toString();
    }
    // Mise en forme de la date si non vide
    if (!request.getParameter("datespectacle").equals("")) {
      try {
        datetest = format.parse(request.getParameter("datespectacle"));
        date = new Timestamp(datetest.getTime());
      } catch (final ParseException e) {
        e.printStackTrace();
      }
    }
    if (request.getParameter("prixspectacle") != "") {
      prix = (new Integer(request.getParameter("prixspectacle")).intValue());
    }
    final Spectacle recherche = new Spectacle();
    recherche.setId(id);
    recherche.setType(type);
    recherche.setTitre(titre);
    recherche.setVille(ville);
    if (date != null) {
      recherche.setDate(date.getTime());
    }
    recherche.setPrix(prix);
    final GestionSpectaclesService service = new GestionSpectaclesService();
    final WSGestionSpectacles port = service.getGestionSpectaclesPort();
    // Récupération de la liste des spectacles concernés
    final List<Spectacle> spectaclesTrouver = port.trouverSpectacle(recherche);
    session.setAttribute("spectaclesTrouver", spectaclesTrouver);
    final RequestDispatcher dispat = request.getRequestDispatcher("resultatTrouverSpectacle.jsp");
    dispat.forward(request, response);
  }

}
