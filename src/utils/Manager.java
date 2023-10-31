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
import model.userProfiles.Admin;
import model.userProfiles.Employer;
import model.userProfiles.Employers;
import model.userProfiles.Professor;
import model.userProfiles.Professors;
import model.userProfiles.Student;
import model.userProfiles.Students;

public class Manager {

    private Persons persons;
    private Courses courses;
    private Students students;
    private HashMap<String, Degree> degreeOfferings;
    private Employers employers;
    private Professors professors;
    private ArrayList<Admin> admins;
    private String[] profs;
    private String[] genders;

    public Manager() {
        this.profs = "Smith,Johnson,Davis,Martinez,Smith,Rodriguez,Williams,Anderson,Miller,Wilson".split(",");
        this.genders = "Male,Female".split(",");
        persons = new Persons();
        courses = new Courses();
        students = new Students();
        degreeOfferings = new HashMap<>();
        professors = new Professors();
        employers = new Employers();
        admins = new ArrayList<Admin>();
    }

    public HashMap<String, Degree> getDegreeOfferings() {
        return degreeOfferings;
    }

    public void setDegreeOfferings(HashMap<String, Degree> degreeOfferings) {
        this.degreeOfferings = degreeOfferings;
    }

    public Professors getProfessors() {
        return professors;
    }

    public void setProfessors(Professors professors) {
        this.professors = professors;
    }

    public Employers getEmployers() {
        return employers;
    }

    public void setEmployers(Employers employers) {
        this.employers = employers;
    }

    public void populateProfessors() {
        for (int i = 0; i < 10; i++) {
            Professor p = this.createProfessor(profs[i], "USA", profs[i] + "@gmail.com", true, genders[i % 2], "Professor@" + i, "professor" + i, "MSIS", "PHD", i + 1, 0);
            ArrayList<Course> courseList = populateCourses();
            p.setCourseOfferings(new ArrayList<>(courseList.subList(i * 2, (i * 2) + 2)));
        }
    }

    public void populateEmployers() {
        // Create and add employers with job listings
        for (int i = 0; i < 5; i++) {
            Employer employer = new Employer();
            Person p = createPerson("emp" + i, "USA", "emp" + i + "@gmail.com", true, "Male", "Employer@" + i, "employer" + i, "employer");
            employer.setName("Employer " + i);
            employer.setDescription("Description for Employer " + i);
            employer.setPerson(p);

            // Create and add 5 job listings for each employer
            for (int j = 1; j <= 5; j++) {
                Job job = new Job();
                job.setName("Job " + j);
                job.setDescription("Description for Job " + j);
                job.setType("Job Type " + j);
                job.setPayPerHour(50 + (j * 10)); // Vary the pay rate

                employer.getJobOfferings().add(job);
            }

            employers.getEmployers().add(employer);
        }
    }

