package com.sphinx.korigin.study.board.service;

import java.util.List;

import com.sphinx.korigin.study.board.domain.Comment;

public interface CommentService {
	public void createComment(Comment comment);

	public List<Comment> findAllComment();

	public void removeComment(String num);

	public List<Comment> findCommentsByCategory(String category);
}
