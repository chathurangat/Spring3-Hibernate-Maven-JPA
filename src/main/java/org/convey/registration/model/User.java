package org.convey.registration.model;

import org.springframework.stereotype.Component;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;

/**
 * $LastChangedDate:  $
 * $LastChangedBy:  $
 * $LastChangedRevision:  $
 *
 * Author: Chathuranga Tennakoon ( chathuranga.t@gmail.com  tel: 009475961039 )
 */
@Component
public class User {

    /* all validation error messages has been defined inside the messages.properties file. */
    @NotBlank
    @Length(min = 5, max = 20)
    private String username;

    @NotBlank
    @Length(min = 5, max = 20)
    private String password;

    @NotBlank
    @Email
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
