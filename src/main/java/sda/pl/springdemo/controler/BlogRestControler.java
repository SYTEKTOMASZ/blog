package sda.pl.springdemo.controler;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // kontroler generujacy wyniki w postaci rest api
//@Controller // kontroler komunikujacy sie z wartswa front-endu
public class BlogRestControler {

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
    public boolean addUser(){
        if (true){
            return true;
        }
        else{
            return false;
        }
    }

}
