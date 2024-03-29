/*  Course Name: HDDS1103 Object-oriented Programming
Student Name: Chan Man Chun (Leo), Chan Kwing Tung Jevons, Lo Tze Kit (Kit), To Ho Hin (Herman)
Student ID: 22661204, 22661077, 22661085, 22661026
*/

import java.util.Scanner;
/**
 * The School Manager class is the main class for the school system. 
 * It allows the manager to make changes to user list and provide the following functions:
 * <ul> 
 * <li> Indicate user role </li> 
 * <li> Student access functions: 
    *<ol> 
    *<li> Record attendance </li> 
    *<li> View attendance record </li> 
    *<li> Print student attendance information </li>
    *</ol> 
 * </li> 
 * <li> Teacher access function: 
 * <ol> 
    *<li> Add student </li> 
    *<li> Remove student </li> 
    *<li> Print student List </li> 
    *<li> Take attendance </li> 
    *<li> Set present </li> 
    *<li> Set absent </li> 
    *<li> Find Student by ID </li> 
    *<li> Print teacher information </li> 
    *</ol>
    </li>
 * <li> IT manager access function:
 * <ol>
    *<li> add student to list </li>
    *<li> remove student </li>
    *<li> Get student by ID </li>
    *<li> Print student list </li>
    *<li> Add teacher to list </li>
    *<li> Remove teacher </li>
    *<li> Get Teacher by ID </li>
    *<li> print teacher list </li>
 *</ol>
 </li>
 *</ul>
 * @author Leo
 * @author Jevons
 * @author Kit 
 * @author Herman
 */

class SchoolManager {
    
