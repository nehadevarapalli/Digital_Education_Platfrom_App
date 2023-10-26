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

public class Manager {

    private final Persons persons = new Persons();
    private final Courses courses = new Courses();
    private final Students students = new Students();
    private final Professors professors = new Professors();

    private Person createPerson(String email, boolean enabled, String gender, String password, String username, String role) {
        if (isValidEmail(email) && isValidUsername(username) && isValidPassword(password)) {
            Person person = new Person();
            person.setEmail(email);
            person.setEnabled(enabled);
            person.setGender(gender);
            person.setRole(role);
            String hashedPassword = hashPassword(person, password);
            ArrayList<String> hashedPasswordList = new ArrayList<>();
            hashedPasswordList.add(hashedPassword);
            person.setHashedPassword(hashedPasswordList);
            person.setUsername(username);
            person.setpId(persons.getPersons().size());
            persons.getPersons().add(person);
            JOptionPane.showMessageDialog(null, "Person created");
            return person;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid email format.");
            return null;
        }
    }

    private Person updatePerson(Person person, String email, boolean enabled, String gender, String password, String username) {
        if (isValidEmail(email)) {
            person.setEnabled(enabled);
            person.setGender(gender);
            person.setEmail(email);
            String hashedPassword = hashPassword(person, password);
            ArrayList<String> hashedPasswordList = new ArrayList<>();
            hashedPasswordList.add(hashedPassword);
            person.setHashedPassword(hashedPasswordList);
            person.setUsername(username);
            persons.update(person.getpId(), person);
            JOptionPane.showMessageDialog(null, "Person updated");
            return person;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid email");
            return null;
        }
    }

    public Course createCourse(int credits, String desc, String instructor, String lang, String name, String schedule, String semester) {
        Course course = new Course();
        course.setCode(courses.getCourses().size());
        course.setCredits(credits);
        course.setDesc(desc);
        course.setInstructor(instructor);
        course.setLanguage(lang);
        course.setName(name);
        course.setSchedule(schedule);
        course.setSemester(semester);
        courses.add(course);
        JOptionPane.showMessageDialog(null, "Course created");
        return course;
    }

    public Course updateCourse(Course course, int credits, String desc, String instructor, String lang, String name, String schedule, String semester) {
        course.setCredits(credits);
        course.setDesc(desc);
        course.setInstructor(instructor);
        course.setLanguage(lang);
        course.setName(name);
        course.setSemester(semester);
        course.setSchedule(schedule);
        courses.getCourses().set(course.getCode(), course);
        JOptionPane.showMessageDialog(null, "Course updated");
        return course;
    }

    public void deleteCourse(int code) {
        ArrayList<Course> coursesList = courses.getCourses();
        Course courseR = coursesList.get(code);
        coursesList.remove(courseR);
        JOptionPane.showMessageDialog(null, "Course deleted");
    }

    public Student createStudent(String email, boolean enabled, String gender, String password, String username, String selectedDegree) {
        if (isValidEmail(email) && isValidUsername(username) && isValidPassword(password)) {
            Person person = createPerson(email, enabled, gender, password, username, "student");
            Student student = new Student();
            student.setPerson(person);
            student.setSelectedDegree(selectedDegree);
            Transcript transcript = new Transcript();
            student.setTranscript(transcript);
            students.add(student);
            JOptionPane.showMessageDialog(null, "Student created");
            return student;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid email format.");
            return null;
        }
    }

    public Student updateStudent(Student student, String email, boolean enabled, String gender, String password, String username, String selectedDegree) {
        Person updatedPerson = updatePerson(student.getPerson(), email, enabled, gender, password, username);
        if (updatedPerson != null) {
            student.setPerson(updatedPerson);
            student.setSelectedDegree(selectedDegree);
            students.update(student.getPerson().getpId(), student);
            JOptionPane.showMessageDialog(null, "Student updated");
            return student;
        } else {
            JOptionPane.showMessageDialog(null, "Error updating student information");
            return null;
        }
    }

    public void deleteStudent(int studentId) {
        ArrayList<Student> studentsList = students.getStudents();
        Student student = studentsList.get(studentId);
        studentsList.remove(student);
        JOptionPane.showMessageDialog(null, "Student deleted");
    }

    public Professor createProfessor(String email, boolean enabled, String gender, String password, String username, String speciality, String qualifications, int yearsOfExperience, int rating) {
        if (isValidEmail(email) && isValidUsername(username) && isValidPassword(password)) {
            Person person = createPerson(email, enabled, gender, password, username, "professor");
            Professor professor = new Professor();
            professor.setPerson(person);
            professor.setSpeciality(speciality);
            professor.setQualifications(qualifications);
            professor.setYearsOfExperience(yearsOfExperience);
            professor.setRating(rating);
            professors.add(professor);
            JOptionPane.showMessageDialog(null, "Professor created");
            return professor;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid email format.");
            return null;
        }
    }

    public Professor updateProfessor(Professor professor, String email, boolean enabled, String gender, String password, String username, String speciality, String qualifications, int yearsOfExperience, int rating) {
        Person updatedPerson = updatePerson(professor.getPerson(), email, enabled, gender, password, username);
        if (updatedPerson != null) {
            professor.setPerson(updatedPerson);
            professor.setSpeciality(speciality);
            professor.setQualifications(qualifications);
            professor.setYearsOfExperience(yearsOfExperience);
            professor.setRating(rating);
            professors.update(professor.getPerson().getpId(), professor);
            JOptionPane.showMessageDialog(null, "Professor updated");
            return professor;
        } else {
            JOptionPane.showMessageDialog(null, "Error updating professor information");
            return null;
        }
    }

    public void deleteProfessor(int professorId) {
        ArrayList<Professor> professorsList = professors.getProfessors();
        Professor professor = professorsList.get(professorId);
        professorsList.remove(professor);
        JOptionPane.showMessageDialog(null, "Professor deleted");
    }

    private boolean containsAdmin() {
        for (Person person : persons.getPersons()) {
            if (person.getUsername() != null && person.getUsername().equals("admin")) {
                return true;
            }
        }
        return false;
    }

    public Person login(String username, String password) {
        if (!containsAdmin()) {
            Person admin = new Person();
            admin.setUsername("admin");
            ArrayList<String> hashedPasswordList = new ArrayList<>();
            hashedPasswordList.add(hashPassword(admin, "admin"));
            admin.setHashedPassword(hashedPasswordList);
            admin.setpId(10000);
            admin.setEnabled(true);
            persons.add(admin);
        }
        for (Person person : persons.getPersons()) {
            if (person.isEnabled() && person.getUsername().equals(username)) {
                if (checkPassword(person, password)) {
                    JOptionPane.showMessageDialog(null, "Login successful.");
                    return person;
                }
            }
        }
        return null;
    }

    private String hashPassword(Person user, String password) {
        try {
            if (user.getSalt() == null) {
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
            return hashedInputString.equals(user.getHashedPassword().get(user.getHashedPassword().size() - 1));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error validating password", e);
        }
    }

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
