<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="fr.eseo.ldcr.webservices.visite.Visite,java.util.ArrayList,java.sql.Timestamp"%>
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
	  ArrayList<Visite> visites =
	      (ArrayList<Visite>) session.getAttribute("visitesTrouver");
	%>
	<div class="CSSTableau">
		<table>
			<tr>
				<th>Description</th>
				<th>Type</th>
				<th>Ville</th>
				<th>Durée</th>
				<th>Date</th>
				<th>Prix</th>
			</tr>
			<%
			  for (int i = 0; i < visites.size(); i++) {
			%>
			<tr>
				<td><%=visites.get(i).getDescription()%></td>
				<td><%=visites.get(i).getType()%></td>
				<td><%=visites.get(i).getVille()%></td>
				<td><%=visites.get(i).getDuree()%></td>
				<td><%=visites.get(i).getDate() %></td>
				<td><%=visites.get(i).getPrix()%>€</td>
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