    static StudentList stuList = new StudentList();
    static Student student = new Student("student_test", 123465789);
    static Teacher teacher = new Teacher("teacher_test", 41230531);
    static ItManager itManager = new ItManager();
    /**
     * Constructor for SchoolManager.
     * {@code itManager}adds a teacher to {@code teacherList},
     * {@code teacher} adds  a student to {@code studentList} by default.
     */
    public SchoolManager(){
        /*  Preset one student with attendance time of 0:0:0, one teacher and one IT manager */
        itManager.addTeacher(teacher);
        teacher.addStudent(student);
    }
    /**
     * Entry point for {@code SchoolManager}.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        SchoolManager s = new SchoolManager();

        System.out.println("Welcome to School Management System.");
        System.out.println("Press any key to continue... or q to quit the program.");
        command = scanner.nextLine();
        while (!(command.equalsIgnoreCase("q"))){
            System.out.println("Please indicate your position (Student (s) / Teacher (t) / ItManager (it) ) or q to quit the program.");
            command = scanner.next().toLowerCase();
            switch (command) {
                case "student":
                case "s":
                    studentAccess(scanner);
                    break;

                case "teacher":
                case "t":
                    teacherAccess(scanner);
                    break;

                case "itmanager":
                case "it":
                    itManagerAccess(scanner);
                    break;
                
                case "q":
                    break;
                default:
            }
        }
        System.out.println("End of system");
        scanner.close();
    }
    
    // Student access functions
    /**
     * Record Attendance time.
     * @param scan  a scanner for multiple purposes.
     */
    static void ATTENDANCE_TIME(Scanner scan) {
        int hour = Integer.MIN_VALUE;
        int minute = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        String temp_output;
        do{
            do {
                System.out.print("Please enter hour: ");                  
                if (scan.hasNextInt()) {
                    hour = scan.nextInt();                     
                } else {
                    System.out.println("Please enter an integer");
                    scan.next();
                }
            } while (hour < 0 || hour >= 24);
            
            do {
                System.out.print("Please enter minute: ");                  
                if (scan.hasNextInt()) {
                    minute = scan.nextInt();                     
                } else {
                    System.out.println("Please enter an integer");
                    scan.next();
                }
            } while (minute < 0 || minute >= 60);
            
            do {
                System.out.print("Please enter second: ");                  
                if (scan.hasNextInt()) {
                    second = scan.nextInt();                     
                } else {
                    System.out.println("Please enter an integer");
                    scan.next();
                }
            } while (second < 0 || second >= 60);
            
            temp_output = student.attendanceTime(hour, minute, second);
            System.out.println(temp_output);
        }while(temp_output.equals("Inappropriate hour/ minute/ second."));
    }

    
    /** 
     * View student attendance.
     * @param s - {@link Student}
     */
    static void VIEW_ATTENDANCE(Student s){
        System.out.println(s.viewAttendance());
    }
    // end of student access functions
    /**
     * Student Access starting point.
     * @param scan - a scanner for multiple purposes.
     * @return {@code false} if {@code studentList} is empty, {@code false} otherwise.
     */
    static boolean studentAccess(Scanner scan){
        System.out.println("\t\t\t-----This is a student access.-----");
        if (StudentList.studentList.size() == 0){
            System.out.println("Student list is empty. Please add a student first.");
            return false;
        }
        PRINT_STUDENT_LIST();
        Student student;
        System.out.print("");
        int index = Integer.MIN_VALUE;
        int size = StudentList.studentList.size();
        do {
            do {
                System.out.print("Please choose a student. (0,1,2, etc.): ");
                if (scan.hasNextInt()) {
                    index = scan.nextInt();                     
                } else {
                    System.out.println("That's not an integer!");
                    scan.next(); 
                }
                if(index >= size) System.out.println("Index out of bounds, please select an integer between 0 and " + (size-1) + " inclusively.");
            } while (index < 0);
        } while (index > size-1);

        student = StudentList.studentList.get(index);
        System.out.println(student.getName() + " selected.");

        int function = Integer.MIN_VALUE;
        
        do {
            System.out.println("Please choose a function. (1: Attendance Time, 2: View Attendance, 3: Print Information, 0: End this session)");
            if (scan.hasNextInt()) {
                function = scan.nextInt();                     
            } else {
                System.out.println("Please enter an non-negative integer.");
                scan.next(); 
            }
        } while (function < 0);
        
        while (function != 0){
            switch (function){
                case 1:
                    ATTENDANCE_TIME(scan);
                    break;
            
                case 2:
                    VIEW_ATTENDANCE(student);
                    break;
                
                case 3:
                    System.out.println(student + " " + student.attendance);
                    break;
                
                default:
                    System.out.println("Incorrect input, please try again.");
            }
            System.out.println("Please choose a function. (1: Attendance Time, 2: View Attendance, 3: Print Information, 0: End this session)");
            while (!scan.hasNextInt()){
                System.out.println("Please enter an integer.");
                System.out.println("Please choose a function. (1: Attendance Time, 2: View Attendance, 3: Print Information, 0: End this session)");            
                scan.next();
            }
            function = scan.nextInt();
            if(function == 0){
                break;
            }
        }
        System.out.println("\t\t\t-----End of student session.-----");
        return true;
    }


    // Teacher access functions
    /**
     * Add student to {@code studentList} in {@code StudentList} class.
     * @param scan a scanner for multiple purposes.
     */
    static void ADD_STUDENT(Scanner scan) {
        Student new_Student;
        String name ="";
        boolean b = true;
        int ID = Integer.MIN_VALUE;
        System.out.print("\nPlease enter student first name: ");
        name = scan.next();

        do {
            do {
                System.out.print("Please enter student ID: ");
                if (scan.hasNextInt()) {
                    ID = scan.nextInt();
                } else {
                    System.out.println("Please enter a non-negative integer.");
                    scan.next();
                }
            } while (ID < 0 && !b);
            new_Student = new Student(name, ID);
            b = teacher.addStudent(new_Student);
        } while (!b);
    }

