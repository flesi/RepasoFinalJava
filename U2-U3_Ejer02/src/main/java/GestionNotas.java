import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GestionNotas {

	public static ResultSet getDatos(int idExamen) {
		try {
			Connection con = ConectarBd.getConnection();
			String sql = "SELECT idalumno, nombre, apellidos, nota, idexamen, descripcion FROM notas n INNER JOIN examenes e ON n.idexamen = e.id INNER JOIN alumnos a ON n.idalumno = a.id WHERE idexamen= ?";

			PreparedStatement ps = con.prepareStatement(
					sql,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			ps.setInt(1, idExamen);
			
			ResultSet rs = ps.executeQuery();
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void crearPdf(ResultSet rs) throws IOException, DocumentException {
		try {
			rs.last();
			int nFilas = rs.getRow();
			rs.beforeFirst();
			
			if (nFilas > 0) {
				
				//CABEZA DEL PDF
				
				rs.next();
				String idExamen = rs.getString("idexamen");
				String descripcion = rs.getString("descripcion");
								
				 //Creamos un documento pdf
	            Document documento = new Document();
	            //creamos un archivo binario
	            OutputStream ficheroPdf = Files.newOutputStream(Paths.get("Notas_"+ descripcion +"_" + idExamen + ".pdf"));
				
	            //Asociar documento con FileOutputStream e indicar espacio entre líneas
	            PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
	            documento.open();
	            
	            //fuentes
	            Font fontArialNormal = new Font(FontFactory.getFont("arial", 8, Font.NORMAL, BaseColor.BLACK));  
	            Font fontArialNegrita = new Font(FontFactory.getFont("arial", 8, Font.BOLD, BaseColor.BLACK));  
				
	            
	            PdfPTable tableCab = new PdfPTable(2);
	            
	            Phrase texto = new Phrase("ID Examen: " + idExamen, fontArialNegrita);            
	            tableCab.addCell(texto);
	            texto = new Phrase("Descripcion: " + descripcion, fontArialNegrita);            
	            tableCab.addCell(texto);
	            
	            documento.add(tableCab);
	            
	            documento.add(new Phrase(" "));
	            documento.add(new Phrase(" "));
	            
				// CUERPO PDF
				
				rs.beforeFirst();
				while (rs.next()) {
					PdfPTable tableDetalle = new PdfPTable(3);
					
		            texto = new Phrase("Apellido: " + rs.getString("apellidos"), fontArialNegrita);            
		            tableDetalle.addCell(texto);
		            texto = new Phrase("Nombre: " + rs.getString("nombre"), fontArialNegrita);            
		            tableDetalle.addCell(texto);
		            texto = new Phrase("Nota: " + rs.getDouble("nota"), fontArialNegrita);            
		            tableDetalle.addCell(texto);
		            
		            documento.add(tableDetalle);
				}			
				documento.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
