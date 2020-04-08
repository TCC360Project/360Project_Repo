import java.util.Random;

public class Sensor {
	
	public static void main(String[] args) {
        // Numbers are for temperature
		int theMin = -40;
		int theMax = 150;

		System.out.println("Random Temperature: " + generateData(theMin, theMax));
	}
    
    // Just makes data for temperature right now
	public static int generateData(int myMin, int myMax) {
		Random random = new Random();
		return random.nextInt((myMin - myMax) + 1) + myMin;
	}
}