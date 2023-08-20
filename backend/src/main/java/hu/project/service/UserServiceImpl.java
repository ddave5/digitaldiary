package hu.project.service;

import hu.project.domain.User;
import hu.project.exception.LoginException;
import hu.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        log.info("Save user with id {}", user.getId());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        log.info("Update user with id {}", user.getId());
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(User user) {
        log.info("Delete user with id {}", user.getId());
        userRepository.delete(user);
    }

    @Override
    public List<User> getUsers() {
        log.info("Get all movies");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> movieOptional = userRepository.findById(id);
        log.info("Fetching user with id {}", id);
        return movieOptional.orElseThrow(
                () -> new IllegalArgumentException(("User with id: " + id + " does not exists.")));
    }

    @Override
    public User getUserByUsernameOrEmailAndPassword(String user, String email, String password) {
        Optional<User> userOptional = userRepository.findByUsernameOrEmailAndPassword(user, email, password);
        log.info("Fetching user with email {} and user {}", email, user);
        return userOptional.orElseThrow(
                () -> new LoginException("Login failed! We cannot find this user!")
        );
    }
}
