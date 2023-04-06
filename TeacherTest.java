/*  Course Name: HDDS1103 Object-oriented Programming
    Student Name: Chan Man Chun (Leo), Chan Kwing Tung Jevons, Lo Tze Kit (Kit), To Ho Hin (Herman)
    Student ID: 22661204, 22661077, 22661085, 22661026
*/
public class TeacherTest {
    
    static StudentList studentList = new StudentList();
    static Teacher teacher = new Teacher("test_1", 41230531);
    public static void main(String[] args) {
        TeacherTest test = new TeacherTest();
        
        test.addStudentTest();
        test.printStudentListTest();
        
        test.removeStudentTest();
        test.takeAttendanceTest();
        System.out.println(StudentList.studentList.size());
        test.setAbsentTest();
        test.setPresentTest();
        test.toStringTest();
        test.convertToSecondsTest();
        test.getStudentByIdTest();
    }
    /**
     * Test about {@code addStudent} method in 
     */
    void addStudentTest(){
        System.out.println("-----Add Student Test-----");
        Student stu1 = new Student("one", 0);
        stu1.attendanceTime(1, 1, 3);
        boolean returned_1 = teacher.addStudent(stu1); // true
        
        Student stu2 = new Student("two", 0);
        stu2.attendanceTime(4, 5, 6);
        boolean returned_2 = teacher.addStudent(stu2); // false
        
        Student stu3 = new Student("three", 2);
        stu3.attendanceTime(11, 0, 0);
        boolean returned_3 = teacher.addStudent(stu3); // true
        
        Student stu4 = new Student("four", 3);
        stu4.attendanceTime(15, 15, 20);
        boolean returned_4 = teacher.addStudent(stu4); // true
        
        boolean expected_1 = true;
        boolean expected_2 = false;
        boolean expected_3 = true;
        boolean expected_4 = true;
        
        System.out.println("\nExpected: " + expected_1 + ".\nReceived: " + returned_1 + ".");
        System.out.println("Expected: " + expected_2 + ".\nReceived: " + returned_2 + ".");
        System.out.println("Expected: " + expected_3 + ".\nReceived: " + returned_3 + ".");
        System.out.println("Expected: " + expected_4 + ".\nReceived: " + returned_4 + ".\n");
        
        if(expected_1 == returned_1 &&
        expected_2 == returned_2 &&
        expected_3 == returned_3 && 
        expected_4 == returned_4)
        {
            System.out.println("Add Student Test passed!");
        }else{
            System.out.println("Add Student Test failed!");
        }
    }
    
    void removeStudentTest(){
        System.out.println("-----Remove Student Test-----");
        int ID = 2;
        String expected_1 = "Student with ID 2 removed";
        String returned_1 =  teacher.removeStudent(ID);
        
        ID = 4;
        String expected_2 = "Student not found.";
        String returned_2 =  teacher.removeStudent(ID);
        
        System.out.println("\nExpected: " + expected_1 + ".\nReceived: " + returned_1 );
        System.out.println("Expected: " + expected_2 + ".\nReceived: " + returned_2 );
        
        if(expected_1.equals(returned_1) && expected_2.equals(returned_2)){
            System.out.println("Remove Student Test passed!");
        }else {   
            System.out.println("Remove Student Test failed!");
        }
    }
    
    void printStudentListTest(){
        System.out.println("-----Print Student Test-----");
        String expected = "0: Name: one     UserID: 0     Attendance: Waiting for teacher's confirmation\n1: Name: three     UserID: 2     Attendance: Waiting for teacher's confirmation\n2: Name: four     UserID: 3     Attendance: Waiting for teacher's confirmation\n";
        String returned = teacher.printStudentList();
        
        System.out.println("Expected: " + expected + "\nReceived: " + returned);
        
        if(expected.equals(returned)){
            System.out.println("Print Student List Test passed!");
        }else{
            System.out.println("Print Student List Test failed!");
        }
    }
    
