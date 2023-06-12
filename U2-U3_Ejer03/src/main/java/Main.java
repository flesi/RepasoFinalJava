import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {

		DecimalFormat df = new DecimalFormat("#.00");
		
		for (int i = 1; i <= 10; i++) {
			int idExamen = i;
			double notaMedia=GestionBd.getNotaMedia(idExamen);
			
			System.out.println("Id Examen: " + idExamen + "\n"
			+ "Nota Media: " + df.format(notaMedia));
			System.out.println("***************");
		}
		
	}

}
