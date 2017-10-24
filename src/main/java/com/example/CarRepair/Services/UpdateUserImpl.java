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
    public NewUserForm findUser(Long userID)
    {
        User user = userRepository.findByUserID(userID);
        return UserToUserFormConverter.convert(user);
    }


    //Ayth h methodos einai gia to patch.Vriskei ton xrhsth mesw tou id toy(kalontas to query apo to repository).
    //Pairnei ta nea updated dedomena pou exei eisagei o xrhsths sth forma
    //kai vazei ayta ta nea stoixeia sta pedia tou user p exoume,epistrefontas
    //etsi thn ananeomenh ekdoxh toy,dld enan updatedUser.
    //Telos auto p kanei return h synarthsh einai nea forma me ta updated stoixeia toy user

@Override
  public User updateUserById(Long userID, NewUserForm userForm)
    {

     User retrieveUser=userRepository.findByUserID(userID);
     retrieveUser= UserFormToUserConverter.convert(userForm,retrieveUser);
     retrieveUser = userRepository.save(retrieveUser);
     return retrieveUser;
    }


     // return  UserToUserFormConverter.convert( userRepository.save(retrieveUser));

    }



