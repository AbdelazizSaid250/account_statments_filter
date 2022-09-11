package com.master.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Set;

@Slf4j
@ToString
public class User {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Set<Role> role;

    public User(String name, Set<Role> role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name)
                && role.equals(user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role);
    }
}
