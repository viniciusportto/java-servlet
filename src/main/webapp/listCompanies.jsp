<%@ page import="br.com.manager.Company" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
    Companies list: <br/>

    <ul>
        <c:forEach items="${companies}" var="company">
            <li>${company.name}</li>
        </c:forEach>
    </ul>

</body>
</html>