package sda.pl.springdemo.controler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity  // tworzy encję i mapuje ją na tabelę
public class User {
    @Id   // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime reigstartionDateTime;
    private boolean status;
}
