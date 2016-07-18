package py.gov.ande.control.gateway.model;
// Generated 18/07/2016 01:42:16 AM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;

/**
 * Playground generated by hbm2java
 */
public class Playground implements java.io.Serializable {

	private int equipId;
	private String type;
	private String color;
	private String location;
	private Date installDate;

	public Playground() {
	}

	public Playground(int equipId, String type, String color) {
		this.equipId = equipId;
		this.type = type;
		this.color = color;
	}

	public Playground(int equipId, String type, String color, String location, Date installDate) {
		this.equipId = equipId;
		this.type = type;
		this.color = color;
		this.location = location;
		this.installDate = installDate;
	}

	public int getEquipId() {
		return this.equipId;
	}

	public void setEquipId(int equipId) {
		this.equipId = equipId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getInstallDate() {
		return this.installDate;
	}

	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}

}
