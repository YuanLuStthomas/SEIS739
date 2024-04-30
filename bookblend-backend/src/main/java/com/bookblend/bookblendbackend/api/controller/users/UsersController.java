package com.bookblend.bookblendbackend.api.controller.users;



import com.bookblend.bookblendbackend.model.LocalUser;
import com.bookblend.bookblendbackend.service.ListUsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to handle the creation, updating & viewing of Books.
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    /** The Book Service. */
    private ListUsersService listUsersService;

    /**
     * Constructor for spring injection.
     * @param listUsersService
     */
    public UsersController(ListUsersService listUsersService) {
        this.listUsersService = listUsersService;
    }

    /**
     * Gets the list of books available.
     * @return The list of books.
     */
    @GetMapping
    public List<LocalUser> getBooks() {
        return listUsersService.getUsers();
    }

}