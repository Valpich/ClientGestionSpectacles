
package javaee.spectacle.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Classe Java pour reserverSpectacle complex type.
 * 
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reserverSpectacle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://webservices.spectacle.javaee/}reservation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserverSpectacle", propOrder = {"arg0"})
public class ReserverSpectacle {

  protected Reservation arg0;

  /**
   * Obtient la valeur de la propriété arg0.
   * 
   * @return possible object is {@link Reservation }
   * 
   */
  public Reservation getArg0() {
    return this.arg0;
  }

  /**
   * Définit la valeur de la propriété arg0.
   * 
   * @param value allowed object is {@link Reservation }
   * 
   */
  public void setArg0(Reservation value) {
    this.arg0 = value;
  }

}
