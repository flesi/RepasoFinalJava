import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class GestionBd {

	public static double getNotaMedia(int idExamen) {
		double notaMedia = 0;
		
		try {
			Connection con = ConectarBd.getConnection();
			
			String sql = "SELECT AVG(nota) notaMedia FROM `notas` WHERE idexamen= ?";
			
			PreparedStatement ps = con.prepareStatement(
					sql,
					ResultSet.CONCUR_READ_ONLY,
					ResultSet.TYPE_SCROLL_SENSITIVE);
			ps.setInt(1, idExamen);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			if (rs.getString(1)!=null) {
				notaMedia = rs.getDouble("notaMedia");				
			}else {
				System.out.println("Examen No encontrado");
			} 
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notaMedia;
	}
	
}
