
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
        populateCourses();
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

    public final void populateCourses() {
        Course course1 = new Course();
        course1.setCode(101);
        course1.setName("Introduction to Computer Science");
        course1.setInstructor("Prof. Smith");
        course1.setSchedule("Mon, Wed, Fri 10:00 AM - 11:30 AM");
        course1.setLanguage("Java");
        course1.setDesc("This course provides an introduction to the fundamentals of computer science, including algorithms, data structures, and programming.");
        course1.setReview(4);
        course1.setCredits(3);
        course1.setGrade("A");
        course1.setSemester("Fall 23");

        Course course2 = new Course();
        course2.setCode(102);
        course2.setName("Data Structures and Algorithms");
        course2.setInstructor("Prof. Johnson");
        course2.setSchedule("Tue, Thu 1:00 PM - 2:30 PM");
        course2.setLanguage("Java");
        course2.setDesc("This course builds on the basics of computer science and delves deeper into data structures and algorithms.");
        course2.setReview(4);
        course2.setCredits(4);
        course2.setGrade("B+");
        course2.setSemester("Fall 23");

        Course course3 = new Course();
        course3.setCode(103);
        course3.setName("Web Development Fundamentals");
        course3.setInstructor("Prof. Davis");
        course3.setSchedule("Mon, Wed 3:00 PM - 4:30 PM");
        course3.setLanguage("HTML, CSS, JavaScript");
        course3.setDesc("Learn the basics of web development, including HTML, CSS, and JavaScript.");
        course3.setReview(4);
        course3.setCredits(3);
        course3.setGrade("B");
        course3.setSemester("Fall 23");

        Course course4 = new Course();
        course4.setCode(104);
        course4.setName("Introduction to Python");
        course4.setInstructor("Prof. Martinez");
        course4.setSchedule("Tue, Thu 10:00 AM - 11:30 AM");
        course4.setLanguage("Python");
        course4.setDesc("An introductory course to Python programming language.");
        course4.setReview(4);
        course4.setCredits(3);
        course4.setGrade("A-");
        course4.setSemester("Fall 23");

        Course course5 = new Course();
        course5.setCode(101);
        course5.setName("Introduction to Computer Science");
        course5.setInstructor("Prof. Adams");
        course5.setSchedule("Tue, Thu 10:00 AM - 11:30 AM");
        course5.setLanguage("Java");
        course5.setDesc("This course provides an introduction to the fundamentals of computer science, including algorithms, data structures, and programming.");
        course5.setReview(4);
        course5.setCredits(3);
        course5.setGrade("A");
        course5.setSemester("Fall 23");
    }
}
