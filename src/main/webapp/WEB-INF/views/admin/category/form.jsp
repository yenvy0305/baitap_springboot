<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<title>${category.id == null ? 'Thêm danh mục' : 'Sửa danh mục'}</title>
<h1>${category.id == null ? 'Thêm danh mục' : 'Sửa danh mục'}</h1>
<c:if test="${not empty errorMessage}"><p class="error">${errorMessage}</p></c:if>
<form action="/admin/categories/save" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <c:if test="${category.id != null}"><input type="hidden" name="id" value="${category.id}"></c:if>
    <p><label>Tên danh mục<br><input name="name" value="${category.name}" required maxlength="120"></label></p>
    <p><label>Đường dẫn hình ảnh<br><input name="images" value="${category.images}" maxlength="500"></label></p>
    <p><label><input type="checkbox" name="status" value="true" ${category.status ? 'checked' : ''}> Đang hoạt động</label></p>
    <button type="submit">Lưu</button>
    <a href="/admin/categories">Quay lại</a>
</form>
