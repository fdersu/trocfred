<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle Vente</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="style.css" rel="stylesheet">
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<nav class="navbar navbar-light bg-light">
		<form class="container-fluid justify-content-start">
			<button class="btn btn-outline-success me-2" type="button">Main
				button</button>
			<button class="btn btn-sm btn-outline-secondary" type="button">Smaller
				button</button>
		</form>
	</nav>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<div class="title">
	<p>Nouvelle Vente</p>
	</div>

	<div class="grid1">
		
			<img class="img" src="./img/interrogation.png" alt="point interrogation"
				width="50px">
		
		<form class="form" action="NewSaleServlet" method="post">
			<div class="grid2">
			<div class="labelarticle">
				<label for="article">Article</label> 
				</div>
				<div class="inputarticle">
				<input type="text"
					name="article" id="article">
					</div> 
					<div class="labeldescription">
					<label for="description">Description</label>
					</div>
					<div class="inputdescription">
				<input type="text" name="description" id="description">
				</div> 
				<div class="labelcategorie">
				<label for="catselect">Catégorie</label> 
				</div>
				
				<select class="selectcategorie" name="selectcat">
					<c:forEach var="cat" items="${categories }">
						<option value="${cat.numero }">${cat.libelle}</option>
					</c:forEach>
				</select> 
				<div class="labelmap">
				<label for="map">Mise à Prix</label>
				</div>
				<div class="inputmap">
				<input type="number"name="map" id="map"> 
				</div>
				<div class="labelDE">
					<label for="debutEnchere">Début de l'enchère</label> 
					</div>
					<div class="inputDE">
					<input type="date" name="debutEnchere"id="debutEnchere">
					</div> 
					<div class="labelFE">
					<label for="finEnchere">Fin de l'Enchère</label> 
					</div> 
					<div class="inputFE">
					<input type="date" name="finEnchere" id="finEnchere">
					</div>
					<div class="retrait">
				<fieldset class="fieldset">
					<legend align="left">Retrait</legend>
					<div class="grid3">
					<div class="labelrue">
					<label for="rue">Rue</label>
					</div>
					<div class="inputrue"> 
					<input type="text" name="rue" id="rue" value="${utilisateur.rue}">
					</div>
					<div class="labelcp">
					<label for="cp">Code Postal</label> 
					</div>
					<div class="inputcp">
					<input type="text" name="cp" id="cp" value="${utilisateur.codePostal}">
					</div>
					<div class="labelville">
					<label for="ville">Ville</label>
					</div>
					<div class="inputville"> 
					<input type="text" name="ville" id="ville" value="${utilisateur.ville}">
					</div>
					</div>
				</fieldset>
				</div>
				<input class="submit" type="submit" value="Enregistrer">
				<button class="annuler">Annuler</button>
			</div>
		</form>
	</div>






</body>

</html>