package com.example.start.wars.usecase.planet;

import com.example.start.wars.model.Planet;
import com.example.start.wars.repository.PlanetRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * Created by jpcs1 on 7/07/17.
 */
@Service
public class SavePlanet {
    private PlanetRepository planetRepository;

    public SavePlanet(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet execute(@NonNull Planet planet) throws NullPointerException {

        return planetRepository.save(planet);

    }
}
