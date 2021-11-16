package br.com.films.api.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.films.api.model.Book;

@FeignClient(name = "books-manager", url = "http://localhost:8080")
@RequestMapping("/api/books")
public interface ConsummerBooksService {
 
	/* Manager-books´s endpoint */
	@GetMapping(value = "/list-books")
	List<Book> FindBookByTitle(@RequestParam String title);
}
