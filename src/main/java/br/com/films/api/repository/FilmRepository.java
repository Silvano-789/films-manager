package br.com.films.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.films.api.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long>{

	@Query("SELECT f FROM Film f WHERE f.title LIKE %:title%")
	List<Film> findByTitle (@Param("title") String title);
}
