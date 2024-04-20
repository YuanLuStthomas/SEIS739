package com.bookblend.bookblendbackend.service;

import org.springframework.stereotype.Service;

import com.bookblend.bookblendbackend.api.model.RegistrationBody;
import com.bookblend.bookblendbackend.exception.UserAlreadyExistsException;
import com.bookblend.bookblendbackend.model.LocalUser;
import com.bookblend.bookblendbackend.model.dao.LocalUserDAO;

@Service
public class UserService {

    /** The LocalUserDAO. */
    private LocalUserDAO localUserDAO;

    /**
     * Constructor injected by spring.
     * @param localUserDAO
     */
    public UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if (localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
        || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setUsername(registrationBody.getUsername());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        //TODO: Encrypt passwords!!
        user.setPassword(registrationBody.getPassword());
        return localUserDAO.save(user);
    }

}
