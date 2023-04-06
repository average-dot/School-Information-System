
public class ItManagerTest {
    ItManager itManager = new ItManager();
    public static void main(String[] args) {
        ItManagerTest itManagerTest = new ItManagerTest();

        System.out.println("IT Manager Test:");
        System.out.println("\t\t\tAdd Teacher To List Test-----\n");
        itManagerTest.addTeacherToListTest();

        
        System.out.println("\t\t\tPrint Teacher List Test-----\n");
        itManagerTest.printTeacherListTest();

        System.out.println("\n\t\t\tGet Teacher By ID Test-----\n");
        itManagerTest.getTeacherByIdTest();
    }
    public void addTeacherToListTest(){
        
        String expected_1 = "Success";
        String expected_2 = "Failed";

        String returned_1 = itManager.addTeacher(new Teacher("teacher1", 0));
        String returned_2 = itManager.addTeacher(new Teacher("teacher2", 0));

        System.out.println("Test Case 1 should return "+ returned_1+".\tReceived: " + expected_1);
        System.out.println("Test Case 2 should return "+ returned_2+".\tReceived " + expected_2);
        
        if(expected_1.equalsIgnoreCase(returned_1) && expected_2.equalsIgnoreCase(returned_2)){
            System.out.println("Add Teacher Test passed!\n");
        }
        else{
            System.out.println("Add Teacher Test failed!\n");
        }    
    }
    public void getTeacherByIdTest(){
        String expected_1 = "Teacher NOT found."; 
        String expected_2 = "Teacher found: Teacher Name: teacher1 UserID: 0"; 
        
        String returned_1 = itManager.getTeacherById(1);
        String returned_2 = itManager.getTeacherById(0);
        
        System.out.println("Expected: "+ expected_1+"\tReceived: " + returned_1);
        System.out.println("Expected: "+ expected_2+"\tReceived: " + returned_2);
    
        if(expected_1.equals(returned_1) && expected_2.equals(returned_2)){
            System.out.println("\nGet Teacher By ID Test passed!");
        }
        else{
            System.out.println("\nGet Teacher By ID Test failed!");
        }
    }
    public void printTeacherListTest(){
        String expectedResult = "0) Name: teacher1, UserID: 0\n";
        String result = itManager.printTeacherList();

        System.out.println("Expected: " + expectedResult +"Received: " + result);
        System.out.println((expectedResult.equalsIgnoreCase(result)) ? "Print Teacher List Test passed!" : "Print Teacher List Test failed!");
    }
    public boolean removeTeacherTest(Teacher t){
        return itManager.removeTeacher(t);
    }

}
