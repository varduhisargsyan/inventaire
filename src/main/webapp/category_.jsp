<%--
  Created by IntelliJ IDEA.
  User: varduhi
  Date: 1/14/2015
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <%@taglib uri="/struts-jquery-tags" prefix="sj" %>
    <%@taglib uri="/struts-tags" prefix="s" %>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <sj:head/>
    <s:head/>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-default">
            <a class="navbar-brand" href="#"><img src="/img/logo.jpg"  alt="logoSP"/></a>

            <div>
                <s:form action="basicSearch" cssClass="navbar-form navbar-right">
                    <s:textfield  name="searchWord" type="text" size="30" cssClass="form-control"
                                 placeholder="%{getText('input.search')}"/>
                    <s:submit cssClass="btn btn-default" key="text.submit"/>
                    <a href="/advancedSearch_input.action" class="navbar-link">
                        <small class="nav-small"><s:text name="text.advanced_search"/></small>
                    </a>
                </s:form>
            </div>
        </nav>
    </div>

    <div class="row content">
        <div class="col-md-2 menu_sidebar  list-group">
            <a class="list-group-item home" href="inventaire.action"><span
                    class="menu_span-gl glyphicon glyphicon-home"></span><span class="menu_span-txt"> <s:text
                    name="text.home"/></span></a>
            <a class="menu list-group-item" href="salesReport.action"><span
                    class="menu_span-gl glyphicon glyphicon-export"></span><span class="menu_span-txt"><s:text
                    name="text.sales"/></span></a>
            <a class="menu list-group-item" href="receiptReport.action"><span
                    class="menu_span-gl glyphicon glyphicon-import"></span><span class="menu_span-txt"><s:text
                    name="text.reciept"/></span></a>
            <a class="menu list-group-item" href="flow.action"><span
                    class="menu_span-gl glyphicon glyphicon-refresh"></span><span class="menu_span-txt"><s:text
                    name="text.flow_control"/></span></a>
            <a class="menu list-group-item" href="client_.action"><span
                    class="menu_span-gl glyphicon glyphicon-user"></span><span
                    class="menu_span-txt"><s:text name="text.client"/></span></a>
            <a class="menu list-group-item" href="request_.action"><span
                    class="menu_span-gl glyphicon glyphicon-book"></span><span
                    class="menu_span-txt"><s:text name="text.request"/></span>
                <s:action name="request_" var="request"/>

                <s:if test="#request.bookRequestList != null">

                    <strong class="label label-danger pull-right"><s:property value="#request.bookRequestList.size"></s:property> </strong>
                </s:if>

            </a>
            <a class="menu list-group-item" href="lot_.action"><span
                    class="menu_span-gl glyphicon glyphicon-send"></span><span class="menu_span-txt"><s:text
                    name="text.case"/></span></a>
            <a class="menu list-group-item" href="category_.action"><span
                    class="menu_span-gl glyphicon glyphicon-list"></span><span class="menu_span-txt"><s:text
                    name="text.categories"/></span></a>




        </div>

        <div class="col-md-6 col-md-offset-1">
            <table class="pagination">
                <tr >
                    <th>#</th>
                    <th><s:text name="text.name"/></th>
                    <th><a href="<s:url action="category_add"/>" class="btn btn-primary btn-sm"> <s:text name="text.add"/></a>
                    </th>

                </tr>
                <s:iterator value="categoryList" status="status" var="category">
                    <tr>
                        <td class="narrow"><s:property value="#status.count"/></td>
                        <td><s:property value="#category.name"/></td>
                        <td class="controls">
                            <s:url action="category_edit" var="edit_url">
                                <s:param name="id"  value="#category.id"/>
                            </s:url>
                            <s:url action="category_delete" var="delete_url">
                                <s:param name="id"  value="#category.id"/>
                            </s:url>
                            <s:a href="%{edit_url}" cssClass="control btn btn-link btn-md"><span
                                    class="glyphicon glyphicon-edit"></span></s:a>
                            <s:a href="%{delete_url}" cssClass="control btn btn-link btn-md"><span
                                    class="glyphicon glyphicon-trash"></span></s:a>

                        </td>

                    </tr>


                </s:iterator>
            </table>


        </div>
    </div>
    <div class="footer row">


        <p class="text-right small"><span class="copyright glyphicon glyphicon-copyright-mark"></span><s:text name="text.copuright"/></p>
    </div>
</div>

</body>
</html>
