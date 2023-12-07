package com.project.bank.service;

import com.project.bank.dao.User;
import com.project.bank.dao.repository.UserRepository;
import com.project.bank.dto.NewUserDTO;
import com.project.bank.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUserByEmail (String email) {
        if (userRepository.findUserByEmail(email) != null) {
            return userRepository.findUserByEmail(email);
        }
        throw new UserNotFoundException("User with email {" + email + "} does not exist");
    }

    public User getUserById (Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id {" + id + "} does not exist"));
    }
    public void saveUser (NewUserDTO newUserDTO) {
        User user = new User();
        user.setFirstName(newUserDTO.getFirstName());
        user.setLastName(newUserDTO.getLastName());
        user.setAge(newUserDTO.getAge());
        user.setEmail(newUserDTO.getEmail());
        user.setPassword(newUserDTO.getPassword());

        userRepository.save(user);
    }
}
