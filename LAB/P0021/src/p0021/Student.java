/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0021;

public class Student implements Comparable<Student> {
    private String id;
    private String studentName;
    private int semester;
    private String courseName;


    public Student() {
    }

    public Student(String id, String studentName, int semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSemester() {
        return this.semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Student id(String id) {
        setId(id);
        return this;
    }

    public Student studentName(String studentName) {
        setStudentName(studentName);
        return this;
    }

    public Student semester(int semester) {
        setSemester(semester);
        return this;
    }

    public Student courseName(String courseName) {
        setCourseName(courseName);
        return this;
    }

    public void displayAll() {
        System.out.printf("%-10s%-15s%-15s%-15s\n", id , studentName, semester, courseName);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", studentName='" + getStudentName() + "'" +
            ", semester='" + getSemester() + "'" +
            ", courseName='" + getCourseName() + "'" +
            "}";
    }

    @Override
    public int compareTo(Student o) {
        return this.studentName.compareToIgnoreCase(o.studentName);
    }

}
