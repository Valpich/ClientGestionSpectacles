package javaee.spectacle.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javaee.spectacle.beans.Client;

public class ClientBDD {
  private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/bdd_agence_reservation";
  private static final String DEFAULT_USER = "119920_eseo";
  private static final String DEFAULT_PASSWORD = "eseo";

  private Connection connection;

  /**
   * Constructeur permettant de vérifier la présence du driver JDBC
   **/
  public ClientBDD() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (final ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  // Ajout d'un client a la base de donnees
  public void ajouterClient(Client client, String hashMDP) throws Exception {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    // connection à la base de donnees
    try {
      this.connection = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USER, DEFAULT_PASSWORD);
    } catch (final SQLException e) {
      e.printStackTrace();
    }
    // recuperation des donnees du client
    try {
      final String request = "INSERT ignore INTO clients VALUES (NULL, ?, ?, ?, NOW(), 0, ?, ?,?);";
      try {
        preparedStatement =
            this.connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
      } catch (final SQLException e) {
        e.printStackTrace();
      }

      // on remplis la requete sql avec les differents parametres
      preparedStatement.setString(1, client.getNom());
      preparedStatement.setString(2, client.getPrenom());
      preparedStatement.setTimestamp(3, new Timestamp(client.getDateDeNaissance()));
      preparedStatement.setString(4, client.getLogin());
      preparedStatement.setString(5, hashMDP);
      preparedStatement.setString(6, client.getMail());
      // on execute la requete
      preparedStatement.executeUpdate();
      // on recupere la cle generee
      resultSet = preparedStatement.getGeneratedKeys();
      if (resultSet.next()) {
        client.setIdClient(resultSet.getInt(1));
      } else {
        throw new Exception("Impossible d'ajouter le client!");
      }
    } catch (final SQLException e) {
      e.printStackTrace();
    }
    try {
      this.connection.close();
    } catch (final SQLException e) {
      e.printStackTrace();
    }

  }

  /**
   * Méthode permettant de chercher un client dans la base de donnée
   **/
  public Client chercherClient(String login) {
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Client client = null;
    try {
      this.connection = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USER, DEFAULT_PASSWORD);
    } catch (final SQLException e1) {
      e1.printStackTrace();
    }
    try {
      final String requete = "select * from clients where login=?";
      try {
        preparedStatement = this.connection.prepareStatement(requete);
      } catch (final SQLException e2) {
        e2.printStackTrace();
      }
      preparedStatement.setString(1, login);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        client = new Client();
        client = new Client(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
            resultSet.getTimestamp(4).getTime(), resultSet.getTimestamp(5).getTime(),
            resultSet.getInt(6), resultSet.getString(7), resultSet.getString(8),
            resultSet.getString(9));

      }
    } catch (final SQLException e) {
      e.printStackTrace();
    }
    try {
      this.connection.close();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return client;
  }

}


