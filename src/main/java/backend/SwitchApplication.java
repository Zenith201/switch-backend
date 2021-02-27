package backend;

import backend.model.Page;
import backend.model.Upload;
import backend.model.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;


import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

@SpringBootApplication
public class SwitchApplication{

    public static void main(String[] args){
        SpringApplication.run(SwitchApplication.class,args);
    }

}
