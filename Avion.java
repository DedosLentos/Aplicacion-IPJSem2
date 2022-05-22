package aplicacion;
	
public class Avion  extends Vehiculo {

		public double longitud;
		public int cantPasajeros;
		
		public Avion(int idVehiculo, String nombre, String color,String tipo, double longitud, int cantPasajeros) {
			super(idVehiculo, nombre, color,tipo);
			this.longitud = longitud;
			this.cantPasajeros = cantPasajeros;
		}
		
		
}
