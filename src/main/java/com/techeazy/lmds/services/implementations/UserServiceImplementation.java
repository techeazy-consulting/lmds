package com.techeazy.lmds.services.implementations;

import com.techeazy.lmds.db.repositories.UserRepository;
import com.techeazy.lmds.payloads.requests.userRequests.UserRegisterRequest;
import com.techeazy.lmds.payloads.responses.UserResponse;
import com.techeazy.lmds.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;
    /**
     * @param user
     * @return
     */
    @Override
    public ResponseEntity<UserResponse> registerUser(UserRegisterRequest user) {

        return null;
    }

    /**
     * @return
     */
    @Override
    public ResponseEntity<List<UserResponse>> listOfAllUsers() {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<Optional<UserResponse>> findUserById(String id) {
        return null;
    }

    /**
     * @param email
     * @return
     */
    @Override
    public ResponseEntity<Optional<UserResponse>> findUserByEmail(String email) {
        return null;
    }
}
