package org.project.java.pizzeria.spring_la_mia_pizzeria_crud.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pizzas")

public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, message = "Name must contain at least 2 characters")
    @NotBlank(message = "The name must not be blank, empty or null")
    private String name;

    @Lob
    @Size(min = 10, max = 2000, message = "Description must contain at least 10 characters and not more than 2000")
    @NotBlank(message = "The description field must not be blank, empty or null")
    private String description;

    @Lob
    @Size(min = 10, max = 1000, message = "Image url must contain at least 10 characters and not more than 1000")
    private String imgUrl;

    @NotNull(message = "Price cannot be null")
    private Double price;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    

}
