package com.spring.sec.auth.services;

import com.spring.sec.auth.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final String EXISTING_EMAIL = "test@gmail.com";

    private static final String EXISTING_ANOTHER_EMAIL = "test2@gmail.com";

    public Optional<User> findByEmail(String username) {

        if(EXISTING_EMAIL.equalsIgnoreCase(username)) {
            //temporary fill in details for the user object. as follows.
            User user = new User();
            user.setId(1L);
            user.setEmail(EXISTING_EMAIL);
            user.setPassword("$2a$12$QIX0lP/xaRHCcRVRLg786eAMjkTrsN.k6h0kg3PRBRyH739c.3U4K"); //admin123
            user.setRole("ROLE_ADMIN");
            user.setExtraInfo("This is test user details");
            return Optional.of(user);
        }else if(EXISTING_ANOTHER_EMAIL.equalsIgnoreCase(username)) {
            //temporary fill in details for the user object. as follows.
            User user = new User();
            user.setId(99L);
            user.setEmail(EXISTING_ANOTHER_EMAIL);
            user.setPassword("$2a$12$QIX0lP/xaRHCcRVRLg786eAMjkTrsN.k6h0kg3PRBRyH739c.3U4K"); //admin123
            user.setRole("ROLE_USER");
            user.setExtraInfo("This is test another user");
            return Optional.of(user);
        }else {
            return Optional.empty();
        }
    }
}
