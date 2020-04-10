import java.util.Random;

public class Sensor {
    private final double theTemperature;
    private final double theHumidity;
    private final double theWind;
    private final double theRain;

    /**
     * Data chosen based off weather at Jess's house.
     * To be used as initial data point.
     */
    public Sensor() {
        theTemperature = 60;
        theHumidity = 44;
        theWind = 10;
        theRain = 0;
        
    }
    
    /**
     * Meant to provide a thread of data that makes sense together.
     * @param currentData the most recent sensor
     */
    public Sensor(Sensor currentData) {
    	// Assign new sensor readings based off of currentData's.
    	theTemperature = generateNotRainData(currentData.getTheTemperature());
    	theHumidity = generateNotRainData(currentData.getTheHumidity());
    	theWind = generateNotRainData(currentData.getTheWind());
    	theRain = generateRainData(currentData.getTheRain());
    	
    }
    
    /**
     * Resets theRain amount for new day.
     * Sets theTemperature,theHumidity, and theWind based off most recent sensor.
     * @param myTemperature theTemperature from most recent sensor.
     * @param myHumidity theHumidity from most recent sensor.
     * @param myWind theWind from most recent sensor.
     */
    public Sensor(double myTemperature, double myHumidity, double myWind) {
    	// Assign new sensor readings based off parameters
    	theTemperature = generateNotRainData(myTemperature);
    	theHumidity = generateNotRainData(myHumidity);
    	theWind = generateNotRainData(myWind);
    	// Reset theRain to 0 for new day
    	theRain = 0;
    }

	public double getTheTemperature() {
		return theTemperature;
	}

	public double getTheHumidity() {
		return theHumidity;
	}

	public double getTheWind() {
		return theWind;
	}

	public double getTheRain() {
		return theRain;
	}
	
	public String toString() {
		return "Temperature: " + this.getTheTemperature() 
		+ " Humidity: " + this.getTheHumidity() + " Wind: " + this.getTheWind() 
		+ " Rain: " + this.getTheRain();
		
	}
	
	/*
	 * Generates data for all sensors besides rain.
	 * Rain cannot decrease in a day.
	 */
	public double generateNotRainData(double theData) {
		Random random = new Random();
		
		// Determines if data will increase or decrease
    	boolean boolDirection = random.nextBoolean();
    	int direction;
    	if (boolDirection) {
    		direction = 1;
    	} else {
    		direction = -1;
    	}
    	
    	// Determines magnitude of data change
    	// Allows no more larger change than 1%
    	int change = random.nextInt(11);
    	
		if (theData != 0.0) {
			return (theData * (direction * change/1000.0)) + theData;
		} else {
			return (direction * change/1000.0) + theData;
		}
	}
	
	public double generateRainData(double theData) {
		Random random = new Random();
		
		// Determines if rain will increase (T) or stay the same (F)
		boolean willChange = random.nextBoolean();
    	if (!willChange) {
    		return theData;
    	} else {
    		// Allows increase of no more than 0.01
    		return (random.nextInt(11)/1000.0) + theData;
    	}
	}
	
	/**
	 * For testing purposes only.
	 * @param args
	 */
	public static void main(String[] args) {
        Sensor s1 = new Sensor();
        Sensor s2 = new Sensor(s1);
        Sensor s3 = new Sensor(s2);
        Sensor s4 = new Sensor(s3);
        Sensor s5 = new Sensor(s4);
        Sensor s6 = new Sensor(s5);
        Sensor s7 = new Sensor(s5.getTheTemperature(), s5.getTheHumidity(), s5.getTheWind());
        
        System.out.println("Sensor 1 Data: " + s1.toString());
        System.out.println("Sensor 2 Data: " + s2.toString());
        System.out.println("Sensor 3 Data: " + s3.toString());
        System.out.println("Sensor 4 Data: " + s4.toString());
        System.out.println("Sensor 5 Data: " + s5.toString());
        System.out.println("Sensor 6 Data: " + s6.toString());
        System.out.println("It's a new day!");
        System.out.println("Sensor 7 Data: " + s7.toString());
        
	}
}
