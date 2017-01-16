<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="javaee.spectacle.webservices.Spectacle,java.sql.Timestamp"%>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation de l'annulation de la réservation du
	spectacle</title>
</head>
<body>
	<p>La resérvation pour le spectacle suivant à été annulée !</p>
	<%
	  Spectacle spectacle = (Spectacle) session.getAttribute("spectacleASupprimer");
	  out.write("Titre : " + spectacle.getTitre() + "<br/>");
	  out.write("Type : " + spectacle.getType() + "<br/>");
	  out.write("Ville : " + spectacle.getVille() + "<br/>");
	  out.write("Date : " + new Timestamp(spectacle.getDate()) + "<br/>");
	%>
	<br />
	<p />
	<a href="MenuPrincipal.jsp">Cliquer ici pour revenir sur la page d'accueil</a>
</body>
</html>