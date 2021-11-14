package br.com.films.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

	private String title;

	private String author;

	private String country;

	private String releaseDate;

	private String publisher;

    private String type;
}
