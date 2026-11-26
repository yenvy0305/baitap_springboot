<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<title>Đăng nhập</title>
<h1>Đăng nhập</h1>
<c:if test="${param.error != null}"><p class="error">Tên đăng nhập hoặc mật khẩu không đúng.</p></c:if>
<c:if test="${param.logout != null}"><p class="message">Bạn đã đăng xuất.</p></c:if>
<c:if test="${param.registered != null}"><p class="message">Đăng ký thành công. Hãy đăng nhập.</p></c:if>
<form action="/login" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <p><label>Tên đăng nhập<br><input type="text" name="username" required autofocus></label></p>
    <p><label>Mật khẩu<br><input type="password" name="password" required></label></p>
    <button type="submit">Đăng nhập</button>
</form>
<p>Chưa có tài khoản? <a href="/register">Đăng ký</a></p>