    /**
     * Remove student from {@code studentList} by ID
     * @param scan a scanner for multiple purposes.
     * @param ID to locate student for removal.
     */
    static void REMOVE_STUDENT(Scanner scan, int ID){        
        do {
            System.out.print("Remove student with ID: ");
            if (scan.hasNextInt()) {
                ID = scan.nextInt();                     
            } else {
                System.out.println("Please enter a non-negative ID.");
                scan.next(); 
            }
        } while (ID < 0);

        System.out.println(teacher.removeStudent(ID));
    }

    /**
     * Print student list.
     */
    static void PRINT_STUDENT_LIST(){
        System.out.println(teacher.printStudentList());
    }
    
    /**
     * Take students attendance by inputting hours, minutes and seconds.
     * @param scan a scanner for multiple purposes.
     */
    static void TAKE_ATTENDANCE(Scanner scan){
        int hours = Integer.MIN_VALUE;
        int minutes = Integer.MIN_VALUE;
        int seconds = Integer.MIN_VALUE;

        do {
            System.out.print("Please provide hours: ");
            if (scan.hasNextInt()) {
                hours = scan.nextInt();                     
            } else {
                System.out.println("Please enter an integer");
                scan.next();
            }
        } while (hours < 0 || hours >= 24);
        
        do {
            System.out.print("Please provide minutes: ");
            if (scan.hasNextInt()) {
                minutes = scan.nextInt();                     
            } else {
                System.out.println("Please enter an integer");
                scan.next();
            }
        } while (minutes < 0 || minutes >= 60);
        
        do {
            System.out.print("Please provide seconds: ");
            if (scan.hasNextInt()) {
                seconds = scan.nextInt();                     
            } else {
                System.out.println("Please enter an integer");
                scan.next();
            }
        } while (seconds < 0 || seconds >= 60);

        teacher.takeAttendance(hours, minutes, seconds);
    }
    
    /**
     * Set student attendance to the specified status {@code present}.
     * @param scan a scanner for multiple purposes.
     * @param ID Student ID for setting attendance purpose.
     */
    static void SET_PRESENT(Scanner scan, int ID){
        do {
            System.out.print("Set student present with ID:");
            if (scan.hasNextInt()) {
                ID = scan.nextInt();                     
            } else {
                System.out.println("Please enter an integer.");
                scan.next();
                }
        } while (ID < 0);

        if(teacher.setPresent(ID)){
            System.out.println("Set Student with ID "+ ID + " to present successfully.");
        }
    }
    
    /**
     * Set student attendance to the specified status {@code absent}.
     * @param scan a scanner for multiple purposes.
     * @param ID Student ID for setting attendance purpose.
     */
    static void SET_ABSENT(Scanner scan, int ID){
        do {
            System.out.print("Set student absent with ID: ");
            if (scan.hasNextInt()) {
                ID = scan.nextInt();                     
            } else {
                System.out.println("Please enter an integer.");
                scan.next();
                }
        } while (ID < 0);

        if(teacher.setAbsent(ID)){
            System.out.println("Set Student with ID" + ID + " to absent successfully.");
        }
        else{
            System.out.println("FAILED. Student NOT FOUND.");
        }
    }
    
    /**
     * Get student with ID from input.
     * @param scan a scanner for multiple purposes.
     * @param ID Student ID for getting student purpose.
     */
    static void GET_STUDENT_BY_ID(Scanner scan, int ID){
        
        do {
            System.out.print("ID to search for: ");
            if (scan.hasNextInt()) {
                ID = scan.nextInt();                     
            } else {
                System.out.println("Please enter an integer.");
                scan.next();
                }
        } while (ID < 0);
        
        System.out.println(teacher.getStudentById(ID));
    }

