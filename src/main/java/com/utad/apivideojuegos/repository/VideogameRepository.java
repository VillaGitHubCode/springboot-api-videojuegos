package com.utad.apivideojuegos.repository;

import com.utad.apivideojuegos.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideogameRepository extends JpaRepository <Videogame, Long> {

    List<Videogame> findByNameContainingIgnoreCase(String name);

    List<Videogame> findByYear(int year);

    List<Videogame> findByCompanyContainingIgnoreCase(String company);

    List<Videogame> findByYearBetweenOrderByYearAsc(int initialYear, int LastYear);



}
