package main;

public class SensorAverageTemparature {

	private String sensorId;
	private String averageTemperature;

	public SensorAverageTemparature(String sensorId, String averageTemperature) {
		this.sensorId = sensorId;
		this.averageTemperature = averageTemperature;
	}
	
	@Override
	public String toString() {
		return sensorId + " - " + averageTemperature;
	}

}
