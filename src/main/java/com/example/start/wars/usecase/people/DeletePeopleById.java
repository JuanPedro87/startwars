package com.example.start.wars.usecase.people;

import com.example.start.wars.repository.PeopleRepository;
import org.springframework.stereotype.Service;

/**
 * Created by jpcs1 on 7/07/17.
 */
@Service
public class DeletePeopleById {
    private PeopleRepository peopleRepository;

    public DeletePeopleById(PeopleRepository PeopleRepository) {
        this.peopleRepository = PeopleRepository;
    }

    public boolean execute(Long idPeople) throws NullPointerException {
        if(idPeople == null) {
            throw new NullPointerException("People id is required");
        }

        peopleRepository.delete(idPeople);
        return true;

    }
}
