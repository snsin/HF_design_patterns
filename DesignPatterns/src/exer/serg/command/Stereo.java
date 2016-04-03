package exer.serg.command;

public class Stereo {
	
	public static final int DEFAULT_VOLUME_LEVEL = 11;
	private String place;
	
	public Stereo(String place) {
		this.place = place;
	}
	
	public void on() {
		System.out.println(place +  "stereo is on!");
	}

	public void off() {
		System.out.println(place +  "stereo is off!");
	}
	
	public void setCd() {
		System.out.println(place +  "stereo is set for CD input!");
	}
	
	public void setDvd() {
		System.out.println(place +  "stereo is set for DVD input!");
	}
	
	public void setRadio() {
		System.out.println(place +  "stereo is set for radio input!");
	}
	
	public void setVolume(int level) {
		System.out.println(place +  "stereo volume is setted to " + level + "!");
	}
}
