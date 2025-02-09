package com.example.inknote.tattoo;

public class TattooService {

      public Tattoo updateTattoo(Tattoo tattoo, TattooUpdateDTO data) {
        if (!data.title().isBlank()){
            tattoo.setTitle(data.title());
        }
        if (!data.image().isBlank()){
            tattoo.setImage(data.image());
        }
        if (data.price() != null){
            tattoo.setPrice(tattoo.getPrice());
        }

        return tattoo;
    }
}
