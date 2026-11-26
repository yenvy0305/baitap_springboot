<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<title>Danh sách danh mục</title>
<h1>Danh sách danh mục</h1>
<p><a href="/admin/categories/add">Thêm danh mục</a></p>
<c:if test="${not empty message}"><p class="message">${message}</p></c:if>

<form action="/admin/categories/searchpaginated" method="get">
    <label for="name">Từ khóa:</label>
    <input type="text" name="name" id="name" value="${name}" placeholder="Nhập tên danh mục cần tìm">
    <input type="hidden" name="page" value="1">
    <input type="hidden" name="size" value="${categoryPage.size}">
    <button type="submit">Tìm kiếm</button>
</form>

<c:if test="${!categoryPage.hasContent()}"><p>Không có danh mục.</p></c:if>
<c:if test="${categoryPage.hasContent()}">
    <table>
        <thead><tr><th>STT</th><th>Hình ảnh</th><th>Tên danh mục</th><th>Trạng thái</th><th>Thao tác</th></tr></thead>
        <tbody>
        <c:forEach items="${categoryPage.content}" var="cate" varStatus="stt">
            <tr>
                <td>${categoryPage.number * categoryPage.size + stt.index + 1}</td>
                <td><c:out value="${cate.images}" /></td>
                <td><c:out value="${cate.name}" /></td>
                <td><c:choose><c:when test="${cate.status}">Đang hoạt động</c:when><c:otherwise>Ngừng hoạt động</c:otherwise></c:choose></td>
                <td>
                    <a href="/admin/categories/edit/${cate.id}">Sửa</a>
                    <form action="/admin/categories/delete/${cate.id}" method="post" style="display:inline">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <button type="submit" onclick="return confirm('Bạn muốn xóa danh mục này?')">Xóa</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<form action="/admin/categories/searchpaginated" method="get">
    <input type="hidden" name="name" value="${name}">
    <input type="hidden" name="page" value="1">
    <label for="size">Số dòng mỗi trang:</label>
    <select name="size" id="size" onchange="this.form.submit()">
        <option value="3" ${categoryPage.size == 3 ? 'selected' : ''}>3</option>
        <option value="5" ${categoryPage.size == 5 ? 'selected' : ''}>5</option>
        <option value="10" ${categoryPage.size == 10 ? 'selected' : ''}>10</option>
        <option value="15" ${categoryPage.size == 15 ? 'selected' : ''}>15</option>
        <option value="20" ${categoryPage.size == 20 ? 'selected' : ''}>20</option>
    </select>
</form>

<c:if test="${categoryPage.totalPages > 1}">
    <ul class="pages">
        <c:forEach items="${pageNumbers}" var="pageNumber">
            <li class="${pageNumber == categoryPage.number + 1 ? 'active' : ''}">
                <c:url value="/admin/categories/searchpaginated" var="pageUrl">
                    <c:param name="name" value="${name}" />
                    <c:param name="size" value="${categoryPage.size}" />
                    <c:param name="page" value="${pageNumber}" />
                </c:url>
                <a href="${pageUrl}">${pageNumber}</a>
            </li>
        </c:forEach>
    </ul>
</c:if>
