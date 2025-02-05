package com.example.inknote.tattoo;


public record TattooResponseDTO(Long Id, String Title, String Image, Integer Price) {
    public TattooResponseDTO(Tattoo tattoo) {
        this(tattoo.getId(), tattoo.getTitle(), tattoo.getImage(), tattoo.getPrice());
    }

}