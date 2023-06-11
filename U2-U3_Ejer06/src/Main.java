
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GestionAspirantes gestionAspirantes = new GestionAspirantes();
		
//		System.out.println(gestionAspirantes.getGeneros().toString());
//		
//		System.out.println(gestionAspirantes.getNumAspirantesGen("Female"));
//		
//		System.out.println(gestionAspirantes.getAspiranteGeneroDepartamento("Female", "Human Resources"));
//
//		if (gestionAspirantes.getAspirante(2).isPresent()) {
//			System.out.println(gestionAspirantes.getAspirante(2).toString());
//		}
		

		System.out.println(gestionAspirantes.getAspirantesOrdenados().toString());
		
	}

}
