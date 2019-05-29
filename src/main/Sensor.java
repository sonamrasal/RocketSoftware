package main;

public class Sensor {

	private String sensorId;
	private float temperature;

	public Sensor(String sensorId, float temperature) {
		this.sensorId = sensorId;
		// TODO Auto-generated constructor stub
		this.temperature = temperature;
	}

	public String getSensorId() {
		return sensorId;
	}

	public double getTemperature() {
		return temperature;
	}
	
	
}
