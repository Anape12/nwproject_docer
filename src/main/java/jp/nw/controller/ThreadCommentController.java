package jp.nw.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import jp.nw.dao.ThreadDao;
import jp.nw.dto.ThreadCommentDto;

@WebServlet("/ThreadCommentController")
public class ThreadCommentController
                extends HttpServlet {

        protected void doPost(
                        HttpServletRequest request,
                        HttpServletResponse response)
                        throws ServletException, IOException {

                request.setCharacterEncoding("UTF-8");

                int threadId = Integer.parseInt(
                                request.getParameter(
                                                "threadId"));

                String commentText = request.getParameter(
                                "commentText");

                ThreadCommentDto dto = new ThreadCommentDto();

                dto.setThreadId(threadId);

                dto.setCommentText(commentText);

                // ログインユーザーのセット
                HttpSession session = request.getSession();
                String loginUserId = (String) session.getAttribute(
                                "loginUserId");
                dto.setAuthorId(loginUserId);
                request.setAttribute(
                                "loginUserId",
                                loginUserId);

                ThreadDao dao = new ThreadDao();

                dao.insertComment(dto);

                response.sendRedirect(
                                "ThreadDetailController?id="
                                                + threadId);
        }
}
