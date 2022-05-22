package aplicacion;
//Clase hija Barco

public class Barco extends Vehiculo {
	
	//Atributos de clase Barco
	public double eslora;
	public double manga;
	
	//Constructor de Barco
	public Barco(int idVehiculo, String nombre, String color,String tipo,double eslora, double manga) {
		super(idVehiculo, nombre, color,tipo);
		this.eslora = eslora;
		this.manga = manga;
	}
}
