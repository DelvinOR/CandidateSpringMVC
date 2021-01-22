<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Candidate Manager</title>
 </head>
 
 <body bgcolor = "darkorange">
 <div align = "center">
 	<h2>Candidate Manager</h2>
 	<form action = "search" method = "GET">
 		<input type = "text" name = "search_word"/> &nbsp;
 		<input type = "submit" value = "Search"/>
 	</form>
 	<h3><a href = "new">New Candidate</a></h3>
 	<table border = "1" cellpadding = "5">
 		<tr>
 			<th>Id</th>
 			<th>Name</th>
 			<th>Email</th>
 			<th>Options</th>
 		</tr>
 		<c:forEach items = "${candidate_list}" var = "candidate">
 		<tr>
 			<td>${candidate.jid}</td>
			<td>${candidate.name}</td>
			<td>${candidate.email}</td>
			<td>
				<a href = "edit?jid=${candidate.jid}">Edit</a>
				&nbsp;&nbsp;&nbsp;
				<a href = "delete?jid=${candidate.jid}">Delete</a>
			</td>
 		</tr>
 		</c:forEach>
 	</table>
 </div>
 </body>
 </html>