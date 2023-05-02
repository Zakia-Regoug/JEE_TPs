package com.example.hospital.service;

import com.example.hospital.entities.Role;
import com.example.hospital.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void AddRoleToUser(String userName, String roleName);
    User authenticate(String userName, String password);

}
