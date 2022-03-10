<%@ include file="./header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<h3>Movie Review</h3>
<sf:form modelAttribute="review" class="w-25">
	<div class="mb-3">
		<label for="rating" class="form-label">Rating</label>
		<sf:input type="number" class="form-control" id="rating" path="rating" />
	</div>

	<div class="mb-3">
		<label for="review" class="form-label">Review</label>
		<sf:input type="text" class="form-control" id="review" path="review" />
	</div>




	<button type="submit" class="btn btn-primary">Add Review</button>
</sf:form>
<%@ include file="./footer.jsp"%>