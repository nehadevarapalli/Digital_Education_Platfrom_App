/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.userProfiles;

import model.person.Person;

/**
 *
 * @author arnav
 */
public class Professor {
    public String speciality;
    public String qualifications;
    public int yearsOfExperience;
    public int rating;
    public Person person;

    public Person getPerson() {
        return person;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
      @Override
    public String toString() {
        return "Professor{" +
                "speciality='" + speciality + '\'' +
                ", qualifications='" + qualifications + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", rating=" + rating +
                ", person=" + person +
                '}';
    }
}
