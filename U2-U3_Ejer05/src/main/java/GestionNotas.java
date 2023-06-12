import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestionNotas {
	
	private ArrayList<String> nuevasNotas = new ArrayList<String>();
	
	private ArrayList<String> cargarDocumento() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("nuevasNotas.csv"));
//			 CSV -> id de alumno, id de examen, nota.
			
			String linea;
			while (((linea=br.readLine())) != null) {
				nuevasNotas.add(linea);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nuevasNotas;
	}

	public void cambiarNotas() {
		cargarDocumento();
		try {
			Connection con = ConectarBd.getConnection();
			String sql = "UPDATE notas SET nota = ? WHERE idalumno=? AND idexamen=? AND nota < ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			for (String nuevaNota : nuevasNotas) {
				int idAlumno = Integer.parseInt(nuevaNota.split(";")[0]);
				int idExamen = Integer.parseInt(nuevaNota.split(";")[1]);
				double nota = Double.parseDouble(nuevaNota.split(";")[2]);
				
				ps.setDouble(1, nota);
				ps.setInt(2, idAlumno);
				ps.setInt(3, idExamen);
				ps.setDouble(4, nota);
				
				int n = ps.executeUpdate();
				
				// LOG CONSOLA
				System.out.println("IdAlumno: "+ idAlumno);
				System.out.println("IdExamen: "+ idExamen);
				System.out.println("Nota: "+ nota);
												
				if (n==1) {
					System.out.println("Nota Actualizada");
				} else {
					System.out.println("Nota No Actualizada");
				}
				System.out.println("*******");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
