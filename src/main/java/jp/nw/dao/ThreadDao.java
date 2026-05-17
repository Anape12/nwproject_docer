package jp.nw.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.nw.dto.ThreadCommentDto;
import jp.nw.dto.ThreadDto;
import jp.nw.parts.DBBase;

public class ThreadDao extends DBBase {

        public List<ThreadDto> findAll() {

                List<ThreadDto> list = new ArrayList<>();

                String sql = "SELECT thread_id, title, author_id, thread_content " +
                                "FROM thread_info " +
                                "ORDER BY thread_id DESC";

                try {

                        PreparedStatement ps = getConnection().prepareStatement(sql);

                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {

                                ThreadDto thread = new ThreadDto();

                                thread.setThreadId(
                                                rs.getInt("thread_id"));

                                thread.setTitle(
                                                rs.getString("title"));

                                thread.setAuthorId(
                                                rs.getString("author_id"));

                                thread.setContent(
                                                rs.getString("thread_content"));

                                list.add(thread);
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                }

                return list;
        }

        public ThreadDto findById(int threadId) {

                ThreadDto dto = null;

                String sql = "SELECT * FROM thread_info WHERE thread_id = ?";

                try {

                        PreparedStatement ps = getConnection().prepareStatement(sql);

                        ps.setInt(1, threadId);

                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {

                                dto = new ThreadDto();

                                dto.setThreadId(
                                                rs.getInt("thread_id"));

                                dto.setTitle(
                                                rs.getString("title"));

                                dto.setAuthorId(
                                                rs.getString("author_id"));

                                dto.setThreadContent(
                                                rs.getString("thread_content"));
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                }

                return dto;
        }

        public List<ThreadCommentDto> findComments(int threadId) {

                List<ThreadCommentDto> list = new ArrayList<>();

                String sql = "SELECT * FROM thread_comment " +
                                "WHERE thread_id = ? " +
                                "ORDER BY created_at";

                try {

                        PreparedStatement ps = getConnection().prepareStatement(sql);

                        ps.setInt(1, threadId);

                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {
                                ThreadCommentDto dto = new ThreadCommentDto();

                                dto.setCommentId(
                                                rs.getInt("comment_id"));

                                dto.setThreadId(
                                                rs.getInt("thread_id"));

                                dto.setAuthorId(
                                                rs.getString("author_id"));

                                dto.setCommentText(
                                                rs.getString("comment_text"));

                                dto.setCreatedAt(
                                                rs.getTimestamp("created_at"));

                                list.add(dto);
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                }

                return list;
        }

        public void insertComment(
                        ThreadCommentDto dto) {

                String sql = "INSERT INTO thread_comment " +
                                "(thread_id, author_id, comment_text) " +
                                "VALUES (?, ?, ?)";

                try {

                        PreparedStatement ps = getConnection().prepareStatement(sql);

                        ps.setInt(1,
                                        dto.getThreadId());

                        ps.setString(2,
                                        dto.getAuthorId());

                        ps.setString(3,
                                        dto.getCommentText());

                        ps.executeUpdate();

                } catch (Exception e) {

                        e.printStackTrace();
                }
        }
}