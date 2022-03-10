<%@ include file="./header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p class="display-5">${movie.name}</p>


<div class="row">
	<div class="col">
		<table class="table">
			<tr>
				<td>ID:</td>
				<td class="lead">${movie.id}</td>
			</tr>

			<tr>
				<td>Name:</td>
				<td class="lead">${movie.name}</td>
			</tr>

			<tr>
				<td>Genere:</td>
				<td class="lead">${movie.genere}</td>
			</tr>
			<tr>
				<td>RunTime:</td>
				<td class="lead">${movie.runTime}</td>
			</tr>
			<tr>
				<td>Release Year:</td>
				<td class="lead">${movie.releaseYear}</td>
			</tr>
		</table>

	</div>


</div>
<div class="col">
	<a class="btn btn-primary" href="./add-review?movieId=${movie.id}">Give
		Review</a> <a class="btn btn-primary"
		href="./get-review?movieId=${movie.id}">Watch Review</a>
</div>





<%@ include file="./footer.jsp"%>