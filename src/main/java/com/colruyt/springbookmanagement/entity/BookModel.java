package com.colruyt.springbookmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOK")
// todo: this is an entity.. should suffice with Entity, BookEntity?
public class BookModel {
    @Id
    @Column(name = "ID")
    @NotNull
    private Integer id;

    @Column(name = "Name")
    @NotEmpty
    private String name;

    @Column(name = "Description")
    private String description;
}
