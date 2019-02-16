package be.mil.users;

import be.mil.users.entitys.Role;
import be.mil.users.entitys.User;
import be.mil.users.repositories.RoleRepository;
import be.mil.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class SystemConfig {

    @Bean
    CommandLineRunner init (@Qualifier("userRepository") UserRepository userRepository, @Qualifier("roleRepository") RoleRepository roleRepository){
        return args -> {

            Role role1=new Role("admin");
            Role role2=new Role("user");
            Role role3=new Role("guest");

            Set<Role> roleSet=new HashSet<Role>();

            User user=new User("benoit@gmail.com","12345","benoit","goethals",1,roleSet);
            User user2=new User("test@gmail.com","12345","test","goethals",1,roleSet);

            userRepository.saveAndFlush(user);
            userRepository.saveAndFlush(user2);

        };
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}



