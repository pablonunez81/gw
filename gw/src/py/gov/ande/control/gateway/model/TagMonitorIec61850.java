package py.gov.ande.control.gateway.model;
// Generated 31/07/2016 03:04:36 PM by Hibernate Tools 5.1.0.Alpha1

/**
 * TagMonitorIec61850 generated by hbm2java
 */
public class TagMonitorIec61850 implements java.io.Serializable {

	private int id;
	private Boolean use;
	private String name;
	private Integer informationTypeId;
	private String telegramAddress;
	private Integer reportingCapacibiliyId;
	private Boolean buffered;
	private Boolean unbuffered;
	private int iedId;
	private Integer normalizationId;
	private Integer brcbId;
	private Integer urcbId;

	public TagMonitorIec61850() {
	}

	public TagMonitorIec61850(int id, String telegramAddress, int iedId) {
		this.id = id;
		this.telegramAddress = telegramAddress;
		this.iedId = iedId;
	}

	public TagMonitorIec61850(int id, Boolean use, String name, Integer informationTypeId, String telegramAddress,
			Integer reportingCapacibiliyId, Boolean buffered, Boolean unbuffered, int iedId, Integer normalizationId,
			Integer brcbId, Integer urcbId) {
		this.id = id;
		this.use = use;
		this.name = name;
		this.informationTypeId = informationTypeId;
		this.telegramAddress = telegramAddress;
		this.reportingCapacibiliyId = reportingCapacibiliyId;
		this.buffered = buffered;
		this.unbuffered = unbuffered;
		this.iedId = iedId;
		this.normalizationId = normalizationId;
		this.brcbId = brcbId;
		this.urcbId = urcbId;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getUse() {
		return this.use;
	}

	public void setUse(Boolean use) {
		this.use = use;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getInformationTypeId() {
		return this.informationTypeId;
	}

	public void setInformationTypeId(Integer informationTypeId) {
		this.informationTypeId = informationTypeId;
	}

	public String getTelegramAddress() {
		return this.telegramAddress;
	}

	public void setTelegramAddress(String telegramAddress) {
		this.telegramAddress = telegramAddress;
	}

	public Integer getReportingCapacibiliyId() {
		return this.reportingCapacibiliyId;
	}

	public void setReportingCapacibiliyId(Integer reportingCapacibiliyId) {
		this.reportingCapacibiliyId = reportingCapacibiliyId;
	}

	public Boolean getBuffered() {
		return this.buffered;
	}

	public void setBuffered(Boolean buffered) {
		this.buffered = buffered;
	}

	public Boolean getUnbuffered() {
		return this.unbuffered;
	}

	public void setUnbuffered(Boolean unbuffered) {
		this.unbuffered = unbuffered;
	}

	public int getIedId() {
		return this.iedId;
	}

	public void setIedId(int iedId) {
		this.iedId = iedId;
	}

	public Integer getNormalizationId() {
		return this.normalizationId;
	}

	public void setNormalizationId(Integer normalizationId) {
		this.normalizationId = normalizationId;
	}

	public Integer getBrcbId() {
		return this.brcbId;
	}

	public void setBrcbId(Integer brcbId) {
		this.brcbId = brcbId;
	}

	public Integer getUrcbId() {
		return this.urcbId;
	}

	public void setUrcbId(Integer urcbId) {
		this.urcbId = urcbId;
	}

}
