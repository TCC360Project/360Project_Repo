/** TCSS 360 
 * 
 * */
/**
 * Program Description: Sensor class generates data for the V2SensorSuite.
 * @author Jess Lastname
 * @author Leika Yamada
 * @author Jacob Sousie
 * 
 * @version 4.10.20
 * */
import java.util.concurrent.locks.ReentrantLock;
public class ISS {
	private static double theTemperature;
    private static double theHumidity;
    private static double theWind;
    private static double theRain;
    public static double[] myArr = new double[4];
    private static double minArray[] = new double[4]; 
    private static double maxArray[] = new double[4];
    private static boolean powerSwitch;
    private static final int TEMP_TYPE = 0;
    private static final int HUM_TYPE = 1;
    private static final int WIND_TYPE = 2;
    private static final int RAIN_TYPE = 3;
    
    
	public static void sensorThread(Sensor sensors) {
         Thread t = new Thread(sensors);
         t.start(); 
     }
     public static void main(String[] args) throws InterruptedException
     {
    	 	powerSwitch = true;
    	 	int test = 4;
    	 	while(powerSwitch) {
    	 		Sensor sensorSuite = new Sensor(myArr);  
    	 		ReentrantLock lock = new ReentrantLock();
    	 		lock.lock();
    	 		try { 
    	 				sensorThread(sensorSuite);
    	 			}
    	 		finally {
    	 			lock.unlock();
    	 		}	
    	 		Runnable mainRun = () -> {
    	 			theTemperature = myArr[0];
    	 			minOrMax(theTemperature, TEMP_TYPE);
    	 			theHumidity = myArr[1];
    	 			minOrMax(theHumidity, HUM_TYPE);
    	 			theWind = myArr[2];
    	 			minOrMax(theWind, WIND_TYPE);
    	 			theRain = myArr[3];
    	 			minOrMax(theRain, RAIN_TYPE);
    	 		};
    	 		Thread t = new Thread(mainRun);
    	 		t.start();
    	 		java.util.concurrent.TimeUnit.MILLISECONDS.sleep(2500);
    	 		test--;
    	 		if (test < 0) {
    	 			powerSwitch = false;
    	 		}
    	 	}
// For testing purposes    	 	
    	 	
//    	 		System.out.println("Temp min: " + minArray[0]);
//    	 		System.out.println("Temp max: " + maxArray[0]);
//    	 		System.out.println("Hum min: " + minArray[1]);
//    	 		System.out.println("Hum max: " + maxArray[1]);
//    	 		System.out.println("Wind min: " + minArray[2]);
//    	 		System.out.println("Wind max: " + maxArray[2]);
//    	 		System.out.println("Rain min: " + minArray[3]);
//    	 		System.out.println("Rain max: " + maxArray[3]);
//    	 	
    	 	
     }
     public static void minOrMax(double data, int type) {
    	if(data < minArray[type]) {
    		minArray[type] = data;
    	} else if(data > maxArray[type]) {
     		maxArray[type] = data;
     	}
     }
}