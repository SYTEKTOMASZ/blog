package sda.pl.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.pl.springdemo.model.User;
import sda.pl.springdemo.reposytory.UserReposytory;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    private UserReposytory userReposytory;

    @Autowired
    public BlogServiceImpl(UserReposytory userReposytory){
        this.userReposytory = userReposytory;
    }

    @Override
    public boolean addUser(User user) {
        if(userReposytory.findFirstByEmail(user.getEmail()) == null){
            userReposytory.save(user);
            return true;
        }
      return false;
    }

    @Override
    public boolean deleteUser(long userId) {
        boolean isDeleted = userReposytory.existsById(userId);
        userReposytory.deleteById(userId);
        return isDeleted;
    }

    @Override
    public boolean updatePassword(long userId, String newPassword) {
        if (userReposytory.findById(userId).isPresent()) {
            User userToUpdate = userReposytory.findById(userId).get();  // pobranie użytkownika po id
            userToUpdate.setPassword(newPassword);                      // aktualizacja pola password
            userReposytory.save(userToUpdate);                          // zapis/update istniejącego obiektu
            return true;
        }
        return false;
    }
    @Override
    public List<User> getAllUserOrderByRegistrationDateDesc() {
        return userReposytory.findAll();
    }

    @Override
    public Optional<User> getUserById(long userId) {
        return userReposytory.findById(userId);
    }
}
