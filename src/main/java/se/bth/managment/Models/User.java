package se.bth.managment.Models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Document(collection = "user")

public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @NotBlank
    @Email
    private String email;
    private String phone;
    private String city;

    @NotBlank
    private String userName;
    @NotBlank
    private String password;

    private Team team;

}
