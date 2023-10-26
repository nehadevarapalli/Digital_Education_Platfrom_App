/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author arnav
 */

public class Manager {

    Student user = new Student();
    Students users = new Students();
    Course course = new Course();
    CourseCatalog courses = new CourseCatalog();
    Persons persons = new Persons();
//    
//  //TODO
//  //any other course present in degree then swap course list and user will have to take more courses for degree completion
////  public void swapDegree(User user) {
////   ArrayList<Course> coursesL = user.getCourses();
////   for(int i = 0; i<= coursesL.size(); i++) {
////      if(coursesL[i].code == 
////     HashMap<String, ArrayList<Integer>> hashMap = degree.hashMap.get(user.getCourses());
////    
////  }
//  
// 
//     public void createPerson(String email) {
//    if(isValidEmail(email)) {
//    Student st = new Student();
//    Person person = new Person();
//    person.setEmail(email);
//    person.setpId(persons.getPersons().size());
//    st.setPerson(person);
//    //st.setp(users.getStudents().size());
//    //users.add(st);
//    persons.add(person); 
//     JOptionPane.showMessageDialog(null, "Person created");
//    } else {
//     JOptionPane.showMessageDialog(null, "Invalid email format.");   
//    }
//  }
//
//    public void createCourse(int credits, String desc,String instructor,String lang,String name,String outcomes, String schedule) {
//      course.setCode(courses.getCourses().size()+1);
//      course.setCredits(credits);
//      course.setDesc(desc);
//      course.setInstructor(instructor);
//      course.setLanguage(lang);
//      course.setName(name);
//      course.setOutcomes(outcomes);
//      course.setSchedule(schedule);
//      courses.add(course);
//      JOptionPane.showMessageDialog(null, "Course created");
//  }
//    
//     public void updateCourse(Course course) {
//      ArrayList<Course> coursesL = courses.getCourses();
//      coursesL.set(course.getCode(), course);
//      JOptionPane.showMessageDialog(null, "Course updated");
//  }
//    
//     public void deleteCourse(int code) {
//      ArrayList<Course> coursesL = courses.getCourses();
//      Course courseR = coursesL.get(code);
//      coursesL.remove(courseR);
//      JOptionPane.showMessageDialog(null, "Course updated");
//  }
//     
//    public void registerCourse(Student st,Course course) {
//      ArrayList<Course> coursesL = st.getCourses();
//      coursesL.add(course);
//      st.setCourses(coursesL);
//      JOptionPane.showMessageDialog(null, "Registered for course");
//  }
//    
//    public void deRegisterCourse(Student st,Course course) {
//      ArrayList<Course> coursesL = st.getCourses();
//      coursesL.remove(course);
//      st.setCourses(coursesL);
//      JOptionPane.showMessageDialog(null, "De-Registered for course");
//  }
//    
//   public void createUser(String username, String plaintextPassword, boolean enabled, String role, String email,User user) {
//    if (isValidUsername(username) && isValidPassword(plaintextPassword)) {
//      String hashedPassword = hashPassword(user,plaintextPassword);
//      user.setUsername(username);
//      user.setEnabled(enabled);
//      user.setRole(role);
//        ArrayList<String> hashedPasswordL = new ArrayList<>();
//        hashedPasswordL.add(hashedPassword);
//        user.setHashedPasswordL(hashedPasswordL);
//          users.update(user.getUserId(), user);
//          JOptionPane.showMessageDialog(null, "User account created");
//    } else {
//      JOptionPane.showMessageDialog(null, "Invalid username or password format.");
//    }
//  }
//   
//   public void updateUser(Student user, String username, String plaintextPassword, String enabled, String role, String email) {
//    if (isValidUsername(username) && isValidPassword(plaintextPassword) && isValidEmail(email)) {
//        Person person = user.getPerson();
//        String hashedPassword = hashPassword(user, plaintextPassword);
//        user.setUsername(username);
//        person.setEmail(email);
//        user.setPerson(person);
//        user.setEnabled(enabled.equals("Y"));
//        user.setRole(role);
//        ArrayList<String> hashedPasswordL = user.getHashedPasswordL();
//       if (hashedPasswordL.contains(hashedPassword)) {
//            JOptionPane.showMessageDialog(null, "Cannot use previously used password");
//        } else {
//            hashedPasswordL.add(hashedPassword);
//            user.setHashedPasswordL(hashedPasswordL);
//            users.update(user.getUserId(), user);
//       JOptionPane.showMessageDialog(null, "User details updated");
//        }  
//    } else {
//        JOptionPane.showMessageDialog(null, "Invalid username, password, or email format.");
//    }
//}
//
//   
//  public void updatePerson(Person person, String email) {
//    if (isValidEmail(email)) {
//      person.setEmail(email);
//      persons.update(person.getNuId(), person);
//    } else {
//      JOptionPane.showMessageDialog(null, "Invalid email");
//    }
//  }
//  
//  public void deletePerson(User user) {
//    Person person = user.getPerson();
//    persons.delete(person);
//  }
//  
//  public void deleteUser(User user) {
//    users.delete(user);
//  }
//
//  public boolean containsAdmin() {
//    ArrayList<User> usersL = users.getUsers();
//    for (User user : usersL) {
//        if(user.getUsername() != null)
//        if (user.getUsername().equals("admin")) {
//            return true; 
//        }
//    }
//    return false; 
//}
//  public User login(String username, String password) { 
//    if (!containsAdmin()) {
//       User admin = new User();
//          admin.setRole("admin");
//          admin.setUsername("admin");
//          ArrayList<String> hashedPasswordL = new ArrayList<>();
//          hashedPasswordL.add(hashPassword(admin,"admin"));
//          admin.setHashedPasswordL(hashedPasswordL);
//          admin.setUserId(10000);
//          admin.setEnabled(true);
//          Person person = new Person();
//          person.setEmail("admin@admin.com");
//          person.setNuId(10000);
//          admin.setPerson(person);
//          users.add(admin);
//        } 
//    ArrayList<User> usersL = users.getUsers();
//    for (User user : usersL) {
//        if (user.isEnabled() && user.getUsername().equals(username)) {
//            if (checkPassword(user, password)) {
//                JOptionPane.showMessageDialog(null, "Login successful.");
//                return user;
//            }
//        } 
//    }
//    
//    return null;
//}
//
//
//  private String hashPassword(User user, String password) {
//    try {
//        if(user.getSalt() == null) {
//            SecureRandom random = new SecureRandom();
//            byte[] salt = new byte[16];
//            random.nextBytes(salt);
//            user.setSalt(salt);
//        }
//
//        MessageDigest md = MessageDigest.getInstance("SHA-512");
//        md.update(user.getSalt());
//        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
//
//        return new String(hashedPassword, StandardCharsets.UTF_16);
//    } catch (NoSuchAlgorithmException e) {
//        throw new RuntimeException("Error hashing password", e);
//    }
//}
//
//
//  private boolean checkPassword(User user, String password) {
//    try {
//      MessageDigest md = MessageDigest.getInstance("SHA-512");
//      md.update(user.getSalt());
//      byte[] hashedInput = md.digest(password.getBytes(StandardCharsets.UTF_8));
//      String hashedInputString = new String(hashedInput, StandardCharsets.UTF_16);
//      return hashedInputString.equals(user.getHashedPasswordL().get(user.getHashedPasswordL().size()-1));
//    } catch (NoSuchAlgorithmException e) {
//      throw new RuntimeException("Error validating password", e);
//    }    
//  }

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

}