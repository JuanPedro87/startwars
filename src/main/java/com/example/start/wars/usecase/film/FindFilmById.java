package com.example.start.wars.usecase.film;

import com.example.start.wars.model.Film;
import com.example.start.wars.repository.FilmRepository;
import org.springframework.stereotype.Service;

/**
 * Created by jpcs1 on 7/07/17.
 */
@Service
public class FindFilmById {
    private FilmRepository filmRepository;

    public FindFilmById(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Film execute(Long idFilm) throws NullPointerException {
        if(idFilm == null) {
            throw new NullPointerException("Film id is required");
        }

        return filmRepository.findOne(idFilm);

    }
}
