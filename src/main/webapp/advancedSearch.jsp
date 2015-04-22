<%--
  Created by IntelliJ IDEA.
  User: varduhi
  Date: 12/25/2014
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: varduhi
  Date: 8/5/2014
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <%@taglib uri="/struts-jquery-tags" prefix="sj" %>
    <%@taglib uri="/struts-tags" prefix="s" %>
    <%@taglib prefix="display" uri="http://displaytag.sf.net" %>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <sj:head locale="fr" jquerytheme="hot-sneaks"/>
    <s:head/>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-default">
            <a class="navbar-brand" href="#"><img src="/img/logo.jpg"
                                                                                                alt="logoSP"/></a>

            <div>
                <s:form action="basicSearch" cssClass="navbar-form navbar-right">
                    <s:textfield name="searchWord" type="text" size="30" cssClass="form-control"
                                 placeholder="%{getText('input.search')}"/>
                    <s:submit cssClass="btn btn-default" key="text.submit"/>
                    <a href="advancedSearch_input.action" class="navbar-link">
                        <small class="nav-small"><s:text name="text.advanced_search"/></small>
                    </a>
                </s:form>
            </div>
        </nav>
    </div>

    <div class="row content">
        <div class="col-md-2 menu_sidebar  list-group">
            <a class="menu list-group-item home" href="inventaire.action"><span
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

        <div class="col-md-10">
            <div class="row content_header">

                <s:if test="hasActionErrors()">
                    <s:actionerror/>
                </s:if>
            </div>

            <div class="row content_body">
                <s:form action="advancedSearch_" cssClass="form-inline">
                    <div class="row" style="padding:10px;padding-bottom: 40px">

                        <div class="col-md-2">
                            <s:textfield name="title" placeholder="%{getText('text.title')}"/>
                        </div>

                        <div class="col-md-2 col-md-offset-1">
                            <s:textfield name="author" placeholder="%{getText('text.author')}"/>
                        </div>

                        <div class="col-md-3 col-md-offset-1">
                            <s:select list="categories" name="categoryId"
                                      listValue="name" listKey="id" headerKey="0"
                                      headerValue="%{getText('select.category')}"/>
                        </div>

                    </div>
                    <div class="row" style="padding: 10px">
                        <div class="col-md-4">
                            <sj:datepicker size="28px" placeholder="%{getText('text.startDate')}" cssClass="form-control"
                                           parentTheme="bootstrap" name="startDate" displayFormat="dd-mm-yy"/>

                        </div>
                        <div class="col-md-4">
                            <sj:datepicker  size="28px" placeholder="%{getText('text.endDate')}" cssClass="form-control"
                                            name="endDate" displayFormat="dd-mm-yy"/>

                        </div>
                    </div>


                    <div class="row" style="padding-top: 70px">
                        <div class="col-md-offset-5">
                            <s:submit key="text.submit" cssClass="btn btn-primary"/>
                        </div>
                    </div>

                </s:form>

            </div>

        </div>
    </div>
    <div class="footer row">

        <p class="text-right small"><span class="copyright glyphicon glyphicon-copyright-mark"></span><s:text
                name="text.copuright"/></p>
    </div>
</div>

</body>
</html>












