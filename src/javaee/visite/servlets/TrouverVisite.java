package javaee.visite.servlets;

import fr.eseo.ldcr.webservices.visite.GestionService;
import fr.eseo.ldcr.webservices.visite.Visite;
import fr.eseo.ldcr.webservices.visite.VisitesServeur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TrouverSpectacle
 */
@WebServlet("/TrouverVisite")
public class TrouverVisite extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public TrouverVisite() {
    super();
  }

  /**
   * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    final HttpSession session = request.getSession();
    String ville = null;
    String type = null;
    float prixMin = 0.0f;
    float prixMax = Float.MAX_VALUE;
    if (!request.getParameter("typevisite").equals("")) {
      type = request.getParameter("typevisite").toString();
    }
    if (!request.getParameter("villevisite").equals("")) {
      ville = request.getParameter("villevisite").toString();
    }
    if (!request.getParameter("prixminvisite").equals("")) {
      prixMin = (new Float(request.getParameter("prixminvisite"))).floatValue();
    }
    if (!request.getParameter("prixmaxvisite").equals("")) {
      prixMax = (new Float(request.getParameter("prixmaxvisite"))).floatValue();
    }
    final GestionService service = new GestionService();
    final Visite visite = new Visite();
    visite.setPrix(prixMin);
    visite.setVille(ville);
    visite.setType(type);
    final VisitesServeur port = service.getGestionPort();
    port.trouverVisite(visite, prixMax, null);
    final List<Visite> visitesTrouver = port.trouverVisite(visite, prixMax, null);
    session.setAttribute("visitesTrouver", visitesTrouver);
    request.getRequestDispatcher("resultatTrouverVisite.jsp").forward(request, response);
  }

}
