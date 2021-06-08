package p0021;

public class Report {
    private String studentName;
    private String courseName;
    private int totalCourse;


    public Report() {
    }

    public Report(String studentName, String courseName, int totalCourse) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse() {
        return this.totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    public Report studentName(String studentName) {
        setStudentName(studentName);
        return this;
    }

    public Report courseName(String courseName) {
        setCourseName(courseName);
        return this;
    }

    public Report totalCourse(int totalCourse) {
        setTotalCourse(totalCourse);
        return this;
    }
    public void displayReport(){
        System.out.printf("%-15s|%-10s|%-5d\n", getStudentName(),getCourseName(), getTotalCourse());
    }
    @Override
    public String toString() {
        return "{" +
            " studentName='" + getStudentName() + "'" +
            ", courseName='" + getCourseName() + "'" +
            ", totalCourse='" + getTotalCourse() + "'" +
            "}";
    }

}
