package com.example.start.wars.usecase.film;

import com.example.start.wars.model.Film;
import com.example.start.wars.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jpcs1 on 7/07/17.
 */
@Service
public class GetAllFilms {
    private FilmRepository filmRepository;

    public GetAllFilms(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> execute() {

        return filmRepository.findAll();
    }
}
