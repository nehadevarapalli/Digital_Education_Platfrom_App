/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.Course;
import model.Courses;
import model.Person;
import model.Persons;
import model.Professor;
import model.Professors;
import model.Student;
import model.Students;
import model.Transcript;

/**
 *
 * @author arnav
 */

public class Manager {

    Students students = new Students();
    Courses courses = new Courses();
    Persons persons = new Persons();
    Professors professors = new Professors();
   
 //Person functions
    public Person createPerson(String email,boolean enabled,String gender,String password,String username) {
    if(isValidEmail(email) && isValidUsername(username) && isValidPassword(password)) {
    Person person = new Person();
    ArrayList<Person> personsL = persons.getPersons();
    person.setEmail(email);
    person.setEnabled(enabled);
    person.setGender(gender);
    ArrayList<String> hashedPasswordL = new ArrayList<>();
   String hashedPassword = hashPassword(person,password);
     hashedPasswordL.add(hashedPassword);
    person.setHashedPassword(hashedPasswordL);
    person.setUsername(username);
    person.setpId(persons.getPersons().size());
    personsL.add(person);
    JOptionPane.showMessageDialog(null, "Person created");
    return person;
    } else {
     JOptionPane.showMessageDialog(null, "Invalid email format.");   
     return null;
    }
    }
    
  public Person updatePerson(Person person, String email,boolean enabled,String gender,String password,String username) {
    if (isValidEmail(email)) {
       person.setEnabled(enabled);
    person.setGender(gender);
     person.setEmail(email);
    String hashedPassword = hashPassword(person,password);
        ArrayList<String> hashedPasswordL = new ArrayList<>();
    hashedPasswordL.add(hashedPassword);
    person.setHashedPassword(hashedPasswordL);
    person.setUsername(username);
      persons.update(person.getpId(), person);
      JOptionPane.showMessageDialog(null, "Person updated"); 
        return person;
    } else {
      JOptionPane.showMessageDialog(null, "Invalid email");
      return null;
    }
  }
  
  //Course functions
  
    public Course createCourse(int credits, String desc,String instructor,String lang,String name, String schedule, String semester) {
      Course courseN = new Course();
      courseN.setCode(courses.getCourses().size());
      courseN.setCredits(credits);
      courseN.setDesc(desc);
      courseN.setInstructor(instructor);
      courseN.setLanguage(lang);
      courseN.setName(name);
      courseN.setSchedule(schedule);
      courseN.setSemester(semester);
      courses.add(courseN);
      JOptionPane.showMessageDialog(null, "Course created");
      return courseN;
  }
    
     public Course updateCourse(Course course,int credits, String desc,String instructor,String lang,String name, String schedule, String semester) {
      ArrayList<Course> coursesL = courses.getCourses();
      course.setCredits(credits);
      course.setDesc(desc);
      course.setInstructor(instructor);
      course.setLanguage(lang);
      course.setName(name);
      course.setSemester(semester);
      course.setSchedule(schedule);
      coursesL.set(course.getCode(), course);
      JOptionPane.showMessageDialog(null, "Course updated");
      return course;
  }
    
     public void deleteCourse(int code) {
      ArrayList<Course> coursesL = courses.getCourses();
      Course courseR = coursesL.get(code);
      coursesL.remove(courseR);
      JOptionPane.showMessageDialog(null, "Course deleted");
  }
     
