package com.example.inknote.controller;

import com.example.inknote.tattoo.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Tattoo")
public class InkNoteController {

    @Autowired
    private TattooRepository repository;

    private final TattooService service = new TattooService();

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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping
    @Transactional
    public void updateTattoo(@RequestBody TattooUpdateDTO data){
        Tattoo tattooData = repository.getReferenceById(data.id());
        if (tattooData == null) {
            System.out.println("sem objeto no banco de dados");
            return;
        }
        Tattoo updateTattoo = service.updateTattoo(tattooData, data);
        repository.save(updateTattoo);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteTattoo(@PathVariable Long id){
        Tattoo tattooData = repository.getReferenceById(id);

        repository.delete(tattooData);
    }
}
