package com.example.start.wars.usecase.planet;

import com.example.start.wars.model.Planet;
import com.example.start.wars.repository.PlanetRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * Created by jpcs1 on 7/07/17.
 */
@Service
public class DeletePlanetById {
    private PlanetRepository planetRepository;

    public DeletePlanetById(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public boolean execute(@NonNull Long idPlanet) throws NullPointerException {

        return planetRepository.deleteByPlanetId(idPlanet);

    }
}
