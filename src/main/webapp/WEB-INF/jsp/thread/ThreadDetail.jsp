<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">

<head>

<meta charset="UTF-8">

<title>スレッド詳細</title>

<link rel="stylesheet"
 href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">

<link
 href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c"
 rel="stylesheet">

<link rel="stylesheet"
 href="${pageContext.request.contextPath}/css/style33.css">

</head>

<body>

<div id="container">

    <h1 class="thread-title">
        ${thread.title}
    </h1>

    <div class="thread-info">

        <p class="thread-author">
            投稿者 :
            ${thread.authorId}
        </p>

        <p class="thread-content">
            ${thread.threadContent}
        </p>

    </div>

    <hr class="section-line">

    <h2 class="section-title">
        コメント一覧
    </h2>

    <div class="comment-area">
        <c:forEach var="comment"
            items="${commentList}">

            <c:choose>
                <c:when test=
                    "${comment.authorId
                        eq loginUserId}">
                    
                    <div class="my-comment">

                        <p class="author">
                            ${comment.authorId}
                        </p>

                        <p class="comment-text">
                            ${comment.commentText}
                        </p>

                        <p class="time">
                            ${comment.createdAt}
                        </p>

                    </div>

                </c:when>

                <c:otherwise>

                    <div class="other-comment">

                        <p class="author">
                            ${comment.authorId}
                        </p>

                        <p class="comment-text">
                            ${comment.commentText}
                        </p>

                        <p class="time">
                            ${comment.createdAt}
                        </p>

                    </div>

                </c:otherwise>

            </c:choose>

        </c:forEach>

    </div>

    <hr class="section-line">

    <h2 class="section-title">
        コメント投稿
    </h2>

    <form action="ThreadCommentController"
          method="post"
          class="comment-form">

        <input type="hidden"
               name="threadId"
               value="${thread.threadId}">

        <textarea
            name="commentText"
            maxlength="500"
            required
            placeholder="コメントを入力してください"></textarea>

        <button type="submit">
            コメント投稿
        </button>

    </form>

</div>

</body>
</html>