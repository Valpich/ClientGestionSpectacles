
package javaee.spectacle.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the javaee.spectacle.webservices package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation
 * for XML content. The Java representation of XML content can consist of schema derived interfaces
 * and classes representing the binding of schema type definitions, element declarations and model
 * groups. Factory methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

  private final static QName _AnnulerSpectacleResponse_QNAME =
      new QName("http://webservices.spectacle.javaee/", "annulerSpectacleResponse");
  private final static QName _ReserverSpectacleResponse_QNAME =
      new QName("http://webservices.spectacle.javaee/", "reserverSpectacleResponse");
  private final static QName _RecupererReservationResponse_QNAME =
      new QName("http://webservices.spectacle.javaee/", "recupererReservationResponse");
  private final static QName _PayerSpectacleResponse_QNAME =
      new QName("http://webservices.spectacle.javaee/", "payerSpectacleResponse");
  private final static QName _TrouverSpectacleResponse_QNAME =
      new QName("http://webservices.spectacle.javaee/", "trouverSpectacleResponse");
  private final static QName _AnnulerSpectacle_QNAME =
      new QName("http://webservices.spectacle.javaee/", "annulerSpectacle");
  private final static QName _RecupererReservation_QNAME =
      new QName("http://webservices.spectacle.javaee/", "recupererReservation");
  private final static QName _TrouverSpectacle_QNAME =
      new QName("http://webservices.spectacle.javaee/", "trouverSpectacle");
  private final static QName _PayerSpectacle_QNAME =
      new QName("http://webservices.spectacle.javaee/", "payerSpectacle");
  private final static QName _ReserverSpectacle_QNAME =
      new QName("http://webservices.spectacle.javaee/", "reserverSpectacle");

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes
   * for package: javaee.spectacle.webservices
   * 
   */
  public ObjectFactory() {}

  /**
   * Create an instance of {@link RecupererReservationResponse }
   * 
   */
  public RecupererReservationResponse createRecupererReservationResponse() {
    return new RecupererReservationResponse();
  }

  /**
   * Create an instance of {@link ReserverSpectacleResponse }
   * 
   */
  public ReserverSpectacleResponse createReserverSpectacleResponse() {
    return new ReserverSpectacleResponse();
  }

  /**
   * Create an instance of {@link AnnulerSpectacleResponse }
   * 
   */
  public AnnulerSpectacleResponse createAnnulerSpectacleResponse() {
    return new AnnulerSpectacleResponse();
  }

  /**
   * Create an instance of {@link TrouverSpectacle }
   * 
   */
  public TrouverSpectacle createTrouverSpectacle() {
    return new TrouverSpectacle();
  }

  /**
   * Create an instance of {@link RecupererReservation }
   * 
   */
  public RecupererReservation createRecupererReservation() {
    return new RecupererReservation();
  }

  /**
   * Create an instance of {@link AnnulerSpectacle }
   * 
   */
  public AnnulerSpectacle createAnnulerSpectacle() {
    return new AnnulerSpectacle();
  }

  /**
   * Create an instance of {@link PayerSpectacleResponse }
   * 
   */
  public PayerSpectacleResponse createPayerSpectacleResponse() {
    return new PayerSpectacleResponse();
  }

  /**
   * Create an instance of {@link TrouverSpectacleResponse }
   * 
   */
  public TrouverSpectacleResponse createTrouverSpectacleResponse() {
    return new TrouverSpectacleResponse();
  }

  /**
   * Create an instance of {@link PayerSpectacle }
   * 
   */
  public PayerSpectacle createPayerSpectacle() {
    return new PayerSpectacle();
  }

  /**
   * Create an instance of {@link ReserverSpectacle }
   * 
   */
  public ReserverSpectacle createReserverSpectacle() {
    return new ReserverSpectacle();
  }

  /**
   * Create an instance of {@link Reservation }
   * 
   */
  public Reservation createReservation() {
    return new Reservation();
  }

  /**
   * Create an instance of {@link Spectacle }
   * 
   */
  public Spectacle createSpectacle() {
    return new Spectacle();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AnnulerSpectacleResponse }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://webservices.spectacle.javaee/",
      name = "annulerSpectacleResponse")
  public JAXBElement<AnnulerSpectacleResponse> createAnnulerSpectacleResponse(
      AnnulerSpectacleResponse value) {
    return new JAXBElement<AnnulerSpectacleResponse>(_AnnulerSpectacleResponse_QNAME,
        AnnulerSpectacleResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ReserverSpectacleResponse }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://webservices.spectacle.javaee/",
      name = "reserverSpectacleResponse")
  public JAXBElement<ReserverSpectacleResponse> createReserverSpectacleResponse(
      ReserverSpectacleResponse value) {
    return new JAXBElement<ReserverSpectacleResponse>(_ReserverSpectacleResponse_QNAME,
        ReserverSpectacleResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link RecupererReservationResponse }
   * {@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://webservices.spectacle.javaee/",
      name = "recupererReservationResponse")
  public JAXBElement<RecupererReservationResponse> createRecupererReservationResponse(
      RecupererReservationResponse value) {
    return new JAXBElement<RecupererReservationResponse>(_RecupererReservationResponse_QNAME,
        RecupererReservationResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PayerSpectacleResponse }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://webservices.spectacle.javaee/",
      name = "payerSpectacleResponse")
  public JAXBElement<PayerSpectacleResponse> createPayerSpectacleResponse(
      PayerSpectacleResponse value) {
    return new JAXBElement<PayerSpectacleResponse>(_PayerSpectacleResponse_QNAME,
        PayerSpectacleResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TrouverSpectacleResponse }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://webservices.spectacle.javaee/",
      name = "trouverSpectacleResponse")
  public JAXBElement<TrouverSpectacleResponse> createTrouverSpectacleResponse(
      TrouverSpectacleResponse value) {
    return new JAXBElement<TrouverSpectacleResponse>(_TrouverSpectacleResponse_QNAME,
        TrouverSpectacleResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AnnulerSpectacle }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://webservices.spectacle.javaee/", name = "annulerSpectacle")
  public JAXBElement<AnnulerSpectacle> createAnnulerSpectacle(AnnulerSpectacle value) {
    return new JAXBElement<AnnulerSpectacle>(_AnnulerSpectacle_QNAME, AnnulerSpectacle.class, null,
        value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link RecupererReservation }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://webservices.spectacle.javaee/", name = "recupererReservation")
  public JAXBElement<RecupererReservation> createRecupererReservation(RecupererReservation value) {
    return new JAXBElement<RecupererReservation>(_RecupererReservation_QNAME,
        RecupererReservation.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TrouverSpectacle }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://webservices.spectacle.javaee/", name = "trouverSpectacle")
  public JAXBElement<TrouverSpectacle> createTrouverSpectacle(TrouverSpectacle value) {
    return new JAXBElement<TrouverSpectacle>(_TrouverSpectacle_QNAME, TrouverSpectacle.class, null,
        value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link PayerSpectacle }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://webservices.spectacle.javaee/", name = "payerSpectacle")
  public JAXBElement<PayerSpectacle> createPayerSpectacle(PayerSpectacle value) {
    return new JAXBElement<PayerSpectacle>(_PayerSpectacle_QNAME, PayerSpectacle.class, null,
        value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ReserverSpectacle }{@code >}}
   * 
   */
  @XmlElementDecl(namespace = "http://webservices.spectacle.javaee/", name = "reserverSpectacle")
  public JAXBElement<ReserverSpectacle> createReserverSpectacle(ReserverSpectacle value) {
    return new JAXBElement<ReserverSpectacle>(_ReserverSpectacle_QNAME, ReserverSpectacle.class,
        null, value);
  }

}
