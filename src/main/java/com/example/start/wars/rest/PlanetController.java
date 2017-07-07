package com.example.start.wars.rest;

import com.example.start.wars.model.Film;
import com.example.start.wars.model.Planet;
import com.example.start.wars.usecase.planet.GetAllPlanets;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpcs1 on 7/07/17.
 */
@RestController("planets")
//@Controller
//@RequestMapping(path = "/planets")
public class PlanetController {

    private GetAllPlanets findAllPlanets;

    public PlanetController(GetAllPlanets findAllPlanets) {
        this.findAllPlanets = findAllPlanets;
    }

    @GetMapping
    public ResponseEntity<List<Planet>> findAll() {
        List<Planet> planets = findAllPlanets.execute();

        return new ResponseEntity<List<Planet>>(planets, HttpStatus.MULTI_STATUS.OK);
    }




}
