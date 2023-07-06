package com.simform.ecommerceapi.service;

import com.simform.ecommerceapi.dto.UserDto;
import com.simform.ecommerceapi.entity.Membership;
import com.simform.ecommerceapi.entity.User;
import com.simform.ecommerceapi.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;

    public UserDto addUser(User user) {
        Membership membership = user.getMembership();
        membership.setUser(user);

        user.getOrderList().forEach(orders -> orders.setUser(user));
        User savedUser = userRepo.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    public List<UserDto> getAllUser() {
        List<UserDto> userDtoList = userRepo.findAll().stream().map((element) -> modelMapper.map(element, UserDto.class)).collect(Collectors.toList());
        return userDtoList;
    }



    public UserDto getUserById(int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            User userFound = user.get();
            return modelMapper.map(userFound, UserDto.class);
        } else {
            throw new RuntimeException("user id is invalid");
        }
    }

    public void deleteUserById(int id) {
        userRepo.deleteById(id);

    }

    public UserDto updateUser(User user) {
        User savedUser = userRepo.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }
}
