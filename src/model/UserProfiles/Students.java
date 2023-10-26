/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.UserProfiles;
import java.util.ArrayList;



/**
 *
 * @author arnav
 */


public class Students {
  
  private static ArrayList<Student> students = new ArrayList<>();

    public static void setStudents(ArrayList<Student> students) {
        Students.students = students;
    }

  public ArrayList<Student> getStudents() {
    return students;
  }

  public void add(Student student) {
    students.add(student);
  }
   public void delete(Student student) {
    students.remove(student);
  }
    public void update(int sId,Student student) {
    students.set(sId, student);
  }
  
}


