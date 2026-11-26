<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<title>Đăng ký tài khoản</title>
<h1>Đăng ký tài khoản</h1>
<c:if test="${not empty errorMessage}"><p class="error">${errorMessage}</p></c:if>
<form action="/register" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <p><label>Tên đăng nhập<br><input name="username" value="${registerForm.username}" required minlength="3" maxlength="50"></label></p>
    <p><label>Email<br><input type="email" name="email" value="${registerForm.email}" required maxlength="150"></label></p>
    <p><label>Mật khẩu (ít nhất 8 ký tự)<br><input type="password" name="password" required minlength="8" maxlength="72"></label></p>
    <p><label>Nhập lại mật khẩu<br><input type="password" name="confirmPassword" required></label></p>
    <button type="submit">Tạo tài khoản</button>
</form>
<p>Đã có tài khoản? <a href="/login">Đăng nhập</a></p>
