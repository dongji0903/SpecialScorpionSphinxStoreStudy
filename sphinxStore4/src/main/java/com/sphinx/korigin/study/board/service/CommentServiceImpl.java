package com.sphinx.korigin.study.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.korigin.study.board.dao.CommentDao;
import com.sphinx.korigin.study.board.domain.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public void createComment(Comment comment) {
		commentDao.insertComments(comment);
	}

	@Override
	public List<Comment> findAllComment() {
		return commentDao.selectAllComment();
	}

	@Override
	public void removeComment(String num) {
		commentDao.deleteComment(num);
	}

	@Override
	public List<Comment> findCommentsByCategory(String category) {
		return commentDao.selectCommentByCategory(category);
	}

}
