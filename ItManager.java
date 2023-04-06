/*  Course Name: HDDS1103 Object-oriented Programming
    Student Name: Chan Man Chun (Leo), Chan Kwing Tung Jevons, Lo Tze Kit (Kit), To Ho Hin (Herman)
    Student ID: 22661204, 22661077, 22661085, 22661026
*/
import java.util.ArrayList;
/** Interface for IT Manager 
 */
interface InnerItManager {
    String addTeacher(Teacher teacher);
    String getTeacherById(int ID);
    String printTeacherList();
    boolean removeTeacher(Teacher t);
}
/** This class contains the administration functions of the IT manager to create a teacher list
 * @author Leo
 * @author Jevons
 * @author Kit 
 * @author Herman
 * @version 1.0
 */
public class ItManager implements InnerItManager{
    /**
    * {@code teacherList} is static ArrayList attaches to {@code ItManager} class 
    */
   static ArrayList<Teacher> teacherList = new ArrayList<>();
    /**
    * Add {@link Teacher} to {@code teacherList}
    * @param    teacher  the name of the teacher
    * @return   {@code Success} usernameID was not on the list, return teacher's info;
                {@code Fail} otherwise.
    */
    @Override
    public String addTeacher(Teacher teacher){
        for(Teacher t: teacherList){   
            if (t.getUserId() == teacher.getUserId()){
                return "Failed"; // need some modification
            }
        }
        teacherList.add(teacher);
        System.out.println("Teacher added successfully");
        return "Success"; // need some modificatio
    }
    /**  The Teacher ID for retrieval
     * @param    ID  Teacher UserID for searching
     * @return Teacher information when found, message of NOT found when teacher is not in {@code teacherList}
     */
    @Override
    public String getTeacherById(int ID){
        for (Teacher t: teacherList){
            if (t.getUserId() == ID) {
                return "Teacher found: " + t;
            }
        }
        return "Teacher NOT found.";
    }
    /**
     * Print Teacher List
     * @return teacher list with index starting from 0
     */
    @Override
    public String printTeacherList(){
        String result="";
        for(int i=0;i<teacherList.size();i++){
            result += i + ") Name: "+ teacherList.get(i).getName() + ", UserID: " + teacherList.get(i).getUserId() + "\n";
        }
        return result;
    }
    /**
     * Remove Teacher from {@code teacherList}
     * @param  t - {@link Teacher}
     * @return     {@code True} if removed successfully
     *             {@code False} otherwise.
     */
    @Override
    public boolean removeTeacher(Teacher t) {
        if (teacherList.remove(t)){
            return true;
        }
        return false;
    }
}

