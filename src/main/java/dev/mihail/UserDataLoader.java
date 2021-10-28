package dev.mihail;

import dev.mihail.DAO.UserDAOService;
import dev.mihail.config.UserDataGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements CommandLineRunner {

    private UserDAOService userDAOService;
    private UserDataGenerator userDataGenerator;

    public UserDataLoader(UserDAOService userDAOService, UserDataGenerator userDataGenerator) {
        this.userDAOService = userDAOService;
        this.userDataGenerator = userDataGenerator;
    }


    @Override
    public void run(String... args) {

        userDAOService.saveAllUsers(userDataGenerator.getUserList());
    }
}
