<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1">
<link rel="stylesheet" href="css/main.css">

</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${mode == 'STUDENT_REGISTRATION'}">
			<form action="student" method="POST" enctype="multipart/form-data" id="uploadStudentForm" name="uploadStudentForm">
				
					<h1>Register</h1>
					<p>Please fill in this form to create a student.</p>
					<hr>

					<label for="firstName"><b>First Name</b></label>
					<input type="text" placeholder="Enter First Name" name="firstName" id="firstName" required>
					
					<label for="secondName"><b>Last Name</b></label>
					<input type="text" placeholder="Enter Last Name" name="lastName" id="lastName" required>
					
					<label for="Age"><b>Age</b></label>
					<input type="number" min="0" placeholder="Enter Age" name="age" id="age" required>
					
					<label for="photo"><b>Photo</b></label><br>
					<input type="file" placeholder="Select Photo" name="photo" id="photo">

					<hr>
					<button type="submit" class="registerbtn">Register</button>

				
				<div id="photoUploadError"></div>
			</form>
		</c:when>		
		
		<c:when test="${mode == 'STUDENT_VIEW'}">
			
			<form enctype="multipart/form-data" id="uploadStudentForm" name="uploadStudentForm">
				<div class="container">
				
					<h1>Student</h1>
					<p>Well come ${response.firstName}</p>
					<hr>
					
					<label for="photo"><b>Photo</b></label><br>
					<img src="${response.photoUri}" } alt="student's photo" id="studentPhoto" width="400">
					<br>

					<label for="firstName"><b>First Name</b></label>
					<label name="firstName" id="studentfirstName"><b>${response.firstName}</b></label>
					
					<br>
					<label for="lastName"><b>Last Name</b></label>
					<label name="lastName" id="studentlastName"><b>${response.lastName}</b></label>
					
					<br>
					<label for="age"><b>Age</b></label>
					<label name="age" id="age"><b>${response.age}</b></label>

					<hr>

				</div>
				<div id="photoUploadError"></div>
			</form>
			
		</c:when>
		
	</c:choose>	
</div>
</body>
</html>
