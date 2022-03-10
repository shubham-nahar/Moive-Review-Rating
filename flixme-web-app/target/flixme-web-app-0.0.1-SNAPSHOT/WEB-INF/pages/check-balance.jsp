<%@ include file="./header.jsp"%>

<h3>Your Current Flixme Balance is:
	"${sessionScope.loggedInUser.balance}"</h3>
<a href="./add-balance">Add Balance</a>

<%@ include file="./footer.jsp"%>