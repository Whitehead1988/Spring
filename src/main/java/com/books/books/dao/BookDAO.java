package com.books.books.dao;

import com.books.books.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookDAO {
  int insertBook(UUID id, Book book);

  default  int insertBook(Book book){
    UUID id = UUID.randomUUID();
    return insertBook(id, book);
  }

  List<Book> selectAllBooks();

  Optional<Book> selectBookByID(UUID id);

  int deleteBook(UUID id);

  int updateBook(UUID id, Book book);
}
