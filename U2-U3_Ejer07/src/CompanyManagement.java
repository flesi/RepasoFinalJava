import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CompanyManagement {

	private ArrayList<Company> companys = new ArrayList<>();
	
	public CompanyManagement() {
		ArrayList<String> documento = getDocumento();
		for (String company : documento) {
			int index = Integer.parseInt(company.split(",")[0]);
			String organizationId = company.split(",")[1];
			String name = company.split(",")[2];
			String website = company.split(",")[3];
			String country = company.split(",")[4];
			String description = company.split(",")[5];
			String founded = company.split(",")[6];
			String industry = company.split(",")[7];
			int numberOfEmployees = Integer.parseInt(company.split(",")[8]);

			companys.add(new Company(index, organizationId, name, website, country, description, founded, industry, numberOfEmployees));
		}	
	}
	
	private ArrayList<String> getDocumento() {
		ArrayList<String> documento = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("organizations-1000.csv"));
			
			String linea = br.readLine();
			
			while ((linea=br.readLine())!=null) {
				documento.add(linea);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return documento;
	}
	
	public ArrayList<Company> mostrarDatos() {
		return companys;
	}
	
	
//	//API STREAM
	
	
//	Extraer las 10 empresas con mayor número de empleados (todos los datos).
	public List<Company> top10() {
		return companys.stream()
		.sorted(Comparator.comparingInt(Company::getNumberOfEmployees).reversed())
		.limit(10)
		.collect(Collectors.toList());
	}

	
//	Extraer la empresa (solo nombre) con mayor número de empleados.
	public Optional<String> nombreEmpresaMasEmpleados(){
		return companys.stream()
		.sorted(Comparator.comparingInt(Company::getNumberOfEmployees).reversed())
		.map(Company::getName)
		.findFirst();
	}
	
//	Extraer las empresas (todos los datos) de varios países pasados como parámetros.
	public List<Company> getCompanyCountrys(String pais1, String pais2){
		return companys.stream()
		.filter(c -> c.getCountry().equalsIgnoreCase(pais1) ||  c.getCountry().equalsIgnoreCase(pais2))
		.collect(Collectors.toList());
	}
	
//	Mostrar las empresas de un país concreto ordenando los datos por número de trabajadores de forma ascendente.
	public List<Company> getCompanyFromCountry(String country){
		return companys.stream()
		.filter(e -> e.getCountry().equalsIgnoreCase(country))
		.sorted(Comparator.comparingInt(Company::getNumberOfEmployees))
		.collect(Collectors.toList());
	}
	
	
}
