package se.bth.managment.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import se.bth.managment.Models.SubTask;
import se.bth.managment.Models.User;

import java.util.Optional;

public interface SubTaskRepository extends MongoRepository<SubTask, String> {

    Optional<SubTask> findByName (@Param("Name")String name);

    Optional<SubTask> findByUsers (@Param("user") User user);
}
