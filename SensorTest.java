/**
 * 
 */
package Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import structure.Sensor;

/**
 * @author Xiuxiang Wu
 * @version 4.14.20
 *
 */
class SensorTest {

	/**
	 * Test method for {@link structure.Sensor#Sensor(double[])}.
	 */
	//@Before
	
	
	@Test
	void testSensorDoubleArray() {
		double[] theArr = {60, 44, 10, 0};
		Sensor sensor = new Sensor(theArr);
		assertEquals(44, sensor.theArr[1]);
		
	}

	/**
	 * Test method for {@link structure.Sensor#Sensor()}.
	 */
	@Test
	void testSensor() {
		Sensor sensor1= new Sensor();
		
		assertEquals(60, sensor1.getTheTemperature());
		assertEquals(44, sensor1.getTheHumidity());
		assertEquals(10, sensor1.getTheWind());
		assertEquals(0, sensor1.getTheRain());
	//	assertTrue("Temperature: 60.0 Humidity: 44.0 Wind: 10.0 Rain: 0.0".(sensor1));

	}

	/**
	 * Test method for {@link structure.Sensor#Sensor(structure.Sensor)}.
	 */
	@Test
	void testSensorSensor() {
		Sensor sensor1 = new Sensor();
		Sensor sensor2 = new Sensor(sensor1);
		assertTrue(sensor2.getTheTemperature() >= 59.4 && sensor2.getTheTemperature()<= 60.6);

		
	}

	/**
	 * Test method for {@link structure.Sensor#Sensor(double, double, double)}.
	 * @param myTemperature 
	 * @param myHumidity 
	 * @param myWind 
	 */
	@Test
	void testSensorDoubleDoubleDouble() {
		double myTemperature = 60;
		double myHumidity = 44;
		double myWind = 15;
		Sensor sensor = new Sensor(myTemperature, myHumidity, myWind);
		assertEquals(0, sensor.getTheRain());
		

	}

	/**
	 * Test method for {@link structure.Sensor#getTheTemperature()}.
	 */
	@Test
	void testGetTheTemperature() {
		Sensor sensor1= new Sensor();
		
		assertEquals(60, sensor1.getTheTemperature());

		
	}

	/**
	 * Test method for {@link structure.Sensor#getTheHumidity()}.
	 */
	@Test
	void testGetTheHumidity() {
		Sensor sensor1= new Sensor();

		assertEquals(44, sensor1.getTheHumidity());

	}

	/**
	 * Test method for {@link structure.Sensor#getTheWind()}.
	 */
	@Test
	void testGetTheWind() {
		Sensor sensor1= new Sensor();
	
		assertEquals(10, sensor1.getTheWind());

	}

	/**
	 * Test method for {@link structure.Sensor#getTheRain()}.
	 */
	@Test
	void testGetTheRain() {
		Sensor sensor1= new Sensor();

		assertEquals(0, sensor1.getTheRain());
	}

	/**
	 * Test method for {@link structure.Sensor#toString()}.
	 */
	@Test
	void testToString() {
		Sensor sensor1= new Sensor();
		//System.out.print(sensor1.toString());
		String result = "Temperature: 60.0 Humidity: 44.0 Wind: 10.0 Rain: 0.0";
		equals(sensor1.toString().equals(result));
	}

	/**
	 * Test method for {@link structure.Sensor#generateNotRainData(double)}.
	 */
	@Test
	void testGenerateNotRainData() {
		Sensor sensor = new Sensor();
		double theData = 0;
		sensor.generateNotRainData(theData);
		//assertTrue()
	}

	/**
	 * Test method for {@link structure.Sensor#generateRainData(double)}.
	 */
	@Test
	void testGenerateRainData() {
		Sensor sensor = new Sensor();
		double theData = 0;
		sensor.generateRainData(theData);
	}

	/**
	 * Test method for {@link structure.Sensor#run()}.
	 */
	@Test
	void testRun() {
		
		double[] theArr = {60, 44, 10, 0};
		Sensor sensor = new Sensor(theArr);
		sensor.run();
		assertEquals(0, theArr[3]);
	}

	/**
	 * Test method for {@link structure.Sensor#round(double, int)}.
	 */
	@Test
	void testRound() {
		double value = 123.4568;
		int places = 2;
		assertEquals(123.46,Sensor.round(value, places));
		places = -1;


	}


}