    /**
     * Entry point for teacher access.
     * @param scan a scanner for multiple purposes.
     * @return {@code false} if {@code teacherList} is empty. {@code true} otherwise.
     */
    static boolean teacherAccess(Scanner scan){
        System.out.println("\t\t\t-----This is teacher access.-----");

        if (ItManager.teacherList.size() == 0){
            System.out.println("Teacher list is empty. Please add a student first.");
            return false;
        }

        Teacher teacher;
        PRINT_TEACHER_LIST();
        int index = Integer.MIN_VALUE;
        int size = ItManager.teacherList.size();
        do {
            do {
                System.out.print("Please choose a teacher. (0,1,2, etc.): ");
                if (scan.hasNextInt()) {
                    index = scan.nextInt();                     
                } else {
                    System.out.println("That's not an integer!");
                    scan.next(); 
                }
                if(index >= size) System.out.println("Index out of bounds, please select an integer between 0 and " + (size-1) + " inclusively.");
            } while (index < 0);
        } while (index > size-1);

        teacher = ItManager.teacherList.get(index);        
        System.out.println("Teacher " + teacher + " selected.");

        int function = Integer.MIN_VALUE;

        do {
            System.out.println("\nPlease choose a function. \n1: Add Student, 2: Remove Student, 3: Print Student List, 4: Take Attendance, 5: Set Present, 6: Set Absent, 7: Get Student By Id, 8: Print Information, 0: End this session\n");
            if (scan.hasNextInt()) {
                function = scan.nextInt();                     
            } else {
                System.out.println("Please enter an non-negative integer.");
                scan.next(); 
            }
        } while (function < 0);

        int temp_ID = Integer.MIN_VALUE;

        while (function != 0 ){
            switch (function){
                case 1: // Add Student and add to the list
                    ADD_STUDENT(scan);
                    break;

                case 2: // remove student
                    REMOVE_STUDENT(scan, temp_ID);
                    break;

                case 3: // Print Student List
                    PRINT_STUDENT_LIST();
                    break;
                
                case 4: // Take Attendance
                    TAKE_ATTENDANCE(scan);
                    break;
                
                case 5: // Set Present
                    SET_PRESENT(scan, temp_ID);
                    break;

                case 6: // Set Absent
                    SET_ABSENT(scan, temp_ID);
                    break;
                
                case 7: // Get Student By Id
                    GET_STUDENT_BY_ID(scan, temp_ID);
                    break;
                
                case 8: // Print Teacher Information
                    System.out.println(teacher);
                    break;
                
                default:
                    System.out.println("Incorrect input, please try again.");
            }
            System.out.println("\nPlease choose a function. \n1: Add Student, 2: Remove Student, 3: Print Student List, 4: Take Attendance, 5: Set Present, 6: Set Absent, 7: Get Student By Id, 8: Print Information, 0: End this session\n");
            while (!scan.hasNextInt()){
                System.out.println("Please enter an integer.");
                System.out.println("\nPlease choose a function. \n1: Add Student, 2: Remove Student, 3: Print Student List, 4: Take Attendance, 5: Set Present, 6: Set Absent, 7: Get Student By Id, 8: Print Information, 0: End this session\n");
                scan.next();
            }
        
            function = scan.nextInt();
            if(function == 0){
                break;   
            }
        }
        System.out.println("\t\t\t-----End of Teacher Session-----");
        return true;
    }

    // IT manager functions
    /**
     * Print teacher list.
     */
    static void PRINT_TEACHER_LIST(){
        System.out.println(itManager.printTeacherList());
    }
    
    /** 
     * Remove teacher from {@code teacherList} in {@code ItManager} class.
     * @param scan a scanner for input purpose.
     */
    static void REMOVE_TEACHER(Scanner scan){
        PRINT_STUDENT_LIST();
        int index = Integer.MIN_VALUE; 
        do {
            System.out.println("Please enter an integer.");
            if (scan.hasNextInt()) {
                index = scan.nextInt();                     
            } else {
                System.out.println("Please enter a non-negative ID.");
                scan.next(); 
            }
            if (index < ItManager.teacherList.size()) { 
                // Teacher t = ItManager.teacherList.get(index);
                itManager.removeTeacher(((Teacher) ItManager.teacherList.get(index)));
            }
        } while (index < 0);

    }
    
