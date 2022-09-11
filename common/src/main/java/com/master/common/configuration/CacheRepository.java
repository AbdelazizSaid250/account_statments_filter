package com.master.common.configuration;

import com.master.common.model.Role;
import com.master.common.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class CacheRepository {

    private static final List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    private void loadUsers() {
        users.add(new User("Abdelaziz", new HashSet<>(Collections.singletonList(Role.ADMIN))));
        users.add(new User("Zizo", new HashSet<>(Collections.singletonList(Role.USER))));
    }

    @PostConstruct
    public void init() {
        loadUsers();
    }
}
