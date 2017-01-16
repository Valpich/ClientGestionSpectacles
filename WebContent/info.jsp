<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="javaee.spectacle.beans.Client,java.util.HashSet"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Informations</title>
</head>
<body>
	Il y a actuellement ${applicationScope.nombreClientsConnectés } clients
	qui sont connectés :)
	<br />
	<%
	  ServletContext sc = request.getServletContext();
	 @SuppressWarnings("unchecked")
	 HashSet<Client> clients = (HashSet<Client>) sc.getAttribute("logins");
	  if (clients!= null) {
	    out.write("	Les utilisateurs connectés sont : ");
	    for (Client client : clients) {
	      out.write(client.getLogin() + " ");
	    }
	    out.write(".");
	  } else {
	    out.write("Personne n'est connecté !");
	  }
	%>
</body>
</html>