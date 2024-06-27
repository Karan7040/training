package com.example.bookmanagement.model.bookmgmtdto;
///using DTO for user
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
// todo : is this a dto or an entity?
public class BookMgmtDto {


    @Id
    private Long id;
    private String name;
    private String description;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



