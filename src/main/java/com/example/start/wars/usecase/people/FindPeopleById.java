package com.example.start.wars.usecase.people;

import com.example.start.wars.model.People;
import com.example.start.wars.repository.PeopleRepository;
import lombok.NonNull;
import lombok.experimental.NonFinal;
import org.springframework.stereotype.Service;

/**
 * Created by jpcs1 on 7/07/17.
 */
@Service
public class FindPeopleById {
    private PeopleRepository peopleRepository;

    public FindPeopleById(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public People execute(@NonNull Long idPeople) throws NullPointerException {

        return peopleRepository.findOne(idPeople);

    }
}
