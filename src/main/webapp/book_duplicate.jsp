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
            <a class="navbar-brand" href="#"><img src="/img/logo.jpg"
                                                                                                alt="logoSP"/></a>

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

        <div class="col-md-10">
            <div class="row content_header found_title">
<s:text name="text.duplicate_found"></s:text>
            </div>


            <div class="content_body">

                    <table class="pagination">

                        <tr>
                            <th>#</th>
                            <th><s:text name="text.title"/></th>
                            <th><s:text name="text.author"/></th>
                            <th><s:text name="text.category"/></th>
                            <th class="narrow"><s:text name="text.price_unit"/></th>
                            <th class="narrow"><s:text name="text.count_store_M"/></th>
                            <th class="narrow"><s:text name="text.count_stock_M"/></th>
                            <th></th>

                        </tr>

                        <tr>
                            <td class="narrow"><s:property value="book.id"></s:property></td>
                            <td><s:property value="book.title"></s:property></td>
                            <td><s:property value="book.author"></s:property></td>
                            <td><s:property value="book.category.name"></s:property></td>
                            <td class="narrow"><s:property value="book.price"></s:property></td>
                            <td class="narrow"><s:property value="book.quantityinstore"></s:property></td>
                            <td class="narrow"><s:property value="book.quantityinstock"></s:property></td>
                            <td class="controls">
                                <s:url action="book_editDuplicate" id="edit_url">
                                    <s:param name="bookId" value="book.id"></s:param>
                                </s:url>
                                <s:a href="%{edit_url}" cssClass="btn btn-link btn-lg "><span
                                        class="glyphicon glyphicon-edit"></span></s:a>
                            </td>
                        </tr>


                    </table>



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