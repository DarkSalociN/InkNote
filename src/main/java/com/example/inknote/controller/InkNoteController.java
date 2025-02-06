package com.example.inknote.controller;

import com.example.inknote.tattoo.Tattoo;
import com.example.inknote.tattoo.TattooRepository;
import com.example.inknote.tattoo.TattooRequestDTO;
import com.example.inknote.tattoo.TattooResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Tattoo")
public class InkNoteController {

    @Autowired
    private TattooRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveTattoo(@RequestBody TattooRequestDTO data){
        Tattoo tattooData = new Tattoo(data);
        repository.save(tattooData);

    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<TattooResponseDTO> getAll(){

        return repository.findAll().stream().map(TattooResponseDTO::new).toList();
    }
}
