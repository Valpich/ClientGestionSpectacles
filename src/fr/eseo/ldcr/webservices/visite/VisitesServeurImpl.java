
/**
 * Please modify this class to meet your needs This class is not complete
 */

package fr.eseo.ldcr.webservices.visite;

import java.util.logging.Logger;

/**
 * This class was generated by Apache CXF 2.7.18 2016-03-17T17:48:35.792+01:00 Generated source
 * version: 2.7.18
 * 
 */

@javax.jws.WebService(serviceName = "GestionService", portName = "GestionPort",
    targetNamespace = "http://visite.ldcr.eseo.fr/",
    wsdlLocation = "http://192.168.4.197:8080/VisitesServeur/services/GestionPort?wsdl",
    endpointInterface = "fr.eseo.ldcr.webservices.visite.VisitesServeur")

public class VisitesServeurImpl implements VisitesServeur {

  private static final Logger LOG = Logger.getLogger(VisitesServeurImpl.class.getName());

  /*
   * (non-Javadoc)
   * 
   * @see
   * fr.eseo.ldcr.webservices.visite.VisitesServeur#trouverVisite(fr.eseo.ldcr.webservices.visite.
   * Visite arg0 ,)float arg1 ,)javax.xml.datatype.XMLGregorianCalendar arg2 )*
   */
  @Override
  public java.util.List<fr.eseo.ldcr.webservices.visite.Visite> trouverVisite(
      fr.eseo.ldcr.webservices.visite.Visite arg0, float arg1,
      javax.xml.datatype.XMLGregorianCalendar arg2) {
    LOG.info("Executing operation trouverVisite");
    System.out.println(arg0);
    System.out.println(arg1);
    System.out.println(arg2);
    try {
      final java.util.List<fr.eseo.ldcr.webservices.visite.Visite> _return =
          new java.util.ArrayList<fr.eseo.ldcr.webservices.visite.Visite>();
      final fr.eseo.ldcr.webservices.visite.Visite _returnVal1 =
          new fr.eseo.ldcr.webservices.visite.Visite();
      _returnVal1.setCodeVisite("CodeVisite-1541935761");
      _returnVal1.setDate(javax.xml.datatype.DatatypeFactory.newInstance()
          .newXMLGregorianCalendar("2016-03-17T17:48:35.810+01:00"));
      _returnVal1.setDescription("Description-423444177");
      _returnVal1.setDuree("Duree-429464685");
      _returnVal1.setPrix(0.1912021f);
      _returnVal1.setType("Type-2128190820");
      _returnVal1.setVille("Ville1195353269");
      _return.add(_returnVal1);
      return _return;
    } catch (final java.lang.Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see fr.eseo.ldcr.webservices.visite.VisitesServeur#payerVisite(java.lang.String arg0 )*
   */
  @Override
  public boolean payerVisite(java.lang.String arg0) {
    LOG.info("Executing operation payerVisite");
    System.out.println(arg0);
    try {
      final boolean _return = false;
      return _return;
    } catch (final java.lang.Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see fr.eseo.ldcr.webservices.visite.VisitesServeur#annulerVisite(java.lang.String arg0 )*
   */
  @Override
  public boolean annulerVisite(java.lang.String arg0) {
    LOG.info("Executing operation annulerVisite");
    System.out.println(arg0);
    try {
      final boolean _return = false;
      return _return;
    } catch (final java.lang.Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fr.eseo.ldcr.webservices.visite.VisitesServeur#reserverVisite(fr.eseo.ldcr.webservices.visite.
   * ReservationVisite arg0 )*
   */
  @Override
  public java.lang.String reserverVisite(fr.eseo.ldcr.webservices.visite.ReservationVisite arg0) {
    LOG.info("Executing operation reserverVisite");
    System.out.println(arg0);
    try {
      final java.lang.String _return = "_return1932665266";
      return _return;
    } catch (final java.lang.Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fr.eseo.ldcr.webservices.visite.VisitesServeur#trouverReservation(fr.eseo.ldcr.webservices.
   * visite.ReservationVisite arg0 )*
   */
  @Override
  public java.util.List<fr.eseo.ldcr.webservices.visite.ReservationVisite> trouverReservation(
      fr.eseo.ldcr.webservices.visite.ReservationVisite arg0) {
    LOG.info("Executing operation trouverReservation");
    System.out.println(arg0);
    try {
      final java.util.List<fr.eseo.ldcr.webservices.visite.ReservationVisite> _return =
          new java.util.ArrayList<fr.eseo.ldcr.webservices.visite.ReservationVisite>();
      final fr.eseo.ldcr.webservices.visite.ReservationVisite _returnVal1 =
          new fr.eseo.ldcr.webservices.visite.ReservationVisite();
      _returnVal1.setCodeAgence("CodeAgence1931708090");
      _returnVal1.setCodeClient("CodeClient1112907584");
      _returnVal1.setCodeReservation("CodeReservation2033422519");
      _returnVal1.setCodeVisite("CodeVisite-1421353071");
      _returnVal1.setNbPersonne(759127213);
      _returnVal1.setPaiementEffectue(false);
      _return.add(_returnVal1);
      return _return;
    } catch (final java.lang.Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }

}
