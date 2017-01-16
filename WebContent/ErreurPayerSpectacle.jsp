<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Attention vous avez mal renseigné une de vos informations bancaires:
<br />
<%if(request.getAttribute("exception")!= null){
			out.write((String)(request.getAttribute("exception"))+"<br/>");
	}%>
<br /> <a href="voirPanier.jsp">Cliquer ici pour revenir au panier</a>
	
</body>
</html>