package exer.serg.command;

public class Stereo {
	
	public static final int DEFAULT_VOLUME_LEVEL = 11;
	
	public void on() {
		System.out.println("Stereo is on!");
	}

	public void off() {
		System.out.println("Stereo is off!");
	}
	
	public void setCd() {
		System.out.println("CD is setted!");
	}
	
	public void setDvd() {
		System.out.println("DVD is setted!");
	}
	
	public void setRadio() {
		System.out.println("Radio is setted!");
	}
	
	public void setVolume(int level) {
		System.out.println("Volume level is setted to " + level + "!");
	}
}
