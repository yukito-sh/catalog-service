package com.yuki.catalogservice.web;

import com.yuki.catalogservice.domain.entity.Book;
import com.yuki.catalogservice.domain.service.BookService;
import java.util.Iterator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public Iterator<Book> get() {
    return bookService.viewBookList();
  }

  @GetMapping("{isbn}")
  public Book getByIsbn(@PathVariable String isbn) {
    return bookService.viewBookDetails(isbn);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Book post(@RequestBody Book book) {
    return bookService.addBookDetails(book);
  }

  @DeleteMapping("{isbn}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable String isbn) {
    bookService.removeBookFromCatalog(isbn);
  }

  @PutMapping("{isbn}")
  public Book put(@PathVariable String isbn, @RequestBody Book book) {
    return bookService.editBookDetails(isbn, book);
  }
}
