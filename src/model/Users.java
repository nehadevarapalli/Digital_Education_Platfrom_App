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


public class Users {
  
  private static ArrayList<User> users = new ArrayList<>();

    public static void setUsers(ArrayList<User> users) {
        Users.users = users;
    }

  public ArrayList<User> getUsers() {
    return users;
  }

  public void add(User user) {
    users.add(user);
  }
   public void delete(User user) {
    users.remove(user);
  }
    public void update(int userId,User user) {
    users.set(userId, user);
  }
  
}


