package br.com.films.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.films.api.model.Film;
import br.com.films.api.repository.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	@Override
	@Transactional
	public Film saveFilm(Film film) {
		return filmRepository.save(film);
	}

	@Transactional
	public void updateFilm(Long id, Film film) {
		filmRepository.findById(id)
					  .map(filmExists -> {
						  film.setId(filmExists.getId());
						  filmRepository.save(film);
						  return film;
					  }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This register don´t exist on database"));
		
	}

	@Transactional
	public void deleteFilm(Long id) {
		filmRepository.findById(id)
		  .map(filmExists -> {
		  filmRepository.delete(filmExists);
		  return Void.TYPE;
		  }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This register don´t exist on database!"));
		
	}
	
	public List<Film> listAllFilms() {
		return filmRepository.findAll();
	}

	public List<Film> findFilmByTitle(String title) {
		return filmRepository.findByTitle(title);
	}
	

	public Film findFilmById(Long id) {
		return filmRepository.findById(id)
				             .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The register was not found!"));
	}

}
