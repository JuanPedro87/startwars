package com.example.start.wars.usecase.planet;

import com.example.start.wars.model.Planet;
import com.example.start.wars.repository.PlanetRepository;
import org.springframework.stereotype.Service;

/**
 * Created by jpcs1 on 7/07/17.
 */
@Service
public class FindPlanetById {
    private PlanetRepository planetRepository;

    public FindPlanetById(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet execute(Long idPlanet) {
        if(idPlanet == null) {
            throw new NullPointerException("Planet is null");
        }

        return planetRepository.findOne(idPlanet);

    }
}
