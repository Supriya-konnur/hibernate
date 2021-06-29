package com.xworkz.movie.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="movie")
@NamedQueries({
	@NamedQuery(name="getAllMovies", query="select dto from MovieDTO dto"),
	@NamedQuery(name="getMovieByMovieId", query="select dto from MovieDTO dto where dto.movieId=:mid"),
	@NamedQuery(name="getMovieLanguageByMovieName", query="select dto.language from MovieDTO  dto where dto.movieName=:mName"),
	@NamedQuery(name="getNameAndRatingByLanguage", query="select dto.movieName, dto.movieRating from MovieDTO dto where dto.language=:lg"),
	@NamedQuery(name="getNameAndRatingByLanguage", query="select dto.movieName, dto.movieRating from MovieDTO dto"),
	@NamedQuery(name="updateLanguageByName", query="update MovieDTO dto set dto.language=:lg where dto.movieName=:mname"),
	@NamedQuery(name="updateRatingByName", query="update MovieDTO dto set dto.movieRating=:rt where dto.movieName=:nm"),
	@NamedQuery(name="deleteMovieByLanguage", query="delete dto from MovieDTO dto where dto.language=:lg")
})
public class MovieDTO implements Serializable{

	@Id
	@GenericGenerator(name="auto" , strategy = "increment")
	@GeneratedValue(generator = "auto")
	
	@Column(name="movie_id")
	private int movieId;
	
	@Column(name="movie_name")
	private String movieName;
	 
	@Column(name="language")
	private String language;
	
	@Column(name="movie_rating")
	private int movieRating;
	
	@Column(name="release_date")
	private int releaseDate;
	
	public MovieDTO() {
		// TODO Auto-generated constructor stub
	}

	
	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

	public int getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "MovieDTO [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language
				+ ", movieRating=" + movieRating + ", releaseDate=" + releaseDate + "]";
	}
	
}
