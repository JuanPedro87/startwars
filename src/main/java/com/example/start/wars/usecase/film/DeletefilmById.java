package com.example.start.wars.usecase.film;

import com.example.start.wars.repository.FilmRepository;
import org.springframework.stereotype.Service;

/**
 * Created by jpcs1 on 7/07/17.
 */
@Service
public class DeletefilmById {
    private FilmRepository filmRepository;

    public DeletefilmById(FilmRepository FilmRepository) {
        this.filmRepository = FilmRepository;
    }

    public boolean execute(Long idFilm) throws NullPointerException {
        if(idFilm == null) {
            throw new NullPointerException("Film id is required");
        }

        filmRepository.delete(idFilm);
        return true;

    }
}
