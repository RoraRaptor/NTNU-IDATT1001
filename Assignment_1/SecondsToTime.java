package Assignment_1;

/**
 * Converts a number of seconds into hours, minutes and remaining seconds
 * 
 * @author Aurora Schmidt-Brekken Vollvik
 */
public class SecondsToTime {

    public static int toDays(int s) {

        return s / 86400; // One day has 84,400 seconds
    }

    public static int toHours(int s) {

        return s / 3600; // One hour has 3,600 seconds
    }

    public static int toMinutes(int s) {
        
        return s / 60; // One minute has 60 seconds
    }

    public static int[] getHoursMinutesAndSeconds(int s) {
        
        int hours = s / 3600;
        int minutes = s % 3600 / 60; 
        int seconds = s % 3600 % 60;

        int[] result = {hours, minutes, seconds}; 
        
        return result;
    }

    public static void main(String[] args) {
    
        // Testing or client? 🤔

    }
}