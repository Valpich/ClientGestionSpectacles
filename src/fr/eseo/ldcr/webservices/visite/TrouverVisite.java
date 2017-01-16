
package fr.eseo.ldcr.webservices.visite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>
 * Classe Java pour trouverVisite complex type.
 * 
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="trouverVisite">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://visite.ldcr.eseo.fr/}visite" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trouverVisite", propOrder = {"arg0", "arg1", "arg2"})
public class TrouverVisite {

  protected Visite arg0;
  protected float arg1;
  @XmlSchemaType(name = "dateTime")
  protected XMLGregorianCalendar arg2;

  /**
   * Obtient la valeur de la propriété arg0.
   * 
   * @return possible object is {@link Visite }
   * 
   */
  public Visite getArg0() {
    return this.arg0;
  }

  /**
   * Définit la valeur de la propriété arg0.
   * 
   * @param value allowed object is {@link Visite }
   * 
   */
  public void setArg0(Visite value) {
    this.arg0 = value;
  }

  /**
   * Obtient la valeur de la propriété arg1.
   * 
   */
  public float getArg1() {
    return this.arg1;
  }

  /**
   * Définit la valeur de la propriété arg1.
   * 
   */
  public void setArg1(float value) {
    this.arg1 = value;
  }

  /**
   * Obtient la valeur de la propriété arg2.
   * 
   * @return possible object is {@link XMLGregorianCalendar }
   * 
   */
  public XMLGregorianCalendar getArg2() {
    return this.arg2;
  }

  /**
   * Définit la valeur de la propriété arg2.
   * 
   * @param value allowed object is {@link XMLGregorianCalendar }
   * 
   */
  public void setArg2(XMLGregorianCalendar value) {
    this.arg2 = value;
  }

}
