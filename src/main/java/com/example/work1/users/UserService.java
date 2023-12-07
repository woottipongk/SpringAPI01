package com.example.work1.users;

import com.example.work1.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    public @ResponseBody UserResponse listusers(UserRequest userRequest) {
        UserResponse response = new UserResponse();
        response.setId(1);
        response.setName("WOOTTIPONG KONGSIB");
        return response;
    }

    public @ResponseBody ResponseEntity<UserResponse> adduser(UserRequest userRequest) {
        MyUser myUser = new MyUser();
        myUser.setEmail("woottiong523@psru.ac.th");
        myUser.setName("WOOTTIPONG KONGSIB");
        myUser = userRepository.save(myUser);
        UserResponse response = new UserResponse();
        response.setEmail("woottiong523@psru.ac.th");
        response.setName("WOOTTIPONG KONGSIB");
        response.setId(myUser.getId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public @ResponseBody Iterable<MyUser> getAllUsers(UserRequest userRequest) {
        return userRepository.findAll();
    }

    public @ResponseBody ResponseEntity<UserResponse> update1(UserRequest userRequest) {

        MyUser myUser = new MyUser();
        myUser.setId(userRequest.getId());
        myUser.setEmail(userRequest.getEmail());
        myUser.setName(userRequest.getName());
        userRepository.save(myUser);
        MyUser updatedUser = userRepository.findById(userRequest.getId()).orElse(null);
        if (updatedUser == null) {
            throw new ApiRequestException("ไม่พบข้อมูลที่คุณต้องการอัปเดท", HttpStatus.NOT_FOUND);
        }
        UserResponse response = new UserResponse();
        response.setEmail(updatedUser.getEmail());
        response.setName(updatedUser.getName());
        response.setId(updatedUser.getId());
        return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
    }

    public ResponseEntity<UserResponse> update2(UserRequest userRequest) {
        userRepository.updateUserData(userRequest.getId(), userRequest.getEmail());
        MyUser updatedUser = userRepository.findById(userRequest.getId()).orElse(null);
        if (updatedUser == null) {
            throw new ApiRequestException("ไม่พบข้อมูลที่คุณต้องการอัปเดท", HttpStatus.NOT_FOUND);
        }
        UserResponse response = new UserResponse();
        response.setEmail(updatedUser.getEmail());
        response.setId(updatedUser.getId());
        return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
    }
}
