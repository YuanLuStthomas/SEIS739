package com.bookblend.bookblendbackend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;


// Service for encrypting passwords.
@Service
public class EncryptionService {

    /** How many salt rounds should the encryption run. */
    @Value("${encryption.salt.rounds}")
    private int saltRounds;
     /** The salt built after construction. */
     private String salt;

    @PostConstruct
    public void postConstruct() {
        salt = BCrypt.gensalt(saltRounds);
    }

    // encryptPassword encrypts a password using BCrypt.
    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, salt);
    }

    public boolean verifyPassword(String password, String hash) {
        return BCrypt.checkpw(password, hash);
      }

}
