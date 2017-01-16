<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page
	import="javaee.spectacle.webservices.Spectacle,java.sql.Timestamp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<title>Annulation de la réservation du spectacle</title>
</head>
<body>
	<p>Voulez-vous annuler votre réservation pour le spectacle suivant
		?</p>
	<%
	  Spectacle spectacle = (Spectacle) session.getAttribute("spectacleASupprimer");
	  out.write("Titre : " + spectacle.getTitre() + "<br/>");
	  out.write("Type : " + spectacle.getType() + "<br/>");
	  out.write("Ville : " + spectacle.getVille() + "<br/>");
	  out.write("Date : " + new Timestamp(spectacle.getDate()) + "<br/>");
	%>
	<div class="warning">
		<p>Attention cette action est irréversible !!</p>
	</div>
	<form method="post" name="Valider" action="AnnulerReservation">
		<input type="submit" value="Valider" />
	</form>
	<form method="post" name="Annuler" action="NePasAnnulerReservation">
		<input type="submit" value="Annuler" />
	</form>
</body>
</html>