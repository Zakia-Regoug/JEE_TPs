package com.example.hospital.service;

import com.example.hospital.entities.Role;
import com.example.hospital.entities.User;
import com.example.hospital.repositories.RoleRepository;
import com.example.hospital.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void AddRoleToUser(String userName, String roleName) {
        User user=findUserByUserName(userName);
        Role role=findRoleByRoleName(roleName);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }


        //userRepository.save(user); // pas besoin transactionnale fait commit
    }

    @Override
    public User authenticate(String userName, String password) {
        User u=userRepository.findByUserName(userName);
        if(u==null) throw new RuntimeException("Bad credentials");
        if(u.getPassword().equals(password)){
            return u;
        }
        throw new RuntimeException("Bad credentials");
    }
}
