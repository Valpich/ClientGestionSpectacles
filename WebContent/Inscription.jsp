<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription client</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />

</head>
<body>
	<%
		if(request.getAttribute("erreurMDP")!= null){
			out.write((String)(request.getAttribute("erreurMDP"))+"<br/>");
		}
	if(request.getAttribute("erreurLogin")!= null){
		out.write((String)(request.getAttribute("erreurLogin"))+"<br/>");
	}
	%>
	<br />
	<h1>Renseigner toutes les informations suivantes : </h1>
	
	<form method="post" action="inscription">

		<br> <br> Nom: <input type="text" name="nom" /> 
		<br> <br> Prénom : <input type="text" name="prenom" /> 
		<br> <br> Année de naissance sous la forme aaaa-mm-jj: <input type="date" name="dateDeNaissance" />
		<br> <br> Adresse mail sous la forme xx@xx.com : <input type="email" name="mail" /> 
		<br> <br> Login: <input type="text" name="login" /> 
		<br> <br> Mot de passe: <input type="password" name="motDePasse" /> 
		<br> <br> Mot de passe (confirmation): <input type="password" name="confirmation" /> 
		<br> <br> 
		<br> <br> <input type="submit" value="Envoyer">
	</form>
	<br /> <a href="index.jsp">Cliquer ici pour revenir sur la page d'accueil</a>
</body>
</html>