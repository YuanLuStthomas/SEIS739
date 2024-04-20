package com.bookblend.bookblendbackend.model.dao;


import com.bookblend.bookblendbackend.model.LocalUser;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

/**
 * Data Access Object for the LocalUser data.
 */
public interface LocalUserDAO extends CrudRepository<LocalUser, Long> {

  Optional<LocalUser> findByUsernameIgnoreCase(String username);

  Optional<LocalUser> findByEmailIgnoreCase(String email);

}