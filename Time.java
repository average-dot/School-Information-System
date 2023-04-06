/*  Course Name: HDDS1103 Object-oriented Programming
    Student Name: Chan Man Chun (Leo), Chan Kwing Tung Jevons, Lo Tze Kit (Kit), To Ho Hin (Herman)
    Student ID: 22661204, 22661077, 22661085, 22661026
*/

/**
 * Interface {@code Time} is the root of method {@code convertToSeconds}
 */
public interface Time {
    /** Converts HH:MM:SS to number of seconds in total
     * @param  hours   hours input for conversion
     * @param  minutes minutes input for conversion
     * @param  seconds seconds input for conversion
     * @return         totalnumber of seconds.
     */
    int convertToSeconds(int hours, int minutes, int seconds);
}
