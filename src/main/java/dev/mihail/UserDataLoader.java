package dev.mihail;

import dev.mihail.DAO.UserDAOImpl;
import dev.mihail.DAO.UserRepository;
import dev.mihail.config.UserDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements CommandLineRunner {

    @Autowired
    private final UserRepository userRepository;
    private final UserDataGenerator userDataGenerator;

    public UserDataLoader(UserRepository userRepository, UserDataGenerator userDataGenerator) {
        this.userRepository = userRepository;
        this.userDataGenerator = userDataGenerator;
    }

    @Override
    public void run(String... args) {

//        userRepository.saveAll(userDataGenerator.getUserList());

        }
}