 //Student functions
     // Student CRUD

public Student createStudent(String email, boolean enabled, String gender, String password, String username, String selectedDegree) {
    if (isValidEmail(email) && isValidUsername(username) && isValidPassword(password)) {
        Person person1 = createPerson(email, enabled, gender, password, username);
        Student student1 = new Student();
        student1.setPerson(person1);
        student1.setSelectedDegree(selectedDegree);
        Transcript transcript = new Transcript(); 
        student1.setTranscript(transcript);
        students.add(student1);
        JOptionPane.showMessageDialog(null, "Student created");
        return student1;
    } else {
        JOptionPane.showMessageDialog(null, "Invalid email format.");
        return null;
    }
}

public Student updateStudent(Student student, String email, boolean enabled, String gender, String password, String username, String selectedDegree) {
    if (isValidEmail(email)) {
        Person updatedPerson = updatePerson(student.getPerson(), email, enabled, gender, password, username);
        if (updatedPerson != null) {
            student.setPerson(updatedPerson);
            student.setSelectedDegree(selectedDegree);
            students.update(student.person.getpId(), student);
            JOptionPane.showMessageDialog(null, "Student updated");
            return student;
        } else {
            JOptionPane.showMessageDialog(null, "Error updating student information");
            return null;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Invalid email");
        return null;
    }
}

public void deleteStudent(int studentId) {
    ArrayList<Student> studentsList = students.getStudents();
    Student student1 = studentsList.get(studentId);
    studentsList.remove(student1);
    JOptionPane.showMessageDialog(null, "Student deleted");
}

// Professor CRUD

public Professor createProfessor(String email, boolean enabled, String gender, String password, String username, String speciality, String qualifications, int yearsOfExperience, int rating) {
    if (isValidEmail(email) && isValidUsername(username) && isValidPassword(password)) {
        Person person1 = createPerson(email, enabled, gender, password, username);
        Professor professor1 = new Professor();
        professor1.setPerson(person1);
        professor1.setSpeciality(speciality);
        professor1.setQualifications(qualifications);
        professor1.setYearsOfExperience(yearsOfExperience);
        professor1.setRating(rating);
        professors.add(professor1);
        JOptionPane.showMessageDialog(null, "Professor created");
        return professor1;
    } else {
        JOptionPane.showMessageDialog(null, "Invalid email format.");
        return null;
    }
}

public Professor updateProfessor(Professor professor, String email, boolean enabled, String gender, String password, String username, String speciality, String qualifications, int yearsOfExperience, int rating) {
    if (isValidEmail(email)) {
        Person updatedPerson = updatePerson(professor.getPerson(), email, enabled, gender, password, username);
        if (updatedPerson != null) {
            professor.setPerson(updatedPerson);
            professor.setSpeciality(speciality);
            professor.setQualifications(qualifications);
            professor.setYearsOfExperience(yearsOfExperience);
            professor.setRating(rating);
            professors.update(professor.person.getpId(), professor);
            JOptionPane.showMessageDialog(null, "Professor updated");
            return professor;
        } else {
            JOptionPane.showMessageDialog(null, "Error updating professor information");
            return null;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Invalid email");
        return null;
    }
}

public void deleteProfessor(int professorId) {
    ArrayList<Professor> professorsList = professors.getProfessors();
    Professor professor1 = professorsList.get(professorId);
    professorsList.remove(professor1);
    JOptionPane.showMessageDialog(null, "Professor deleted");
}


     //TODO - hashmap
//    public void registerCourse(Student st,Course course) {
//      ArrayList<Course> coursesL = st.getTranscript();
//      coursesL.add(course);
//      Transcript ts = st.getTranscript();
//      
//      JOptionPane.showMessageDialog(null, "Registered for course");
//  }
//    
//    public void deRegisterCourse(Student st,Course course) {
//      ArrayList<Course> coursesL = st
//      coursesL.remove(course);
//      st.setCourses(coursesL);
//      JOptionPane.showMessageDialog(null, "De-Registered for course");
//  }
      
    public boolean _containsAdmin() {
    ArrayList<Person> personL = persons.getPersons();
    for (Person person1 : personL) {
        if(person1.getUsername() != null)
        if (person1.getUsername().equals("admin")) {
            return true; 
        }
    }
    return false; 
}
    
  public Person login(String username, String password) { 
    if (!_containsAdmin()) {
       Person admin = new Person();
          admin.setUsername("admin");
          ArrayList<String> hashedPasswordL = new ArrayList<>();
          hashedPasswordL.add(hashPassword(admin,"admin"));
          admin.setHashedPassword(hashedPasswordL);
          admin.setpId(10000);
          admin.setEnabled(true);
          persons.add(admin);
        } 
    ArrayList<Person> personsL = persons.getPersons();
    for (Person person1 : personsL) {
        if (person1.isEnabled() && person1.getUsername().equals(username)) {
            if (checkPassword(person1, password)) {
                JOptionPane.showMessageDialog(null, "Login successful.");
                return person1;
            }
        } 
    }
    
    return null;
}
  
  private String hashPassword(Person user, String password) {
    try {
        if(user.getSalt() == null) {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            user.setSalt(salt);
        }

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(user.getSalt());
        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        return new String(hashedPassword, StandardCharsets.UTF_16);
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException("Error hashing password", e);
    }
}


  private boolean checkPassword(Person user, String password) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-512");
      md.update(user.getSalt());
      byte[] hashedInput = md.digest(password.getBytes(StandardCharsets.UTF_8));
      String hashedInputString = new String(hashedInput, StandardCharsets.UTF_16);
      return hashedInputString.equals(user.getHashedPassword().get(user.getHashedPassword().size()-1));
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Error validating password", e);
    }    
  }
  //Validators
  
  private boolean isValidUsername(String username) {
    return username.matches("[a-zA-Z0-9_]+");
  }

  private boolean isValidPassword(String password) {
    return password.length() >= 6;
  }

  private boolean isValidEmail(String email) {
    return email.matches("^(.+)@(.+)$"); 
  }
  
  public static ArrayList<String> extractDateTime(String schedule) {
        ArrayList<String> dateTimeList = new ArrayList<>();
        String regex = "(Sun|Mon|Tue|Wed|Thu|Fri|Sat), ([0-9]{1,2}:[0-9]{2} [APMapm]{2}) - ([0-9]{1,2}:[0-9]{2} [APMapm]{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(schedule);

        if (matcher.find()) {
            String day = matcher.group(1);
            String startTime = matcher.group(2);
            String endTime = matcher.group(3);
            dateTimeList.add(day);
            dateTimeList.add(startTime);
            dateTimeList.add(endTime);
        }

        return dateTimeList;
    }

    public void test() {
       Person person = createPerson("email@email.com",true,"Male","password","email");     
       Person updatedPerson = updatePerson(person,"email1@email.com",true,"Female","password1","email1");    
    }
    
}