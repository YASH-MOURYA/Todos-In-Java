<%@ include file="common/header.jspf"%>
<!-- <div>Welcome to JSP Learning Tutorial</div>
    <div>Welcome ${name}</div> -->
<!-- <div>Your Todos are : ${todos}</div> -->

<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>Your Todos</h1>
	<table class="table">
		<thead>
			<tr>
				<!-- <th>id</th> -->
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<!-- <td>${todo.id}</td> -->
					<!-- "redirect:list-todos"; -->
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="delete-todo?id=${todo.id}"
						class="btn btn-warning">DELETE</a></td>
					<td><a href="update-todo?id=${todo.id}"
						class="btn btn-success">UPDATE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<%@ include file="common/footer.jspf" %>>
