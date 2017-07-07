package com.example.start.wars.repository;

import com.example.start.wars.model.Film;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


/**
 * Created by jpcs1 on 30/06/17.
 */
@Slf4j
//@ConfigurationProperties("taller.spring.ua")
public class CustomFilmRepositoryImpl implements CustomFilmRepository{
    //@Getter @Setter
    //private List<String> aulas;
    @Override
    public void logFilm(Film film) {
        log.info(film.toString());
    }

}
