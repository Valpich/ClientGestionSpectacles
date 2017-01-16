
package fr.eseo.ldcr.webservices.visite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>
 * Classe Java pour visite complex type.
 * 
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="visite">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeVisite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="duree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ville" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "visite",
    propOrder = {"codeVisite", "date", "description", "duree", "prix", "type", "ville"})
public class Visite {

  protected String codeVisite;
  @XmlSchemaType(name = "dateTime")
  protected XMLGregorianCalendar date;
  protected String description;
  protected String duree;
  protected float prix;
  protected String type;
  protected String ville;

  /**
   * Obtient la valeur de la propriété codeVisite.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getCodeVisite() {
    return this.codeVisite;
  }

  /**
   * Définit la valeur de la propriété codeVisite.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setCodeVisite(String value) {
    this.codeVisite = value;
  }

  /**
   * Obtient la valeur de la propriété date.
   * 
   * @return possible object is {@link XMLGregorianCalendar }
   * 
   */
  public XMLGregorianCalendar getDate() {
    return this.date;
  }

  /**
   * Définit la valeur de la propriété date.
   * 
   * @param value allowed object is {@link XMLGregorianCalendar }
   * 
   */
  public void setDate(XMLGregorianCalendar value) {
    this.date = value;
  }

  /**
   * Obtient la valeur de la propriété description.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Définit la valeur de la propriété description.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setDescription(String value) {
    this.description = value;
  }

  /**
   * Obtient la valeur de la propriété duree.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getDuree() {
    return this.duree;
  }

  /**
   * Définit la valeur de la propriété duree.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setDuree(String value) {
    this.duree = value;
  }

  /**
   * Obtient la valeur de la propriété prix.
   * 
   */
  public float getPrix() {
    return this.prix;
  }

  /**
   * Définit la valeur de la propriété prix.
   * 
   */
  public void setPrix(float value) {
    this.prix = value;
  }

  /**
   * Obtient la valeur de la propriété type.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getType() {
    return this.type;
  }

  /**
   * Définit la valeur de la propriété type.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setType(String value) {
    this.type = value;
  }

  /**
   * Obtient la valeur de la propriété ville.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getVille() {
    return this.ville;
  }

  /**
   * Définit la valeur de la propriété ville.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setVille(String value) {
    this.ville = value;
  }

}
