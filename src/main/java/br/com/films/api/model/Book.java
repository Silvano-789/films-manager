package br.com.films.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book extends BaseFilm {

	private Long id;
	
	private String title;

	private String author;

	private String country;

	private String releaseDate;

	private String publisher;

    private String type;
}
