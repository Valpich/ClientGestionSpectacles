
package javaee.spectacle.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Classe Java pour spectacle complex type.
 * 
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="spectacle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="titre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "spectacle", propOrder = {"date", "id", "prix", "titre", "type", "ville"})
public class Spectacle {

  protected Long date;
  protected Integer id;
  protected Integer prix;
  protected String titre;
  protected String type;
  protected String ville;

  /**
   * Obtient la valeur de la propriété date.
   * 
   * @return possible object is {@link Long }
   * 
   */
  public Long getDate() {
    return this.date;
  }

  /**
   * Définit la valeur de la propriété date.
   * 
   * @param value allowed object is {@link Long }
   * 
   */
  public void setDate(Long value) {
    this.date = value;
  }

  /**
   * Obtient la valeur de la propriété id.
   * 
   * @return possible object is {@link Integer }
   * 
   */
  public Integer getId() {
    return this.id;
  }

  /**
   * Définit la valeur de la propriété id.
   * 
   * @param value allowed object is {@link Integer }
   * 
   */
  public void setId(Integer value) {
    this.id = value;
  }

  /**
   * Obtient la valeur de la propriété prix.
   * 
   * @return possible object is {@link Integer }
   * 
   */
  public Integer getPrix() {
    return this.prix;
  }

  /**
   * Définit la valeur de la propriété prix.
   * 
   * @param value allowed object is {@link Integer }
   * 
   */
  public void setPrix(Integer value) {
    this.prix = value;
  }

  /**
   * Obtient la valeur de la propriété titre.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getTitre() {
    return this.titre;
  }

  /**
   * Définit la valeur de la propriété titre.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setTitre(String value) {
    this.titre = value;
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
