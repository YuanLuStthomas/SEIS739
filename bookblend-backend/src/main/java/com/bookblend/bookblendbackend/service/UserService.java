package com.bookblend.bookblendbackend.service;

import org.springframework.stereotype.Service;
import java.util.Optional;

import com.bookblend.bookblendbackend.api.model.LoginBody;
import com.bookblend.bookblendbackend.api.model.RegistrationBody;
import com.bookblend.bookblendbackend.exception.UserAlreadyExistsException;
import com.bookblend.bookblendbackend.model.LocalUser;
import com.bookblend.bookblendbackend.model.dao.LocalUserDAO;

@Service
public class UserService {

    /** The LocalUserDAO. */
    private LocalUserDAO localUserDAO;

    private EncryptionService encryptionService;

    private JWTService jwtService;

    /**
     * Constructor injected by spring.
     * @param localUserDAO
     */
    public UserService(LocalUserDAO localUserDAO, EncryptionService encryptionService, JWTService jwtService) {
        this.localUserDAO = localUserDAO;
        this.encryptionService = encryptionService;
        this.jwtService = jwtService;
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

        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        return localUserDAO.save(user);
    }

    public String loginUser(LoginBody loginBody) {
        Optional<LocalUser> opUser = localUserDAO.findByUsernameIgnoreCase(loginBody.getUsername());
        if (opUser.isPresent()) {
        LocalUser user = opUser.get();
        if (encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())) {
            return jwtService.generateJWT(user);
        }
        }
        return null;

    }

}
