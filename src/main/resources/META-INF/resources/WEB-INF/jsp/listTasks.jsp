<%@ include file="common/headers.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<h1>
	Your Tasks are
	</h1> 
	<table class="table">
	<thead>
	<tr>
		<th>DESCRIPTION</th>
		<th>DATE</th>
		<th>IS DONE?</th>
		<th></th>
		<th></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items= "${tasks}" var="task">
		<tr>
			<td>${task.description}</td>
			<td>${task.date}</td>
			<td>${task.done}</td>
			<td ><a href="delete-todo?id=${task.id}" class="btn btn-warning">Delete</a></td>
			<td ><a href="update-todo?id=${task.id}" class="btn btn-success">Update</a></td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">Add Task</a>
</div>
<%@ include file="common/footers.jspf" %>