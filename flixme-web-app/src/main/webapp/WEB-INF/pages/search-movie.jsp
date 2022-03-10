<%@ include file="./header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<h3>User Registration</h3>
<form action="./search-movies" method="post" class="w-25">
	<div class="mb-3">
		<label for="search" class="form-label">search</label> <input
			type="text" class="form-control" id="title" name="title" />
	</div>


	<button type="submit" class="btn btn-primary">search</button>
</form>
<%@ include file="./footer.jsp"%>
