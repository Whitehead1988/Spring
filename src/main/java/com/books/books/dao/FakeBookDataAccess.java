package com.books.books.dao;

import com.books.books.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeBookDataAccess implements BookDAO
{
  private static List<Book> DB = new ArrayList<>();

  @Override
  public int insertBook(UUID id, Book book)
  {
    DB.add(new Book(id, book.getName()));
    return 1;
  }

  @Override
  public List<Book> selectAllBooks()
  {
    return DB;
  }

  @Override
  public Optional<Book> selectBookByID(UUID id)
  {
    return DB.stream().filter(book -> book.getId().equals(id))
            .findFirst();
  }

  @Override
  public int deleteBook(UUID id)
  {
    Optional<Book> bookFound = selectBookByID(id);
    if(!bookFound.isPresent()){
      return 0;
    }
    DB.remove(bookFound.get());
    return 1;
  }

  @Override
  public int updateBook(UUID id, Book book)
  {
    return selectBookByID(id).map(b -> {
      int index = DB.indexOf(b);
      if(index >=0){
        DB.set(index, new Book(id, b.getName()));
        return 1;
      }
      return 0;
    }).orElse(0);
  }
}
