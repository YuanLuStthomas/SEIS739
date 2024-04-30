package com.bookblend.bookblendbackend.service;

import com.bookblend.bookblendbackend.model.LocalUser;
import com.bookblend.bookblendbackend.model.dao.LocalUserDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUsersService {

    private LocalUserDAO localUserDAO;

    public ListUsersService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

    public List<LocalUser> getUsers() {
        return localUserDAO.findAll();
    }

}
