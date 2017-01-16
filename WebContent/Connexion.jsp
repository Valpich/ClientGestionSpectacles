<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<title>Connexion client</title>
</head>
<body>
	<%@ page import="javaee.spectacle.beans.Client"%>
	<%
	  if (session.getAttribute("client") != null) {
	    out.write("Vous êtes déjà connecté en tant que : "+ ((Client) session.getAttribute("client")).getLogin());
		  out.write(
		      "<br/><a href=\"MenuPrincipal.jsp\"/>Cliquer ici pour revenir sur le menu principal</a>");
	  } else {
	    out.write(
	      "<form method=\"post\" action=\"connexion\">Insérer les informations suivantes : <br><br>Login:<input type=\"text\" name=\"login\" /> <br><br>Mot de passe: <input type=\"password\" name=\"motDePasse\" /> <br><br><br><br> <input type=\"submit\" value=\"Envoyer\"></form>");
		  out.write(
		      "<br/><a href=\"index.jsp\"/>Cliquer ici pour revenir sur la page d'accueil</a>");
	  }
	%>
</body>
</html>