package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.Movie;
import com.simplilearn.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@PostMapping("/movies")
	// @RequestMapping(name="/movies", method=RequestMethod.POST)
	private int saveMovie(@RequestBody Movie movie) {
		movieService.saveMovie(movie);
		return movie.getId();
	}
	
	@GetMapping("/movies")
	private List<Movie> getMovies() {
		return movieService.listMovies();
	}
	
	@DeleteMapping("/movie/{id}")
	private void deleteMove(@PathVariable("id") int id) {
		movieService.delete(id);
	}

}
