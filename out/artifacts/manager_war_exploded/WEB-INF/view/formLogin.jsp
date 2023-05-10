<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrance" var="linkEntranceServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
    <form action="${linkEntranceServlet}" method="post">

        Login: <input type="text" name="login"/>
        Password: <input type="password" name="password">

        <input type="hidden" name="action" value="Login" >

        <input type="submit"/>

    </form>
</body>
</html>