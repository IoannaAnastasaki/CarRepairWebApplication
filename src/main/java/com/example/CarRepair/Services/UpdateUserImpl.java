package com.example.CarRepair.Services;
import com.example.CarRepair.Converter.UserFormToUserConverter;
import com.example.CarRepair.Converter.UserToUserFormConverter;
import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Exceptions.UserExistException;
import com.example.CarRepair.Model.NewUserForm;
import com.example.CarRepair.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UpdateUserImpl implements UpdateUser {




    @Autowired
    UserRepository userRepository;


    //H methodos ayth einai gia to get tou update,dld gia th forma tou user
    //pou tha vlepei o xrhsths molis pataei to link toy edit
    //vriskei ena xrhsth meso ths id toy(apo to query sto repository) kai kalei ton katallhlo converter
    //wste na perasei ta stoixeia toy sth forma poy exoume ftiaksei sto model(NewUserForm)
    //auto p dld kanei return sthn ousia mesw tou converter einai mia userform

    @Override
    public User findOne(Long userID)
    {
        User user = userRepository.findByUserID(userID);
        return user;
    }


    @Override
    public NewUserForm findUser(Long userID)
    {
        User user = userRepository.findByUserID(userID);
        return UserToUserFormConverter.convert(user);
    }






@Override

    public void UpdateUser(User user) throws Exception
    {
        //vriskw ton user apo to id toy
        if (user!=null) {
            throw new UserExistException("User doesnt");
        }
        else {
            user=userRepository.save(user);
        }

    }











//    public void UpdateUser(Long userID,NewUserForm userForm) throws Exception
//    {
//        //vriskw ton user apo to id toy
//        User retrievedUser=userRepository.findByUserID(userID);
//        if (retrievedUser==null)
//        {
//            throw new UserExistException("User is not exist");
//        }
//        else
//        {
//            //pairnw ta updated stoixeia apo th forma kai ta vazw ston User
//            retrievedUser= UserFormToUserConverter.convert(userForm,retrievedUser);
//            //apothikeuw ton user kai ftiaxnw antikeimeno me ta nea stoixeia tou
//            User updatedUser = userRepository.save(retrievedUser);
//            //epistrefw ton neo user
//            //return updatedUser;
//
//        }
//    }
//


    }



