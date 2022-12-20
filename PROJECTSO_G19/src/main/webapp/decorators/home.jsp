<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Home</title>
    <%@include file="/common/link-css-js.jsp"%>
</head>
<body>
<div class="wrapper">
<%--<%@include file="/common/header.jsp"%>--%>
<%@include file="/common/header.jsp"%>
<nav
        class="navbar navbar-expand-md navbar-light bg-light sticky-top"
>
    <div class="container-fluid">
        <button
                class="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarResponsive"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/login"/> "
                    >Đăng nhập</a
                    >
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row mt-3">
        <div class="col-3">
            <%@include file="/common/admin/menu.jsp"%>
        </div>
        <div class="col-9">
            <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                </ol>
            </nav>
            <dec:body/>
        </div>
    </div>
</div>
<%@include file="/common/footer.jsp"%>
</body>
</html>
