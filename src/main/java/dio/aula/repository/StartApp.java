package dio.aula.repository;

import dio.aula.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        List<User> users = repository.findByNameContaining("Gina");
        for(User u: users){
            System.out.println(u);
        }
    }
    private void insertUser(){
        User user = new User();
        user.setName("Gina");
        user.setUsername("gdutra");
        user.setPassword("Brita1234");
        repository.save(user);

        for(User u: repository.findAll()){
            System.out.println(u);
        }
    }
}
