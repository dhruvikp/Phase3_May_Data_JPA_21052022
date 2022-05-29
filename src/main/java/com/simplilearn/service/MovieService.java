package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Director;
import com.simplilearn.entity.Movie;
import com.simplilearn.repository.DirectorRepository;
import com.simplilearn.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	DirectorRepository directorRepository;

	public void saveMovie(Movie movie) {
		String directorName = movie.getDirector().getDirectoName();

		Optional<Director> directorOpt = directorRepository.findByDirectoName(directorName);
		if(directorOpt.isPresent()) {
			movie.setDirector(directorOpt.get());
		}
		movieRepository.save(movie);
	}
	
	public List<Movie> getMoviesByDirectorName(String directorName) {
		return movieRepository.findMoviesByDirectoName(directorName);
	}

	public List<Movie> listMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		movieRepository.findAll().forEach(movie -> movies.add(movie));
		return movies;
	}

	public void delete(int id) {
		movieRepository.deleteById(id);
	}

}
