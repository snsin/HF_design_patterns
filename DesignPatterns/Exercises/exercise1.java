import java.util.Observable;
import java.util.Observer;

import exer.serg.observer.DisplayElement;
import exer.serg.observer.WeatherData;

public class ForecastDisplay implements Observer, DisplayElement {
	private float currentPressure = 29.92f;
	private float lastPressure;
	
	public ForecastDisplay(Observable observable) {
		observable.addObserver(this);
		
	}
	
	@Override
	public void update(Observable observable, Object args){
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) observable;
			lastPressure = currentPressure;
			currentPressure = weatherData.getPressure();
		}
		display();
		
	}
	
	@Override
	public void display() {
		//display code here
	}
}