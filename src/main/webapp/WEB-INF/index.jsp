<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books And Authors</title>
</head>
<body>
<h1>All Authors</h1>
<ul>
	<c:forEach items="${authors}" var="author">
		<li>${author.name} wrote:
			<ul>
				<c:forEach items="${author.books}" var="book">
					<li>${book.title }</li>
				</c:forEach>
			</ul>
		</li>
	</c:forEach>
</ul>
<h1>New Author</h1>
<form:form action="/authors" method="post" modelAttribute="author">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form> 

<h1>All Books</h1>
<ul>
	<c:forEach items="${books}" var="book">
		<li>${book.title} written by: ${book.author.name }
			<ul>
				<li>Published By:
					<ul>
						<c:forEach items="${book.publishers }" var="publisher">
							<li>${publisher.name }</li>
						</c:forEach>
					</ul>
				</li>
			</ul>
		</li>
	</c:forEach>
</ul>   

<h1>New Book</h1>
<form:form action="/books" method="post" modelAttribute="book">
    <p>
        <form:label path="title">Title:</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
    	<form:label path="author">Author:</form:label>
        <form:errors path="author"/>
        <form:select path="author">
		    <form:options items="${authors}" itemValue="id" itemLabel="name"/>
		</form:select>
    </p>  
    <input type="submit" value="Submit"/>
</form:form> 

<h1>All Publishers</h1>
<ul>
	<c:forEach items="${publishers}" var="publisher">
		<li>${publisher.name }
			<ul>
				<c:forEach items="${publisher.books}" var="book">
					<li>${book.title}</li>
				</c:forEach>
			</ul>
		</li>
	</c:forEach>
</ul>

<h1>New Publisher</h1>
<form:form action="/publishers" method="post" modelAttribute="publisher">
    <p>
        <form:label path="name">Name:</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>

<h1>Create a Publication</h1>
<form:form action="/publications" method="post" modelAttribute="publications">
    <p>
        <form:label path="publish_date">Publish Date:</form:label>
        <form:errors path="publish_date"/>
        <form:input path="publish_date" type="date"/>
    </p>
    <p>
    	<form:label path="book">Book:</form:label>
        <form:errors path="book"/>
        <form:select path="book">
		    <form:options items="${books}" itemValue="id" itemLabel="title"/>
		</form:select>
    </p>
    <p>
    	<form:label path="publisher">Publisher:</form:label>
        <form:errors path="publisher"/>
        <form:select path="publisher">
		    <form:options items="${publishers}" itemValue="id" itemLabel="name"/>
		</form:select>
    </p> 
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>