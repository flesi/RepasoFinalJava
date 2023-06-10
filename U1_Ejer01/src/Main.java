import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {

	public static void main(String[] args) {
		LocalDate fecha1 = LocalDate.of(2021, 5, 1);
		LocalDate fecha2 = LocalDate.of(2023, 1, 5);
		
		System.out.println("Diferencia en Dias: " + difDias(fecha1,fecha2));
		System.out.println("Diferencia en Meses: " + difMes(fecha1,fecha2));
		System.out.println("Diferencia en Años: " + difAnio(fecha1,fecha2));
		
	}
	
	
	public static long difDias(LocalDate fecha1, LocalDate fecha2) {
		return ChronoUnit.DAYS.between(fecha1, fecha2);
	}

	public static long difMes(LocalDate fecha1, LocalDate fecha2) {
		return ChronoUnit.MONTHS.between(fecha1, fecha2);
	}

	public static long difAnio(LocalDate fecha1, LocalDate fecha2) {
		return ChronoUnit.YEARS.between(fecha1, fecha2);
	}
}
