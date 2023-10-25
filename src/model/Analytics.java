/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.HashMap;

/**
 *
 * @author arnav
 */
public class Analytics {
    
    Users users;
    Persons persons;
    Courses courses;

  public Analytics() {
   users = new Users();
   persons = new Persons();
   courses = new Courses();
  }
  
  //Add prof review, course review, course region, students region, get degre
  
  public HashMap<String, Integer> getAnalytics() {
      HashMap<String, Integer> hashMap = new HashMap<>();
      hashMap.put("Persons", persons.getPersons().size());
      hashMap.put("Courses", courses.getCourses().size());
      hashMap.put("Users", users.getUsers().size());
      return hashMap;
  }
    
}
