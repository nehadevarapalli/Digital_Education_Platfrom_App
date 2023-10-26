/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Person.Persons;
import java.util.HashMap;

/**
 *
 * @author arnav
 */
public class Analytics {
   
    Persons persons = new Persons();
    Courses courses = new Courses();

  public Analytics() {
  }
  
  //Add prof review, course review, course region, students region, get degre
  
  public HashMap<String, Integer> getAnalytics() {
      HashMap<String, Integer> hashMap = new HashMap<>();
      hashMap.put("Persons", persons.getPersons().size());
      hashMap.put("Courses", courses.getCourses().size());
      return hashMap;
  }
    
}
