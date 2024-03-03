package isp.lab6.exercise1;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class TestExercise1 {

    ArrayList<Student> students = new ArrayList<Student>();

    @Test
        public void TestAddStudents(){

            Student student=new Student("Deniz", 14);
            students.add(student);
            int actual = students.get(0).getId();
            int expected=14;
            assertEquals(expected,actual);
        }

    @Test
    public void TestRemoveStudents(){

        Student student=new Student("Deniz", 14);
        students.add(student);             // student added
        boolean test=students.isEmpty();        // the array list is not empty now so it should print out "false"
        System.out.println(test);
        students.remove(student);           // student removed
        boolean actual=students.isEmpty();      // the array list is now empty
        boolean expected=true;                  // so we expect to return true
        assertEquals(expected,actual);
    }

    @Test
    public void TestUpdateInformation(){

        Student student=new Student("Deniz", 14);
        students.add(student);
        System.out.println("The name of the student just added is : " + students.get(0).getName());
        students.get(0).setName("Obama");   // updating name
        String actual= students.get(0).getName();
        String expected="Obama";
        System.out.println("The name of the updated student is : " + students.get(0).getName());
        assertEquals(expected,actual);
    }


    @Test
    public void TestAverageGrade(){

        Student student= new Student("Deniz", 14);
        student.addGrade("Ts1", 5);
        student.addGrade("Java", 7);
        student.addGrade("English", 9);
        double actual=student.calculateAverageGrade();
        double expected=7;
        System.out.println("The average grade is : " + actual);
        assertEquals(expected,actual,0.01);



    }

}
