package aplicacion;
//en esta clase esta el funcionamiento de la contraseña
import java.util.ArrayList;

public class DatosUsuario {
		//Constructor vacío
		public DatosUsuario( ) {
			
		}
		//Atributos DarosUsuario
		String usuario1="";
		String pass1="";
		
		//Aquí se pueden modificar las credenciales de ingreso si se desea
		public int probarPass() {
			usuario1=PanelLog.usuarioTxt.getText();
			pass1=PanelLog.passTxt.getText();
			if (usuario1.equals("user")&&pass1.equals("1234")) {
				return 1;
			}else {
				return 0;
			}
			//Si retorna 1 el log se da como valido
		
		
		}
		
}
