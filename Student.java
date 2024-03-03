package isp.lab6.exercise1;
import java.util.ArrayList;
import java.util.HashMap;

public class Student {

    private String name;
    private int id;
    private HashMap<String, Integer> grades;
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades=new HashMap<String, Integer>();   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public HashMap<String, Integer> getGrades() {
        return grades;
    }

    public void addGrade(String subject ,int grade) {
        grades.put(subject,grade);
    }
    public void removeGrade(String subject){
        grades.remove(subject);
    }
    public String toString() {
        return "Name: " + this.name + ", ID: " + this.id + ", Grades: " + this.grades;
    }

    public double calculateAverageGrade() {
        double sum = 0;
        int count = 0;
        for (int grade : grades.values()) {
            sum += grade;
            count++;
        }
        return sum / count;
    }


            }