    private ArrayList<Course> populateCourses() {
        ArrayList<Course> courseList = new ArrayList<>();

        Course course1 = new Course();
        course1.setCode(101);
        course1.setName("Introduction to Computer Science");
        course1.setSchedule("Mon, Wed, Fri 10:00 AM - 11:30 AM");
        course1.setLanguage("Java");
        course1.setDesc("This course provides an introduction to the fundamentals of computer science, including algorithms, data structures, and programming.");
        course1.setCredits(3);
        course1.setSemester("Fall 23");

        Course course2 = new Course();
        course2.setCode(102);
        course2.setName("Data Structures and Algorithms");
        course2.setSchedule("Tue, Thu 1:00 PM - 2:30 PM");
        course2.setLanguage("Java");
        course2.setDesc("This course builds on the basics of computer science and delves deeper into data structures and algorithms.");
        course2.setCredits(4);
        course2.setSemester("Fall 23");

        Course course3 = new Course();
        course3.setCode(103);
        course3.setName("Web Development Fundamentals");
        course3.setSchedule("Mon, Wed 3:00 PM - 4:30 PM");
        course3.setLanguage("HTML, CSS, JavaScript");
        course3.setDesc("Learn the basics of web development, including HTML, CSS, and JavaScript.");
        course3.setCredits(3);
        course3.setSemester("Fall 23");

        Course course4 = new Course();
        course4.setCode(104);
        course4.setName("Introduction to Python");
        course4.setSchedule("Tue, Thu 10:00 AM - 11:30 AM");
        course4.setLanguage("Python");
        course4.setDesc("An introductory course to Python programming language.");
        course4.setCredits(3);
        course4.setSemester("Fall 23");

        Course course5 = new Course();
        course5.setCode(105);
        course5.setName("Machine Learning Fundamentals");
        course5.setSchedule("Mon, Wed 2:00 PM - 3:30 PM");
        course5.setLanguage("Python");
        course5.setDesc("Explore the basics of machine learning and data analysis using Python.");
        course5.setCredits(4);
        course5.setSemester("Fall 23");

        Course course6 = new Course();
        course6.setCode(103);
        course6.setName("Database Management Systems");
        course6.setSchedule("Wed, Fri 3:00 PM - 4:30 PM");
        course6.setLanguage("SQL");
        course3.setDesc("Learn the fundamentals of database design and management using SQL.");
        course6.setCredits(4);
        course6.setSemester("Fall 23");

        Course course7 = new Course();
        course7.setCode(107);
        course7.setName("Digital Marketing Strategy");
        course7.setSchedule("Mon, Wed 11:30 AM - 1:00 PM");
        course7.setLanguage("N/A");
        course7.setDesc("Develop effective digital marketing strategies to promote products and services online.");
        course7.setCredits(3);
        course7.setSemester("Fall 23");

        Course course8 = new Course();
        course8.setCode(108);
        course8.setName("Ethical Hacking and Cybersecurity");
        course8.setSchedule("Tue, Thu 2:30 PM - 4:00 PM");
        course8.setLanguage("N/A");
        course8.setDesc("Explore the techniques and tools used in ethical hacking and cybersecurity.");
        course8.setCredits(4);
        course8.setSemester("Fall 23");

        Course course9 = new Course();
        course9.setCode(109);
        course9.setName("Artificial Intelligence and Robotics");
        course9.setSchedule("Wed, Fri 1:30 PM - 3:00 PM");
        course9.setLanguage("Python, C++");
        course9.setDesc("Study artificial intelligence and robotics, including computer vision and autonomous systems.");
        course9.setCredits(4);
        course9.setSemester("Fall 23");

        Course course10 = new Course();
        course10.setCode(110);
        course10.setName("Data Analytics with R");
        course10.setSchedule("Mon, Wed 4:30 PM - 6:00 PM");
        course10.setLanguage("R");
        course10.setDesc("Analyze and visualize data using the R programming language for data analytics.");
        course10.setCredits(3);
        course10.setSemester("Fall 23");

        Course course11 = new Course();
        course11.setCode(111);
        course11.setName("Mobile App Development");
        course11.setSchedule("Tue, Thu 10:30 AM - 12:00 PM");
        course11.setLanguage("Java, Swift");
        course11.setDesc("Learn to develop mobile applications for both Android and iOS platforms.");
        course11.setCredits(4);
        course11.setSemester("Fall 23");

        Course course12 = new Course();
        course12.setCode(112);
        course12.setName("Business Management Fundamentals");
        course12.setSchedule("Mon, Wed 2:30 PM - 4:00 PM");
        course12.setLanguage("N/A");
        course12.setDesc("Introduction to core business management concepts and principles.");
        course12.setCredits(3);
        course12.setSemester("Fall 23");

        Course course13 = new Course();
        course13.setCode(101);
        course13.setName("Introduction to Programming");
        course13.setSchedule("Mon, Wed 10:00 AM - 11:30 AM");
        course13.setLanguage("Python");
        course13.setDesc("An introductory course for programming beginners, teaching the basics of Python.");
        course13.setCredits(3);
        course13.setSemester("Fall 23");

        Course course14 = new Course();
        course14.setCode(102);
        course14.setName("Data Structures and Algorithms");
        course14.setSchedule("Tue, Thu 1:00 PM - 2:30 PM");
        course14.setLanguage("Java");
        course14.setDesc("This course builds on the basics of computer science and delves deeper into data structures and algorithms.");
        course14.setCredits(4);
        course14.setSemester("Fall 23");

        Course course15 = new Course();
        course15.setCode(103);
        course15.setName("Database Management Systems");
        course15.setSchedule("Wed, Fri 3:00 PM - 4:30 PM");
        course15.setLanguage("SQL");
        course15.setDesc("Learn the fundamentals of database design and management using SQL.");
        course15.setCredits(4);
        course15.setSemester("Fall 23");

        Course course16 = new Course();
        course16.setCode(105);
        course16.setName("Machine Learning Fundamentals");
        course16.setSchedule("Mon, Wed 2:00 PM - 3:30 PM");
        course16.setLanguage("Python");
        course16.setDesc("Explore the basics of machine learning and data analysis using Python.");
        course16.setCredits(4);
        course16.setSemester("Fall 23");

        Course course17 = new Course();
        course17.setCode(205);
        course17.setName("Big Data Analytics");
        course17.setSchedule("Mon, Wed 3:30 PM - 5:00 PM");
        course17.setLanguage("Hadoop, Spark");
        course17.setDesc("Learn to work with big data and perform analytics on large datasets.");
        course17.setCredits(4);
        course17.setSemester("Fall 23");

        Course course18 = new Course();
        course18.setCode(206);
        course18.setName("Data Mining and Pattern Recognition");
        course18.setSchedule("Tue, Thu 10:00 AM - 11:30 AM");
        course18.setLanguage("Python, Weka");
        course18.setDesc("Explore data mining techniques and pattern recognition in data.");
        course18.setCredits(3);
        course18.setSemester("Fall 23");

        Course course19 = new Course();
        course19.setCode(207);
        course19.setName("Deep Learning for Data Science");
        course19.setSchedule("Mon, Wed 1:00 PM - 2:30 PM");
        course19.setLanguage("Python, TensorFlow");
        course19.setDesc("Dive into deep learning concepts and applications for data science.");
        course19.setCredits(4);
        course19.setSemester("Fall 23");

        Course course20 = new Course();
        course20.setCode(208);
        course20.setName("Data Science Capstone Project");
        course20.setSchedule("Flexible (Independent Study)");
        course20.setLanguage("Python, R");
        course20.setDesc("Apply your data science skills to a real-world project in this capstone course.");
        course20.setCredits(4);
        course20.setSemester("Fall 23");

        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);
        courseList.add(course4);
        courseList.add(course5);
        courseList.add(course6);
        courseList.add(course7);
        courseList.add(course8);
        courseList.add(course9);
        courseList.add(course10);
        courseList.add(course11);
        courseList.add(course12);
        courseList.add(course13);
        courseList.add(course14);
        courseList.add(course15);
        courseList.add(course16);
        courseList.add(course17);
        courseList.add(course18);
        courseList.add(course19);
        courseList.add(course20);

