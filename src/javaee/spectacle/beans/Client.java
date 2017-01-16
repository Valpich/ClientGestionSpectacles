package javaee.spectacle.beans;

import java.util.Set;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Client implements HttpSessionBindingListener {

  private Integer idClient;
  private String nom;
  private String prenom;
  private Long dateDeNaissance;
  private Long dateInscription;
  private Integer pointDeFidelite;
  private String login;
  private String motDePasse;
  private String mail;

  public Integer getIdClient() {
    return this.idClient;
  }

  public void setIdClient(Integer idClient) {
    this.idClient = idClient;
  }

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return this.prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Long getDateDeNaissance() {
    return this.dateDeNaissance;
  }

  public void setDateDeNaissance(Long dateDeNaissance) {
    this.dateDeNaissance = dateDeNaissance;
  }

  public Long getDateInscription() {
    return this.dateInscription;
  }

  public void setDateInscription(Long dateInscription) {
    this.dateInscription = dateInscription;
  }

  public Integer getPointDeFidelite() {
    return this.pointDeFidelite;
  }

  public void setPointDeFidelite(Integer pointDeFidelite) {
    this.pointDeFidelite = pointDeFidelite;
  }

  public String getLogin() {
    return this.login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getMotDePasse() {
    return this.motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  public String getMail() {
    return this.mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public Client(Integer idClient, String nom, String prenom, Long dateDeNaissance,
      Long dateInscription, Integer pointDeFidelite, String login, String motDePasse, String mail) {
    super();
    this.idClient = idClient;
    this.nom = nom;
    this.prenom = prenom;
    this.dateDeNaissance = dateDeNaissance;
    this.dateInscription = dateInscription;
    this.pointDeFidelite = pointDeFidelite;
    this.login = login;
    this.motDePasse = motDePasse;
    this.mail = mail;
  }

  public Client() {}

  // Permet de detecter l'instantiation d'un client et donc sa connexion pour mettre a jour les
  // clients connectes
  @SuppressWarnings("unchecked")
  @Override
  public void valueBound(HttpSessionBindingEvent event) {
    final Set<Client> logins =
        (Set<Client>) event.getSession().getServletContext().getAttribute("logins");
    logins.add(this);
  }

  // Permet de detecter le dereferencement d'un client et donc sa deconnexion pour mettre a jour les
  // clients connectes
  @SuppressWarnings("unchecked")
  @Override
  public void valueUnbound(HttpSessionBindingEvent event) {
    final Set<Client> logins =
        (Set<Client>) event.getSession().getServletContext().getAttribute("logins");
    logins.remove(this);
  }

}
