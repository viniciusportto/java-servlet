<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <body>
    <c:if test="${not empty company}">
        Company ${ company } Sucessfull create!
    </c:if>

    <c:if test="${empty company}">
        No company created!
    </c:if>
    </body>
</html>
