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
   
    Persons persons;
    CourseCatalog courses;

  public Analytics() {
   persons = new Persons();
   courses = new CourseCatalog();
  }
  
  //Add prof review, course review, course region, students region, get degre
  
  public HashMap<String, Integer> getAnalytics() {
      HashMap<String, Integer> hashMap = new HashMap<>();
      hashMap.put("Persons", persons.getPersons().size());
      hashMap.put("Courses", courses.getCourses().size());
      return hashMap;
  }
    
}
