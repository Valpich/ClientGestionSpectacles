
package javaee.spectacle.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Classe Java pour reservation complex type.
 * 
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idClient" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idReservation" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idSpectacle" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nombrePlaces" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="paiement" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservation",
    propOrder = {"idClient", "idReservation", "idSpectacle", "nombrePlaces", "paiement"})
public class Reservation {

  protected int idClient;
  protected Integer idReservation;
  protected Integer idSpectacle;
  protected Integer nombrePlaces;
  protected Boolean paiement;

  /**
   * Obtient la valeur de la propriété idClient.
   * 
   */
  public int getIdClient() {
    return this.idClient;
  }

  /**
   * Définit la valeur de la propriété idClient.
   * 
   */
  public void setIdClient(int value) {
    this.idClient = value;
  }

  /**
   * Obtient la valeur de la propriété idReservation.
   * 
   * @return possible object is {@link Integer }
   * 
   */
  public Integer getIdReservation() {
    return this.idReservation;
  }

  /**
   * Définit la valeur de la propriété idReservation.
   * 
   * @param value allowed object is {@link Integer }
   * 
   */
  public void setIdReservation(Integer value) {
    this.idReservation = value;
  }

  /**
   * Obtient la valeur de la propriété idSpectacle.
   * 
   * @return possible object is {@link Integer }
   * 
   */
  public Integer getIdSpectacle() {
    return this.idSpectacle;
  }

  /**
   * Définit la valeur de la propriété idSpectacle.
   * 
   * @param value allowed object is {@link Integer }
   * 
   */
  public void setIdSpectacle(Integer value) {
    this.idSpectacle = value;
  }

  /**
   * Obtient la valeur de la propriété nombrePlaces.
   * 
   * @return possible object is {@link Integer }
   * 
   */
  public Integer getNombrePlaces() {
    return this.nombrePlaces;
  }

  /**
   * Définit la valeur de la propriété nombrePlaces.
   * 
   * @param value allowed object is {@link Integer }
   * 
   */
  public void setNombrePlaces(Integer value) {
    this.nombrePlaces = value;
  }

  /**
   * Obtient la valeur de la propriété paiement.
   * 
   * @return possible object is {@link Boolean }
   * 
   */
  public Boolean isPaiement() {
    return this.paiement;
  }

  /**
   * Définit la valeur de la propriété paiement.
   * 
   * @param value allowed object is {@link Boolean }
   * 
   */
  public void setPaiement(Boolean value) {
    this.paiement = value;
  }

}
