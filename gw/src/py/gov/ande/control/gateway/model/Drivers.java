package py.gov.ande.control.gateway.model;
// Generated 21/07/2016 02:30:07 PM by Hibernate Tools 5.1.0.Alpha1

/**
 * Drivers generated by hbm2java
 */
public class Drivers implements java.io.Serializable {

	private int id;
	private String description;
	private String observation;
	private Boolean iec61850;
	private Boolean iec101;
	private Boolean ied;
	private Boolean subestation;

	public Drivers() {
	}

	public Drivers(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public Drivers(int id, String description, String observation, Boolean iec61850, Boolean iec101, Boolean ied,
			Boolean subestation) {
		this.id = id;
		this.description = description;
		this.observation = observation;
		this.iec61850 = iec61850;
		this.iec101 = iec101;
		this.ied = ied;
		this.subestation = subestation;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Boolean getIec61850() {
		return this.iec61850;
	}

	public void setIec61850(Boolean iec61850) {
		this.iec61850 = iec61850;
	}

	public Boolean getIec101() {
		return this.iec101;
	}

	public void setIec101(Boolean iec101) {
		this.iec101 = iec101;
	}

	public Boolean getIed() {
		return this.ied;
	}

	public void setIed(Boolean ied) {
		this.ied = ied;
	}

	public Boolean getSubestation() {
		return this.subestation;
	}

	public void setSubestation(Boolean subestation) {
		this.subestation = subestation;
	}

}
