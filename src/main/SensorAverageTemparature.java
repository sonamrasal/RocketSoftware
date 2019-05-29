package main;

import java.text.DecimalFormat;

public class SensorAverageTemparature implements Comparable<SensorAverageTemparature> {

	private String sensorId;
	private double averageTemperature;

	public SensorAverageTemparature(String sensorId, double averageTemperature) {
		this.sensorId = sensorId;
		this.averageTemperature = averageTemperature;
	}

	@Override
	public String toString() {
		return sensorId + " - "
				+ new DecimalFormat("0.00").format(averageTemperature);
	}

	@Override
	public int compareTo(SensorAverageTemparature arg0) {
		return this.sensorId.compareTo(arg0.sensorId);
	}

}
