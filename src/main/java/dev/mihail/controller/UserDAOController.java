package dev.mihail.controller;

import dev.mihail.DAO.UserDAOImpl;
import dev.mihail.model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLSyntaxErrorException;

@RestController
@RequestMapping("/test") //http://localhost:8092/test
public class UserDAOController {


    private final UserDAOImpl userDAOImpl;

    public UserDAOController(UserDAOImpl userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }


    @GetMapping(path = "/search/email/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User getUserByEmail(@RequestBody String email) throws SQLSyntaxErrorException {

        return userDAOImpl.getUserByEmail(email);
    }
    @PostMapping(path = "/save", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Integer> saveUser(@RequestBody User user) throws SQLSyntaxErrorException {

        return ResponseEntity.ok().body(userDAOImpl.createUser(user));
    }

    @GetMapping(path = "search/",
                                            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String greeting(@RequestBody String text) {
        return "hello world" + text;
    }
    @GetMapping(path = "search/")
    public int getRecordsCount() {
        return userDAOImpl.getCountOfUsers();
    }
}
