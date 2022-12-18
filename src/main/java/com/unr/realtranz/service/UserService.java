package com.unr.realtranz.service;

import com.unr.realtranz.entities.Users;
import com.unr.realtranz.model.UserModel;
import com.unr.realtranz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:07-06-2022 01:31
 **/
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<Users> getUsers(){
        List<Users> users = userRepository.findAll();
        return users;
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
