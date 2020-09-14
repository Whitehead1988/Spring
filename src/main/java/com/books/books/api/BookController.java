package com.books.books.api;

import com.books.books.model.Book;
import com.books.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/book")
@RestController
public class BookController {

  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService)
  {
    this.bookService = bookService;
  }

  @PostMapping
  public void addBook(@RequestBody Book book){
    bookService.addBook(book);
  }

  @GetMapping
  public List<Book> getAllBooks(){
    return bookService.getAllBooks();
  }

  @GetMapping(path = "{id}")
  public Book getBookByID(@PathVariable("id") UUID id){
    return bookService.getBookById(id).orElse(null);
  }

  @DeleteMapping(path = "{id}")
  public void deleteBookById(@PathVariable UUID id){
    bookService.deleteBook(id);
  }

  @PutMapping(path = "{id}")
  public void updateBook(@PathVariable("id") UUID id,
                         @Validated @RequestBody Book book) {
    bookService.updateBook(id, book);
  }

  }
