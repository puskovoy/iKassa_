package com.iKassa.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQuery(name = "USER.getAll", query = "SELECT c from User c")
public class User extends Model {

    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "login", length = 50)
    private String login;
    @Column(name = "addres", length = 50)
    private String addres;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
