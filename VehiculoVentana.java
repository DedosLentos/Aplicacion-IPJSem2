package aplicacion;
//Clase de la ventana VehiculoVentana
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;

public class VehiculoVentana {

	//Atributos de clase VehiculoVentana
	public JFrame frmDarAltaVehculo;
	protected Object frmDarAltaVehiculo;
	private JTextField texID;
	private JTextField textNombre;
	private JTextField textColor;
	public ArrayList<Vehiculo>vehiculo=new ArrayList<Vehiculo>();
	private JTextField textResultado;
	private JButton btnSalir;
	private JButton btnMostrar;
	private JTextField textTipo;

	//Método main donde se hace visible la ventana
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehiculoVentana window = new VehiculoVentana();
					window.frmDarAltaVehculo.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Método que hace algo
	public VehiculoVentana() {
		initialize();
	}

	//Definición del frame
	private void initialize() {
		frmDarAltaVehculo = new JFrame();
		frmDarAltaVehculo.setResizable(false);
		frmDarAltaVehculo.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\titof\\OneDrive\\Escritorio\\Pablo\\LTI\\Semestre I\\5-Programaci\u00F3n en Java\\Semana 1\\Cod2.png"));
		frmDarAltaVehculo.setTitle("Dar alta veh\u00EDculo");
		frmDarAltaVehculo.setBounds(100, 100, 459, 383);
		frmDarAltaVehculo.getContentPane().setLayout(null);

		//Se crea etiqueta ID
		JLabel lblIDVehiculo = new JLabel("ID:");
		lblIDVehiculo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblIDVehiculo.setBounds(135, 21, 44, 27);
		frmDarAltaVehculo.getContentPane().add(lblIDVehiculo);

		//Se crea etiqueta Nombre
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNombre.setBounds(104, 58, 85, 27);
		frmDarAltaVehculo.getContentPane().add(lblNombre);

		//Se crea etiqueta Color
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Arial", Font.PLAIN, 18));
		lblColor.setBounds(124, 93, 65, 27);
		frmDarAltaVehculo.getContentPane().add(lblColor);

		//Se crea campo de texto ID
		texID = new JTextField();
		texID.setBounds(192, 25, 96, 19);
		frmDarAltaVehculo.getContentPane().add(texID);
		texID.setColumns(10);

		//Se crea campo de texto Nombre
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(192, 62, 96, 19);
		frmDarAltaVehculo.getContentPane().add(textNombre);

		//Se crea campo de texto Color
		textColor = new JTextField();
		textColor.setColumns(10);
		textColor.setBounds(192, 99, 96, 19);
		frmDarAltaVehculo.getContentPane().add(textColor);

		//Se crea botón vehículo
		JButton btnVehiculo = new JButton("Ingresar Veh\u00EDculo");
		btnVehiculo.setFont(new Font("Arial", Font.PLAIN, 13));
		btnVehiculo.addMouseListener(new MouseAdapter() {

			//Se crea método Ingresar Vehículo
			@Override
			public void mouseClicked(MouseEvent e) {
				//Control de excepciones con try y catch
				try {
					//Variables
					int idVehiculo;
					String nombre;
					String color;
					String tipo;	

					//Asigna a las variables lo que se escribe en los campos de texto
					idVehiculo = Integer.parseInt(texID.getText());			
					nombre = textNombre.getText();		
					color = textColor.getText();		
					tipo=textTipo.getText();

					//Instancia Vehículo var y lo agrega a la ista
					Vehiculo var=new Vehiculo(idVehiculo,nombre,color,tipo);
					vehiculo.add(var);

					//Borra los campos luego de ingresar la persona
					texID.setText("");
					textNombre.setText("");
					textColor.setText("");
					textTipo.setText("");

					//No les voy a mentir, no se muy bien que hace este for aca
					for (Vehiculo g: vehiculo)
						System.out.println(g);

					//Si no se ingresan todos los datos sale un mensaje para indicarlo
				}catch(Exception ex) {
					if(texID.getText().equals("")|| textNombre.getText().equals("") || textColor.getText().equals("")|| textTipo.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Verifique la información"); 
					}
				}

			}
		});
		//Añade el botón vehículo y define sus caracteristicas
		btnVehiculo.setBounds(135, 180, 134, 21);
		frmDarAltaVehculo.getContentPane().add(btnVehiculo);

		//Crea y define campo de texto Resultados (Donde se imprimen los usuarios luego)
		textResultado = new JTextField();
		textResultado.setFont(new Font("Arial", Font.PLAIN, 13));
		textResultado.setBounds(20, 211, 402, 94);
		frmDarAltaVehculo.getContentPane().add(textResultado);
		textResultado.setColumns(10);

		//Crea botón salir y su método
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 13));
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

		});

		//Añade el boton salir y define sus caracteristicas
		btnSalir.setBounds(337, 315, 85, 21);
		frmDarAltaVehculo.getContentPane().add(btnSalir);

		//Crea botón mostrar y define sus métodos
		btnMostrar = new JButton("Mostrar Veh\u00EDculo");
		btnMostrar.addMouseListener(new MouseAdapter() {
			//Muestra la lista en el campo de texto Resultado, convirtiendo los datos de la lista a String
			@Override
			public void mouseClicked(MouseEvent e) {
				textResultado.setText(String.valueOf(vehiculo));
			}
		});

		//Crea y añade botón mostrar,también define sus caracteristicas
		btnMostrar.setFont(new Font("Arial", Font.PLAIN, 13));
		btnMostrar.setBounds(34, 315, 125, 21);
		frmDarAltaVehculo.getContentPane().add(btnMostrar);

		//Crea y añade el texto Tipo
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTipo.setBounds(135, 132, 44, 27);
		frmDarAltaVehculo.getContentPane().add(lblTipo);

		//Crea y añade el campo de texto Tipo
		textTipo = new JTextField();
		textTipo.setColumns(10);
		textTipo.setBounds(192, 138, 96, 19);
		frmDarAltaVehculo.getContentPane().add(textTipo);
	}
}
