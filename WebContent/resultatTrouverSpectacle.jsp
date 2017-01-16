<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="javaee.spectacle.webservices.Spectacle,java.util.ArrayList,java.sql.Timestamp"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spectacles</title>
</head>
<body>
	<%
	  @SuppressWarnings("unchecked")
	  ArrayList<Spectacle> spectacles =
	      (ArrayList<Spectacle>) session.getAttribute("spectaclesTrouver");
	%>
	<h1>Voici les visites disponibles !</h1>
	<br />
	<div class="CSSTableau">
		<table>
			<tr>
				<th>Titre</th>
				<th>Type</th>
				<th>Ville</th>
				<th>Date</th>
				<th>Prix</th>
				<th>Réserver</th>
			</tr>
			<%
			  for (int i = 0; i < spectacles.size(); i++) {
			%>
			<tr>
				<td><%=spectacles.get(i).getTitre()%></td>
				<td><%=spectacles.get(i).getType()%></td>
				<td><%=spectacles.get(i).getVille()%></td>
				<td><%=new Timestamp(spectacles.get(i).getDate())%></td>
				<td><%=spectacles.get(i).getPrix()%></td>
				<td>
					<form method="post" name="Choisir" action="reserverSpectacle.jsp">
						<%
						  out.write("<input type=\"submit\" value=\"" + "Choix " + (i + 1) + "\" name=\"Choisir\"/>");
						%>
					</form>
				</td>
			</tr>
			<%
			  }
			%>
		</table>
	</div>
	<br>
	<br>
	<form method="post" name="return" action="MenuPrincipal.jsp">
		<input type="submit" name="return" value="Page principale" />
	</form>
</body>
</html>