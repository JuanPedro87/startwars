package com.example.start.wars.usecase.planet;

import com.example.start.wars.model.Planet;
import com.example.start.wars.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by jpcs1 on 7/07/17.
 */
@Service
public class FindPlanetByName {
    private PlanetRepository planetRepository;

    public FindPlanetByName(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Optional<Planet> execute(String namePlanet) throws NullPointerException {
        if(namePlanet == null) {
            throw new NullPointerException("Planet id is required");
        }

        return planetRepository.findByName(namePlanet);

    }
}
