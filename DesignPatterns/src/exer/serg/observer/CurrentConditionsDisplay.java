package exer.serg.observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
//	private float pressure;
	private Observable weatherData;
	
	public CurrentConditionsDisplay(Observable weatherData) {
		weatherData.addObserver(this);
		this.weatherData = weatherData;
	}

/*	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}
*/
	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and "
				+ humidity + "% humidity");
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
		
	}
	
	public void removeSubj() {
		weatherData.deleteObserver(this);	
	}

}
