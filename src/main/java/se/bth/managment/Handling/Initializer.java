package se.bth.managment.Handling;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.bth.managment.Models.*;
import se.bth.managment.repositories.*;

@Component
public class Initializer implements CommandLineRunner {
    private final UserRepository userrepo;
    private final TeamRepository teamrepo;
    private final TaskRepository taskrepo;
    private final SubTaskRepository subTaskrepo;
    private final BacklogRepository backlogrepo;

    public Initializer(UserRepository repository, TeamRepository teamrepo, TaskRepository taskrepo, SubTaskRepository subTaskrepo, BacklogRepository backlogrepo) {
        this.userrepo = repository;
        this.teamrepo = teamrepo;

        this.taskrepo = taskrepo;
        this.subTaskrepo = subTaskrepo;
        this.backlogrepo = backlogrepo;
    }

    @Override
    public void run(String... strings) {
        addPersons();
        addBacklogTask();
        addTask();
        addSubTask();


    }

    private void addBacklogTask() {
        BacklogTask plannedperriod = BacklogTask.builder().plannedPeriod(15).build();
        backlogrepo.save(plannedperriod);
        BacklogTask backlogTask = BacklogTask.builder().id("Backlog").build();
        backlogrepo.save(backlogTask);
       // BacklogTask subtask = BacklogTask.builder().tasks(List<SubTask>).build();
    }

    private void addSubTask() {
        SubTask subtask = SubTask.builder().name("subtask").build();
        subTaskrepo.save(subtask);
        System.out.println(subtask);
    }

    private void addTask() {
        Task task = Task.builder().name("BacklogTask").build();
        taskrepo.save(task);
        System.out.println(task);
    }


    private void addPersons() {
        Team team = Team.builder().Name("Scrum Team").build();
        teamrepo.save(team);
        System.out.println(team);
        User c = User.builder().firstName("Erik").lastName("Juhanson").email("erik@bth.se").phone("0760762135").city("Karlskrona").userName("Erik").password("1111").team(team).build();
        userrepo.save(c);
        c = User.builder().firstName("Fredrik").lastName("Svensson").email("fridrek@bth.se").phone("0770772135").city("Karlshamen")
                .userName("Fredrik").password("2222").team(team).build();
        userrepo.save(c);

        //userrepo.findAll().forEach(System.out::println);
        //teamrepo.findAll().forEach(System.out::println);
    }
}
