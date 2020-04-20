package Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.jupiter.api.Assertions;
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
		ISS iss = new ISS(4);
		assertEquals(true, iss.getPowerSwitch());
		iss.setPowerSwitch(true);
		assertEquals(true, iss.getPowerSwitch());
		iss.setPowerSwitch(false);
		assertEquals(false, iss.getPowerSwitch());
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
		ISS iss = new ISS(4);
		iss.setPowerSwitch(true);
		assertEquals(true, iss.getPowerSwitch());
	}

	@Test
	void testSensorThread() throws InterruptedException {
		Sensor sensor = new Sensor();
		ISS.sensorThread(sensor);

	}
	
	@Test
	void testIssThread() {
		ISS iss = new ISS(4);
		ISS.issThread(iss);

	}

	@Test
	void testRun() {
		
		ISS iss = new ISS(4);
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

	/**
	 * Test method for {@link structure.ISS#endConditionCheck()}.
	 */
	@Test
	void testendConditionCheck() {
		ISS iss = new ISS(4);
		iss.endConditionCheck(iss.getClockTick());
		assertEquals(iss.getPowerSwitch(), true);
		iss.setClockTick(-1);
		iss.endConditionCheck(iss.getClockTick());
		assertEquals(iss.getPowerSwitch(), false);
	}
	/**
	 * Test method for {@link structure.ISS#writeToFile()}.
	 * @throws IOException 
	 */
	@Test
	void testWriteToFile() throws IOException {
		File data = new File("C:\\Users\\Leika Yamada\\Desktop\\360 Software Development\\data2.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(data));
		ISS.writeToFile(writer);
		writer.close();
		assertTrue( 0 != data.length());
	}
}