<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jp.nw.model.MyCalendar"%>
<%@ taglib prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <title>スレッド一覧</title>
  <link rel="stylesheet"  href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
  <link href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c" rel="stylesheet">
  <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/style33.css">
</head>
<body>
  <c:forEach var="thread" items="${threadList}">
    <div class="thread-card">
        <h2>${thread.title}</h2>

        <p>投稿者: ${thread.authorId}</p>

        <p>${thread.content}</p>

        <a href="ThreadDetailController?id=${thread.threadId}">
            詳細を見る
        </a>
    </div>
</c:forEach>
</body>