    /** 
     * Add teacher to {@code teacherList} in {@code ItManger} class.
     * @param scan a scanner for multiple purposes.
     */
    static void ADD_TEACHER(Scanner scan){
        System.out.println("Please provide teacher name: ");

        String name = scan.nextLine();
        String add = "Failed";
        int ID = Integer.MIN_VALUE;

        do {
            do {
                System.out.println("Please provide teacher userID: ");
                if (scan.hasNextInt()) {
                    ID = scan.nextInt();
                } else {
                    System.out.println("Please enter a non-negative integer.");
                    scan.next();
                }
                if (ID < 0) {System.out.println("Please enter valid teacher userID.");}
            } while (ID < 0);
  
            add = itManager.addTeacher(new Teacher(name, ID));
        } while (add.equals("Failed"));

    }
    
    /** 
     * Get teacher with ID from input.
     * @param scan a scanner for input purpose.
     * @param ID teacher ID for retrival.
     */
    static void GET_TEACHER_BY_ID(Scanner scan, int ID){
        System.out.println("Search for teacher with ID: ");
        try {
            while (!scan.hasNextInt()) {
                System.out.println("Please enter an integer: ");
                scan.next();            
            }
            ID = scan.nextInt();
            System.out.println(itManager.getTeacherById(ID));
        } catch (Exception e) {
            System.out.println("Please re-enter an valid ID:");
        }
    }

    
    /** 
     * Entry point for IT Manager Access.
     * @param scan a scanner for multiple purposes.
     * @return true by default.
     */
    static boolean itManagerAccess(Scanner scan){
        System.out.println("\t\t\t-----This is IT Manager Access.-----");

        int temp_ID = 0;

        int function = Integer.MIN_VALUE;

        do {
            System.out.println("\nPlease choose a function. \n1: Add Student to list, 2: Remove Student, 3: Get Student By ID, 4: Print Student List, 5: Add Teacher to List, 6: Remove teacher, 7:Get Teacher By ID, 8: Print Teacher, 0: End this session\n");
            if (scan.hasNextInt()) {
                function = scan.nextInt();                     
            } else {
                System.out.println("Please enter an non-negative integer.");
                scan.next(); 
            }
        } while (function < 0);
        
        while (function != 0 ){
            switch (function){
                case 1: // add student to list
                    ADD_STUDENT(scan);
                    break;

                case 2: // remove student
                    REMOVE_STUDENT(scan, temp_ID);
                    break;
            
                case 3: // Get Student By Id
                    GET_STUDENT_BY_ID(scan, temp_ID);
                    break;

                case 4: // print student list
                    PRINT_STUDENT_LIST();
                    break;
                    
                case 5: // Add teacher to list
                    ADD_TEACHER(scan);
                    break;
                    
                case 6: // remove teacher
                    REMOVE_TEACHER(scan);
                    break;
                    
                case 7: // get Teacher By ID
                    GET_TEACHER_BY_ID(scan, temp_ID);
                    break;
                    
                case 8: // print teacher list
                    PRINT_TEACHER_LIST();
                    break;
                
                default:
                    System.out.println("Incorrect input, please try again.");
            }
            System.out.println("\nPlease choose a function. \n1: Add Student to list, 2: Remove Student, 3: Get Student By ID, 4: Print Student List, 5: Add Teacher to List, 6: Remove teacher, 7:Get Teacher By ID, 8: Print Teacher, 0: End this session\n");
            while (!scan.hasNextInt()){
                System.out.println("Please enter an integer.");
                System.out.println("\nPlease choose a function. \n1: Add Student to list, 2: Remove Student, 3: Get Student By ID, 4: Print Student List, 5: Add Teacher to List, 6: Remove teacher, 7:Get Teacher By ID, 8: Print Teacher, 0: End this session\n");
                scan.next();
            }
            function = scan.nextInt();
            if(function == 0){
                break;
            }
        }
        System.out.println("IT Manager Access Terminated");
        return true;
    }
}
