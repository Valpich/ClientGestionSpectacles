<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue sur la page d'accueil</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
	<h1>Menu Principal</h1>
	<%
	  if (session.getAttribute("client") != null)
	    out.write("Vous êtes connecté en tant que : ");
	%>${sessionScope.client.login }
	<br /> Selectionner le type de critère à faire:
	<br>
	<br>
	<form method="post" name="Trouver" action="trouverSpectacle.jsp">
		<input type="submit" value="Trouver"> <br> <br>
	</form>
	<form method="post" name="Réserver"
		action="reserverSpectacleParmiTous.jsp">
		<input type="submit" value="Réserver"> <br> <br>
	</form>

	<form method="post" name="Payer" action="voirPanier.jsp">
		<input type="submit" value="Payer"> <br> <br>

	</form>
	<form method="post" name="Annuler" action="MonCompte">
		<input type="submit" name="annulerOuCompte" value="Annuler"> <br>
		<br>

	</form>

	<form method="get" name="AccederAMonCompte" action="MonCompte">
		<input type="submit" name="annulerOuCompte"
			value="Acceder a mon compte">
	</form>
	
	<br><br>
	Voici le WebService du groupe Visite Guidée:
	<form method="post" name="Trouver vite" action="trouverVisite.jsp">
		<input type="submit" value="Trouver visite">
	</form>
	<br><br>
	<%
	  if (session.getAttribute("client") != null)
	    out.write(
	        "<p><a href=\"DeconnexionClient\">Cliquer ici pour vous déconnecter<img src=\"/ClientGestionSpectacles/inc/smiley_crying.png\" width=\"30\" height=\"30\"/></a></p>");
	%>
</body>
</html>