<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<title>Bienvenue</title>
</head>
<body>
	<h1 style="color: red;">Trouver un spectacle</h1>

	<form method="post" name="methodePost" action="TrouverSpectacle">
		<h2>Remplir les informations ci-dessous</h2>
		<fieldset>
			<ol>
				<li>
					Titre du Spectacle:
					<input type="text" name="titrespectacle" />
				</li>
				<li>
					Ville du Spectacle:
					<input type="text" name="villespectacle" />
				</li>
				<li>
					Date du Spectacle:
					<input type="date" name="datespectacle" />
				</li>
				<li>
					Prix du Spectacle:
					<input type="text" name="prixspectacle" />
				</li>
				<%-- Voir pour CSS --%>
				<li>
					Type du spectacle:
					<select name="typespectacle" id="listeType">
						<option value="choixType">Choisir le type</option>
						<option value="Comédie">Comédie</option>
						<option value="Musique">Musique</option>
						<option value="Dramatique">Dramatique</option>
						<option value="Théâtre">Théâtre</option>
						<option value="Cinéma">Cinéma</option>
					</select>
				</li>
			</ol>
		</fieldset>
		<br>
		<br>
		<input type="submit" value="Valider" />
	</form>
</body>
</html>


