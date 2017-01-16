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
		<h1 style="color: red;">Trouver une visite</h1>
	<form method="post" name="methodePost" action="TrouverVisite">
		<h2>Remplir les informations ci-dessous</h2>
		<ol>
			<li>Type de la visite: <input type="text" name="typevisite" />
			</li>
			<li>Ville de la visite: <input type="text" name="villevisite" />
			</li>
			<li>Date de la visite: <input type="date" name="datevisite" />
			</li>
			<li>Durée de la visite: <input type="text" name="dureevisite" />
			</li>
			<li>Prix min de la visite: <input type="text" name="prixminvisite" />
			</li>
			<li>Prix max de la visite: <input type="text" name="prixmaxvisite" />
			</li>
		</ol>
		<br> <br> <input type="submit" value="Valider" />
	</form>
</body>
</html>


