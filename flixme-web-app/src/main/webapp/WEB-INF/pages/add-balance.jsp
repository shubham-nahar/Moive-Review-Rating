<%@ include file="./header.jsp"%>

<h3>Enter amount to add to Flixme Walet</h3>

<form method="post" action="./add-balance" class="w-25">

	<div class="mb-3">
		<label for="FlixmeBalance" class="form-label">Enter Amount</label> <input
			type="number" class="form-control" id="balance" name="balance" />
	</div>
	<button type="submit" class="btn btn-primary">Add</button>
</form>



<%@ include file="./footer.jsp"%>