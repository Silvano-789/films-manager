package br.com.films.api.service;

import java.util.List;

import br.com.films.api.model.Film;

public interface FilmService {

	Film saveFilm (Film film);
	
	/*It changes a register on database*/
	void updateFilm (Long id ,Film film);
	
	/*It deletes a register on database*/
	void deleteFilm (Long id);
	
	/*It find all registers from database*/
	List<Film> listAllFilms();
	
	/*It lists films by title*/
	List<Film> findFilmByTitle (String title);
}
