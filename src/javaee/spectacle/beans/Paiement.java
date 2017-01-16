package javaee.spectacle.beans;

import java.sql.Timestamp;

public class Paiement {
  private Integer idPaiement;
  private Float montant;
  private String modalites;
  private Timestamp datePaiement;
  private Integer numeroCarte;
  private Timestamp dateValidite;
  private Integer cryptogramme;



  public Integer getidPaiement() {
    return this.idPaiement;
  }

  public void setidPaiement(Integer idPaiement) {
    this.idPaiement = idPaiement;
  }


  public Float getmontant() {
    return this.montant;
  }

  public void setmontant(Float montant) {
    this.montant = montant;
  }

  public String getmodalites() {
    return this.modalites;
  }

  public void setmodalites(String modalites) {
    this.modalites = modalites;
  }

  public Timestamp getdatePaiement() {
    return this.datePaiement;
  }

  public void setdatePaiement(Timestamp datePaiement) {
    this.datePaiement = datePaiement;
  }

  public Integer getnumeroCarte() {
    return this.numeroCarte;
  }

  public void setnumeroCarte(Integer numeroCarte) {
    this.numeroCarte = numeroCarte;
  }

  public Timestamp getdateValidite() {
    return this.dateValidite;
  }

  public void setdateValidite(Timestamp dateValidite) {
    this.dateValidite = dateValidite;
  }

  public Integer getcryptogramme() {
    return this.cryptogramme;
  }

  public void setcryptogramme(Integer cryptogramme) {
    this.cryptogramme = cryptogramme;
  }

  public Paiement(Integer idPaiement, Float montant, String modalites, Timestamp datePaiement,
      Integer numeroCarte, Timestamp dateValidite, Integer cryptogramme) {
    super();
    this.idPaiement = idPaiement;
    this.montant = montant;
    this.modalites = modalites;
    this.datePaiement = datePaiement;
    this.numeroCarte = numeroCarte;
    this.dateValidite = dateValidite;
    this.cryptogramme = cryptogramme;
  }
}
