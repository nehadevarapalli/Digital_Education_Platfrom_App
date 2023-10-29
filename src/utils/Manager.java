package utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Course;
import model.Courses;
import model.Degree;
import model.Job;
import model.person.Person;
import model.person.Persons;
import model.userProfiles.Employer;
import model.userProfiles.Employers;
import model.userProfiles.Professor;
import model.userProfiles.Professors;
import model.userProfiles.Student;
import model.userProfiles.Students;

public class Manager {

    private final Persons persons = new Persons();
    private final Courses courses = new Courses();
    private final Students students = new Students();
    private final Professors professors = new Professors();
    private HashMap<String, Degree> degreeOfferings = new HashMap<String, Degree>();
    private Employers employerList = new Employers();

    public Employers populateEmployers() {
        // Create and add employers with job listings
        for (int i = 1; i <= 5; i++) {
            Employer employer = new Employer();
            employer.setName("Employer " + i);
            employer.setDescription("Description for Employer " + i);

            // Create and add 5 job listings for each employer
            for (int j = 1; j <= 5; j++) {
                Job job = new Job();
                job.setName("Job " + j);
                job.setDescription("Description for Job " + j);
                job.setType("Job Type " + j);
                job.setPayPerHour(50 + (j * 10)); // Vary the pay rate

                employer.getJobOfferings().add(job);
            }

            employerList.getEmployers().add(employer);
        }
        return employerList;
    }

    public void populateDegrees() {
        Degree degree1 = new Degree();
        degree1.setName("MSIS");

        Course course1 = new Course();
        course1.setCode(101);
        course1.setName("Introduction to Computer Science");
        course1.setInstructor("Prof. Smith");
        course1.setSchedule("Mon, Wed, Fri 10:00 AM - 11:30 AM");
        course1.setLanguage("Java");
        course1.setDesc("This course provides an introduction to the fundamentals of computer science, including algorithms, data structures, and programming.");
        course1.setReview(4);
        course1.setCredits(3);
        course1.setGrade("A");
        course1.setSemester("Fall 23");

        Course course2 = new Course();
        course2.setCode(102);
        course2.setName("Data Structures and Algorithms");
        course2.setInstructor("Prof. Johnson");
        course2.setSchedule("Tue, Thu 1:00 PM - 2:30 PM");
        course2.setLanguage("Java");
        course2.setDesc("This course builds on the basics of computer science and delves deeper into data structures and algorithms.");
        course2.setReview(4);
        course2.setCredits(4);
        course2.setGrade("B+");
        course2.setSemester("Fall 23");

        Course course3 = new Course();
        course3.setCode(103);
        course3.setName("Web Development Fundamentals");
        course3.setInstructor("Prof. Davis");
        course3.setSchedule("Mon, Wed 3:00 PM - 4:30 PM");
        course3.setLanguage("HTML, CSS, JavaScript");
        course3.setDesc("Learn the basics of web development, including HTML, CSS, and JavaScript.");
        course3.setReview(4);
        course3.setCredits(3);
        course3.setGrade("B");
        course3.setSemester("Fall 23");

        Course course4 = new Course();
        course4.setCode(104);
        course4.setName("Introduction to Python");
        course4.setInstructor("Prof. Martinez");
        course4.setSchedule("Tue, Thu 10:00 AM - 11:30 AM");
        course4.setLanguage("Python");
        course4.setDesc("An introductory course to Python programming language.");
        course4.setReview(4);
        course4.setCredits(3);
        course4.setGrade("A-");
        course4.setSemester("Fall 23");

        Course course5 = new Course();
        course5.setCode(101);
        course5.setName("Introduction to Computer Science");
        course5.setInstructor("Prof. Adams");
        course5.setSchedule("Tue, Thu 10:00 AM - 11:30 AM");
        course5.setLanguage("Java");
        course5.setDesc("This course provides an introduction to the fundamentals of computer science, including algorithms, data structures, and programming.");
        course5.setReview(4);
        course5.setCredits(3);
        course5.setGrade("A");
        course5.setSemester("Fall 23");

        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);
        courseList.add(course4);
        courseList.add(course5);

        degree1.setCourseRequirement(courseList);

