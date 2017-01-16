<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList"
	import="java.util.List"
	import="javaee.spectacle.webservices.WSGestionSpectacles"
	import="javaee.spectacle.webservices.GestionSpectaclesService"
	import="javaee.spectacle.beans.Client,javaee.spectacle.webservices.Reservation,javaee.spectacle.webservices.Spectacle,java.util.Date,java.util.ArrayList,java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="inc/style.css" />
<title>Mon compte</title>
</head>
<body>

	<%
	  float prix = 0;
	  //S'il on souhaite payer à partir du menu trouver ou reserver
	  if ((String) request.getParameter("Choisir") != null) {
	    Client client = (Client) session.getAttribute("client");
	    GestionSpectaclesService service = new GestionSpectaclesService();
	    WSGestionSpectacles port = service.getGestionSpectaclesPort();
	    //Récupération des réservations
	    List<Reservation> reservations = null;
	    try {
	      reservations = port.recupererReservation(client.getIdClient());
	      session.setAttribute("reservations", reservations);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	    //Récupération de la liste des spectacles non payés
	    List<Spectacle> spectacles = port.trouverSpectacle(new Spectacle());
	    session.setAttribute("spectaclesTrouver", spectacles);
	    List<Reservation> reservationsNonPayées = new ArrayList<Reservation>();
	    if (reservations != null) {
	      for (int i = 0; i < reservations.size(); i++) {
	        if (reservations.get(i).isPaiement() == false) {
	          reservationsNonPayées.add(reservations.get(i));
	        }
	      }
	      session.setAttribute("listesSpectaclesNonPayées", reservationsNonPayées);
	    }

	    //Récuper le numéro (choix) du spectacle à payer
	    String stringChoix = (String) request.getParameter("Choisir").toString();
	    int choix = Integer.parseInt(stringChoix.substring(6)) - 1;
	    System.out.println("choix: " + choix);
	    Reservation reservationChoisi = reservationsNonPayées.get(choix);
	    session.setAttribute("reservationChoisi", reservationChoisi);
	    int nbPlaces = ((Reservation) session.getAttribute("reservationChoisi")).getNombrePlaces();
	    session.setAttribute("reservation",
	        (Reservation) session.getAttribute("reservationChoisi"));
	    int spectacleId = reservationChoisi.getIdSpectacle();
	    int i = 0;
	    while (i < spectacles.size()) {
	      if (spectacleId == spectacles.get(i).getId()) {
	        prix = (int) spectacles.get(i).getPrix();
	      }
	      i++;
	    }
	    //prix de la réservations 
	    prix *= nbPlaces;

	    //Si le paiement se fait à partir du panier
	  } else {
	    prix = ((Spectacle) session.getAttribute("spectacleChoisi")).getPrix();
	    prix *= ((Reservation) session.getAttribute("reservation")).getNombrePlaces();
	  }
	%>
	<h1>Payer un spectacle</h1>
	<form method="post" name="methodePost" action="PayerSpectacle">
		<h2>Remplir les informations ci-dessous</h2>
		<br>
		<fieldset>
			<ol>
				<li>
					Modalite de paiement:
					<select name="ModalitePaiement" id="listeType">
						<option value="choixPaiement">Choisir votre moyen de
							paiement</option>
						<option value="VISA">VISA</option>
						<option value="MasterCard">MasterCard</option>
					</select>
				</li>
				<li>
					Numero de carte:
					<input type="text" name="numeroCarte" />
				</li>
				<li>
					Date de validite de la carte:
					<input type="date" name="dateValidite" />
				</li>
				<li>
					Cryptogramme de la carte:
					<input type="text" name="cryptogramme" />
				</li>
			</ol>
		</fieldset>
		<br>
		Total à payer :
		<%=prix%>
		€
		<br>
		<input type="submit" value="Valider le paiement de la reservation" />
		<br>
		<br>
	</form>

	<a href="MenuPrincipal.jsp">Cliquer ici pour revenir sur la page
		d'accueil</a>

</body>
</html>



