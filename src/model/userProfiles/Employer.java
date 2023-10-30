/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.userProfiles;

import java.util.ArrayList;
import model.Job;
import model.person.Person;

/**
 *
 * @author arnav
 */
public class Employer {
    private Person person;
    private String name;
    private String description;
    private ArrayList<Job> jobOfferings;

    public Employer() {
        jobOfferings = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
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

    public ArrayList<Job> getJobOfferings() {
        return jobOfferings;
    }

    public void setJobOfferings(ArrayList<Job> jobOfferings) {
        this.jobOfferings = jobOfferings;
    }
    
}
