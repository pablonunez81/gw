package py.gov.ande.control.gateway.model;
// Generated 05/07/2016 01:12:05 AM by Hibernate Tools 5.1.0.Alpha1

/**
 * InformationType generated by hbm2java
 */
public class InformationType implements java.io.Serializable {

	private int id;
	private String description;

	public InformationType() {
	}

	public InformationType(int id, String description) {
		this.id = id;
		this.description = description;
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

}
