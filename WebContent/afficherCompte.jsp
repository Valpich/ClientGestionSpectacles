<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="javaee.spectacle.beans.Client,javaee.spectacle.webservices.Reservation,java.util.Date,java.util.ArrayList,java.text.SimpleDateFormat,javaee.spectacle.webservices.WSGestionSpectacles,javaee.spectacle.webservices.GestionSpectaclesService,javaee.spectacle.webservices.Spectacle,java.util.List,java.sql.Timestamp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<title>Mon compte</title>
</head>
<body>
   <% if(new String("Acceder a mon compte").equals(request.getParameter("annulerOuCompte"))){ 
	%>
	<p>Bonjour ${sessionScope.client.prenom} ${sessionScope.client.nom}
		! Heureux de vous voir :)</p>
	<p>Bienvenue sur la page de gestion de votre compte :)</p>
	<p>
		Vous avez renseigné les informations suivantes :
		<br>
		<br>
		Nom : ${sessionScope.client.nom}
		<br>
		<br>
		Prénom : ${sessionScope.client.prenom}
		<br>
		<br>
		Année de naissance :
		<%
		
		
		  Client client = (Client) session.getAttribute("client");
		  if (client != null) {
		    Date date = new Date((client).getDateDeNaissance());
		    String dateSimple = new SimpleDateFormat("yyyy-MM-dd").format(date);
		    out.write(dateSimple);
		  } else {
		    out.write("");
		  }
		%>
		<br>
		<br>
		Adresse mail : ${sessionScope.client.mail}
		<br>
		<br>
		Login: ${sessionScope.client.login}
		<br>
	<p />
	<%} %>
	<div>
		<%  
		  @SuppressWarnings("unchecked")
		  List<Reservation> reservations = (List<Reservation>) session.getAttribute("reservations");
		if(reservations==null){
			out.write("Vous n'avez aucun spectacle spectacle sur votre compte!");
		}else{
		%>
		Vous avez des billets pour les spectacles suivants :
		<p />
		<div class="CSSTableau">
			<table>
				<tr>
					<th>Titre</th>
					<th>Type</th>
					<th>Ville</th>
					<th>Date</th>
					<th>Nombre de places</th>
					<th>Paiement effectué</th>
					<th>Annuler la réservation</th>
					<% if(!new String("Annuler").equals(request.getParameter("annulerOuCompte"))){ 
					%>		
					<th>Payer</th>
					<%} %>
				</tr>
				<%
				  if (reservations != null)
				    for (int i = 0; i < reservations.size(); i++) {
				      Spectacle spectacle = new Spectacle();
				      spectacle.setId(reservations.get(i).getIdSpectacle());
				      GestionSpectaclesService service = new GestionSpectaclesService();
				      WSGestionSpectacles port = service.getGestionSpectaclesPort();
				      List<Spectacle> spectaclesTrouver = port.trouverSpectacle(spectacle);
				      session.setAttribute("listeDesSpectacles",spectaclesTrouver);
				  for (Spectacle spectacleBoucle : spectaclesTrouver) {
				  if (spectacleBoucle.getId() == reservations.get(i).getIdSpectacle()) {
				%>

				<tr>
					<td><%=spectacleBoucle.getTitre()%></td>
					<td><%=spectacleBoucle.getType()%></td>
					<td><%=spectacleBoucle.getVille()%></td>
					<td><%=new Timestamp(spectacleBoucle.getDate())%></td>
					<td><%=reservations.get(i).getNombrePlaces()%></td>
					<td>
						<%
						  if (reservations.get(i).isPaiement() == true)
						            out.write("Oui");
						          else
						            out.write("Non");
						%>
					</td>
					<td>
						<form method="post" name="annuler"
							action="AnnulerReservationChoix">
							<%
							  out.write("<input type=\"submit\" value=\"" + "Choix " + (i + 1) + "\" name=\"Choisir\"/>");
							%>
						</form>
					</td>
					<% if(!new String("Annuler").equals(request.getParameter("annulerOuCompte"))){ 
					%>
					<td>
						<form method="post" name="payer" action="payerSpectacle.jsp">
							<%
							  if (reservations.get(i).isPaiement() == false)
								  out.write("<input type=\"submit\" value=\"" + "Choix " + (i + 1) + "\" name=\"Choisir\"/>");
							%>
						</form>
					</td>
					<%} %>
				</tr>
				<%
				  }
				  }
				  }
				}
				%>
			</table>
			<a href="MenuPrincipal.jsp">Cliquer ici pour revenir sur la page
				d'accueil</a>
		</div>
	</div>
</body>
</html>