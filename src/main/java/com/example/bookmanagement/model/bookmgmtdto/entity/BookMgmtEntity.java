package com.example.bookmanagement.model.bookmgmtdto.entity;

///using ENtity for Mapping the data to database
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookMgmtEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
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
