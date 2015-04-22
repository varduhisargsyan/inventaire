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
    <script type="text/javascript">
        function disableF5(e) {
            if ((e.which || e.keyCode) == 116 || (e.which || e.keyCode) == 82) e.preventDefault();
        }
        ;

        $(document).ready(function () {
            $(document).on("keydown", disableF5);
        });
        function preventBack() {
            window.history.forward();
        }
        setTimeout("preventBack()", 0);
        window.onunload = function () {
            null
        };
    </script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-default">
            <a class="navbar-brand"  href="#"><img src="/img/logo.jpg" alt="logoSP"/></a>

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
            <div class="row cloture ">
                <div class="col-md-1 col-md-offset-7">
                    <a href="inventaire.action"> <span class="cloture glyphicon glyphicon-remove-circle"></span></a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-5  col-md-offset-2 panel panel-default">

                    <div class="panel-heading">
                        <span class="form_panel_heading_gl glyphicon glyphicon-bookmark"></span><span
                            class="form_panel_heading_txt"><s:text name="text.sales"/></span>
                    </div>
                    <s:form action="sale_">
                        <div class="row">
                            <div class="col-md-12">
                                <s:textfield name="book.title" key="text.title" readonly="true"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <s:textfield name="book.author" key="text.author" readonly="true"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <s:hidden name="book.id"/>
                                <s:hidden name="book.category.id"/>
                                <s:textfield name="book.category.name" key="text.category" readonly="true"/>
                            </div>
                        </div>


                        <div class="row">

                            <div class="col-md-2">
                                <strong> <s:text name="text.count"/></strong>

                            </div>
                            <div class="col-md-5">
                                <s:textfield name="book.quantityinstore" placeholder="%{getText('text.count_store')}"
                                             readonly="true"/>
                            </div>
                            <div class="col-md-5">
                                <s:textfield name="book.quantityinstock" placeholder="%{getText('text.count_stock')}"
                                             readonly="true"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3">
                                <strong> <s:text name="text.price_unit"/></strong>

                            </div>
                            <div class="col-md-3"><s:textfield name="book.price" readonly="true"/></div>
                            <div class="col-md-3">
                                <strong> <s:text name="text.price_sold"/></strong>

                            </div>
                            <div class="col-md-3"><s:textfield name="sales.soldPrice" value="%{book.price}"/></div>
                        </div>
                        <div class="row">
                            <div class="col-md-2">
                                <strong> <s:text name="text.count"/></strong>

                            </div>
                            <div class="col-md-5">
                                <s:textfield name="sales.soldquantityinstore"
                                             placeholder="%{getText('text.sold_count_store')}"/>
                            </div>
                            <div class="col-md-5">
                                <s:textfield name="sales.soldquantityinstock"
                                             placeholder="%{getText('text.sold_count_stock')}"/>

                            </div>

                        </div>

                        <s:if test="hasActionErrors()">
                            <div class="row">
                                <div class="col-md-12">
                                    <s:actionerror/>

                                </div>

                            </div>
                        </s:if>
                        <div class="row">
                            <div class="col-md-12">
                                <s:textarea name="sales.desc" key="text.desc"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <s:submit cssClass="btn btn-primary pull-right" key="text.submit_crud"/>
                            </div>
                        </div>


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

