<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <c:set var = "check" scope = "session" value = "${action}"/>
    <h5 class="form-title" style="font-weight: bold">Tạo tài khoản</h5>
    <form <c:if test = "${check == 'create'}"> action="create" method="post"</c:if>
            <c:if test = "${check == 'update'}"> action="../account/update" method="post" </c:if>>
        <div class="row">
            <div class="form-group col-6">
                <label>Tài khoản</label>
                <input id="a" type="text" class="form-control" placeholder="Tên tài khoản" required name="username" value="<c:if test = "${check == 'update'}">${user.username}</c:if>" <c:if test = "${check == 'update'}">readonly</c:if>>
            </div>
            <div class="form-group col-6">
                <label>Mật khẩu</label>
                <input id="b" type="text" class="form-control" placeholder="Mật khẩu" required name="password" value="<c:if test = "${check == 'update'}">${user.password}</c:if>">
            </div>
            <div class="form-group col-6">
                <label>Họ tên</label>
                <input id="name" type="text" class="form-control" placeholder="Tên của bạn" required name="fullname" value="<c:if test = "${check == 'update'}">${user.fullname}</c:if>">
            </div>
            <div class="form-group col-6">
                <label>Giới tính:</label> <br>
                <c:if test = "${check == 'create'}">
                <label><input type="radio" value="Nam" name="male" checked> Nam</label>
                <label><input type="radio" name="male" value="Nu"> Nữ</label>
                </c:if>
                <c:if test = "${check == 'update'}">
                <c:set var = "male" scope = "session" value = "${user.male}"/>
                <label><input type="radio" value="Nam" name="male" <c:if  test="${male =='Nam'}">checked</c:if>> Nam</label>
                <label><input type="radio" name="male" value="Nu" <c:if  test="${male !='Nam'}">checked</c:if>> Nữ</label>
                </c:if>
            </div>
            <div class="form-group col-12">
                <label>Email</label>
                <input type="email" class="form-control" placeholder="Email của bạn" required name="email" value="<c:if test = "${check == 'update'}">${user.email}</c:if>">
            </div>
            <div class="form-group col-12">
                <label>Ngày sinh</label>
                <input id="dob" type="date" class="form-control" placeholder="Ngày sinh của bạn" required name="birthday" value="<c:if test = "${check == 'update'}">${date1}</c:if>">
            </div>
            <div class="form-group col-6">
                <label>Địa chỉ</label>
                <input type="tel" class="form-control" placeholder="Địa chỉ hiện tại" required name="address" value="<c:if test = "${check == 'update'}">${user.address}</c:if>">
            </div>
            <div class="form-group col-6">
                <label>SĐT</label>
                <input type="tel" class="form-control" placeholder="Số điện thoại" required name="phone" value="<c:if test = "${check == 'update'}">${user.phone}</c:if>">
            </div>
            <div class="col">
                <label>Năm hoạt động</label> <input type="text"
                                                    class="form-control" placeholder="Năm vào trường" required
                                                    name="schoolyear" value="<c:if test = "${check == 'update'}">${user.schoolyear}</c:if>">
            </div>
            <div class="col">
                <label>Khoa</label>
                <c:set var = "checkDepartments" scope = "session" value = "${user.department}"/>
                <select id="departments" class="form-control" name="department">
                    <option value="Công nghệ thông tin" <c:if test = "${check == 'update' and checkDepartments =='Công nghệ thông tin'}"> selected</c:if>>Công nghệ thông tin</option>
                <option value="Kinh tế" <c:if test = "${check == 'update' and checkDepartments =='Kinh tế'}"> selected</c:if>>Kinh tế</option>
                <option value="Xây dựng" <c:if test = "${check == 'update' and checkDepartments =='Xây dựng'}"> selected</c:if>>Xây dựng</option>
                </select>
            </div>
            <div class="form-group col-12">
                <c:set var = "checkrole" scope = "session" value = "${user.role}"/>
                <label> Chức vụ</label> <br>
                <label><input type="radio" value="sinhvien" name="role" <c:if test = "${check == 'update' and checkrole =='sinhvien'}"> checked</c:if>>Sinh viên</label>
                <label><input type="radio" name="role" value="giangvien" <c:if test = "${check == 'update' and checkrole =='giangvien'}"> checked</c:if>> Giảng viên</label>
                <label><input type="radio" name="role" value="truongbomon" <c:if test = "${check == 'update' and checkrole =='truongbomon'}"> checked</c:if>> Trưởng bộ môn</label>
                <label><input type="radio" name="role" value="admin" <c:if test = "${check == 'update' and checkrole =='admin'}"> checked</c:if>> Admin</label>
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
    <h5 style="font-weight: bold">Danh sách tài khoản</h5>
    <table class="table">
        <thead>
        <tr>
            <th>Tài khoản</th>
            <th>Mật khẩu</th>
            <th>Họ tên</th>
            <th>Khoa</th>
            <th>Ngày sinh</th>
            <th>Giới tính</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userModelList}">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.fullname}</td>
            <td>${user.department}</td>
            <td>${user.birthday}</td>
            <td>${user.male}</td>
            <td>
                <div class="d-flex justify-content-around align-items-center">
                    <a href="http://localhost:8080/ProjectCNPM_war/admin/account/update?id=${user.username}">
                        <i class="fa-solid fa-pen-to-square"></i>
                    </a>
                    <a href="http://localhost:8080/ProjectCNPM_war/admin/account/delete?id=${user.username}">
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
