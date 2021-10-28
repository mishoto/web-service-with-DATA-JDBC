package dev.mihail;

import dev.mihail.DAO.UserDAOService;
import dev.mihail.config.UserDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements CommandLineRunner {

    @Autowired
    private final UserDAOService userDAOService;
    private final UserDataGenerator userDataGenerator;

    public UserDataLoader(UserDAOService userDAOService, UserDataGenerator userDataGenerator) {
        this.userDAOService = userDAOService;
        this.userDataGenerator = userDataGenerator;
    }


    @Override
    public void run(String... args) {

        userDAOService.saveAllUsers(userDataGenerator.getUserList());
    }
}
