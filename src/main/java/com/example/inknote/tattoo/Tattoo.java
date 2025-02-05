package com.example.inknote.tattoo;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Table(name = "tattoo")
@Entity(name = "tattoo")
@NoArgsConstructor
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
        this.title = data.tittle();
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
}