<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@include file="/common/taglib.jsp"%>
<html>
    <head>
        <title>Tạo đợt đăng ký</title>
    </head>
    <body>
        <form class="mb-5" action="createregistrationperiod" method="post">
            <label>Đối tượng</label>
            <div class="form-group row">
                <div class="col-6">
                    <select class="custom-select" name="role" id="">
                        <option value="sinhvien" selected>Sinh viên</option>
                        <option value="giangvien">Giảng viên</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-6">
                    <label>Chọn ngày bắt đầu</label>
                    <input
                        class="form-control"
                        type="date"
                        name="startday"
                        value=""
                        required
                    />
                </div>
                <div class="form-group col-6">
                    <label>Chọn ngày kết thúc</label>
                    <input
                        class="form-control"
                        type="date"
                        name="endday"
                        value=""
                        required
                    />
                </div>
            </div>
            <button
                type="submit"
                class="btn btn-primary d-block position-absolute"
                style="right: 16px"
            >
                Tạo đợt đăng ký
            </button>
        </form>
        <div>
            <h5 style="font-weight: bold">Danh sách đợt đăng ký</h5>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Đối tượng</th>
                        <th scope="col">Ngày bắt đầu</th>
                        <th scope="col">Ngày kết thúc</th>
                        <th scope="col">Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach
                        var="regis"
                        items="${registrationPeriodModelList}"
                    >
                        <tr>
                            <td></td>
                            <td>${regis.role}</td>
                            <td>${regis.startday}</td>
                            <td>${regis.endday}</td>
                            <td>
                                <div class="d-flex justify-content-around align-items-center">
                                    <a href="<c:url value="/admin/create-registration/delete?id=${regis.id}"/>">
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
