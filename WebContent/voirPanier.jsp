<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ page import="javaee.spectacle.webservices.Spectacle"
	import="javaee.spectacle.webservices.Reservation"
	import="javaee.spectacle.beans.Client"
	import="java.util.Date,java.util.ArrayList" import="java.util.List"
	import="java.lang.Boolean"
	import="javaee.spectacle.webservices.WSGestionSpectacles"
	import="javaee.spectacle.webservices.GestionSpectaclesService"
	import="java.sql.Timestamp"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon panier</title>
</head>
<body>
	<h1>Bienvenue dans votre panier:</h1>
	<h2>Les spectacles que vous avez réservés sont les suivants:</h2>
	<h3>Vous pouvez annuler ou payer ces spectacles à tout moment:</h3>
	<br>
	<%
	  Client client = (Client) session.getAttribute("client");

	  GestionSpectaclesService service = new GestionSpectaclesService();
	  WSGestionSpectacles port = service.getGestionSpectaclesPort();
	  List<Reservation> reservations = null;
	  try {
	    reservations = port.recupererReservation(client.getIdClient());
	    session.setAttribute("reservations", reservations);
	  } catch (Exception e) {
	    e.printStackTrace();
	  }

	  //Récupération des réservations non payés
	  List<Reservation> reservationsNonPayées = new ArrayList<Reservation>();
	  if (reservations != null) {
	    for (int i = 0; i < reservations.size(); i++) {
	      if (reservations.get(i).isPaiement() == false) {
	        reservationsNonPayées.add(reservations.get(i));
	      }
	    }
	    session.setAttribute("listesSpectaclesNonPayées",reservationsNonPayées);
	  }
	%>
	<br />
	<br />
	<div class="CSSTableau">
		<table>
			<tr>
				<th>Titre</th>
				<th>Type</th>
				<th>Ville</th>
				<th>Date</th>
				<th>Nombre de places</th>
				<th>Payer</th>
			</tr>
			<%
			  if (reservationsNonPayées != null)
			    for (int i = 0; i < reservationsNonPayées.size(); i++) {
			      Spectacle spectacle = new Spectacle();
			      spectacle.setId(reservationsNonPayées.get(i).getIdSpectacle());
			      List<Spectacle> spectaclesTrouver = port.trouverSpectacle(spectacle);
			  for (Spectacle spectacleBoucle : spectaclesTrouver) {
			  if (spectacleBoucle.getId() == reservationsNonPayées.get(i).getIdSpectacle()) {
			%>

			<tr>
				<td><%=spectacleBoucle.getTitre()%></td>
				<td><%=spectacleBoucle.getType()%></td>
				<td><%=spectacleBoucle.getVille()%></td>
				<td><%=new Timestamp(spectacleBoucle.getDate())%></td>
				<td><%=reservationsNonPayées.get(i).getNombrePlaces()%></td>
				<td>
					<form method="post" name="payer" action="payerSpectacle.jsp">
						<%
						  out.write("<input type=\"submit\" value=\"" + "Choix " + (i + 1) + "\" name=\"Choisir\"/>");
						%>
					</form>
				</td>
			</tr>
			<%
			  }
			  }
			  }
			%>
		</table>
	</div>
	<br />
	<a href="MenuPrincipal.jsp">Cliquer ici pour revenir sur la page d'accueil</a>
</body>
</html>