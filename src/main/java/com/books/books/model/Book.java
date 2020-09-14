package com.books.books.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Book
{
  private final UUID id;

  @NotNull
  private final String name;

  public Book(@JsonProperty("id") UUID id,
              @JsonProperty("name") String name)
  {
    this.id = id;
    this.name = name;
  }

}
