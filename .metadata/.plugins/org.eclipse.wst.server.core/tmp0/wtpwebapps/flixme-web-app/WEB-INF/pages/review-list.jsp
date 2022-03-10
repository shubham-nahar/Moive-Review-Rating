<%@ include file="./header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Movie list</h2>

<div class="table-responsive">
	<table class="table caption-top w-auto table-bordered">
		<caption>Reviews</caption>
		<thead>
			<tr>
				<th>Rating</th>
				<th>Review</th>
				<th>Given By</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${reviews}" var="rv">
				<tr>

					<td>${rv.rating}</td>
					<td>${rv.review}</td>
					<td>${rv.customer.name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="footer.jsp"%>