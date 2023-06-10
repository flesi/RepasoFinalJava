import java.io.IOException;

import com.itextpdf.text.DocumentException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			GestionNotas.crearPdf(GestionNotas.getDatos(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
