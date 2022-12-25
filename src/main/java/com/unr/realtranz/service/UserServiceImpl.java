package com.unr.realtranz.service;

import com.unr.realtranz.entities.Role;
import com.unr.realtranz.entities.Users;
import com.unr.realtranz.model.UserModel;
import com.unr.realtranz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:07-06-2022 01:31
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Users> getUsers(){
        List<Users> users = userRepository.findAll();
        return users;
    }

    @Override
    public Users save(Users registrationDto) {
        Users user = new Users(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getUsername(),
                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")),registrationDto.getEmail_id(),registrationDto.getPhone1());

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),  mapRolesToAuthorities(user.getRoles()));
    }

    private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(Collection < Role > roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
    public Users getUsersByUserName(String userName){
        Users users = userRepository.findByUsername(userName);
        return users;
    }
    private List<UserModel> convertUserModels(List<Users> users) {
        List<UserModel> userModels = new ArrayList<>();
        for (Users user : users){
            UserModel userModel = new UserModel();
            userModel.setName(user.getUsername());
            userModel.setPassword(user.getPassword());
            userModels.add(userModel);
        }
        return userModels;
    }

    public void saveUser(Users users){
        userRepository.save(users);
    }


}
