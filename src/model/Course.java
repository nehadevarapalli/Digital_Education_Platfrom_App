/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author arnav
 */
public class Course {
    
    private int code;
    private String name;
    private String instructor;
    private String schedule;
    private String language;
    private String desc;
    private int review;
    private int credits;
    private String outcomes;
    private String grade;

//     public Course(int code, String name, String instructor, String schedule, String language, String desc,
//                  int review, int credits, String outcomes, String grade) {
//        this.code = code;
//        this.name = name;
//        this.instructor = instructor;
//        this.schedule = schedule;
//        this.language = language;
//        this.desc = desc;
//        this.review = review;
//        this.credits = credits;
//        this.outcomes = outcomes;
//        this.grade = grade;
//    }
     
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(String outcomes) {
        this.outcomes = outcomes;
    }
   
}
