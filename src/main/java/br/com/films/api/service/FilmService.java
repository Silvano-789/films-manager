package br.com.films.api.service;

import java.util.List;

import br.com.films.api.model.Film;

public interface FilmService {

	Film saveFilm (Film film);
	
	/*It changes a register on database*/
	void updateBook (Long id ,Film film);
	
	/*It deletes a register on database*/
	void deleteFilm (Long id);
	
	/*It lists films by title*/
	List<Film> findByTitle (String title);
}
