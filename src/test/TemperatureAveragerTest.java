package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.Sensor;
import main.TemperatureAverager;

public class TemperatureAveragerTest {
	private TemperatureAverager avgTemp;

	@Before
	public void setUp() {
		avgTemp = new TemperatureAverager();
	}

	@Test
	public void noTemperatureNoAverage() {
		TemperatureAverager avgTemp = new TemperatureAverager();
		Assert.assertEquals(0, avgTemp.average().size());
	}

	@Test
	public void addTemperatureForASensor() {
		avgTemp.add(new Sensor("ABCD", 20));
		Assert.assertTrue("ABCD - 20.00".equals(avgTemp.average().get(0).toString()));
	}
	
	@Test
	public void addTemperaturesForASensor() {
		avgTemp.add(new Sensor("ABCD", 20));
		avgTemp.add(new Sensor("ABCD", 20.1f));
		Assert.assertTrue("ABCD - 20.05".equals(avgTemp.average().get(0)));
	}

	
/*	@Test
	public void addTemperaturesForMultipleSensor() {
		avgTemp.add(new Sensor("ABCD", 20));
		avgTemp.add(new Sensor("ABCD", 20.1f));
		avgTemp.add(new Sensor("ABCD1", 10.1f));
		avgTemp.add(new Sensor("ABCD2", 10f));
		avgTemp.add(new Sensor("ABCD1", 20.1f));
		List<Float> averagesForSensors = avgTemp.average();
		Assert.assertNotNull(averagesForSensors);
		Assert.assertEquals(3, averagesForSensors.size());
		
		//Assert.assertEquals(20.05, averagesForSensors.get(0), 0.01);
	}
*/
}
