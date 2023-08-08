package com.fabianpalma.eventos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabianpalma.eventos.models.Comment;
import com.fabianpalma.eventos.models.Event;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
	
	List<Comment> findByEvent(Event event);
}
