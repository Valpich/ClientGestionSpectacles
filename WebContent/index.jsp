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
	<h1>Page d'acceuil</h1>
	<h2>Bienvenue sur notre projet de Gestion de Spectacle!</h2> 
	<p>Après vous être connecté ou inscrit, vous pourrez choisir de réserver des places pour les spectacles que vous voulez.<br />
		De plus, notre service vous permettra de payer directement en ligne les places de spectacle si vous le souhaitez. <br /> 
		Bien sûr, si vous changez d'avis, il vous sera possible d'annuler la réservation des places d'un spectacle (qu'elles soient déjà payées ou non).</p>
	<br />
	<p>Pour continuer, veuillez vous connecter: </p>
		<form method="post" action="Connexion.jsp">
			<input type="submit" value="Se connecter">
		</form>
	<br />
	<p>Si vous n'avez pas encore de compte, veuillez vous inscrire:</p>
		<form method="post" action="Inscription.jsp">
			<input type="submit" value="S'inscrire">
		</form>
	
</body>
</html>