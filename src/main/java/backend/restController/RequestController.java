package backend.restController;

import backend.helpers.DataHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RequestController {

    DataHelper helper=DataHelper.getInstance();

    @PostMapping("/register")
    String register(@RequestBody HashMap<String,String>body){
        return helper.createAccount(body);
    }


    @GetMapping("/users")
    String getUsers(){
        return helper.getUsers();
    }


    @GetMapping("/git_test")
    String gitTest(){
        return "app successful";
    }

    @GetMapping("/test")
    String test(){
        return "app quite successful";
    }

    @GetMapping("/different_test")
    String test2(){
        return "last test";
    }



    @GetMapping("/usernames")
    String getUsernames(){
        return helper.getUserNames();
    }


}