package com.books.books.dao;

import com.books.books.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class BookDataAccessService implements BookDAO
{
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public BookDataAccessService(JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertBook(UUID id, Book book)
  {
    return 0;
  }

  @Override
  public List<Book> selectAllBooks()
  {
    final String sql = "SELECT id, name FROM books";
    return jdbcTemplate.query(sql, (resultSet, i) -> new Book(
            UUID.fromString(resultSet.getString("id")),
            resultSet.getString("name")
    ));
  }

  @Override
  public Optional<Book> selectBookByID(UUID id)
  {
    final String sql = "SELECT id, name FROM books WHERE id = ?";
    Book book =  jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> new Book(
            UUID.fromString(resultSet.getString("id")),
            resultSet.getString("name")
    ));
    return Optional.ofNullable(book);
  }

  @Override
  public int deleteBook(UUID id)
  {
    return 0;
  }

  @Override
  public int updateBook(UUID id, Book book)
  {
    return 0;
  }
}
