package com.example.start.wars.usecase.people;

import com.example.start.wars.model.People;
import com.example.start.wars.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jpcs1 on 7/07/17.
 */
@Service
public class GetAllPeople {
    private PeopleRepository peopleRepository;

    public GetAllPeople(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<People> execute() {

        return peopleRepository.findAll();
    }
}
