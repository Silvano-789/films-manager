package br.com.films.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.films.api.dto.DataDTO;
import br.com.films.api.model.Book;
import br.com.films.api.model.Film;
import br.com.films.api.service.ConsummerBookService;
import br.com.films.api.service.FilmService;

@RestController
@RequestMapping("/api/films")
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired 
	private ConsummerBookService consummerBookService;

	@PostMapping(value = "/save")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Film saveFilm (@RequestBody Film film) {
		return filmService.saveFilm(film); 
	}
	
	@GetMapping(value = "/list")
	public DataDTO listFilm (@RequestParam String title) {
		
		DataDTO bookRegister = new DataDTO();
		
		bookRegister.setListBooks(consummerBookService.FindBookByTitle(title));
		bookRegister.setListFilms(filmService.findByTitle(title));
		
		return bookRegister;
		
	}
}
