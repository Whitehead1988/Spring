package com.books.books.service;

import com.books.books.dao.BookDAO;
import com.books.books.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService
{
  private final BookDAO booksDAO;

  @Autowired
  public BookService(@Qualifier("postgres") BookDAO booksDAO) {
    this.booksDAO = booksDAO;
  }

  public int addBook(Book book){
    return booksDAO.insertBook(book);
  }

  public List<Book> getAllBooks(){
    return booksDAO.selectAllBooks();
  }

  public Optional<Book> getBookById(UUID id){
    return booksDAO.selectBookByID(id);
  }

  public int deleteBook(UUID id){
    return booksDAO.deleteBook(id);
  }

  public int updateBook(UUID id, Book newBook){
    return booksDAO.updateBook(id, newBook);
  }
}
