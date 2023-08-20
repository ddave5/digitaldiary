package hu.project.controller;

import hu.project.domain.User;
import hu.project.dto.userCreate.UserCreateRequest;
import hu.project.dto.userCreate.UserCreateResponse;
import hu.project.dto.userGet.LoginRequest;
import hu.project.dto.userGet.LoginResponse;
import hu.project.mapper.UserMapper;
import hu.project.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        log.info("Sending all users");
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/user/{movieId}")
    public User getUser(@PathVariable("movieId") Long userId) {
        log.info("Sending user with id {}", userId);
        return userService.getUserById(userId);
    }

    @PostMapping("/loginuser")
    public ResponseEntity<LoginResponse> getUserByUsernameOrEmail(@RequestBody LoginRequest user) {
        User searchedUser = userService.getUserByUsernameOrEmailAndPassword(user.getUser(), user.getUser(), user.getPassword());
        log.info("Sending user with username {} or email {}", searchedUser.getUsername(), searchedUser.getEmail());
        return new ResponseEntity<>(UserMapper.INSTANCE.mapToGetResponse(searchedUser), HttpStatus.OK);
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserCreateResponse> saveUser(@RequestBody @Valid UserCreateRequest user) {
        User savedUser = userService.saveUser(UserMapper.INSTANCE.mapToCreateEntity(user));
        log.info("Successful saved user with id {}", savedUser.getId());
        return new ResponseEntity<>(UserMapper.INSTANCE.mapToCreateResponse(savedUser), HttpStatus.OK);
    }

    @DeleteMapping("/user/delete/{movieId}")
    public void deleteUser(@PathVariable("movieId") Long userId){
        log.info("Successful saved user with id {}", userId);
        userService.deleteUser(userService.getUserById(userId));
    }

}
