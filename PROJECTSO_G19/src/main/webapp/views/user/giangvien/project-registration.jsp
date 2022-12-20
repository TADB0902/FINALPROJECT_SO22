<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <c:if test="${not empty message}">
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <strong>Không nằm trong thời gian đăng ký</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <c:set var = "check" scope = "session" value = "${action}"/>

    <form <c:if test = "${check == 'create'}"> action="registration/create" method="post" </c:if>
            <c:if test = "${check == 'update'}"> action="../registration/update" method="post" </c:if>>
        <h5 style="font-weight: bold" >Đăng ký đề tài</h5>
    <div class="form-group">
      <div class="row">
          <input name="id" value="${projectLecturersModel.id}" hidden>
        <div class="form-group col-12">
          <label>Tên đề tài</label>
          <input id="a" type="text" class="form-control" placeholder="Tên đề tài" required name="topic"  value="<c:if test = "${check == 'update'}"> ${projectLecturersModel.topic}</c:if>">
        </div>
        <div class="form-group col-6">
            <input hidden name="username" value="${lecturers.username}">
          <label>Chuyên ngành</label>
          <input id="" type="text" class="form-control" placeholder="Chuyên ngành" required name="" value="${lecturers.department}" disabled>
            <input name="department" value="${lecturers.department}" hidden>
        </div>
        <div class="form-group col-6">
          <label>Giáo viên hướng dẫn</label>
          <input id="name" type="text" class="form-control" placeholder="GVHD" required name="fullname" value="${lecturers.fullname}" disabled>
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="row">
        <div class="form-group col-12">
          <label>Yêu Cầu</label>
          <input type="tel" class="form-control" placeholder="Yêu Cầu" required name="request" value="<c:if test = "${check == 'update'}"> ${projectLecturersModel.request}</c:if>">
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="row">
        <div class="form-group col-12">
          <label>Mục tiêu</label>
          <input type="tel" class="form-control" placeholder="Mục tiêu" required name="target" value="<c:if test = "${check == 'update'}"> ${projectLecturersModel.target}</c:if>">
        </div>
      </div>
    </div>
    <div class="form-group d-flex justify-content-end">
      <button style="padding-left: 20px; padding-right: 20px; margin-right: 10px;"
              id="btnAddEmployee" class="btn btn-primary" type="submit">
          <c:if test = "${check == 'create'}"> Tạo</c:if>
          <c:if test = "${check == 'update'}"> Sửa</c:if>
      </button>
        <c:if test = "${check == 'create'}">
            <button style="padding-left: 20px; padding-right: 20px;"
                    class="btn btn-danger" type="reset">Hủy
            </button>
        </c:if>

    </div>
  </form>
</div>

<div>
  <h5 style="font-weight: bold">Danh sách đề tài</h5>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">Tên đề tài</th>
      <th scope="col">Chuyên ngành</th>
      <th scope="col">GVHD</th>
        <th scope="col">Mục tiêu</th>
        <th scope="col">Yêu cầu</th>
        <th scope="col">Yêu cầu</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${projectLecturersDAOS}" var="p">
    <tr>
        <td>${p.topic}</td>
        <td>${p.department}</td>
        <td>${p.user.fullname}</td>
        <td>${p.target}</td>
        <td>${p.request}</td>
        <td>
            <div class="d-flex justify-content-around align-items-center">
                <a href="<c:url value="/giangvien/registration/update?id=${p.id}"/>">
                    <i class="fa-solid fa-pen-to-square"></i>
                </a>
                <a href="<c:url value="/giangvien/registration/delete?id=${p.id}"/>">
                    <i class="fa-solid fa-trash"></i>
                </a>
            </div>
        </td>
    </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
