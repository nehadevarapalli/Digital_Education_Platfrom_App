/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author arnav
 */
import model.userProfiles.Student;
import java.util.ArrayList;
import java.util.HashMap;

public class Degree {

    private String name;
    private ArrayList<Course> courseRequirement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Course> getCourseRequirement() {
        return courseRequirement;
    }

    public void setCourseRequirement(ArrayList<Course> courseRequirement) {
        this.courseRequirement = courseRequirement;
    }

    public boolean audit(Student s) {
        int relevantCourses = 0;
        for (HashMap.Entry<Course, String> a : s.getTranscript().entrySet()) {
            if (courseRequirement.contains(a.getKey()) && !a.getValue().equals("TBA")) {
                relevantCourses++;
            }
        }
        return relevantCourses >= 8;
    }

    public int switchDegree(Student s, Degree newDegree, boolean preview) {
        int relevantCourses = 0;
        HashMap<Course, String> assignedCourses = s.getTranscript();
        for (HashMap.Entry<Course, String> a : s.getTranscript().entrySet()) {
            if (newDegree.getCourseRequirement().contains(a.getKey()) && !a.getValue().equals("TBA")) {
                relevantCourses++;
            }
        }
        if (!preview) {
            s.setSelectedDegree(newDegree);
        }
        return relevantCourses;
    }
    
}
