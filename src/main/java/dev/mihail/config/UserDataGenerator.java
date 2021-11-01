//package dev.mihail.config;
//
//import com.github.javafaker.Faker;
//import dev.mihail.model.User;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//@Configuration
//public class UserDataGenerator extends Faker {
//
//    private static final int START_RANGE_GENERATION = 1;
//    private static final int END_RANGE_GENERATION = 20;
//    private final List<User> userList;
//
//    public UserDataGenerator(){
//
//        this.userList = setUserList();
//    }
//
//    List<User> setUserList() {
//        List<User> users = IntStream.rangeClosed(START_RANGE_GENERATION,END_RANGE_GENERATION)
//                .mapToObj(i -> generateUser()).collect(Collectors.toList());
//        return users;
//    }
//
//    public List<User> getUserList(){
//        return this.userList;
//    }
//
//
//    User generateUser() {
//        return new User(
//                name().firstName(),
//                name().lastName(),
//                internet().emailAddress()
//        );
//    }
//}
