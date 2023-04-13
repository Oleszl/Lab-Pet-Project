package com.excellentbook.excellentbook.dto.book;

import com.excellentbook.excellentbook.dto.author.AuthorDto;
import com.excellentbook.excellentbook.dto.category.CategoryDto;
import com.excellentbook.excellentbook.dto.tag.TagDto;
import com.excellentbook.excellentbook.dto.user.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class BookDtoResponse {
    private Long id;
    private String name;
    private String description;
    private AuthorDto author;
    private CategoryDto category;
    @JsonProperty("photo_url")
    private String photoUrl;
    private String status; //active
    private Set<TagDto> tags;
    private UserDto owner;
//    private Set<User> users;
}
