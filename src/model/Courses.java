
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
public class Courses {

    final private ArrayList<Course> courses;

    public Courses() {
        this.courses = new ArrayList<>();
//    populateCourses();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void add(Course course) {
        courses.add(course);
    }

    public void delete(Course course) {
        courses.remove(course);
    }

    public void update(int code, Course course) {
        courses.set(code, course);
    }
}
