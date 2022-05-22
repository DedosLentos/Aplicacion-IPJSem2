package aplicacion;

public class Barco extends Vehiculo {

		public double eslora;
		public double manga;
		
		public Barco(int idVehiculo, String nombre, String color,String tipo,double eslora, double manga) {
			super(idVehiculo, nombre, color,tipo);
			this.eslora = eslora;
			this.manga = manga;
		}
}
