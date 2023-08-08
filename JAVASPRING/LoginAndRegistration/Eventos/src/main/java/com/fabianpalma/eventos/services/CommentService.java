package com.fabianpalma.eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.eventos.models.Comment;
import com.fabianpalma.eventos.models.Event;
import com.fabianpalma.eventos.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private final CommentRepository commentRepo;
	
	public CommentService(CommentRepository commentRepo) {
		this.commentRepo = commentRepo;
	}
	
	public Comment saveComment(Comment comment) {
		return commentRepo.save(comment);
	}
	
	public List<Comment> findByEvent(Event event) {
        return commentRepo.findByEvent(event);
    }

    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }
}
