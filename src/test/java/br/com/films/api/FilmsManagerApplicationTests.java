package br.com.films.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.films.api.model.Film;
import br.com.films.api.repository.FilmRepository;

@SpringBootTest
class FilmsManagerApplicationTests {

	@Autowired
	FilmRepository filmRepository;
	
	@Test
	public void testSave () {
		Film film = new Film();
		film.setId(1L);
		film.setAuthor("Author");
		film.setCinematography("Test ");
		film.setCountry("Brazil");
		film.setReleaseDate("14 November 1992");
		film.setTitle("Test name film");
		film.setType("film");
		
		filmRepository.save(film);
		
		
	}
	
}
	