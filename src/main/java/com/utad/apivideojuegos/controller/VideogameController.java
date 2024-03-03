package com.utad.apivideojuegos.controller;

import com.utad.apivideojuegos.model.Videogame;
import com.utad.apivideojuegos.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/videogames")
public class VideogameController {

    private final VideogameService videogameService;

    @Autowired
    public VideogameController(VideogameService videogameService) {

        this.videogameService = videogameService;
    }

    @PostMapping
    public ResponseEntity<Videogame> save(@RequestBody Videogame videogame){
        Videogame videogameNew = videogameService.saveOrUpdate(videogame);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(videogameNew);
    }

    @GetMapping
    public ResponseEntity<List<Videogame>> getAll(){
        List<Videogame> videogames = videogameService.getVideojuegos();
        return ResponseEntity.ok(videogames);
    }

    @GetMapping("/{idVideogame}")
    public ResponseEntity<Optional<Videogame>> getById(@PathVariable Long idVideogame){
        Optional<Videogame> videogame = videogameService.getVideojuego(idVideogame);

        if (videogame.isPresent()){
            return ResponseEntity.ok(videogame);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<Videogame>> searchVideogameName(@RequestParam String name){
        List<Videogame> videogames = videogameService.getVideojuego(name);
        return ResponseEntity.ok(videogames);
    }

    @GetMapping("/searchByYear")
    public ResponseEntity<List<Videogame>> searchVideogameYear(@RequestParam int year){
        List<Videogame> videogames = videogameService.getVideojuegosByYear(year);
        return ResponseEntity.ok(videogames);
    }

    @GetMapping("/searchByCompany")
    public ResponseEntity<List<Videogame>> searchVideogameCompany(@RequestParam String company){
        List<Videogame> videogames = videogameService.getVideojuegosByCompany(company);
        return ResponseEntity.ok(videogames);
    }

    @GetMapping("/searchByPeriod")
    public ResponseEntity<List<Videogame>> searchVideogamePeriod(@RequestParam int initialYear, @RequestParam int lastYear){
        List<Videogame> videogames = videogameService.getVideojuegosBetweenYears(initialYear, lastYear);
        return ResponseEntity.ok(videogames);
    }

    @PutMapping("/{idVideogame}")
    public ResponseEntity<Videogame> updateVideogame (@PathVariable Long idVideogame, @RequestBody Videogame videogame) {
        videogame.setId(idVideogame);
        videogameService.saveOrUpdate(videogame);
        return ResponseEntity.ok(videogame);
    }

    @DeleteMapping("/{idVideogame}")
    public ResponseEntity<Optional<Videogame>> deleteVideogame (@PathVariable Long idVideogame){
        videogameService.deleteVideojuego(idVideogame);
        return ResponseEntity.ok().build();
    }




}
