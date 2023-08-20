package hu.project.service;

import hu.project.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User movie);
    User updateUser(User movie);
    void deleteUser(User movie);
    List<User> getUsers();
    User getUserById(Long id);
    User getUserByUsernameOrEmailAndPassword(String username, String email, String password);
}
