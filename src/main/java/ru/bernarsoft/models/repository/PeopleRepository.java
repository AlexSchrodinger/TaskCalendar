package ru.bernarsoft.models.repository;

import org.springframework.data.repository.CrudRepository;
import ru.bernarsoft.models.entity.PeopleEntity;

import java.util.List;

public interface PeopleRepository extends CrudRepository<PeopleEntity, Long> {

    List<PeopleEntity> findAll();
    PeopleEntity findById(int id);

}
