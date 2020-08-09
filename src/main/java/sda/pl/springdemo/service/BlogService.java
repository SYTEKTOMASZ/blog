package sda.pl.springdemo.service;

import sda.pl.springdemo.model.User;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    //dodawanie użytkownika
     boolean addUser(User user);

    //usuwanie użytkownika
    boolean deleteUser(long userId);
    //zmiana hasła użytkownika
    boolean updatePassword(long userID, String newPassword);
    //pobranie wszystki użytkowników
    List<User> getAllUserOrderByRegistrationDateDesc();
    // pobranie użytkownika po ID
    Optional<User> getUserById(long userId);
}
