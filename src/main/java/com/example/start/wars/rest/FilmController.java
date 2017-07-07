package com.example.start.wars.rest;

import com.example.start.wars.model.Film;
import com.example.start.wars.model.Planet;
import com.example.start.wars.usecase.film.FindFilmById;
import com.example.start.wars.usecase.film.GetAllFilms;
import com.example.start.wars.usecase.planet.DeletePlanetById;
import com.example.start.wars.usecase.planet.FindPlanetById;
import com.example.start.wars.usecase.planet.GetAllPlanets;
import com.example.start.wars.usecase.planet.SavePlanet;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by jpcs1 on 7/07/17.
 */
@RestController("films")
@AllArgsConstructor
public class FilmController {

    private GetAllFilms findAll;

    private FindFilmById findId;

    @GetMapping
    public ResponseEntity<List<Film>> findAll() {
        List<Film> elements = findAll.execute();
        Link swapiLink = new Link("https://swapi.co/");
        Link planetsLink=  linkTo(PlanetController.class).withRel("planets");

        elements.forEach((Film f)-> {
            f.getPlanets().forEach((Planet p) -> {
                Link linkSelf = linkTo(methodOn(PlanetController.class).findById(p.getPlanetId())).withSelfRel();
                p.add(linkSelf);
            });

        });

        return new ResponseEntity<List<Film>>(elements, HttpStatus.OK);
    }

    @GetMapping(path = "/planets/{id}")
    public ResponseEntity<Film> findId(@PathVariable Long id) {
        Film elements = findId.execute(id);

        return new ResponseEntity<Film>(elements, HttpStatus.OK);
    }

}
