package com.sphinx.korigin.study.board.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.study.board.domain.Comment;
@Repository("CommentDao")
public class CommentDaoImpl extends AbstractDaoJdbc implements CommentDao{

	
	public List<Comment> selectAllComment() {
		String sql = "SELECT * FROM comment Order by num desc";

		return jdbcTemplate.query(sql, new RowMapper<Comment>() {

			@Override
			public Comment mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Comment comment = new Comment();
				comment.setNum(rs.getInt("num"));
				comment.setRef(rs.getInt("ref"));
				comment.setNickname(rs.getString("nickname"));
				comment.setContent(rs.getString("content"));
				comment.setWritedate(rs.getTimestamp("writedate"));
				comment.setCategory(rs.getString("category"));
				return comment;
			}
		});
	}

	public List<Comment> selectCommentByCategory(String category) {
		String sql = "SELECT * FROM comment WHERE category = ?"
				+ " Order by num desc";

		return jdbcTemplate.query(sql, new RowMapper<Comment>() {

			@Override
			public Comment mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Comment comment = new Comment();
				comment.setNum(rs.getInt("num"));
				comment.setRef(rs.getInt("ref"));
				comment.setNickname(rs.getString("nickname"));
				comment.setContent(rs.getString("content"));
				comment.setWritedate(rs.getTimestamp("writedate"));
				comment.setCategory(rs.getString("category"));
				return comment;
			}
		}, category);
	}

	public void insertComments(Comment comment) {
		String sql = "INSERT INTO comment(nickname, content, writedate,"
				+ " category, ref) values(?, ?, ?, ?, ?)";

		jdbcTemplate.update(sql,
				new Object[] { comment.getNickname(), comment.getContent(),
						new Date(comment.getWritedate().getTime()),
						comment.getCategory(), comment.getRef() });
	}

	public void deleteComment(String num) {
		String sql = "delete from comment where num = ?";
		jdbcTemplate.update(sql, new Object[] { num });
	}
	
}
