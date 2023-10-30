/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.userProfiles;

import java.util.ArrayList;
import model.Course;
import model.person.Person;

/**
 *
 * @author arnav
 */
public class Professor {

    private String speciality;
    private String qualifications;
    private int yearsOfExperience;
    private float rating;
    private int ratingCount;
    private Person person;
    private ArrayList<Course> courseOfferings;

    public Professor() {
        courseOfferings = new ArrayList<>();
    }

    public Person getPerson() {
        return person;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }
    
    public void addRating(int newRating) {
        ratingCount++;
        rating = (rating + newRating)/ratingCount;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public ArrayList<Course> getCourseOfferings() {
        return courseOfferings;
    }

    public void setCourseOfferings(ArrayList<Course> courseOfferings) {
        this.courseOfferings = courseOfferings;
    }

    public Course addCourse() {
        Course c = new Course();
        courseOfferings.add(c);
        return c;
    }

    public boolean removeCourse(String name) {
        for (Course c : courseOfferings) {
            if (c.getName().equals(name)) {
                courseOfferings.remove(c);
                return true;
            }
        }
        return false;
    }

//    public boolean updateCourse(String name, Course newCourse) {
//        for (Course c: courseOfferings) {
//            if (c.getName().equals(name)) {
//                courseOfferings.add(newCourse);
//                newCourse.setRegisteredStudents(c.getRegisteredStudents());
//                courseOfferings.remove(c);
//                return true;
//            }
//        }
//        return false;
//    }
    
    public String display() {
        return "Professor{"
                + "speciality='" + speciality + '\''
                + ", qualifications='" + qualifications + '\''
                + ", yearsOfExperience=" + yearsOfExperience
                + ", rating=" + rating
                + ", person=" + person
                + '}';
    }
    @Override
    public String toString() {
        return person.getName();
    }
}
