package dev.mihail;


import dev.mihail.DAO.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements CommandLineRunner {

    @Autowired
    private final UserRepository userRepository;


    public UserDataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public void run(String... args) {

//        userRepository.saveAll(userDataGenerator.getUserList());

        }
}
