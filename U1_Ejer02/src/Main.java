import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate[] fechas = {
				LocalDate.of(2023, 12, 30),
				LocalDate.of(2021, 8, 3),
				LocalDate.of(2001, 4, 13),
				LocalDate.of(2020, 1, 5),
				LocalDate.of(2003, 5, 21),
		};
	
		LocalDate fechaMasAntigua = fechas[0];
		for (LocalDate fecha : fechas) {
			if (fecha.isBefore(fechaMasAntigua)) {
				fechaMasAntigua=fecha;
			}
		}
		System.out.println(fechaMasAntigua);
	
	
	
	}

}
