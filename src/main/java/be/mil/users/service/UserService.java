package be.mil.users.service;

import be.mil.users.entitys.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);

    List<User> all();
}
