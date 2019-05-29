package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TemperatureAverager {

	private Map<String, List<Double>> containerMap;

	public TemperatureAverager() {
		containerMap = new HashMap();
	}

	public List<SensorAverageTemparature> average() {

		List<SensorAverageTemparature> result = new ArrayList();
		Set<Entry<String, List<Double>>> allEntries = containerMap.entrySet();

		allEntries.forEach(entry -> {
			List<Double> values = entry.getValue();
			int totalItem = values.size();
			float totalTemperature = 0;
			for (int i = 0; i < values.size(); i++) {
				totalTemperature += values.get(i);
			}
			result.add(new SensorAverageTemparature(entry.getKey(),
					totalTemperature / totalItem));
		});
		// consider only those entries which are not older than 15 minutes
		// allEntries - perKey => currentTime <TempData> -> compare currentTime
		// - tempData.timeStamp - totalTempForSensor += this.tempEntry
		Collections.sort(result);
		return result;
	}

	public void add(Sensor sensor) {
		// TempData - timeStamp, temperature -> store timestamp
		List<Double> allTemperatures = containerMap.containsKey(sensor
				.getSensorId()) ? containerMap.get(sensor.getSensorId())
				: new ArrayList<Double>();
		allTemperatures.add(sensor.getTemperature());
		containerMap.put(sensor.getSensorId(), allTemperatures);
	}

}
