package com.example.inknote.tattoo;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Table(name = "tattoo")
@Entity(name = "tattoo")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")


public class Tattoo {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tittle")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private Integer price;

    public Tattoo(TattooRequestDTO data) {
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
    }

    public Tattoo(){

    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}