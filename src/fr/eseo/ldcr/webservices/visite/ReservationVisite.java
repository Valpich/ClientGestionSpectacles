
package fr.eseo.ldcr.webservices.visite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Classe Java pour reservationVisite complex type.
 * 
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reservationVisite">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codeAgence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeClient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeReservation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codeVisite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nbPersonne" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="paiementEffectue" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservationVisite", propOrder = {"codeAgence", "codeClient", "codeReservation",
    "codeVisite", "nbPersonne", "paiementEffectue"})
public class ReservationVisite {

  protected String codeAgence;
  protected String codeClient;
  protected String codeReservation;
  protected String codeVisite;
  protected int nbPersonne;
  protected boolean paiementEffectue;

  /**
   * Obtient la valeur de la propriété codeAgence.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getCodeAgence() {
    return this.codeAgence;
  }

  /**
   * Définit la valeur de la propriété codeAgence.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setCodeAgence(String value) {
    this.codeAgence = value;
  }

  /**
   * Obtient la valeur de la propriété codeClient.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getCodeClient() {
    return this.codeClient;
  }

  /**
   * Définit la valeur de la propriété codeClient.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setCodeClient(String value) {
    this.codeClient = value;
  }

  /**
   * Obtient la valeur de la propriété codeReservation.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getCodeReservation() {
    return this.codeReservation;
  }

  /**
   * Définit la valeur de la propriété codeReservation.
   * 
   * @param value allowed object is {@link String }
   * 
   */
  public void setCodeReservation(String value) {
    this.codeReservation = value;
  }

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
   * Obtient la valeur de la propriété nbPersonne.
   * 
   */
  public int getNbPersonne() {
    return this.nbPersonne;
  }

  /**
   * Définit la valeur de la propriété nbPersonne.
   * 
   */
  public void setNbPersonne(int value) {
    this.nbPersonne = value;
  }

  /**
   * Obtient la valeur de la propriété paiementEffectue.
   * 
   */
  public boolean isPaiementEffectue() {
    return this.paiementEffectue;
  }

  /**
   * Définit la valeur de la propriété paiementEffectue.
   * 
   */
  public void setPaiementEffectue(boolean value) {
    this.paiementEffectue = value;
  }

}
