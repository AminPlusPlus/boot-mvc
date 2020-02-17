<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>First Web Application</title>

</head>

<body>


<form:form action="processForm" modelAttribute="customer">
    <br/>
   First Name <form:input path="firstName"/>
   Last Name <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <input type="submit" value="Submit">
</form:form>
</body>

</html>