
package fr.eseo.ldcr.webservices.visite;

/**
 * Please modify this class to meet your needs This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 2.7.18 2016-03-17T17:48:35.734+01:00 Generated source
 * version: 2.7.18
 * 
 */
public final class VisitesServeur_GestionPort_Client {

  private static final QName SERVICE_NAME =
      new QName("http://visite.ldcr.eseo.fr/", "GestionService");

  private VisitesServeur_GestionPort_Client() {}

  public static void main(String args[]) throws java.lang.Exception {
    URL wsdlURL = GestionService.WSDL_LOCATION;
    if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
      final File wsdlFile = new File(args[0]);
      try {
        if (wsdlFile.exists()) {
          wsdlURL = wsdlFile.toURI().toURL();
        } else {
          wsdlURL = new URL(args[0]);
        }
      } catch (final MalformedURLException e) {
        e.printStackTrace();
      }
    }

    final GestionService ss = new GestionService(wsdlURL, SERVICE_NAME);
    final VisitesServeur port = ss.getGestionPort();

    {
      System.out.println("Invoking trouverVisite...");
      final fr.eseo.ldcr.webservices.visite.Visite _trouverVisite_arg0 =
          new fr.eseo.ldcr.webservices.visite.Visite();
      _trouverVisite_arg0.setCodeVisite("CodeVisite995854636");
      _trouverVisite_arg0.setDate(javax.xml.datatype.DatatypeFactory.newInstance()
          .newXMLGregorianCalendar("2016-03-17T17:48:35.783+01:00"));
      _trouverVisite_arg0.setDescription("Description572714360");
      _trouverVisite_arg0.setDuree("Duree-132372081");
      _trouverVisite_arg0.setPrix(0.59869176f);
      _trouverVisite_arg0.setType("Type-1086215669");
      _trouverVisite_arg0.setVille("Ville1987995178");
      final float _trouverVisite_arg1 = 0.51489794f;
      final javax.xml.datatype.XMLGregorianCalendar _trouverVisite_arg2 =
          javax.xml.datatype.DatatypeFactory.newInstance()
              .newXMLGregorianCalendar("2016-03-17T17:48:35.785+01:00");
      final java.util.List<fr.eseo.ldcr.webservices.visite.Visite> _trouverVisite__return =
          port.trouverVisite(_trouverVisite_arg0, _trouverVisite_arg1, _trouverVisite_arg2);
      System.out.println("trouverVisite.result=" + _trouverVisite__return);


    }
    {
      System.out.println("Invoking payerVisite...");
      final java.lang.String _payerVisite_arg0 = "_payerVisite_arg0759231902";
      final boolean _payerVisite__return = port.payerVisite(_payerVisite_arg0);
      System.out.println("payerVisite.result=" + _payerVisite__return);


    }
    {
      System.out.println("Invoking annulerVisite...");
      final java.lang.String _annulerVisite_arg0 = "_annulerVisite_arg0-160933905";
      final boolean _annulerVisite__return = port.annulerVisite(_annulerVisite_arg0);
      System.out.println("annulerVisite.result=" + _annulerVisite__return);


    }
    {
      System.out.println("Invoking reserverVisite...");
      final fr.eseo.ldcr.webservices.visite.ReservationVisite _reserverVisite_arg0 =
          new fr.eseo.ldcr.webservices.visite.ReservationVisite();
      _reserverVisite_arg0.setCodeAgence("CodeAgence2064534022");
      _reserverVisite_arg0.setCodeClient("CodeClient630141288");
      _reserverVisite_arg0.setCodeReservation("CodeReservation78931575");
      _reserverVisite_arg0.setCodeVisite("CodeVisite-1118180795");
      _reserverVisite_arg0.setNbPersonne(-1202680412);
      _reserverVisite_arg0.setPaiementEffectue(true);
      final java.lang.String _reserverVisite__return = port.reserverVisite(_reserverVisite_arg0);
      System.out.println("reserverVisite.result=" + _reserverVisite__return);


    }
    {
      System.out.println("Invoking trouverReservation...");
      final fr.eseo.ldcr.webservices.visite.ReservationVisite _trouverReservation_arg0 =
          new fr.eseo.ldcr.webservices.visite.ReservationVisite();
      _trouverReservation_arg0.setCodeAgence("CodeAgence-2121737627");
      _trouverReservation_arg0.setCodeClient("CodeClient-131861323");
      _trouverReservation_arg0.setCodeReservation("CodeReservation-657658690");
      _trouverReservation_arg0.setCodeVisite("CodeVisite836317188");
      _trouverReservation_arg0.setNbPersonne(-1523895438);
      _trouverReservation_arg0.setPaiementEffectue(true);
      final java.util.List<fr.eseo.ldcr.webservices.visite.ReservationVisite> _trouverReservation__return =
          port.trouverReservation(_trouverReservation_arg0);
      System.out.println("trouverReservation.result=" + _trouverReservation__return);


    }

    System.exit(0);
  }

}
