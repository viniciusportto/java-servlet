<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<body>
    Companies list: <br/>

    <ul>
        <c:forEach items="${companies}" var="company">
            <li>${company.name} - <fmt:formatDate value="${company.openDate}" pattern="MM/dd/yyyy"/> </li>
        </c:forEach>
    </ul>

</body>
</html>