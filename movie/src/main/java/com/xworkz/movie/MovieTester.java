package com.xworkz.movie;

import java.util.List;

import com.xworkz.movie.dto.MovieDTO;
import com.xworkz.movie.service.MovieService;
import com.xworkz.movie.service.MovieServiceImpl;

public class MovieTester {

	public static void main(String[] args) {

		MovieDTO dto = new MovieDTO();
		dto.setMovieName("Roberrt");
		dto.setLanguage("telugu");
		dto.setMovieRating(4);
		dto.setReleaseDate(2021);

		MovieService service = new MovieServiceImpl();
//		service.valideAndSave(dto);
		
//		MovieDTO dto1 = service.validateAndGetById(3);
//		System.out.println(dto1);
		
//		service.validateAndUpdateRatingByName(4, "Ala Vaikunthapurramuloo", 4);
//		service.validateAndDelete(2, "Roberrt");
		
//		List<MovieDTO> dtos = service.getAllMovies();
//		dtos.forEach(System.out::println);
		
		
//		MovieDTO movieDTOFromDB = service.getMovieByMovieId(4);
//		System.out.println(movieDTOFromDB);
		
//		String language = service.getMovieLanguageByMovieName("KGF");
//		System.out.println(language);
		
		Object[] object = service.getNameAndRatingByLanguage("English");
		for (Object object2 : object) {
			System.out.println(object2);
		}
		
		
	}

}
