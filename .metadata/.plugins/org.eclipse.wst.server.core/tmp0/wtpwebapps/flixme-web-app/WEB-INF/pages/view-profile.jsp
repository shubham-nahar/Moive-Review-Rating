<%@ include file="./header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p class="display-5">${sessionScope.cust.name}</p>

<div class="row">
	<div class="col">
		<h3>User details</h3>
		<table class="table" style="width: 50%;">
			<tr>
				<td>Customer name:</td>
				<td>${sessionScope.loggedInUser.name}</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${sessionScope.loggedInUser.email}</td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td>${sessionScope.loggedInUser.phone}</td>
			</tr>
			<tr>
				<td>Flixme Balance:</td>
				<td>${sessionScope.loggedInUser.balance}</td>
			</tr>
			<tr>
				<td>City:</td>
				<td>${sessionScope.loggedInUser.city}</td>
			</tr>
			<tr>
				<td>Country:</td>
				<td>${sessionScope.loggedInUser.country}</td>
			</tr>
		</table>
		<a class="btn btn-primary" href="./edit-profile">Edit Profile</a> <a
			class="btn btn-primary" href="./add-balance">Add Balance</a>
	</div>


</div>





<%@ include file="./footer.jsp"%>