        return courseList;
    }

    public void populateDegrees() {
        Degree degree1 = new Degree();
        degree1.setName("MSIS");
        degree1.setCourseRequirement(new ArrayList<>(populateCourses().subList(0, 8)));

        Degree degree2 = new Degree();
        degree2.setName("MSCS");
        ArrayList<Course> req2 = new ArrayList<Course>(populateCourses().subList(0, 4));
        req2.addAll(populateCourses().subList(6, 10));
        degree2.setCourseRequirement(req2);

        Degree degree3 = new Degree();
        degree3.setName("MSDS");
        ArrayList<Course> req3 = new ArrayList<Course>(populateCourses().subList(0, 4));
        req3.addAll(populateCourses().subList(10, 14));
        degree2.setCourseRequirement(req3);

        degreeOfferings.put("MSIS", degree1);
        degreeOfferings.put("MSCS", degree2);
        degreeOfferings.put("MSDS", degree3);
    }

    public Person createPerson(String name, String country, String email, boolean enabled, String gender, String password, String username, String role) {
        if (isValidEmail(email) && isValidUsername(username) && isValidPassword(password)) {
            Person person = new Person();
            person.setName(name);
            person.setCountry(country);
            person.setEmail(email);
            person.setEnabled(enabled);
            person.setGender(gender);
            person.setRole(role);
            String hashedPassword = hashPassword(person.getSalt(), password);

            person.setCurrentHashedPassword(hashedPassword);
            person.setUsername(username);
            person.setpId(persons.getPersons().size());
            persons.getPersons().add(person);
            return person;
        } else {
            return null;
        }
    }

    private Person updatePerson(Person person, String name, String country, String email, boolean enabled, String gender, String password, String username) {
        if (isValidEmail(email)) {
            person.setName(name);
            person.setCountry(country);
            person.setEnabled(enabled);
            person.setGender(gender);
            person.setEmail(email);
            String hashedPassword = hashPassword(person.getSalt(), password);
            person.setCurrentHashedPassword(hashedPassword);
            person.setUsername(username);
            persons.update(person.getpId(), person);
            return person;
        } else {
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
        return course;
    }

    public boolean deleteCourse(int code) {
        ArrayList<Course> coursesList = courses.getCourses();
        Course courseR = coursesList.get(code);
        return coursesList.remove(courseR);
    }

    public Student createStudent(String name, String country, String email, boolean enabled, String gender, String password, String username, String selectedDegree) {
        if (isValidEmail(email) && isValidUsername(username) && isValidPassword(password)) {
            Person person = createPerson(name, country, email, enabled, gender, password, username, "student");
            Student student = new Student();
            student.setPerson(person);
            student.setSelectedDegree(degreeOfferings.get(selectedDegree));
            students.add(student);
            return student;
        } else {
            return null;
        }
    }

    public Student updateStudent(Student student, String name, String country, String email, boolean enabled, String gender, String password, String username, String selectedDegree) {
        Person updatedPerson = updatePerson(student.getPerson(), name, country, email, enabled, gender, password, username);
        if (updatedPerson != null) {
            student.setPerson(updatedPerson);
            student.setSelectedDegree(degreeOfferings.get(selectedDegree));
            students.update(student.getPerson().getpId(), student);
            return student;
        } else {
            return null;
        }
    }

    public boolean deleteStudent(int studentId) {
        ArrayList<Student> studentsList = students.getStudents();
        Student student = studentsList.get(studentId);
        return studentsList.remove(student);
    }

    public Professor createProfessor(String name, String country, String email, boolean enabled, String gender, String password, String username, String speciality, String qualifications, int yearsOfExperience, int rating) {
        if (isValidEmail(email) && isValidUsername(username) && isValidPassword(password)) {
            Person person = createPerson(name, country, email, enabled, gender, password, username, "professor");
            Professor professor = new Professor();
            professor.setPerson(person);
            professor.setSpeciality(speciality);
            professor.setQualifications(qualifications);
            professor.setYearsOfExperience(yearsOfExperience);
            professor.setRating((float) rating);
            professors.add(professor);
            return professor;
        } else {
            return null;
        }
    }

    public Admin createAdmin(String username, String password) {
        Person p = createPerson("admin", "admin", "admin@admin.com", true, "admin ", password, username, "admin");
        Admin admin = new Admin();
        admin.setPerson(p);
        admins.add(admin);
        return admin;
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
            return professor;
        } else {
            return null;
        }
    }

    public boolean deleteProfessor(int professorId) {
        ArrayList<Professor> professorsList = professors.getProfessors();
        Professor professor = professorsList.get(professorId);
        return professorsList.remove(professor);
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
            hashedPasswordList.add(hashPassword(admin.getSalt(), "admin"));
            admin.setHashedPassword(hashedPasswordList);
            admin.setpId(10000);
            admin.setEnabled(true);
            persons.add(admin);
        }
        for (Person person : persons.getPersons()) {
            if (person.isEnabled() && person.getUsername().equals(username)) {
                if (person.getCurrentHashedPassword().equals(hashPassword(person.getSalt(), password))) {
                    switch (person.getRole()) {
                        case "student":
                            for (Student s : students.getStudents()) {
                                if (s.getPerson().equals(person)) {
                                    return s;
                                }
                            }
                            break;
                        case "professor":
                            for (Professor p : professors.getProfessors()) {
                                if (p.getPerson().equals(person)) {
                                    return p;
                                }
                            }
                            break;
                        case "employer":
                            for (Employer p : employers.getEmployers()) {
                                if (p.getPerson().equals(person)) {
                                    return p;
                                }
                            }
                            break;
                        case "admin":
                            for (Admin p : admins) {
                                if (p.getPerson().equals(person)) {
                                    return p;
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return null;
    }

    public String hashPassword(byte[] salt, String password) {
        try {
            if (salt == null) {
                SecureRandom random = new SecureRandom();
                salt = new byte[16];
                random.nextBytes(salt);
//                user.setSalt(salt);
            }

            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

            return new String(hashedPassword, StandardCharsets.UTF_16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public boolean isValidUsername(String username) {
        return username.matches("[a-zA-Z0-9_]+");
    }

    public boolean isValidPassword(String password) {
        // Password validation criteria (e.g., minimum 8 characters, containing letters, numbers, and special characters)
        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&*!])[A-Za-z\\d@#$%^&*!]{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
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
    
    public Students getStudents() {
        return students;
    }

}
