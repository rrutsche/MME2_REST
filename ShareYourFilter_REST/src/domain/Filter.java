package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Filter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8665182375873062581L;

	@Id
	@GeneratedValue
	private long id;

	private String name;
	private int brightness;
	private int contrast;
	private int saturation;
	private int red;
	private int green;
	private int blue;
	private boolean negative;
	private float[] random;

	@Temporal(TemporalType.DATE)
	Date created;
	@Temporal(TemporalType.DATE)
	Date changed;

	public Filter() {

	}

	public Filter(String name, int brightness, int contrast, int saturation,
			int red, int green, int blue, boolean negative) {
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

	public long getId() {
		return id;
	}

	private Date getCurrentDate() {
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

	public float[] getRandom() {
		return random;
	}

	public void setRandom(float[] random) {
		this.random = random;
	}

	@Override
	public String toString() {
		return "Filter [id=" + id + ", name=" + name + ", brightness="
				+ brightness + ", contrast=" + contrast + ", saturation="
				+ saturation + ", red=" + red + ", green=" + green + ", blue="
				+ blue + ", negative=" + negative + ", created=" + created
				+ ", changed=" + changed + "]";
	}

}
