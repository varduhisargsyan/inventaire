<%--
  Created by IntelliJ IDEA.
  User: varduhi
  Date: 1/12/2015
  Time: 5:41 PM
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
            <a class="navbar-brand" href="#"><img src="/img/logo.jpg" alt="logoSP"/></a>

            <div>
                <s:form  action="basicSearch" cssClass="navbar-form navbar-right">
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
            <div class="row cloture ">
                <div class="col-md-1 col-md-offset-6">
                    <a href="client_.action">  <span class="cloture glyphicon glyphicon-remove-circle"></span></a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4  col-md-offset-2 panel panel-default">


                    <div class="panel-heading">
                        <span class="form_panel_heading_gl glyphicon glyphicon-bookmark"></span><span class="form_panel_heading_txt"><s:text name="text.add_client"/></span>
                    </div>
                    <s:form action="client_save">
                        <div class="form-group">
                            <s:textfield  name="client.fname" key="text.first_name"/>
                        </div>


                        <s:textfield  name="client.lname" key="text.last_name"/>

                        <s:textfield  name="client.nfix" key="text.tel_fix"/>

                        <s:textfield  name="client.nmob" key="text.tel_mob"/>
                        <s:textfield  name="client.email" key="text.mail"/>
                        <s:textarea  name="client.address" key="text.address"/>
                        <s:submit key="text.submit_crud" cssClass="btn btn-primary pull-right"/>
                    </s:form>
                </div>
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




