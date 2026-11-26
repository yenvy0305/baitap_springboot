<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sitemesh" uri="http://www.sitemesh.org/sitemesh3" %>
<!doctype html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><sitemesh:write property="title" /></title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; color: #222; background: #f5f7fa; }
        header, footer { background: #17324d; color: white; padding: 1rem 2rem; }
        header a, footer a { color: white; margin-right: 1rem; }
        main { max-width: 1050px; margin: 2rem auto; padding: 1.5rem; background: white; }
        table { width: 100%; border-collapse: collapse; margin-top: 1rem; }
        th, td { border: 1px solid #ccd3da; padding: .6rem; text-align: left; }
        .message { color: #176b35; }
        .error { color: #a12020; }
        input, select, button { padding: .45rem; margin: .2rem 0; }
    </style>
    <sitemesh:write property="head" />
</head>
<body>
<header>
    <a href="/">Trang chủ</a>
    <a href="/admin/categories">Danh mục</a>
</header>
<main><sitemesh:write property="body" /></main>
<footer>Ứng dụng Spring Boot JSP</footer>
</body>
</html>
