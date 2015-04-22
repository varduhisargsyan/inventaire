<%--
  Created by IntelliJ IDEA.
  User: varduhi
  Date: 2/23/2015
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <%@taglib uri="/struts-jquery-tags" prefix="sj" %>
    <%@taglib uri="/struts-tags" prefix="s" %>
    <sj:head/>
    <s:head/>
</head>
<body>
<%
    response.sendRedirect("inventaire.action");
%>

</body>
</html>
