package com.fabianpalma.eventos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fabianpalma.eventos.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{

	List<Event> findAll();

	List<Event> findByState(String state);
	
	@Query("SELECT e.name, e.date, e.location, u.firstName, e.host, e.id, " +
		       "CASE WHEN u.id = :userId THEN true " +
		       "ELSE EXISTS (SELECT 1 FROM Confirmation c WHERE c.event.id = e.id AND c.user.id = :userId) " +
		       "END AS joined " +
		       "FROM Event e JOIN e.host u " +
		       "WHERE e.state = :state")
	List<Object[]> getByStateWithJoinStatusForUser(@Param("state") String state, @Param("userId") Long userId);

	@Query("SELECT e.name, e.date, e.location, e.state, e.host, e.id " +
		       "FROM Event e JOIN e.host u " +
		       "WHERE e.state != :state AND NOT EXISTS (SELECT 1 FROM Confirmation c WHERE c.event.id = e.id AND c.user.id = :userId)")
	List<Object[]> getEventsWithDifferentStateForUser(@Param("state") String state, @Param("userId") Long userId);

	

	
}
