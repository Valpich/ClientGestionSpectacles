package javaee.spectacle.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.18 2016-03-16T20:46:16.708+01:00 Generated source
 * version: 2.7.18
 * 
 */
@WebService(targetNamespace = "http://webservices.spectacle.javaee/", name = "WSGestionSpectacles")
@XmlSeeAlso({ObjectFactory.class})
public interface WSGestionSpectacles {

  @WebResult(name = "return", targetNamespace = "")
  @RequestWrapper(localName = "reserverSpectacle",
      targetNamespace = "http://webservices.spectacle.javaee/",
      className = "javaee.spectacle.webservices.ReserverSpectacle")
  @WebMethod
  @ResponseWrapper(localName = "reserverSpectacleResponse",
      targetNamespace = "http://webservices.spectacle.javaee/",
      className = "javaee.spectacle.webservices.ReserverSpectacleResponse")
  public int reserverSpectacle(
      @WebParam(name = "arg0", targetNamespace = "") javaee.spectacle.webservices.Reservation arg0);

  @WebResult(name = "return", targetNamespace = "")
  @RequestWrapper(localName = "recupererReservation",
      targetNamespace = "http://webservices.spectacle.javaee/",
      className = "javaee.spectacle.webservices.RecupererReservation")
  @WebMethod
  @ResponseWrapper(localName = "recupererReservationResponse",
      targetNamespace = "http://webservices.spectacle.javaee/",
      className = "javaee.spectacle.webservices.RecupererReservationResponse")
  public java.util.List<javaee.spectacle.webservices.Reservation> recupererReservation(
      @WebParam(name = "arg0", targetNamespace = "") int arg0);

  @WebResult(name = "return", targetNamespace = "")
  @RequestWrapper(localName = "payerSpectacle",
      targetNamespace = "http://webservices.spectacle.javaee/",
      className = "javaee.spectacle.webservices.PayerSpectacle")
  @WebMethod
  @ResponseWrapper(localName = "payerSpectacleResponse",
      targetNamespace = "http://webservices.spectacle.javaee/",
      className = "javaee.spectacle.webservices.PayerSpectacleResponse")
  public boolean payerSpectacle(@WebParam(name = "arg0", targetNamespace = "") int arg0);

  @WebResult(name = "return", targetNamespace = "")
  @RequestWrapper(localName = "annulerSpectacle",
      targetNamespace = "http://webservices.spectacle.javaee/",
      className = "javaee.spectacle.webservices.AnnulerSpectacle")
  @WebMethod
  @ResponseWrapper(localName = "annulerSpectacleResponse",
      targetNamespace = "http://webservices.spectacle.javaee/",
      className = "javaee.spectacle.webservices.AnnulerSpectacleResponse")
  public boolean annulerSpectacle(@WebParam(name = "arg0", targetNamespace = "") int arg0);

  @WebResult(name = "return", targetNamespace = "")
  @RequestWrapper(localName = "trouverSpectacle",
      targetNamespace = "http://webservices.spectacle.javaee/",
      className = "javaee.spectacle.webservices.TrouverSpectacle")
  @WebMethod
  @ResponseWrapper(localName = "trouverSpectacleResponse",
      targetNamespace = "http://webservices.spectacle.javaee/",
      className = "javaee.spectacle.webservices.TrouverSpectacleResponse")
  public java.util.List<javaee.spectacle.webservices.Spectacle> trouverSpectacle(
      @WebParam(name = "arg0", targetNamespace = "") javaee.spectacle.webservices.Spectacle arg0);
}
