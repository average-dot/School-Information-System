/*  Course Name: HDDS1103 Object-oriented Programming
    Student Name: Chan Man Chun (Leo), Chan Kwing Tung Jevons, Lo Tze Kit (Kit), To Ho Hin (Herman)
    Student ID: 22661204, 22661077, 22661085, 22661026
*/

/**
 * Abstract class {@code User} is the root user of the class hierarchy.
 * Every user sybtype has {@code User} as a superclass. All users
 * except IT Manager inherit {@code User}.
 * @author Leo
 */
abstract class User{ 
    /**Default Constructor, but unable to construct object directly from {@code User} 
     * @param name     The String to be passed in
     * @param userID   The integer to be passed in
    */
    User(String name, int userID){
        this.name = name;
        this.userID = userID;
    }
    /**name is a private property*/
    private String name; 
    /** userID is a private property */
    private int userID; 
    
    /**
     * Get user name
     * @return private property <b> {@code name} </b>
     */
    String getName(){return name;}
    /**
     * Get user ID
     * @return private property <b> {@code userID} </b>
     */
    int getUserId(){return userID;}
}