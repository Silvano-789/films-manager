package br.com.films.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseFilm {

    @JsonInclude(value = Include.NON_NULL)
	private String publisher;
    @JsonInclude(value = Include.NON_NULL)
    private String cinematography;
}
