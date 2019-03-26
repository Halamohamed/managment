package se.bth.managment.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.bth.managment.Models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByFirstName(@Param("first_name")String firstName);

    List<User> findByLastName(@Param("last_name")String lastName);

    List<User> findByEmail(@Param("email")String email);

    List<User> findByPhone(@Param("phone")String phone);

    List<User> findByCity(@Param("city")String city);

    List<User> findByFirstNameAndLastName(@Param("first_name")String firstName,@Param("last_name")String lastName);

    List<User> findByFirstNameOrEmail(@Param("first_name")String firstName,@Param("email")String email);

    Optional<User> findByUserName (String userName);

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);

}
