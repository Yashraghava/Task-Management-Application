<%@ include file="common/headers.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<h1>
	Add new Task
	</h1> 
	<form:form method="post" modelAttribute="task">
	
		<fieldset class="mb-3">
		<form:label path="description">Description</form:label>
		<form:input type="text" name="description" path="description" required="true"/>
		<form:errors path="description" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset class="mb-3">
		<form:label path="date">Target Date</form:label>
		<form:input type="text" name="date" path="date" required="required"/>
		<form:errors path="date" cssClass="text-warning"/>
		</fieldset>
		
		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="done" />
		<input type="submit" class="btn btn-success">
	</form:form>
</div>
<%@ include file="common/footers.jspf" %>
