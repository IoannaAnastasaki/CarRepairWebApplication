package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CarRepair.Exceptions.InvalidUserException;
import org.springframework.security.core.AuthenticationException;
import java.util.ArrayList;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);
    private ArrayList<String> loggedIn = new ArrayList<String>();
    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User retrievedUser = userRepository.findByEmailAndUserpassword(email,password);
        if (retrievedUser == null) {
            throw new InvalidUserException("User not found!");
        }

        loggedIn.add(email);
        return retrievedUser;
    }

    @Override
    public void logout(String email) throws Exception {
        loggedIn.remove(email);
    }
}




