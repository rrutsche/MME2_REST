package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private int brightness;
	private int contrast;
	private int saturation;
	private int red;
	private int green;
	private int blue;
	private boolean negative;
	Date created;
	Date changed;
	
	
	public Filter(){
		
	}
	
	public Filter(String name, int brightness, int contrast, int saturation, int red,
			int green, int blue, boolean negative) {
		this.name = name;
		this.brightness = brightness;
		this.contrast = contrast;
		this.saturation = saturation;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.negative = negative;
		created = getCurrentDate();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int i){
		this.id = i;
	}

	private Date getCurrentDate(){
		return new Date();
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		changed = getCurrentDate();
		this.brightness = brightness;
	}

	public int getContrast() {
		return contrast;
	}

	public void setContrast(int contrast) {
		changed = getCurrentDate();
		this.contrast = contrast;
	}

	public int getSaturation() {
		return saturation;
	}

	public void setSaturation(int saturation) {
		changed = getCurrentDate();
		this.saturation = saturation;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		changed = getCurrentDate();
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		changed = getCurrentDate();
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		changed = getCurrentDate();
		this.blue = blue;
	}

	public boolean isNegative() {
		return negative;
	}

	public void setNegative(boolean negative) {
		changed = getCurrentDate();
		this.negative = negative;
	}

	public Date getCreated() {
		return created;
	}

	public Date getChanged() {
		return changed;
	}
	
}
