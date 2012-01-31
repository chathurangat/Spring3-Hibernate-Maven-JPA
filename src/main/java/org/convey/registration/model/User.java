package org.convey.registration.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;

import javax.persistence.*;

/**
 * $LastChangedDate:  $
 * $LastChangedBy:  $
 * $LastChangedRevision:  $
 *
 * Author: Chathuranga Tennakoon ( chathuranga.t@gmail.com  tel: 009475961039 )
 */
@Entity
@Table(name="USER")
@Component
public class User {

    /* all validation error messages has been defined inside the messages.properties file. */

    @Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;

    @NotBlank
    @Length(min = 5, max = 20)
    @Column(name="USERNAME")
    private String username;

    @NotBlank
    @Length(min = 5, max = 20)
    @Column(name="PASSWORD")
    private String password;

    @NotBlank
    @Email
    @Column(name="EMAIL")
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
