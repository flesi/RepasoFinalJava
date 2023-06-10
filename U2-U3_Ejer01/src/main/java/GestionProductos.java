import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestionProductos {

	private ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public GestionProductos() {
		try {
			Connection con = ConectarBd.getConnection();
			String sql = "Select * from productos";
			
			PreparedStatement ps = con.prepareStatement(
					sql,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = ps.executeQuery();
			
			rs.last();
			int nFilas = rs.getRow();
			rs.beforeFirst();
			
			if (nFilas>0) {
				while (rs.next()) {
					String codigoProducto = rs.getString("codigoProducto");
					String nombreProducto = rs.getString("nombreProducto");
					String categoriaProducto = rs.getString("categoriaProducto");
					String escala = rs.getString("escala");
					String vendedor = rs.getString("vendedor");
					String descripcion = rs.getString("descripcion");
					int unidadesStock = rs.getInt("unidadesStock");
					double precioCompra = rs.getDouble("precioCompra");
					double precioVenta = rs.getDouble("precioVenta");
					productos.add(new Producto(codigoProducto,nombreProducto,categoriaProducto,escala,vendedor,descripcion,unidadesStock,precioCompra,precioVenta));
				}
			}			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public ArrayList<Producto> getListaProductos(){
		return productos;
	}
	
	// API STREAM
	
//	buscar producto por código.
	public Optional<Producto> getProducto(String codigo) {
		return productos.stream()
				.filter(c -> c.getCodigoProducto().equals(codigo))
				.findFirst();
	}
		
//	retornar los productos con precio de compra entre dos valores. Ordenar por precio de compra ascendentemente.
	public List<Producto> productosEntrePrecio(double valor1, double valor2){
		return productos.stream()
		.filter(p -> p.getPrecioCompra() > valor1 && p.getPrecioCompra() < valor2)
		.sorted()
		.collect(Collectors.toList());
		
	}
	
	
//	retornar los productos de una escala concreta
	public List<Producto> productosEscala(String escala){
		return productos.stream()
		.filter(e -> e.getEscala().equalsIgnoreCase(escala))
		.collect(Collectors.toList());
	}
	
//	retornar las categorías existentes. Una sola vez cada una.
	public List<String> categoriaProductos(){
		return productos.stream()
		.map(Producto::getCategoriaProducto)
		.distinct()
		.toList();
	}
	
//	mostrar los productos (código, nombre, vendedor y precio de compra) ordenando los datos por el campo precio de compra ASC.

	
	
	
	
}
