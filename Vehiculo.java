package aplicacion;

public class Vehiculo {
	
	public int idVehiculo;
	private String nombre;
	private String color;
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Vehiculo(int idVehiculo, String nombre, String color, String tipo) {
		this.idVehiculo = idVehiculo;
		this.nombre = nombre;
		this.color = color;
		this.tipo=tipo;
	}
	@Override
	public String toString() {
		return "Vehiculo idVehiculo=" + idVehiculo + ", nombre=" + nombre + ", color=" + color +", tipo:"+tipo+ "\n";
	}
	public static Vehiculo parse(String text) {
		
		return null;
	}
	
		
		
	
	}
	
	

