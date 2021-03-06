package com.revature.model;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {


    private Role role;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Integer id;


    // need default constructor for json to class
    public User(){}
    public User(Role role, String username, int id){
        this.role = role;
        this.username = username;
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getPassword() {return password;}

    public User setPassword(String password) {this.password = password; return this;}

    public String getFirstName() {return firstName;}

    public User setFirstName(String firstName) {this.firstName = firstName; return this;}

    public String getLastName() {return lastName;}

    public User setLastName(String lastName) {this.lastName = lastName; return this;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return role == user.role && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, username, password, firstName, lastName, id);
    }

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}
