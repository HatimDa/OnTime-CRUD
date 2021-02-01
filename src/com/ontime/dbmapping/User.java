package com.ontime.dbmapping;

import javax.persistence.*;

@Entity
@Table(name = "USER")

/*
 * Anotating Java Class
 */
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_password")
    private String userpassword;

    @Column(name = "full_name")
    private String fullname;

    @Column(name = "user_email")
    private String usermail;

    public User() {

    }

    public User(String username, String userpassword, String fullname,
                String usermail) {
        this.username = username;
        this.userpassword = userpassword;
        this.fullname = fullname;
        this.usermail = usermail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    // For debugging purposes
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", userpassword="
                + userpassword + ", fullname=" + fullname
                + ", usermail=" + usermail + "]";
    }

}
