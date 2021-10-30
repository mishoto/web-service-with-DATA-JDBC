package dev.mihail.controller;

import dev.mihail.DAO.UserDAO;
import dev.mihail.DTO.UserDTO;
import dev.mihail.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLSyntaxErrorException;

@RestController
@RequestMapping("/test") //http://localhost:8092/test
public class UserDAOController {

    @Autowired
    private final UserDAO<User, Long> userDAO;


    public UserDAOController(UserDAO<User, Long> userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping(path = "/search{email}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) throws SQLSyntaxErrorException {

        return ResponseEntity.ok().body(userDAO.getUserByEmail(email));
    }
    @PostMapping(path = "/save", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Integer> saveUser(@RequestBody User user) throws SQLSyntaxErrorException {

        return ResponseEntity.ok().body(userDAO.createUser(user));
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new User().toString();
    }

}
