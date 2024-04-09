package com.example.studenmanagewithnuxtjsandspring.service;

import com.example.studenmanagewithnuxtjsandspring.entity.Role;
import com.example.studenmanagewithnuxtjsandspring.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
