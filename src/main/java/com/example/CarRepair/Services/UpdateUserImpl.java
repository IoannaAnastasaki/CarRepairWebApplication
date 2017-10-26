package com.example.CarRepair.Services;
import com.example.CarRepair.Converter.UserFormToUserConverter;
import com.example.CarRepair.Converter.UserToUserFormConverter;
import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Exceptions.UserExistException;
import com.example.CarRepair.Model.NewUserForm;
import com.example.CarRepair.Model.UserUpdateForm;
import com.example.CarRepair.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UpdateUserImpl implements UpdateUser {




    @Autowired
    UserRepository userRepository;


    @Override
    public User findOne(Long userID)
    {
        User user = userRepository.findByUserID(userID);
        return user;
    }


    @Override
    public UserUpdateForm findUser(Long userID)
    {
        User user = userRepository.findByUserID(userID);
        return UserToUserFormConverter.convert(user);
    }






@Override

    public void UpdateUser(User user) throws Exception
    {
        //vriskw ton user apo to id toy

            user=userRepository.save(user);

    }



    }



