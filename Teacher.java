/*  Course Name: HDDS1103 Object-oriented Programming
    Student Name: Chan Man Chun (Leo), Chan Kwing Tung Jevons, Lo Tze Kit (Kit), To Ho Hin (Herman)
    Student ID: 22661204, 22661077, 22661085, 22661026
*/


import java.util.Scanner;
/**
 * Teacher class extends {@link User} and implements method from {@link Time}
 */
public class Teacher extends User implements Time{
    StudentList stuList = new StudentList();
    int seconds = -1;
    Scanner scan = new Scanner(System.in);
    /**
     * Constructor for the {@code Teacher} class.
     * @param name    Name of teacher
     * @param userID  UserID of teacher
     */
    Teacher(String name, int userID){
        super(name, userID); 
    }

    /**
     * This method prints the list of students.
     * @return name list of students
     * @see         StudentList 
     */

    public String printStudentList(){
        return stuList.printStudentList();
    }

    /**
     * This method prints the list of students.
     * @param  s   Student to be added to {@code studentList} in stuList.
     * @return     {@code Student added successfully} if studentID does not exist, student will be added to {@code studentList}.
     *             {@code Student with the same ID already exists} otherwise
     */
    public boolean addStudent(Student s){ 
        if(stuList.addStudent(s)){
            System.out.println("Student added successfully");
            return true;
        }
        System.out.println("Student with the same ID already exists.");
        return false;
    }
    
    /**
     * This method removes Student with input ID.
     * @param ID - userID to be searched for
     * @return {@code Student with input ID removed}
     */
    public String removeStudent(int ID){
        Student s = stuList.getStudentById(ID);
        int index = StudentList.studentList.indexOf(s);
        if(StudentList.studentList.remove(s)){
            StudentList.attendanceList.remove(index);
            return "Student with ID " + ID + " removed.";
        }
        return "Student not found.";
    }
    /**
     * Record attendance time
     * @param h  hour of attendance time
     * @param m minute of attendance time
     * @param s  second of attendance time
     * @return {@code Student Present} if Student arrives before teacher taking attendance time.
     * {@code Student Late} if Student arrives after teacher taking attendance time.
     * {@code Unable to update} if Student is not present in {@code studentList}.
     */
    public String takeAttendance(int h, int m, int s ){
        String result = "";
    
        this.seconds = convertToSeconds(h, m, s);
        if ((seconds != -1)){
            int index;
            for (Student stu : StudentList.studentList){
                index = StudentList.studentList.indexOf(stu);
                if(stu.totalSeconds <= this.seconds){
                    StudentList.attendanceList.set(index, "Present");
                    stu.attendance = "Present";
                    result += "Student with ID " + stu.getUserId() + " is present.\n";
                }
                else{
                    StudentList.attendanceList.set(index, "Late");
                    result += "Student with ID " + stu.getUserId() + " is late.\n";
                }
            }
        }
        else result += "Unable to update.\n";
        return result;
    }

    /**
     * This boolean method shows whether the student is present in the {@code StudentList}.
     * @param   ID   Student ID for checking whether the student is present in the list
     * @return       {@code Present} If the student ID in the {@code studentList}, show {@code Present};
     *               no value are displayed otherwise
     */
    public boolean setPresent(int ID){
        Student tempStudent = stuList.getStudentById(ID);
        int index = StudentList.studentList.indexOf(tempStudent);
        if(index < StudentList.studentList.size() && index != -1){
            StudentList.attendanceList.set(index, "Present");
            return true;
        }
        return false;
    }
    /**
     * The boolean method for checking whether the student is absent
     * @param  ID Student ID for checking whether the student is in the list.
     * @return {@code Absent} if the student ID in the {@code studentList}. 
     *         no value are updated otherwise.
     */
    public boolean setAbsent(int ID){
        Student tempStudent = stuList.getStudentById(ID);
        int index = StudentList.studentList.indexOf(tempStudent);
        if(index < StudentList.studentList.size() && index != -1){
            StudentList.attendanceList.set(index, "Absent");
            return true;
        }
        return false;
    }
    
    /**
     * Convert hours, minutes and seconds to seconds.
     * @param h hours to convert
     * @param m minutes to convert
     * @param s seconds to convert
     * @return total seconds converted from hours and minutes.
     */
    public int convertToSeconds(int h, int m, int s){
        int temp_seconds = -1;
        if (h < 24 && h >= 0 &&  m < 60 && m >= 0 && s < 60 && s >= 0){
            temp_seconds = h*3600+m*60+s;
        }
        if (temp_seconds == -1){
            System.out.println("Inappropiate hour/ minute/ seconds.");
        }
        return temp_seconds;
    }
    
    /** 
     * Get Student By ID.
     * @param ID user ID to be looked up
     * @return {@code Student found} with information.
     *          {@code Student NOT found} otherwise.
     */
    public String getStudentById(int ID){
        Student s = stuList.getStudentById(ID);
        if (s!=null){
            return "Student found: " + s;
        }
        return "Student NOT found.";
    }

    @Override
    public String toString() {
        return "Teacher Name: " + this.getName() + " UserID: " + this.getUserId();
    }
    
}
