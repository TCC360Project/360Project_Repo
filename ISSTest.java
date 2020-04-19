package Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.Test;
import structure.ISS;
import structure.Sensor;

/**
 * @author Xiuxiang Wu
 * @author Leika Yamada
 * @version 4.18.20
 */
class ISSTest {

	/**
	 * Test method for {@link structure.ISS#sensorThread(structure.Sensor)}.
	 * This test runs the sensor thread inside of the ISS class to 
	 * 
	 */
	@Test
	 void testGetMinArray() {

		assertTrue( 60 == ISS.getMinArray()[0]);
		assertTrue( 44 == ISS.getMinArray()[1]);
		assertTrue( 10 == ISS.getMinArray()[2]);
		assertTrue( 0 == ISS.getMinArray()[3]);
		

	}
	@Test
	void testGetMaxArray() {
		assertTrue( 60 == ISS.getMaxArray()[0]);
		assertTrue( 44 == ISS.getMaxArray()[1]);
		assertTrue( 10 == ISS.getMaxArray()[2]);
		assertTrue( 0 == ISS.getMaxArray()[3]);

	}
	
	@Test
	void testGetPowerSwitch() {
		ISS.setPowerSwitch(true);
		assertEquals(true, ISS.getPowerSwitch());

	}
	
	@Test
	void testGetMyArr() {
		double[] theArr = {60, 44, 10, 0};
		ISS.setMyArr(theArr);
		assertTrue(60 == ISS.getMyArr()[0]);
		assertTrue(44 == ISS.getMyArr()[1]);
		assertTrue(10 == ISS.getMyArr()[2]);
		assertTrue(0 == ISS.getMyArr()[3]);

	}
	@Test
	void testSetMyArr() {
		double[] theArr = {60, 44, 10, 0};
		ISS.setMyArr(theArr);
		assertTrue(60 == ISS.getMyArr()[0]);
		assertTrue(44 == ISS.getMyArr()[1]);
		assertTrue(10 == ISS.getMyArr()[2]);
		assertTrue(0 == ISS.getMyArr()[3]);

	}
	@Test
	void testSetPowerSwitch() {
		ISS.setPowerSwitch(true);
		assertEquals(true, ISS.getPowerSwitch());

	}

	@Test
	void testSensorThread() throws InterruptedException {
		Sensor sensor = new Sensor();
		ISS.sensorThread(sensor);

	}
	
	@Test
	void testIssThread() {
		ISS iss = new ISS();
		ISS.issThread(iss);

	}

	@Test
	void testRun() {
		
		ISS iss = new ISS();
		double data = 22;
		int type = 2;
		ISS.minOrMax(data, type);
		assertEquals(data, ISS.getMaxArray()[type]);
		iss.run();
		
		assertTrue( 60 == ISS.getMaxArray()[0]);
		assertTrue( 44 == ISS.getMaxArray()[1]);
		assertTrue( 22 == ISS.getMaxArray()[2]);
		assertTrue( 0 == ISS.getMaxArray()[3]);
		
	}

	@Test
	void testMinOrMax() {		
		double[] theArr = {60, 44, 10, 0};
		Sensor sensor = new Sensor(theArr);
		sensor.run();
		
		double data = -22;
		int type = 1;
		ISS.minOrMax(data, type);
		assertEquals(data, ISS.getMinArray()[type]);

		data = 22;
		type = 2;
		ISS.minOrMax(data, type);
		assertEquals(data, ISS.getMaxArray()[type]);
		

	}

	@Test
	void testUpdateData() {	
		double data = 22;
		int type = 2;
		ISS.minOrMax(data, type);
		assertEquals(data, ISS.getMaxArray()[type]);
		
		ISS.updateData();
		assertTrue( 60 == ISS.getMaxArray()[0]);
		assertTrue( 44 == ISS.getMaxArray()[1]);
		assertTrue( 22 == ISS.getMaxArray()[2]);
		assertTrue( 0 == ISS.getMaxArray()[3]);
		


	}

}