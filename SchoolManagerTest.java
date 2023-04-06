/*  Course Name: HDDS1103 Object-oriented Programming
    Student Name: Chan Man Chun (Leo), Chan Kwing Tung Jevons, Lo Tze Kit (Kit), To Ho Hin (Herman)
    Student ID: 22661204, 22661077, 22661085, 22661026
*/
import java.util.Scanner;

public class SchoolManagerTest {

    Teacher t = new Teacher("Leo", 22661204);
    
    public static void main(String[] args) {
        // SchoolManager.main(args);
        
        System.out.println("Student Access Test started (without students in the list)");
        // String temp_input = "";
        // Scanner temp_scan = new Scanner(temp_input);
        // SchoolManager.REMOVE_STUDENT(temp_scan, 0);
        
        String temp_str = "";
        Scanner temp_scan = new Scanner(temp_str);
        // String expected_1 = "This is a student access.\nStudent list is empty. Please add a student first.\nStudent Access ended.";
        if (!SchoolManager.studentAccess(temp_scan)){
            System.out.println("\nStudent Access Test passed!");
        }
        System.out.println("\nTeacher Access Test started (without teacher in the list)");
        if (!SchoolManager.teacherAccess(temp_scan)){
            System.out.println("\nTeacher Access Test passed!");
        }


// 1: Add Student, 2: Remove Student, 3: Print Student List, 4: Take Attendance, 
// 5: Set Absent, 6: Get Student By Id, 7: Print Information, 0: terminate teacher access"

        SchoolManager schoolManager = new SchoolManager();

        String student_test_input = "5\n"+ "0\n"+ "1\n" + "10\n" + "60\n" + "10\n" + "11\n" + "0\n" + "10\n" +
                                    "2\n" +  
                                    "3\n" + "0\n";
        Scanner student_scan = new Scanner(student_test_input);
        if(SchoolManager.studentAccess(student_scan)){
            System.out.println("\nStudent Access Test passed!");
        }else{
            System.out.println("\nStudent Access Test failed!");
        }

        String teacher_test_input = "1\n" + "0\n" + "1\n" + "testing\n" + "123\n" + 
                                        "3\n" +  
                                        "4\n" + "23\n" + "60\n" + "40\n" + 
                                        "4\n" + "23\n" + "50\n" + "40\n" +
                                        "6\n" + "123465789\n"+
                                        "3\n" + 
                                        "7\n" + "123\n" + 
                                        "2\n" + "12\n" + 
                                        "3\n" + 
                                        "8\n" +  "0\n";
        Scanner teacher_scan = new Scanner(teacher_test_input);
            
        if (SchoolManager.teacherAccess(teacher_scan)){   
            System.out.println("Teacher Access Test passed!");
        }else{
            System.out.println("Teacher Access Test failed!");
        }
            

        String itManager_test_input = "1\n" + "testing\n" + "p\n" + "123\n" +
                                      "4\n" + 
                                      "3\n" + "one\n" + "1\n" + 
                                      "2\n" + "two\n" + "123465789\n" + 
                                      "5\n" + "test_1" + "three\n" + "4\n" + 
                                      "8\n" + 
                                      "7\n" + "41230530\n" + "41230531\n" + 
                                      "6\n" + "four\n" + "41230531\n" + 
                                      "0\n";
        Scanner itManager_scan = new Scanner(itManager_test_input);

        if(SchoolManager.itManagerAccess(itManager_scan)){
            System.out.println("IT Manager Access Test passed!");
        }
        else{
            System.out.println("IT Manager Access Test failed!");
        }
    }
    
}
