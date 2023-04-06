/*  Course Name: HDDS1103 Object-oriented Programming
    Student Name: Chan Man Chun (Leo), Chan Kwing Tung Jevons, Lo Tze Kit (Kit), To Ho Hin (Herman)
    Student ID: 22661204, 22661077, 22661085, 22661026
*/

public class StudentTest {
    
    static Student student_1 = new Student("student_1", 12345678);
    static Student student_2 = new Student("student_2", 23456789);
    static Student student_3 = new Student("student_3", 34567890);

/**
*
* @param args
* 
 */

    public static void main(String[] args) {
        StudentTest studentTest = new StudentTest();
        studentTest.attendanceTime();

        System.out.println("\n");
        studentTest.viewAttendanceTest();

        System.out.println("\n");
        studentTest.convertToSecondsTest();

        System.out.println("\n");
        studentTest.toStringTest();
    }
    void attendanceTime(){
        String student_1_time = student_1.attendanceTime(0,60,1); // Inappropriate hour/ minute/ seconds
        String student_2_time = student_2.attendanceTime(10, 12, 30); // 10:12:30
        String student_3_time = student_3.attendanceTime(23, 59, 60); // Inappropriate hour/ minute/ seconds
        
        String student_1_expected = "Inappropriate hour/ minute/ second.";
        String student_2_expected = "10:12:30 recorded";
        String student_3_expected = "Inappropriate hour/ minute/ second.";

        System.out.println("Student 1 Expected Result: Inappropriate hour/ minute/ second.\n\t\t Received: "+ student_1_time);
        System.out.println("Student 2 Expected Result: 10:12:30 \n\t\t Received: " + student_2_time);
        System.out.println("Student 3 Expected Result: Inappropriate hour/ minute/ second. \n\t\t Received: " + student_3_time);
        
        if(student_1_time.equals(student_1_expected) && student_2_time.equals(student_2_expected) && student_3_time.equals(student_3_expected)){
            System.out.println("Attendance Time Test passed!");
        }
        else{
            System.out.println("Attendance Time Test failed!");
        }
    }
    void viewAttendanceTest(){
        String student_1_attendance = student_1.viewAttendance();
        String student_2_attendance = student_2.viewAttendance();
        String student_3_attendance = student_3.viewAttendance();
        
        String student_1_expected = "student_1 ID: 12345678 Arrive Time: 0:0:0 Status: Unknown.";
        String student_2_expected = "student_2 ID: 23456789 Arrive Time: 10:12:30 Status: Waiting for teacher's confirmation.";
        String student_3_expected = "student_3 ID: 34567890 Arrive Time: 0:0:0 Status: Unknown.";

        System.out.println("Student 1 Expected Result: " + student_1_expected + "\n\t\t Received: " + student_1_attendance);
        System.out.println("Student 2 Expected Result: " + student_2_expected + "\n\t\t Received: " + student_2_attendance);
        System.out.println("Student 3 Expected Result: " + student_3_expected + "\n\t\t Received: " + student_3_attendance);
        
        if(student_1_attendance.equals(student_1_expected) && student_2_attendance.equals(student_2_expected) && student_3_attendance.equals(student_3_expected)){
            System.out.println("View Attendance Test passed!");
        }
        else{
            System.out.println("View Attendance Test failed!");
        }
    }
    
    void convertToSecondsTest(){
        int student_1_totalSeconds = student_1.convertToSeconds(0,60,1);
        int student_2_totalSeconds = student_2.convertToSeconds(10,12,30);
        int student_3_totalSeconds = student_3.convertToSeconds(23,59,60);
        
        int student_1_expectedTotalSeconds = 0;
        int student_2_expectedTotalSeconds = 36750;
        int student_3_expectedTotalSeconds = 0;
        
        System.out.println("Student 1 Expected Total Seconds: " + student_1_expectedTotalSeconds + "\n\t\t Received: " + student_1_totalSeconds);
        System.out.println("Student 2 Expected Total Seconds: " + student_2_expectedTotalSeconds + "\n\t\t Received: " + student_2_totalSeconds);
        System.out.println("Student 3 Expected Total Seconds: " + student_3_expectedTotalSeconds + "\n\t\t Received: " + student_3_totalSeconds);
        
        if(student_1_expectedTotalSeconds == student_1_totalSeconds &&
        student_2_expectedTotalSeconds == student_2_totalSeconds &&
        student_3_expectedTotalSeconds == student_3_totalSeconds)
        {
            System.out.println("Convert to Seconds Test passed!");
        }
        else{
            System.out.println("Convert to Seconds Test passed!");
        }
    }
    void toStringTest(){
        String student_1_String = student_1.toString();
        String student_2_String = student_2.toString();
        String student_3_String = student_3.toString();
        
        String student_1_expectedString = "Name: student_1 ID: 12345678";
        String student_2_expectedString = "Name: student_2 ID: 23456789";
        String student_3_expectedString = "Name: student_3 ID: 34567890";
        
        System.out.println("Student 1 Expected Total Seconds: " + student_1_expectedString + "\n\t\t\tReceived: " + student_1_String);
        System.out.println("Student 2 Expected Total Seconds: " + student_2_expectedString + "\n\t\t\tReceived: " + student_2_String);
        System.out.println("Student 3 Expected Total Seconds: " + student_3_expectedString + "\n\t\t\tReceived: " + student_3_String);
        
        if (student_1_expectedString.equals(student_1_String) &&
            student_2_expectedString.equals(student_2_String) &&
            student_3_expectedString.equals(student_3_String))
            {
                System.out.println("To String Test passed!");                
            }
        else{
            System.out.println("To String Test failed!");
        }
    }
}
