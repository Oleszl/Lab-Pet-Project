package com.excellentbook.excellentbook.dto.tag;

import com.excellentbook.excellentbook.entity.Book;

import java.util.Set;

public class TagDto {
    private Long id;
    private String name;

    private Set<Book> books;
}