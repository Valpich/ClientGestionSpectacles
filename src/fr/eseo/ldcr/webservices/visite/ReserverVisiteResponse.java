
package fr.eseo.ldcr.webservices.visite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Classe Java pour reserverVisiteResponse complex type.
 * 
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reserverVisiteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserverVisiteResponse", propOrder = {"_return"})
public class ReserverVisiteResponse {

  @XmlElement(name = "return")
  protected String _return;

  /**
   * Obtient la valeur de la propriété return.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getReturn() {
    return this._return;
  }

  /**
   * Définit la valeur de la propriété return.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setReturn(String value) {
    this._return = value;
  }

}
