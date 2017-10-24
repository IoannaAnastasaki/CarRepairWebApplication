package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Exceptions.UserExistException;
import com.example.CarRepair.Exceptions.UserNotExistException;
import com.example.CarRepair.Repositories.UserRepository;
import com.google.common.base.FinalizablePhantomReference;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void CreateUser(User user) throws Exception {
        User retrievedUser=userRepository.findByTaxNumberOrEmail(user.getTaxNumber(),user.getEmail());
        if (retrievedUser!=null) {
            throw new UserExistException("User already exist");
        }
        else {
            retrievedUser = userRepository.save(user);
        }
    }

    @Override
    public User findByTaxNumber(Integer taxNumber) throws Exception{
        User retrievedUser=userRepository.findByTaxNumber(taxNumber);
        if (retrievedUser==null) {
            throw new UserNotExistException("User does not exist");
        }
        else {
            return retrievedUser;
        }
    }

    @Override
    public User SearchUser(String inputSearch) throws Exception {
        Pattern emailPattern =Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$");
        Pattern taxPattern= Pattern.compile("\\d\\d\\d\\d\\d\\d\\d\\d\\d");

        Matcher emailMach=emailPattern.matcher(inputSearch);
        Matcher taxMach=taxPattern.matcher(inputSearch);

        User retrievedUser=null;

        if(emailMach.find()){
            retrievedUser=userRepository.findByEmail(inputSearch);
        }
        else if(taxMach.find()){
            Integer taxNumber=Integer.parseInt(inputSearch);
            retrievedUser=userRepository.findByTaxNumber(taxNumber);

        }else{
            System.out.println("User does not give ether email ether password");
            throw new UserNotExistException("User can be found by email or tax number");
        }
        if (retrievedUser==null) {
            throw new UserNotExistException("User does not exist");
        }
        else {
            return retrievedUser;
        }
    }
}
