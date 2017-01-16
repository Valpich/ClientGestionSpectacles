
package javaee.spectacle.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Classe Java pour trouverSpectacle complex type.
 * 
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="trouverSpectacle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://webservices.spectacle.javaee/}spectacle" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trouverSpectacle", propOrder = {"arg0"})
public class TrouverSpectacle {

  protected Spectacle arg0;

  /**
   * Obtient la valeur de la propriété arg0.
   * 
   * @return possible object is {@link Spectacle }
   * 
   */
  public Spectacle getArg0() {
    return this.arg0;
  }

  /**
   * Définit la valeur de la propriété arg0.
   * 
   * @param value allowed object is {@link Spectacle }
   * 
   */
  public void setArg0(Spectacle value) {
    this.arg0 = value;
  }

}
