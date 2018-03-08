package com.sphinx.korigin.study.board.dao;

import java.util.List;

import com.sphinx.korigin.study.board.domain.Comment;

public interface CommentDao {
	
	List<Comment> selectAllComment();

	List<Comment> selectCommentByCategory(String category);

	void insertComments(Comment comment);

	void deleteComment(String num);

}
