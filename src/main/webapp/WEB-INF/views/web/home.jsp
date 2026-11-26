<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<title>Trang chủ</title>
<h1>Ứng dụng quản lý danh mục</h1>
<c:choose>
    <c:when test="${pageContext.request.userPrincipal != null}">
        <p>Xin chào, ${pageContext.request.userPrincipal.name}.</p>
        <p><a href="/admin/categories">Tìm kiếm và quản lý danh mục</a></p>
        <form action="/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button type="submit">Đăng xuất</button>
        </form>
    </c:when>
    <c:otherwise>
        <p><a href="/login">Đăng nhập</a> hoặc <a href="/register">Đăng ký tài khoản</a>.</p>
    </c:otherwise>
</c:choose>
