import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CompanyManagement companyManagement = new CompanyManagement();

//		for (Company company : companyManagement.mostrarDatos()) {
//			System.out.println(company.toString());
//		}

//		Optional eMP = companyManagement.nombreEmpresaMasEmpleados();
//		if (eMP.isPresent()) {
//			System.out.println(eMP.toString());
//		} else {
//			System.out.println("no existe");
//		}
		
		
		
		for (Object string : companyManagement.getCompanyFromCountry("United States of America").toArray()) {
			System.out.println(string.toString());
		}		
	}

}
