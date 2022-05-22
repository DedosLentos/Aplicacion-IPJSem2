package aplicacion;
//Clase padre Vehiculo
public class Vehiculo {

	//Atributos de clase Vehiculo
	public int idVehiculo;
	private String nombre;
	private String color;
	private String tipo;

	//Getters y setters de Vehiculo
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

	//Constructor de Vehiculo
	public Vehiculo(int idVehiculo, String nombre, String color, String tipo) {
		this.idVehiculo = idVehiculo;
		this.nombre = nombre;
		this.color = color;
		this.tipo=tipo;
	}

	//Método toString de Vehiculo
	@Override
	public String toString() {
		return "Vehiculo idVehiculo=" + idVehiculo + ", nombre=" + nombre + ", color=" + color +", tipo:"+tipo+ "\n";
	}

}



