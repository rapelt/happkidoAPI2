package happkidoAPI.users;

import happkidoAPI.feedback.Feedback;
import happkidoAPI.grade.Grade;
import happkidoAPI.gradingHistory.GradingHistory;
import org.springframework.data.annotation.Id;

public class User {
    @Id private String id;

    private String firstName;
    private String lastName;
    private String username;
    private boolean isAdmin;
    private boolean isFirstLogin;
    private Grade grade;
    private String [] attendance;
    private GradingHistory [] grades;
    private Feedback[] feedback;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isFirstLogin() {
        return isFirstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        isFirstLogin = firstLogin;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getAttendance() {
        return attendance;
    }

    public void setAttendance(String[] attendance) {
        this.attendance = attendance;
    }

    public GradingHistory[] getGrades() {
        return grades;
    }

    public void setGrades(GradingHistory[] grades) {
        this.grades = grades;
    }

    public Feedback[] getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback[] feedback) {
        this.feedback = feedback;
    }
}