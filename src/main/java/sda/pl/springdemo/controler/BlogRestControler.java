package sda.pl.springdemo.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sda.pl.springdemo.model.User;
import sda.pl.springdemo.service.BlogService;
import sda.pl.springdemo.service.BlogServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController // kontroler generujacy wyniki w postaci rest api
//@Controller // kontroler komunikujacy sie z wartswa front-endu
public class BlogRestControler {

private BlogServiceImpl blogService;

@Autowired
public BlogRestControler(BlogServiceImpl blogService){
    this.blogService = blogService;
}


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/hello/{name}")
    public String helloMe(
            @PathVariable("name") String name
    )
    {
        return "hello " + name.toUpperCase();
    }
    // żadanie dodania nowego uzytkownika do tabweli user

    @PostMapping("/addUser")
    public boolean addUser(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){
      return blogService.addUser(new User(name, lastName, email, password));
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
    return blogService.getAllUserOrderByRegistrationDateDesc();
    }

    @DeleteMapping("/delete")
    public boolean deleteUser(@RequestParam("Id") long id)
    {
        return blogService.deleteUser(id);
    }

    @GetMapping("/user/{userId}")
    public String getUserById(@PathVariable("userId") Long userId){
        Optional<User> userOpt = blogService.getUserById(userId);
        if(userOpt.isPresent()){
            return userOpt.get().toString();
        }
        return "brak użytkownika o id: " + userId;
    }
    @PutMapping("/updateUserPassword")
    public boolean updateUserPassword(@RequestParam("userId") Long userId,
                                      @RequestParam("newPassword") String newPassword){
        return blogService.updatePassword(userId,newPassword);
    }


}
