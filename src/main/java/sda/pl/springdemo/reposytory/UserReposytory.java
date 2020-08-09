package sda.pl.springdemo.reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.pl.springdemo.model.User;

@Repository
public interface UserReposytory extends JpaRepository<User, Long> {


    //SELECT * FROM user WHERE user.email = ? LIMIT 1

    User findFirstByEmail(String email);

}
