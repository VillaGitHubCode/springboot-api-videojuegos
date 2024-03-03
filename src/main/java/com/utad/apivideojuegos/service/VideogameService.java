package com.utad.apivideojuegos.service;

import com.utad.apivideojuegos.model.Videogame;
import com.utad.apivideojuegos.repository.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideogameService {

    @Autowired
    VideogameRepository videojuegoRepository;

    public List<Videogame> getVideojuegos(){
        return videojuegoRepository.findAll();
    }

    public Optional<Videogame> getVideojuego (Long id){
        return videojuegoRepository.findById(id);
    }

    public List<Videogame> getVideojuego (String name){
        return videojuegoRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Videogame> getVideojuegosByYear (int year){
        return videojuegoRepository.findByYear(year);
    }
    public List<Videogame> getVideojuegosByCompany (String company){
        return videojuegoRepository.findByCompanyContainingIgnoreCase(company);
    }
    public List<Videogame> getVideojuegosBetweenYears(int initialYear, int lastYear){
        return videojuegoRepository.findByYearBetweenOrderByYearAsc(initialYear, lastYear);
    }

    public Videogame saveOrUpdate (Videogame videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    public void deleteVideojuego ( Long id ){
        videojuegoRepository.deleteById(id);
    }

}
