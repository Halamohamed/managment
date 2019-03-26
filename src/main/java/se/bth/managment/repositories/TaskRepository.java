package se.bth.managment.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import se.bth.managment.Models.SubTask;
import se.bth.managment.Models.Task;

import java.util.Optional;

public interface TaskRepository extends MongoRepository<Task, String> {


    Optional<Task> findByName(@Param("name")String name);

    Optional<Task> findByPriority (@Param("priority")Integer priority);

    Optional<Task> findBySubTasks (@Param("subtask")SubTask subTask);
}
