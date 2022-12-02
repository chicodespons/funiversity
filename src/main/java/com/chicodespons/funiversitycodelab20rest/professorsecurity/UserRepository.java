package com.chicodespons.funiversitycodelab20rest.professorsecurity;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Repository;

import javax.annotation.concurrent.Immutable;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private Map<String, User> userMap = ImmutableMap.<String, User>builder()
            .put("Bob", new User("Bob", "pwd", Role.ADMIN))
            .put("Tim", new User("Tim", "pwd", Role.NORMAL))
            .put("Sofie", new User("Tim", "pwd", Role.NORMAL))
            .build();

    public User getUser(String username) {
       return userMap.get(username);
    }

}
