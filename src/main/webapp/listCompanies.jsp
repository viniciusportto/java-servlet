<%@ page import="br.com.manager.Company" %>
<%@ page import="java.util.List" %>

<html>
<body>
        Companies List: <br/>
<ul>
    <%
        List<Company> companyList = (List<Company>) request.getAttribute("companies");
        for (Company company : companyList) {
    %>
    <li><%=company.getName()%>
    </li>
    <%
        }
    %>
</ul>
</body>
</html>