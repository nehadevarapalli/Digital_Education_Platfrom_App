package model;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author arnav
 */
public class Student {

    private Person person;
    private Degree selectedDegree;
    private HashMap<Course, String> transcript;

    public HashMap<Course, String> getTranscript() {
        return transcript;
    }

    public void setTranscript(HashMap<Course, String> transcript) {
        this.transcript = transcript;
    }

    public Degree getSelectedDegree() {
        return selectedDegree;
    }

    public void setSelectedDegree(Degree selectedDegree) {
        this.selectedDegree = selectedDegree;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
      
  @Override
    public String toString() {
        return "Student{" +
                "person=" + person +
                ", selectedDegree='" + selectedDegree + '\'' +
                ", transcript=" + transcript +
                '}';
    }

}
