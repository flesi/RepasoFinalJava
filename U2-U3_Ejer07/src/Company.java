
public class Company {

	//Index,Organization Id,Name,Website,Country,Description,Founded,Industry,Number of employees
	//1,E84A904909dF528,Liu-Hoover,http://www.day-hartman.org/,Western Sahara,Ergonomic zero administration knowledge user,1980,Online Publishing,6852
	private int index;
	private String OrganizationId;
	private String name;
	private String website;
	private String country;
	private String description;
	private String founded;
	private String Industry;
	private int numberOfEmployees;
	
	public Company(int index, String organizationId, String name, String website, String country, String description,
			String founded, String industry, int numberOfEmployees) {
		super();
		this.index = index;
		OrganizationId = organizationId;
		this.name = name;
		this.website = website;
		this.country = country;
		this.description = description;
		this.founded = founded;
		Industry = industry;
		this.numberOfEmployees = numberOfEmployees;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getOrganizationId() {
		return OrganizationId;
	}
	public void setOrganizationId(String organizationId) {
		OrganizationId = organizationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFounded() {
		return founded;
	}
	public void setFounded(String founded) {
		this.founded = founded;
	}
	public String getIndustry() {
		return Industry;
	}
	public void setIndustry(String industry) {
		Industry = industry;
	}
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}
	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	@Override
	public String toString() {
		return "Company [index=" + index + ", OrganizationId=" + OrganizationId + ", name=" + name + ", website="
				+ website + ", country=" + country + ", description=" + description + ", founded=" + founded
				+ ", Industry=" + Industry + ", numberOfEmployees=" + numberOfEmployees + "]";
	}
	
	
	
	
}
