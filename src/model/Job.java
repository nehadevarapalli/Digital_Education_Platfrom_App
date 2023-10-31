/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import model.userProfiles.Student;

/**
 *
 * @author ashishnevan
 */
public class Job {
    private String name;
    private String description;
    private String type;
    private float payPerHour;
    private ArrayList<Student> appliedStudents;
    
    public Job() {
        appliedStudents = new ArrayList<>();
    }

    public ArrayList<Student> getAppliedStudents() {
        return appliedStudents;
    }

    public void setAppliedStudents(ArrayList<Student> appliedStudents) {
        this.appliedStudents = appliedStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(float payPerHour) {
        this.payPerHour = payPerHour;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
