/*  Course Name: HDDS1103 Object-oriented Programming
    Student Name: Chan Man Chun (Leo), Chan Kwing Tung Jevons, Lo Tze Kit (Kit), To Ho Hin (Herman)
    Student ID: 22661204, 22661077, 22661085, 22661026
*/

import java.util.ArrayList;

/**
 * StudentList is a class stores student list and attendance list. It is used by @see SchoolManager, @see Teacher and @see ItManager.
 */
public class StudentList {
    
    static ArrayList<Student> studentList = new ArrayList<Student>();
    static ArrayList<String> attendanceList = new ArrayList<String>();

    /**
     * Add student to {@code studentList}
     * @param s Student to add.
     * @return {@code true} if student is not already present in {@code studentList}, {@code false} otherwise.
     */
    boolean addStudent(Student s){
        if (studentList.size()>0){
            for(Student stu : studentList){
                if(s.getUserId() == stu.getUserId()){
                    System.out.println("Student with ID " + stu.getUserId() + " is already in the list.");
                    return false; 
                }
            }
        }
        studentList.add(s);
        return true;
    }
    /**
     * Get Student By user ID
     * @param ID student ID to retrieve.
     * @return {@code Student} if the student user ID is found, {@code null} otherwise.
     */
    public Student getStudentById(int ID){
        for(Student s : studentList){
            if (s.getUserId() == ID){
                return s;
            }
        }
        return null;
    }
    
    /**
     * Print Student List by iterating through {@code studentList} and {@code attendanceList}
     * @return studentList by Name, userID and attendance
     */
    public String printStudentList() {
        String s = "";
        for (int i = 0; i < studentList.size(); i++) {
            s += i + ": Name: "+ studentList.get(i).getName() + "     UserID: " + studentList.get(i).getUserId() + "     Attendance: " + attendanceList.get(i) +"\n";
        }
        return s;
    }

    @Override
    public String toString() {
        return "Student List has "+ studentList.size() +" student(s).";
    }
}
