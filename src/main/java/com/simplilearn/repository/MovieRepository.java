package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
	List<Movie> findByName(@Param("movieName") String movieName);

	/*
	 * @Query(HQL - JOIN QUERY) 
	 * List<Movie> findByDirectorName();
	 */

}
