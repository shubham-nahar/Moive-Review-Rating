<%@ include file="./header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<h3>Add Movie</h3>
<sf:form modelAttribute="movie" class="w-25">
  <div class="mb-3">
    <label for="name" class="form-label">name</label>
    <sf:input type="text" class="form-control" id="name" path="name" />
  </div>
  
  <div class="mb-3">
    <label for="releaseyear" class="form-label">Release Year</label>
    <sf:input type="number" class="form-control" id="releaseyear" path="releaseYear" />
  </div>
  
  <div class="mb-3">
    <label for="runtime" class="form-label">RunTime</label>
    <sf:input type="text" class="form-control" id="runtime" path="runTime" />
  </div>
  
  <div class="mb-3">
    <label for="genere" class="form-label">Genere</label>
    <sf:input type="text" class="form-control" id="phone" path="genere" />
  </div>
  
  
  <button type="submit" class="btn btn-primary">Add Movie</button>
</sf:form>
<%@ include file="./footer.jsp" %>