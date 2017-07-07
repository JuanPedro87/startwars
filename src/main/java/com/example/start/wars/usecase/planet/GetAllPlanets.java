package com.example.start.wars.usecase.planet;

import com.example.start.wars.model.Planet;
import com.example.start.wars.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jpcs1 on 7/07/17.
 */
@Service
public class GetAllPlanets {
    private PlanetRepository planetRepository;

    public GetAllPlanets(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public List<Planet> execute() {

        return planetRepository.findAll();
    }
}
