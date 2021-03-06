
package fr.eseo.ldcr.webservices.visite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Classe Java pour trouverReservation complex type.
 * 
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="trouverReservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://visite.ldcr.eseo.fr/}reservationVisite" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trouverReservation", propOrder = {"arg0"})
public class TrouverReservation {

  protected ReservationVisite arg0;

  /**
   * Obtient la valeur de la propriété arg0.
   * 
   * @return possible object is {@link ReservationVisite }
   * 
   */
  public ReservationVisite getArg0() {
    return this.arg0;
  }

  /**
   * Définit la valeur de la propriété arg0.
   * 
   * @param value allowed object is {@link ReservationVisite }
   * 
   */
  public void setArg0(ReservationVisite value) {
    this.arg0 = value;
  }

}
