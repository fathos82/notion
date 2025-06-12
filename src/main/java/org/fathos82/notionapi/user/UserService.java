package org.fathos82.notionapi.user;

import org.fathos82.notionapi.user.errors.UserNotNoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public User findUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElseThrow(() -> new UserNotNoundException("No note found with ID: " + userId));
        return user;
    }

    public UserResponse createUser(CreateUserRequest userRequest) {
        User user = new User(userRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return new UserResponse(user);
    }
}