        degreeOfferings.put("MSIS", degree1);
        degreeOfferings.put("MSCS", degree1);
        degreeOfferings.put("MSDS", degree1);
    }

    private Person createPerson(String name, String country, String email, boolean enabled, String gender, String password, String username, String role) {
        if (isValidEmail(email) && isValidUsername(username) && isValidPassword(password)) {
            Person person = new Person();
            person.setName(name);
            person.setCountry(country);
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
//            JOptionPane.showMessageDialog(null, "Person created");
            return person;
        } else {
//            JOptionPane.showMessageDialog(null, "Invalid email format.");
            return null;
        }
    }

    private Person updatePerson(Person person, String name, String country,String email, boolean enabled, String gender, String password, String username) {
        if (isValidEmail(email)) {
            person.setName(name);
            person.setCountry(country);
            person.setEnabled(enabled);
            person.setGender(gender);
            person.setEmail(email);
            String hashedPassword = hashPassword(person, password);
            ArrayList<String> hashedPasswordList = new ArrayList<>();
            hashedPasswordList.add(hashedPassword);
            person.setHashedPassword(hashedPasswordList);
            person.setUsername(username);
            persons.update(person.getpId(), person);
//            JOptionPane.showMessageDialog(null, "Person updated");
            return person;
        } else {
//            JOptionPane.showMessageDialog(null, "Invalid email");
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
//        JOptionPane.showMessageDialog(null, "Course created");
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
//        JOptionPane.showMessageDialog(null, "Course updated");
        return course;
    }

    public boolean deleteCourse(int code) {
        ArrayList<Course> coursesList = courses.getCourses();
        Course courseR = coursesList.get(code);
        return coursesList.remove(courseR);
//        JOptionPane.showMessageDialog(null, "Course deleted");
    }

    public Student createStudent(String name, String country, String email, boolean enabled, String gender, String password, String username, String selectedDegree) {
        if (isValidEmail(email) && isValidUsername(username) && isValidPassword(password)) {
            Person person = createPerson(name, country, email, enabled, gender, password, username, "student");
            Student student = new Student();
            student.setPerson(person);
            student.setSelectedDegree(degreeOfferings.get(selectedDegree));
            students.add(student);
//            JOptionPane.showMessageDialog(null, "Student created");
            return student;
        } else {
//            JOptionPane.showMessageDialog(null, "Invalid email format.");
            return null;
        }
    }

    public Student updateStudent(Student student, String name, String country, String email, boolean enabled, String gender, String password, String username, String selectedDegree) {
        Person updatedPerson = updatePerson(student.getPerson(), name, country, email, enabled, gender, password, username);
        if (updatedPerson != null) {
            student.setPerson(updatedPerson);
            student.setSelectedDegree(degreeOfferings.get(selectedDegree));
            students.update(student.getPerson().getpId(), student);
//            JOptionPane.showMessageDialog(null, "Student updated");
            return student;
        } else {
//            JOptionPane.showMessageDialog(null, "Error updating student information");
            return null;
        }
    }

    public boolean deleteStudent(int studentId) {
        ArrayList<Student> studentsList = students.getStudents();
        Student student = studentsList.get(studentId);
        return studentsList.remove(student);
//        JOptionPane.showMessageDialog(null, "Student deleted");
    }

    public Professor createProfessor(String name, String country, String email, boolean enabled, String gender, String password, String username, String speciality, String qualifications, int yearsOfExperience, int rating) {
        if (isValidEmail(email) && isValidUsername(username) && isValidPassword(password)) {
            Person person = createPerson(name, country, email, enabled, gender, password, username, "professor");
            Professor professor = new Professor();
            professor.setPerson(person);
            professor.setSpeciality(speciality);
            professor.setQualifications(qualifications);
            professor.setYearsOfExperience(yearsOfExperience);
            professor.setRating(rating);
            professors.add(professor);
//            JOptionPane.showMessageDialog(null, "Professor created");
            return professor;
        } else {
//            JOptionPane.showMessageDialog(null, "Invalid email format.");
            return null;
        }
    }

    public Professor updateProfessor(Professor professor, String name, String country, String email, boolean enabled, String gender, String password, String username, String speciality, String qualifications, int yearsOfExperience, int rating) {
        Person updatedPerson = updatePerson(professor.getPerson(), name, country, email, enabled, gender, password, username);
        if (updatedPerson != null) {
            professor.setPerson(updatedPerson);
            professor.setSpeciality(speciality);
            professor.setQualifications(qualifications);
            professor.setYearsOfExperience(yearsOfExperience);
            professor.setRating(rating);
            professors.update(professor.getPerson().getpId(), professor);
//            JOptionPane.showMessageDialog(null, "Professor updated");
            return professor;
        } else {
//            JOptionPane.showMessageDialog(null, "Error updating professor information");
            return null;
        }
    }

    public boolean deleteProfessor(int professorId) {
        ArrayList<Professor> professorsList = professors.getProfessors();
        Professor professor = professorsList.get(professorId);
        return professorsList.remove(professor);
//        JOptionPane.showMessageDialog(null, "Professor deleted");
    }

    private boolean containsAdmin() {
        for (Person person : persons.getPersons()) {
            if (person.getUsername() != null && person.getUsername().equals("admin")) {
                return true;
            }
        }
        return false;
    }

    public Object login(String username, String password) {
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
//                    JOptionPane.showMessageDialog(null, "Login successful.");
                    if (person.getRole() == "student") {
                        for (Student s : students.getStudents()) {
                            if (s.getPerson().equals(person)) {
                                return s;
                            }
                        }
                    } else if (person.getRole() == "professor") {
                        for (Professor p : professors.getProfessors()) {
                            if (p.getPerson().equals(person)) {
                                return p;
                            }
                        }
                    }
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
