package com.sian.leech;

import com.sian.leech.model.entity.User;
import com.sian.leech.model.repository.UserDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ProductInit implements ApplicationRunner {
    @Autowired
    UserDA userDA;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void createUser(String username, String password) {


        User user = new User()
                .setUsername(username)
                .setPassword(passwordEncoder.encode(password))
                .setRole("ROLE_USER");

        userDA.save(user);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("NEW USER");
        createUser("alvin", "q1q1q1Q!");

    }
}
