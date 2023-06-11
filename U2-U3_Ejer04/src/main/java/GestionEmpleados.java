import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionEmpleados {

	
	public static void cargarDocumento() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("empleados.csv"));
			
			String linea = br.readLine();
			
			while ((linea = br.readLine())!=null) {
				System.out.print(linea);
				int nEmpleado = Integer.parseInt(linea.split(",")[0]);
				if (esEmpleado(nEmpleado)) {
					System.out.print(" - Es Empleado");
				} else {
					System.out.print(" - No es Empleado");
				}
				System.out.println("");
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static boolean esEmpleado(int nEmpleado) {
		boolean esEmpleado=false;
		try {
			Connection con = ConectarBd.getConnection();
			String sql = "SELECT * FROM `empleados` WHERE numeroEmpleado=?";
			
			PreparedStatement ps = con.prepareStatement(
					sql,
					ResultSet.CONCUR_READ_ONLY,
					ResultSet.TYPE_SCROLL_SENSITIVE);
			ps.setInt(1, nEmpleado);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				esEmpleado=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return esEmpleado;
	}
	
}
