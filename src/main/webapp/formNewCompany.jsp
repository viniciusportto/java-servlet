<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/newcompany" var="linkServletNewCompany"/>
<html>
<body>
    <form action="${linkServletNewCompany}" method="post">

      Company name: <input type="text" name="Company name"/>

        <input type="submit"/>

    </form>
</body>
</html>