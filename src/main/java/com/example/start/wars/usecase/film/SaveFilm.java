package com.example.start.wars.usecase.film;

import com.example.start.wars.model.Film;
import com.example.start.wars.model.People;
import com.example.start.wars.model.Planet;
import com.example.start.wars.repository.FilmRepository;
import com.example.start.wars.repository.PeopleRepository;
import com.example.start.wars.repository.PlanetRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * Created by jpcs1 on 7/07/17.
 */
@Service
public class SaveFilm {
    private FilmRepository filmRepository;
    private PeopleRepository peopleRepository;
    private PlanetRepository planetRepository;

    public SaveFilm(FilmRepository filmRepository, PeopleRepository peopleRepository, PlanetRepository planetRepository) {
        this.filmRepository = filmRepository;
        this.peopleRepository = peopleRepository;
        this.planetRepository = planetRepository;
    }

    public Film execute(@NonNull Film film) throws NullPointerException {

        createPlanetWhenNotExist(film);

        createPeopleWhenNotExist(film);

        return filmRepository.save(film);

    }

    private void createPlanetWhenNotExist(@NonNull Film film) {
        film.getPlanets().forEach((Planet p) -> {
            if(!planetRepository.exists(p.getPlanetId())){
                planetRepository.save(p);
            }
        });
    }

    private void createPeopleWhenNotExist(@NonNull Film film) {
        film.getPeople().forEach((People p) -> {
            if(!peopleRepository.exists(p.getId())){
                peopleRepository.save(p);
            }
        });
    }
}
