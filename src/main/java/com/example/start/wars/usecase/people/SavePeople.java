package com.example.start.wars.usecase.people;

import com.example.start.wars.model.People;
import com.example.start.wars.repository.PeopleRepository;
import org.springframework.stereotype.Service;

/**
 * Created by jpcs1 on 7/07/17.
 */
@Service
public class SavePeople {
    private PeopleRepository peopleRepository;

    public SavePeople(PeopleRepository PeopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public People execute(People people) throws NullPointerException {
        if(people == null) {
            throw new NullPointerException("People is null");
        }

        return peopleRepository.save(people);

    }
}
