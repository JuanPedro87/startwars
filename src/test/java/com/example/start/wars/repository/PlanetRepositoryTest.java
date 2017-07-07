package com.example.start.wars.repository;

import com.example.start.wars.model.Planet;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by jpcs1 on 30/06/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetRepositoryTest {
    @Autowired
    private PlanetRepository repository;

    /**
     * te pone el autowired automaticamente
     */
    //public PlanetRepositoryTest(PlanetRepository planetRepository) {
    //    this.repository = planetRepository;
    //}

    @Test
    public void should_fin_by_name()throws Exception {
        //Alderaan
        Planet planet = repository.findByName("Alderaan");
        assertThat(planet.getName(), is("Alderaan"));

    }
    @Test
    public void should_fin_pagination()throws Exception {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<Planet> planets = repository.findAll(pageRequest);
        assertNotNull(planets);
    }

    @Test
    public void should_fin_shorting()throws Exception {
        Sort sort= new Sort(Sort.Direction.DESC,"name");
        List<Planet> planets1 = repository.findAll();
        assertNotNull(planets1);

    }

}
