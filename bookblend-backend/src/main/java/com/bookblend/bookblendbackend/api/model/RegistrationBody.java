package com.bookblend.bookblendbackend.api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

// outline of the data that will be sent to the server when a user registers
public class RegistrationBody {

  @NotNull
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;
  
  @NotNull
  @NotBlank
  @Email
  private String email;
  
  @NotNull
  @NotBlank
  @Size(min = 3, max = 20)
  @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
  private String password;
  
  @NotNull
  @NotBlank
  private String firstName;
  
  @NotNull
  @NotBlank
  private String lastName;

    public String getUsername() {
        return username;
      }
    
      public String getEmail() {
        return email;
      }
    
      public String getPassword() {
        return password;
      }
    
      public String getFirstName() {
        return firstName;
      }
    
      public String getLastName() {
        return lastName;
      }

}
