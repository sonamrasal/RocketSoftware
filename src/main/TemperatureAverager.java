package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TemperatureAverager {

	private Map<String, List<Float>> containerMap;

	public TemperatureAverager() {
		containerMap = new HashMap();
	}

	public List<SensorAverageTemparature> average() {
		DecimalFormat format = new DecimalFormat("0.00");
		List<SensorAverageTemparature> result = new ArrayList();
		Set<Entry<String, List<Float>>> allEntries = containerMap.entrySet();

		allEntries.forEach(entry -> {
			List<Float> values = entry.getValue();
			int totalItem = values.size();
			float totalTemperature = 0;
			for(int i = 0; i < values.size(); i++) {
				totalTemperature += values.get(i);
			}
			result.add(new SensorAverageTemparature(entry.getKey(), format.format(totalTemperature / totalItem)));
		});
		// allEntries - perKey => currentTime <TempData> -> compare currentTime
		// - tempData.timeStamp - totalTempForSensor += this.tempEntry
		return result;
	}

	public void add(Sensor sensor) {
		// TempData - timeStamp, temperature
		List<Float> allTemperatures;
		if (containerMap.containsKey(sensor.getSensorId())) {
			allTemperatures = containerMap.get(sensor.getSensorId());
		} else {
			allTemperatures = new ArrayList<>();
		}
		allTemperatures.add(sensor.getTemperature());
		containerMap.put(sensor.getSensorId(), allTemperatures);
	}

}
