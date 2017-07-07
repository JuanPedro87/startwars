package com.example.start.wars.repository;

import com.example.start.wars.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by jpcs1 on 30/06/17.
 */
public interface FilmRepository extends JpaRepository<Film, Long>, CustomFilmRepository{
    List<Film> findAllByOrderByEpisodeIdAsc();
    List<Film> findAllByReleaseDateGreaterThan(Date releaseDate);

    // native query para usar sql
    //sin native query es un lenguage propio de JPA
    @Query(value = "select f from Film f where f.people.size = (select min(f2.people.size) from Film f2)")
    List<Film> findAllByMaxFilm();

    // con parametros
    @Query(value = "select f from Film f where f.people.size = (select max(f2.people.size) from Film f2)")
    List<Film> findAllByMinFilm();

    // tb funciona el predicado: findByNameStartingWith
    @Query("select f from Film f join f.people p where p.name=:name")
    List<Film> findAllByFilmContains(@Param("name") String name);

}
