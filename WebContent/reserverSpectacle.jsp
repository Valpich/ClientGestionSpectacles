<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="javaee.spectacle.webservices.Spectacle,java.util.ArrayList,java.sql.Timestamp"%>
<!DOCTYPE html >
<html>
<head>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reservation d'un spectacle</title>
</head>
<body>
	<h1>Vous avez choisi de réserver le spectacle suivant:</h1>
	<br>
	<%
	  @SuppressWarnings("unchecked")
	  ArrayList<Spectacle> spectacles =
	      (ArrayList<Spectacle>) session.getAttribute("spectaclesTrouver");
	  String stringChoix = (String) request.getParameter("Choisir").toString();
	  int choix = Integer.parseInt(stringChoix.substring(6)) - 1;
	  Spectacle spectacleChoisi = spectacles.get(choix);
	  session.setAttribute("spectacleChoisi", spectacleChoisi);
	%>
	<div class="CSSTableau">
		<table>
			<tr>
				<th>Titre</th>
				<th>Type</th>
				<th>Ville</th>
				<th>Date</th>
				<th>Prix</th>
			</tr>
			<tr>
				<td><%=spectacleChoisi.getTitre()%></td>
				<td><%=spectacleChoisi.getType()%></td>
				<td><%=spectacleChoisi.getVille()%></td>
				<td><%=new Timestamp(spectacleChoisi.getDate())%></td>
				<td><%=spectacleChoisi.getPrix()%></td>
			</tr>
		</table>
	</div>
	<br>
	<p>Que souhaitez-vous faire?</p>
	<br>
	<form method="post" name="Reserver" action="ReserverSpectacle">
		Nombre de places:
		<input type="number" min="1" max="500" name="Nombre de places">
		<br>
		<input type="radio" name="choix"
			value="Réserver seulement en ajoutant au panier" checked>
		Réserver seulement en ajoutant au panier
		<br>
		<input type="radio" name="choix" value="Payer maintenant">
		Payer maintenant
		<br>
		<input type="submit" name="Valider">
		<br>
		<br>
	</form>
	<form method="post" name="Retour" action="resultatTrouverSpectacle.jsp">
		<input type="submit" value="Retour">
		<br>
		<br>
	</form>

</body>
</html>