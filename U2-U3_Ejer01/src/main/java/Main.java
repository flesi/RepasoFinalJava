import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestionProductos gProductos = new GestionProductos();
		
//		for (Producto producto : gProductos.getListaProductos()) {
//			System.out.println(producto.toString());
//		}
		
		
//		if (gProductos.getProducto("S10_1678").isPresent()) {
//			System.out.println(gProductos.getProducto("S131678").toString());
//		} else {
//			System.out.println("Ese producto no existe");
//		}
		
		
//		for (Producto producto : gProductos.productosEntrePrecio(10, 40)) {
//			System.out.println(producto.toString());
//		}
		
//		for (Producto producto : gProductos.productosEscala("1:18")) {
//			System.out.println(producto.toString());
//		}
		
		for (String categoria : gProductos.categoriaProductos()) {
			System.out.println(categoria);
		}
		
		
		
	}

}
