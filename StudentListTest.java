/*  Course Name: HDDS1103 Object-oriented Programming
    Student Name: Chan Man Chun (Leo), Chan Kwing Tung Jevons, Lo Tze Kit (Kit), To Ho Hin (Herman)
    Student ID: 22661204, 22661077, 22661085, 22661026
*/

public class StudentListTest {
    StudentList studentListTest = new StudentList();
    /**
     * 
     * @param args
     * 
     */
    public static void main(String[] args) {
        StudentListTest test = new StudentListTest();
        test.addStudentTest();

        test.getStudentByIdTest();

        test.printStudentListTest();

        test.toStringTest();
    }
    /**
     * Test 
     * 
     */
    void addStudentTest(){
        boolean test_case_1 = studentListTest.addStudent(new Student("student_1", 123465));
        boolean test_case_2 = studentListTest.addStudent(new Student("student_2", 123465));
        
        System.out.println("Test case 1 Expected Result: true. \n\t\tReceived: " + test_case_1);
        System.out.println("Test case 2 Expected Result: false. \n\t\tReceived: " + test_case_2);
        System.out.println("\n");
        
        if(test_case_1 && !test_case_2){
            System.out.println("Add Student Test passed!");
        }
        else{
            System.out.println("Add Student Test failed!");
        }
    }
    void getStudentByIdTest(){
        Student test_case_1 = studentListTest.getStudentById(123465);
        Student test_case_2 = studentListTest.getStudentById(567890);
        
        Student test_case_1_expected = StudentList.studentList.get(0);
        Student test_case_2_expected = null;
        
        System.out.println("Test case 1 Expected Result: "+ test_case_1_expected + ". \n\tReceived: " + test_case_1);
        System.out.println("Test case 2 Expected Result: "+ test_case_2_expected + ". \n\tReceived: " + test_case_2);
        System.out.println("\n");

        if (test_case_1.equals(test_case_1_expected) &&
        test_case_2 == test_case_2_expected)
        {
            System.out.println("Get Student By ID Test passed!");
        } 
        else{
            System.out.println("Get Student By ID Test passed!");
        }
    }
    void printStudentListTest(){
        String expected = "Name: student_1     UserID: 123465     Attendance: unknown\n";
        String returned = studentListTest.printStudentList();
        
        System.out.println("Expected Result: " + expected + "\n\tReceived: " + returned);
        System.out.println("\n");

        if (expected.equalsIgnoreCase(returned)){
            System.out.println("Print Student List Test passed!");
        }else{           
            System.out.println("Print Student List Test failed!");
        }
    }
    void toStringTest(){
        String expected_toString = "Student List has 1 student(s).";
        String returned_toString = studentListTest.toString();
        
        System.out.println("Expected Result: " + expected_toString + "\n\tReceived: " + returned_toString);
        System.out.println("\n");
        
        if(expected_toString.equals(returned_toString)){
            System.out.println("To String Test passed!");
        }else{
            System.out.println("To String Test failed!");
        }
    }
}
