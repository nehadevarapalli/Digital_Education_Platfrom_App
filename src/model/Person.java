/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author arnav
 */
public class Person {

    private String username;
    private String gender;
    private boolean enabled;
    private String email;
    private int pId;
    private byte[] salt;
    private ArrayList<String> hashedPassword;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public ArrayList<String> getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(ArrayList<String> hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
  
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", enabled=" + enabled +
                ", email='" + email + '\'' +
                ", pId=" + pId +
                ", hashedPassword=" + hashedPassword +
                '}';
    }
    
}

