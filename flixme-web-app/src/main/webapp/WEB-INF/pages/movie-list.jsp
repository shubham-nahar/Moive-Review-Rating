<%@ include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Movies list</h2>

<div class="table-responsive">
	<table class="table caption-top w-auto table-bordered">
		<caption>List of Movies</caption>
		<thead>
			<tr>
				<th>Movie</th>
				<th>Genere</th>
				<th>Release Year</th>
				<th>RunTime</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${movies}" var="mv">
				<tr>
					<td><a href="./view-movie-details?id=${mv.id}"> ${mv.name}
					</a></td>
					<td>${mv.genere}</td>
					<td>${mv.releaseYear}</td>
					<td>${mv.runTime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="footer.jsp"%>