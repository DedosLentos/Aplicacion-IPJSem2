package aplicacion;
//Clase Avion
public class Avion  extends Vehiculo {

		public double longitud;
		public int cantPasajeros;
		
		//Constructor de Avion
		public Avion(int idVehiculo, String nombre, String color,String tipo, double longitud, int cantPasajeros) {
			super(idVehiculo, nombre, color,tipo);
			this.longitud = longitud;
			this.cantPasajeros = cantPasajeros;
		}
		
		
}