    void takeAttendanceTest(){
        System.out.println("-----Take Attendance Test-----");
        
        String returned_1 = teacher.takeAttendance(24, 20, 30);
        String returned_2 = teacher.takeAttendance(0, 1, 1);
        String returned_3 = teacher.takeAttendance(10, 20, 30);
        
        String expected_1 = "Unable to update.\n";
        String expected_2 = "Student with ID 0 is late.\nStudent with ID 3 is late.\n";
        String expected_3 = "Student with ID 0 is present.\nStudent with ID 3 is late.\n";
        
        System.out.println("Expected: " + expected_1 + "\nReceived: " + returned_1 + "\n");
        System.out.println("Expected: " + expected_2 + "\nReceived: " + returned_2 + "\n");
        System.out.println("Expected: " + expected_3 + "\nReceived: " + returned_3 + "\n");
        
        // System.out.println(returned_1);
        if (returned_1.equals(expected_1) && returned_2.equals(expected_2) && returned_3.equals(expected_3)) {
            System.out.println("Teacher Take Attendance Test passed!");
        } else {
            System.out.println("Teacher Take Attendance Test failed!");
        }
        
    }
    void setPresentTest(){
        System.out.println("-----Set Present Test-----");

        boolean returned_1 = teacher.setPresent(3);
        boolean returned_2 = teacher.setAbsent(5);
        
        boolean expected_1 = true;
        boolean expected_2 = false;

        System.out.println("Expected: " + expected_1 + "\nReceived: " + returned_1 + "\n");
        System.out.println("Expected: " + expected_2 + "\nReceived: " + returned_2 + "\n");
        
        if (expected_1 == returned_1 && expected_2 == returned_2) {
            System.out.println("Set Absent Test passed!");
        } else {
            System.out.println("Set Absent Test failed!");            
        }
    }
    void setAbsentTest(){
        System.out.println("-----Set Absent Test-----");
    
        boolean returned_1 = teacher.setAbsent(0);
        boolean returned_2 = teacher.setAbsent(5);
        
        boolean expected_1 = true;
        boolean expected_2 = false;
        
        System.out.println("Expected: " + expected_1 + "\nReceived: " + returned_1 + "\n");
        System.out.println("Expected: " + expected_2 + "\nReceived: " + returned_2 + "\n");
        
        if (expected_1 == returned_1 && expected_2 == returned_2) {
            System.out.println("Set Absent Test passed!");
        } else {
            System.out.println("Set Absent Test failed!");            
        }
    }
    
    void convertToSecondsTest(){
        System.out.println("-----Convert to Seconds Test-----");

        int expected_1 = -1;
        int expected_2 = 39001;
        
        int returned_1 = teacher.convertToSeconds(0,60,1);
        int returned_2 = teacher.convertToSeconds(10,50,1);
        
        System.out.println("Expected value: " + expected_1 + "\nReceived: " + returned_1);
        System.out.println("Expected value: " + expected_2 + "\nReceived: " + returned_2); 
        
        if(expected_1 == returned_1 && expected_2 == returned_2){
            System.out.println("Convert to Seconds Test passed!");
        }
        else{
            System.out.println("Convert to Seconds Test failed!");
        }
    }
    void getStudentByIdTest(){
        System.out.println("-----Get Student By ID Test-----");

        String expected_1 = "Student found: Name: four ID: 3";
        String expected_2 = "Student NOT found.";
        
        String returned_1 = teacher.getStudentById(3);
        String returned_2 = teacher.getStudentById(5);
        
        System.out.println("Expected return: " + expected_1 + "\nReceived: " + returned_1);
        System.out.println("Expected return: " + expected_2 + "\nReceived: " + returned_2);
        
        if (expected_1.equals(returned_1) && expected_2.equals(returned_2)) {
            System.out.println("Get Student Test passed!");
        } else {
            System.out.println("Get Student Test failed!");            
        }
    }   
    void toStringTest(){
        System.out.println("-----To String Test-----");

        String teacher_String = teacher.toString();
        
        String teacher_expected = "Teacher Name: test_1 UserID: 41230531";
        
        System.out.println("Expected: " + teacher_expected + "\nReceived: " + teacher_String);
        
        if (teacher_String.equals(teacher_expected)){
            System.out.println("To String Test passed!");                
        }
        else{
            System.out.println("To String Test failed!");
        }
    }
}
