/**
 * 
 */
package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import structure.ISS;
import structure.Sensor;

/**
 * @author Xiuxiang Wu
 *
 */
class ISSTest {

	/**
	 * Test method for {@link structure.ISS#sensorThread(structure.Sensor)}.
	 */
	@Test
	void testSensorThread() {

		Sensor sensor = new Sensor();
		ISS.sensorThread(sensor);

	}

	/**
	 * Test method for {@link structure.ISS#minOrMax(double, int)}.
	 */
	@Test
	void testMinOrMax() {		
		double[] theArr = {60, 44, 10, 0};
		Sensor sensor = new Sensor(theArr);
		sensor.run();
		assertEquals(0, theArr[3]);
		
		double data = -22;
		int type = 1;
		ISS.minOrMax(data, type);
		assertEquals(data, ISS.getMinArray()[type]);

		data = 22;
		type = 1;
		ISS.minOrMax(data, type);
		assertEquals(data, ISS.getMaxArray()[type]);
		
		
	}

}
