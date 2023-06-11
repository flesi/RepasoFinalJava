import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestionAspirantes {

	private static ArrayList<Aspirante> aspirantes = new ArrayList<>();
	
	public GestionAspirantes() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("aspirantes.csv"));
//			id,first_name,last_name,email,gender,departament,job title
			String linea = br.readLine();
			while ((linea=br.readLine())!=null) {
				int id= Integer.parseInt(linea.split(",")[0]);
				String firstName = linea.split(",")[1];
				String lastName = linea.split(",")[2];
				String email = linea.split(",")[3];
				String gender = linea.split(",")[4];
				String departament = linea.split(",")[5];
				String jobTitle = linea.split(",")[6];
				
				aspirantes.add(new Aspirante(id, firstName, lastName, email, gender, departament, jobTitle));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	Obtener una lista de los géneros (gender) sin repeticiones.
	public List getGeneros() {
		return aspirantes.stream()
			.map(a -> a.getGender())
			.distinct()
			.collect(Collectors.toList());
	}
	
//	Contar cuántos aspirantes existen de un género pasado como parámetro.
	public long getNumAspirantesGen(String genero) {
		return aspirantes.stream()
			.filter(a -> a.getGender().equalsIgnoreCase(genero))
			.count();
	}
	
	
//	Obtener una lista de los aspirantes de un género a un departamento. Por ejemplo, género “Female” al departamento de “Engineering”.
	public List<Aspirante> getAspiranteGeneroDepartamento(String genero, String departamento){
		return aspirantes.stream()
			.filter(a -> a.getGender().equalsIgnoreCase(genero) && a.getDepartament().equalsIgnoreCase(departamento))
			.collect(Collectors.toList());
	}
	
	
//	Mostrar apellido y nombre de todos los aspirantes ordenando por apellido y nombre.
	public List getAspirantesOrdenados() {
		return aspirantes.stream()
		.sorted(Comparator.comparing(Aspirante::getLastName).thenComparing(Aspirante::getFirstName))
		.collect(Collectors.toList());
	}
	
	
	
//	Buscar un aspirante por su id.
	public Optional<Aspirante> getAspirante(int idAspirante) {
		return aspirantes.stream()
			.filter(a -> a.getId()==idAspirante)
			.findFirst();
	}
	
}
