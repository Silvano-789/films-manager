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

	@Override
	@Transactional
	public void updateBook(Long id, Film film) {
		filmRepository.findById(id)
					  .map(filmExists -> {
						  film.setId(filmExists.getId());
						  filmRepository.save(film);
						  return film;
					  }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This register don´t exist on database"));
		
	}

	@Override
	public void deleteFilm(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Film> findByTitle(String title) {
		return filmRepository.findByTitle(title);
	}

}
