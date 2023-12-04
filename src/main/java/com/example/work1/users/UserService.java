package com.example.work1.users;
import com.example.work1.exception.ApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private boolean isExistingUserInDb() {
        return true;
    }

    public UserResponse listusers(UserRequest userRequest){
        if(isExistingUserInDb()){
            throw new ApiRequestException("User existed", HttpStatus.ACCEPTED);
        }
        UserResponse response = new UserResponse();
        response.setId(1);
        response.setName("WOOTTIPONG KONGSIB");
        return response;
    }

}
