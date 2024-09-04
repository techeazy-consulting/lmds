package com.techeazy.lmds.services;

import com.techeazy.lmds.payloads.requests.userRequests.UserRegisterRequest;
import com.techeazy.lmds.payloads.responses.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    ResponseEntity<UserResponse> registerUser(UserRegisterRequest user);
    ResponseEntity<List<UserResponse>> listOfAllUsers();
    ResponseEntity<Optional<UserResponse>> findUserById(String id);
    ResponseEntity<Optional<UserResponse>> findUserByEmail(String email);

}
