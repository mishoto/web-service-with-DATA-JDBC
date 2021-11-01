package dev.mihail.controller;

import dev.mihail.DAO.UserRepository;
import dev.mihail.DTO.UserDTO;
import dev.mihail.DTO.UserDTOService;
import dev.mihail.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@RestController
//@RequestMapping("/user") //http://localhost:8092/user
//public class UserController {
//
//    private static final Logger logUserController = LoggerFactory.getLogger(UserController.class);
//    @Autowired
//    private final UserDTOService userDTOService;
//    private final UserRepository userRepository;
//
//    public UserController(UserDTOService userDTOService, UserRepository userRepository) {
//        this.userDTOService = userDTOService;
//        this.userRepository = userRepository;
//    }
//
//
//    @PostMapping(path = "/save", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<String> saveUser(@RequestBody UserDTO userDTO) {
//
//        logUserController.info("UserController - saveUser");
//
//        return ResponseEntity.ok().body(userDTOService.saveDTOUser(userDTO));
//    }
//
//    @GetMapping(path = "/search/email/{email}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//                                   consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
//
//        logUserController.info("UserController - getUserByEmail");
//
//        return ResponseEntity.ok().body(userDTOService.getDTOUserByEmail(email));
//    }
//
//    @GetMapping(path = "/search/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
//
//        logUserController.info("UserController - getUserByEmail");
//
//        return ResponseEntity.ok().body(userRepository.findById(id));
//    }
//
//    @PutMapping(path = "/update", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<UserDTO> updateUserByEmail(@RequestBody UserDTO userDTO) {
//
//        logUserController.info("UserController - updateUserByEmail");
//
//        return ResponseEntity.ok().body(userDTOService.updateDTOUserByEmail(userDTO));
//    }
//
//    @GetMapping(path = "/delete/{email}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public ResponseEntity<String> deleteUserByEmail(@PathVariable String email) {
//
//        logUserController.info("UserController - deleteUserByEmail");
//
//        return ResponseEntity.ok().body(userDTOService.deleteUserDTOByEmail(email));
//    }
//}
