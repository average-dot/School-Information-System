/*  Course Name: HDDS1103 Object-oriented Programming
    Student Name: Chan Man Chun (Leo), Chan Kwing Tung Jevons, Lo Tze Kit (Kit), To Ho Hin (Herman)
    Student ID: 22661204, 22661077, 22661085, 22661026
*/

import java.util.ArrayList;
import java.util.Scanner;
/**
 * {@code Student} is the subtype of {@link User}.
 * It also implements {@link Time}.
 */
public class Student extends User implements Time{
    Scanner scan = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<Student>();

    StudentList tempList = new StudentList();
    int index;
    
    int totalSeconds = -1;
    private int hour, minute, second;
    String attendance = "Unknown";

    /**
     * Constructor for Student objects.
     * @param name - student name
     * @param userID - student user ID
     */
    public Student(String name, int userID){
        super(name, userID);
        students.add(this);
        this.index = students.indexOf(this);
        StudentList.attendanceList.add(attendance);
    }
    
    /**
     * Record Attendance time.
     * @param hour - hour
     * @param minute - minute
     * @param second - second
     * @return HH:MM:SS. An error message if HH or MM or SS is out of bounds.
     */
    String attendanceTime(int hour, int minute, int second){
        convertToSeconds(hour, minute, second);
        switch (totalSeconds){
            case -1:
                return "Inappropriate hour/ minute/ second.";
            
            default:
                this.attendance = "Waiting for teacher's confirmation";
                StudentList.attendanceList.set(this.index, this.attendance);
                return hour + ":" + minute + ":" + second + " recorded";
        }
        
    }
    /**
    * View attendance.
    * @return student name, ID, attendance time and attendance status.
    */
    public String viewAttendance(){
        String tempString = this.hour + ":" + this.minute + ":" + this.second;
        int index = students.indexOf(this);
        return this.getName() + " ID: "+ this.getUserId() +" Arrive Time: "+tempString + " Status: " + StudentList.attendanceList.get(index) + ".";
    }
    
    /**
     * Converting time to total seconds.
     * @param h hour
     * @param m  minute
     * @param s second
     * @return total seconds by converting hour and minute to seconds and adding second. return -1 if time format is not supported, i.e. hour set to 24, minute set to 60, etc.
     */
    @Override
    public int convertToSeconds(int h, int m, int s) {

        if (h < 24 && h >= 0 &&  m < 60 && m >= 0 && s < 60 && s >= 0){
            hour = h;
            minute = m;
            second = s;
            totalSeconds = h*3600+m*60+s;
            return totalSeconds;
        }
        totalSeconds = -1;
        return totalSeconds;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + " ID: " + getUserId();
    }
    
}
