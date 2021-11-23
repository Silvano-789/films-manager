package br.com.films.api.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.films.api.dto.DataDTO;
import br.com.films.api.model.Book;
import br.com.films.api.model.Film;
import br.com.films.api.service.ConsummerBooksService;
import br.com.films.api.service.FilmService;

@RestController
@RequestMapping("/api/films")
public class FilmController {
	
	/*Dependences injects*/
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private ConsummerBooksService consummerBooksService;

	/*Save endpoint*/
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Film saveFilm (@RequestBody Film film) {
		return filmService.saveFilm(film); 
	}
	
	/*Update endpoint*/
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateBook (@PathVariable(name = "id") Long id,  @RequestBody Film film) {
	    filmService.updateFilm(id, film);
	}
	
	/*Delete endpoint*/
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete (@PathVariable(name = "id") Long id) {
		filmService.deleteFilm(id);
	}
	
	/*List all endpoint*/
	@GetMapping
	public List<Film> listAllFilms (String title) {
	      return filmService.listAllFilms();
	}
	
	/*This endpoint is to books-manager API consumes*/
	@GetMapping("/list-films")
	public List<Film> findFilmByTitle (@RequestParam String title) {
	      return filmService.findFilmByTitle(title);
	}
	
	/*List with filter endpoint*/
	@GetMapping("/list")
	public List<DataDTO> listRegisters (@RequestParam String title) {	    	
			  return dataBuilder(title);
	}
	
	/*This method is to build the informations on DataDTO object */
	private List<DataDTO> dataBuilder (String title) {
	
	if(!title.isEmpty()) {
		List<DataDTO> dataCollect = new ArrayList<DataDTO>();
		
		List<Book> listBook = consummerBooksService.FindBookByTitle(title);
		
		for (Book book : listBook) {
			  DataDTO dtoBook = new DataDTO();
			  
			  dtoBook.setTitle(book.getTitle());
			  dtoBook.setAuthor(book.getAuthor());
			  dtoBook.setCountry(book.getCountry());
			  dtoBook.setReleaseDate(book.getReleaseDate());
			  dtoBook.setPublisher(book.getPublisher());
			  dtoBook.setType(book.getType());
			  
			  dataCollect.add(dtoBook);
		}
		
		List<Film> listFilm = filmService.findFilmByTitle(title);
		
		for (Film film : listFilm) {
			 DataDTO dtoFilm = new DataDTO();
			
			dtoFilm.setTitle(film.getTitle());
			dtoFilm.setAuthor(film.getAuthor());
			dtoFilm.setCountry(film.getCountry());
			dtoFilm.setReleaseDate(film.getReleaseDate());
			dtoFilm.setCinematography(film.getCinematography());
			dtoFilm.setType(film.getType());
			
			dataCollect.add(dtoFilm);
		}
		return dataCollect;
		     
	}
	return Collections.emptyList();
  }
	
}
