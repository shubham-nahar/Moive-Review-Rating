<%@ include file="./header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<h3>User Registration</h3>
<sf:form modelAttribute="cust" class="w-25">
	<div class="mb-3">
		<label for="name" class="form-label">name</label>
		<sf:input type="text" class="form-control" id="name" path="name" />
	</div>

	<div class="mb-3">
		<label for="email" class="form-label">email</label>
		<sf:input type="email" class="form-control" id="email" path="email" />
	</div>

	<div class="mb-3">
		<label for="password" class="form-label">password</label>
		<sf:input type="password" class="form-control" id="password"
			path="password" />
	</div>

	<div class="mb-3">
		<label for="phone" class="form-label">phone</label>
		<sf:input type="text" class="form-control" id="phone" path="phone" />
	</div>

	<div class="mb-3">
		<label for="city" class="form-label">City</label>
		<sf:input type="text" class="form-control" id="city" path="city" />
	</div>

	<div class="mb-3">
		<label for="pincode" class="form-label">PinCode</label>
		<sf:input type="text" class="form-control" id="pincode" path="pincode" />
	</div>

	<div class="mb-3">
		<label for="country" class="form-label">Country</label>
		<sf:input type="text" class="form-control" id="country" path="country" />
	</div>


	<button type="submit" class="btn btn-primary">Registration</button>
</sf:form>
<%@ include file="./footer.jsp"%>