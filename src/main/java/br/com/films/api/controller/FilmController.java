package br.com.films.api.controller;

import java.util.Iterator;
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
import br.com.films.api.model.Film;
import br.com.films.api.service.ConsummerBooksService;
import br.com.films.api.service.FilmService;

@RestController
@RequestMapping("/api/films")
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private ConsummerBooksService consummerBooksService;

	@PostMapping(value = "/save")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Film saveFilm (@RequestBody Film film) {
		return filmService.saveFilm(film); 
	}
	
	@GetMapping(value = "/list")
	public DataDTO listFilm (@RequestParam String title) {
	    
		DataDTO dto = new DataDTO();
		
		dto.setListBooks(consummerBooksService.FindBookByTitle(title));
		dto.setListFilms(filmService.findByTitle(title));
		
		return dto;	
	}
}
