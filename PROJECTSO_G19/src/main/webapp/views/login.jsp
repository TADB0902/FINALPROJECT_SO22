<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
</head>
<body>
    <aside>
        <div style="padding: 20px 50px 50px 50px">
            <div class="signin-form">
                <h2 class="form-title">Đăng nhập</h2>
                <form method="post" class="register-form" id="login-form">
                    <div class="form-group">
                        <label>Tài khoản</label>
                        <input
                            type="text" class="form-control" placeholder="Tài khoản của bạn"
                            required name="username" value="">
                    </div>
                    <div class="form-group">
                        <label>Mật khẩu</label>
                        <input type="password"
                               class="form-control"
                               placeholder="Mật khẩu của bạn"
                               required name="password" v	alue="">
                    </div>
                    <div class="form-group">
                        <label>
                            <iconify-icon icon="material-symbols:work"></iconify-icon>
                            Chức vụ</label> <br>
                        <label><input type="radio" name="role" value="sinhvien" required> Sinh viên</label>
                        <label><input type="radio" name="role" value="giangvien" required> Giảng viên</label>
                        <label><input type="radio" name="role" value="truongbomon" required> Trưởng bộ môn</label>
                        <label><input type="radio" name="role" value="admin" required> Admin</label>
                    </div>
                    <!-- Nút nộp -->
                    <div class="form-group">
                        <button class="btn btn-success" formaction="<c:url value="/login"/> ">Đăng nhập</button>
                        <button style="padding-left: 20px; padding-right: 20px;"
                                class="btn btn-danger" onclick="Back(event)">Hủy
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </aside>
<script>
    function Back(e) {
        e.preventDefault();
        history.go(-1);
    }
</script>
</body>
</html>