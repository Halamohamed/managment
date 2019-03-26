package se.bth.managment.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import se.bth.managment.Models.BacklogTask;
import se.bth.managment.Models.Task;
import se.bth.managment.Models.Team;

import java.util.Optional;

public interface BacklogRepository extends MongoRepository<BacklogTask, String> {


    Optional<BacklogTask> findByTasks(@Param("Task")Task task);

    Optional<BacklogTask> findByTeam (@Param("Team")Team team);
}
