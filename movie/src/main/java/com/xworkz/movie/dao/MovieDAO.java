package com.xworkz.movie.dao;

import java.util.List;

import com.xworkz.movie.dto.MovieDTO;

public interface MovieDAO {

	public void save(MovieDTO movieDTO);

	public MovieDTO getMovieName(int id);

	public void updateRatingByName(int id, String name, int rating);

	public void deleteByName(int id, String name);

	public List<MovieDTO> getAllMovies();

	public MovieDTO getMovieByMovieId(int id);

	public String getMovieLanguageByMovieName(String movieName);

	public Object[] getNameAndRatingByLanguage(String language);

	public List<Object[]> getNameAndRatingByLanguage();
	
	public int updateLanguageByName(String language, String name);
	
	public int updateRatingByName(int rating, String name);
	
	public int deleteMovieByLanguage(String language);

}
