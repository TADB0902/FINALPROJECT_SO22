<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>HomePage</title>
    <%@include file="/common/link-css-js.jsp"%>
</head>
<body class="wrapper">
<%@include file="/common/header.jsp"%>
<%@include file="/common/nav.jsp"%>
<div class="container-fluid">
    <div class="row mt-3">
        <div class="col-3">
            <%@include file="/common/giangvien/menu.jsp"%>
        </div>
        <div class="col-9">
            <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="<c:url value="/giangvien/home"/>">Home</a></li>
                </ol>
            </nav>
            <dec:body/>
        </div>
    </div>
</div>
<%@include file="/common/footer.jsp"%>
</body>
</html>
