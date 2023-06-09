package com.excellentbook.excellentbook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@SuperBuilder
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "books", callSuper = true)
public class Tag extends BaseEntity {
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "tags")
    private Set<Book> books;
}
