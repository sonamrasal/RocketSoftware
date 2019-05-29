package test;

import java.util.List;

import main.Sensor;
import main.SensorAverageTemparature;
import main.TemperatureAverager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TemperatureAveragerTest {
	private TemperatureAverager averager;

	@Before
	public void setUp() {
		averager = new TemperatureAverager();
	}

	@Test
	public void noTemperatureNoAverage() {
		TemperatureAverager avgTemp = new TemperatureAverager();
		Assert.assertEquals(0, avgTemp.average().size());
	}

	@Test
	public void addTemperatureForASensor() {
		averager.add(new Sensor("ABCD", 20));
		Assert.assertTrue("ABCD - 20.00".equals(averager.average().get(0).toString()));
	}
	
	@Test
	public void addTemperaturesForASensor() {
		averager.add(new Sensor("ABCD", 20));
		averager.add(new Sensor("ABCD", 20.1f));
		Assert.assertTrue("ABCD - 20.05".equals(averager.average().get(0).toString()));
	}

	
	@Test
	public void addTemperaturesForMultipleSensor() {
		averager.add(new Sensor("ABCD", 20));
		averager.add(new Sensor("ABCD", 20.1f));
		averager.add(new Sensor("ABCD1", 10.1f));
		averager.add(new Sensor("ABCD2", 10f));
		averager.add(new Sensor("ABCD1", 20.1f));
		List<SensorAverageTemparature> averagesForSensors = averager.average();
		Assert.assertNotNull(averagesForSensors);
		Assert.assertEquals(3, averagesForSensors.size());
		
		Assert.assertTrue("ABCD - 20.05".equals(averagesForSensors.get(0).toString()));
		Assert.assertTrue("ABCD1 - 15.10".equals(averagesForSensors.get(1).toString()));
		Assert.assertTrue("ABCD2 - 10.00".equals(averagesForSensors.get(2).toString()));
	}

}
