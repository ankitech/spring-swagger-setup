package ankitech.springswagger.controller;

import ankitech.springswagger.model.User;
import ankitech.springswagger.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "User Controller for managing users")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    private final String API_VERSION = "/v1";

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Get the details of a user based on id", response = User.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(API_VERSION + "/user/{userId}")
    public ResponseEntity<User> getUserDetails(@PathVariable("userId") String userId) {
        logger.info("Value of user id : {}", userId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "Create a new user",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(API_VERSION + "/user")
    public ResponseEntity<String> createUserDetails(@RequestBody User user) {

        User savedUser = userService.createUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Location", API_VERSION + "/user/" + savedUser.getId());

        return new ResponseEntity<>("User created with id : " + savedUser.getId(), headers, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update user details",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(API_VERSION + "/user/{userId}")
    public ResponseEntity<String> updateUserDetails(@PathVariable("userId") String userId, @RequestBody User user) {

        User updatedUser = userService.updateUser(userId, user);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Location", API_VERSION + "/user/" + updatedUser.getId());

        return new ResponseEntity<>("", headers, HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Delete user details", produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping(API_VERSION + "/user/{userId}")
    public ResponseEntity<String> deleteUserDetails(@PathVariable("userId") String userId) {

        userService.deleteUser(userId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>("User successfully deleted", headers, HttpStatus.NO_CONTENT);
    }
}
