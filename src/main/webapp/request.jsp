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
    <%@ taglib prefix="c" uri="/struts-tags" %>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <sj:head/>
    <s:head/>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-default">
            <a class="navbar-brand" href="#"><img src="/img/logo.jpg" alt="logoSP"/></a>

            <div>
                <s:form action="basicSearch" cssClass="navbar-form navbar-right">
                    <s:textfield name="searchWord" type="text" size="30" cssClass="form-control"
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

        <div class="col-md-10">
            <div class="row content_header">
                <div class="category col-md-5">
                    <s:form action="request_" cssClass="form-inline">
                        <span><s:text name="text.filter_by_client"/></span>
                        <s:select name="clientId" list="clientList" listKey="id" listValue="%{lname+' '+fname}"/>
                        <s:submit cssClass="btn btn-default" key="text.submit"></s:submit>
                    </s:form>
                </div>
                <div class="category col-md-5 ">
                    <s:form action="request_" cssClass="form-inline">
                        <span><s:text name="text.filter_by_status"/></span>
                        <s:select name="requestStatus" list="statusList" listKey="statusCode" listValue="statusCode"/>
                        <s:submit cssClass="btn btn-default" key="text.submit"></s:submit>
                    </s:form>
                </div>
                <div class="add col-md-2">
                    <s:form action="request_add">
                        <s:submit cssClass="btn btn-primary" key="text.add"/>
                    </s:form>
                </div>

            </div>

            <div class="row content_body">
                <s:if test="bookRequestList!=null">
                    <display:table requestURI="request_" name="bookRequestList" id="bookRequest" pagesize="10" class="pagination">
                        <display:column title="#" class="narrow"><s:property value="#attr.bookRequest_rowNum"/>
                        </display:column>
                        <display:column property="client.lname" title="Client"></display:column>
                        <display:column property="client.fname" title=""></display:column>
                        <display:column property="status" title="Status"></display:column>
                        <display:column property="orderDate" title="Date"></display:column>
                        <display:column property="decsription" title="Déscription" class="desc"></display:column>
                        <display:column title="Critére(s) de recherche" class="tag">
                            <table class="tag">
                                <s:if test="#attr.bookRequest.author!=null && #attr.bookRequest.author !=''">
                                    <tr>
                                        <td class="tag_name"><strong><s:text name="text.author"/></strong></td>
                                        <td class="tag_value"><span> <s:property value="#attr.bookRequest.author"/></span></td>
                                    </tr>
                                </s:if>
                                <s:if test="#attr.bookRequest.title!=null && #attr.bookRequest.title !=''">
                                    <tr>
                                        <td class="tag_name"><strong><s:text name="text.title"/></strong></td>

                                        <td class="tag_value"><span> <s:property value="#attr.bookRequest.title"/></span></td>
                                    </tr>
                                </s:if>
                                <s:if test="#attr.bookRequest.category!=null">
                                    <tr>
                                        <td class="tag_name">
                                            <strong><s:text name="text.category"/></strong></td>
                                        <td class="tag_value"><span> <s:property
                                                value="#attr.bookRequest.category.name"/></span></td>
                                    </tr>
                                </s:if>


                            </table>
                        </display:column>

                        <display:column media="html" class="controls">
                            <s:url action="request_edit" id="edit_url">
                                <s:param name="requestId" value="#attr.bookRequest.id"></s:param>
                            </s:url>
                            <s:url action="request_delete" id="delete_url">
                                <s:param name="requestId" value="#attr.bookRequest.id"></s:param>
                                <s:param name="clientId" value="#attr.bookRequest.client.id"></s:param>
                            </s:url>
                            <s:if test="requestStatus!=null && requestStatus=='Disponible'">
                                <s:url action="request_passivate" id="passivate_url">
                                    <s:param name="requestId" value="#attr.bookRequest.id"></s:param>
                                </s:url>
                            </s:if>

                            <s:a href="%{edit_url}" cssClass="control btn btn-link"><span
                                    class="glyphicon glyphicon-edit"></span></s:a>
                            <s:a href="%{delete_url}" cssClass="control btn btn-link"><span
                                    class="control glyphicon glyphicon-trash"></span></s:a>
                            <s:if test="requestStatus!=null && requestStatus=='Disponible'">
                                <s:a href="%{passivate_url}" cssClass="control btn btn-link"><span
                                        class="glyphicon glyphicon-ok-circle"></span></s:a>
                            </s:if>
                        </display:column>
                    </display:table>
                </s:if>

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