package aplicacion;
//Clase Principal, en ella se define la interfaz donde se ingresan los usuarios, se accede a menú ingresar Vehículo, y más!
import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.time.*;
import java.util.*;
import java.time.LocalDate;
import java.awt.Font;
import javax.swing.JMenuBar;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class Principal {

	//La biblia de Atributos de la clase Principal
	public JFrame frmDarDeAlta;
	public JTextField textNombre;
	public JTextField textApellido;
	public JTextField textID;
	public JTextField textFechaAct;
	public JTextField textCantHijos;
	public JTextField textDptoResidencia;
	private JLabel lblID;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblCantHijos;
	private JLabel lblDpto;
	private JButton btnFecha;
	private JButton btnSalir;
	private JButton btnmostrarLista;
	private JButton btnBuscar;
	private JTextField textBusqueda;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblFechanac;
	private JTextField textFechaNacimiento;
	ArrayList<Persona> persona=new ArrayList<>();

	//Método main donde se crea la ventana
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmDarDeAlta.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Método que inicializa algo
	public Principal() {
		initialize();
	}


	private void initialize() {

		//Crea el frame y define caracteristicas
		frmDarDeAlta = new JFrame();
		frmDarDeAlta.setResizable(false);
		frmDarDeAlta.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\titof\\OneDrive\\Escritorio\\Pablo\\LTI\\Semestre I\\5-Programaci\u00F3n en Java\\Semana 1\\Cod2.png"));
		frmDarDeAlta.setTitle("Dar de Alta");
		frmDarDeAlta.setBounds(100, 100, 492, 633);
		frmDarDeAlta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Crea y define caracteristicas de campo de texto Nombre
		textNombre = new JTextField();
		textNombre.setBounds(177, 70, 119, 19);
		textNombre.setColumns(10);

		//Crea y define caracteristicas de campo de texto Apellido
		textApellido = new JTextField();
		textApellido.setBounds(177, 107, 119, 19);
		textApellido.setColumns(10);

		//Crea y define caracteristicas de campo de texto ID
		textID = new JTextField();
		textID.setBounds(177, 32, 119, 19);
		textID.setColumns(10);

		////Crea y define caracteristicas de campo de texto FechaAct
		textFechaAct = new JTextField();
		textFechaAct.setBounds(177, 255, 119, 19);
		textFechaAct.setColumns(10);

		//Crea y define caracteristicas de campo de texto CantHijos
		textCantHijos = new JTextField();
		textCantHijos.setBounds(177, 144, 119, 19);
		textCantHijos.setColumns(10);

		//Crea y define caracteristicas de campo de texto DptoResidencia
		textDptoResidencia = new JTextField();
		textDptoResidencia.setBounds(177, 177, 119, 19);
		textDptoResidencia.setColumns(10);

		////Crea y define caractersiticas del botón Fecha, este devuelve la fecha actual
		btnFecha = new JButton("Fecha Actual");
		btnFecha.setBounds(10, 252, 147, 25);
		btnFecha.setFont(new Font("Arial", Font.PLAIN, 13));


		btnFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//Método que devuelve la fecha actual
		btnFecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LocalDate fecha =LocalDate.now();
				String ahora=String.valueOf(fecha);
				textFechaAct.setText(ahora);

			}
		});

		//Crea y define el campo de texto Resultados
		JTextPane textResultados = new JTextPane();
		textResultados.setBounds(10, 332, 457, 101);

		//Crea y define boton Ingrese Persona, este asignara el usuario ingresado a la lista
		JButton btnIngresePersona = new JButton("Dar de alta");
		btnIngresePersona.setBounds(177, 297, 119, 25);
		btnIngresePersona.setFont(new Font("Arial", Font.PLAIN, 13));
		btnIngresePersona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				//Método que recibe lo ingresado por el usuario a variables, las agrega a un objeto persona y lo suma a la lista
				try {
					//Variables
					int idPersona;
					String nombre;
					String apellido;
					String dptoResidencia;
					byte cantHijos;
					LocalDate fechaNac;
					LocalDate fechaAct;

					//Recibe lo ingresado en los campos de texto y los asigna a las variables
					idPersona = Integer.parseInt(textID.getText());			
					nombre = textNombre.getText();		
					apellido = textApellido.getText();		
					dptoResidencia = textDptoResidencia.getText();		
					cantHijos = (byte) Integer.parseInt(textCantHijos.getText());
					fechaNac=LocalDate.parse(textFechaNacimiento.getText());
					fechaAct=LocalDate.parse(textFechaAct.getText());

					//Instancia Persona y lo agrega a la lista
					Persona var=new Persona(idPersona,nombre,apellido,dptoResidencia,cantHijos,fechaNac,fechaAct);
					persona.add(var);

					//Borra los campos luego de dar de alta un usuario
					textID.setText("");
					textNombre.setText("");
					textApellido.setText("");
					textDptoResidencia.setText("");
					textCantHijos.setText("");
					textFechaNacimiento.setText("");
					textFechaAct.setText("");

					//El for de Copperfield
					for (Persona g: persona)
						System.out.println(g);

					//Si no se ingresa valor en algún campo devuelve un mensaje de aviso
				}catch(Exception ex) {
					if(textID.getText().equals("")|| textFechaNacimiento.getText().equals("") || textNombre.getText().equals("") || textApellido.getText().equals("")||textDptoResidencia.getText().equals("")|| textCantHijos.getText().equals("")||textFechaAct.getText().equals("")) {

						JOptionPane.showMessageDialog(null, "Verifique la información"); 
					}

				}		
			}

		});

		//Crea botón Buscar, define caracteristicas y el método
		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				//Método roto
				String buscarNombre;
				buscarNombre=(textResultados.getText());
				Persona encontre;
				boolean aparecio=false;

				for (int i=0; i<persona.size()&& !aparecio; i++) {
					if (persona.toString().contains(buscarNombre)) {
						encontre = persona.get(i);
						System.out.println("la persona es: " + encontre);
						JOptionPane.showMessageDialog((null), "La persona es: " + encontre);
					}else {
						System.out.println("no ha sido ingresada");
						JOptionPane.showMessageDialog((null), "La persona no fue ingresada");
					}
				}
			}
		});

		//Define y añade el botón Buscar
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 13));
		btnBuscar.setBounds(317, 499, 119, 21);
		frmDarDeAlta.getContentPane().add(btnBuscar);

		//Crea y define etiqueta ID
		lblID = new JLabel("ID:");
		lblID.setBounds(120, 32, 23, 27);
		lblID.setFont(new Font("Arial", Font.PLAIN, 18));

		//Crea y define etiqueta Nombre
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(75, 64, 70, 27);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));

		//Crea y define etiqueta Apellido
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(75, 101, 67, 27);
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 18));

		//Crea y define etiqueta CantHijos
		lblCantHijos = new JLabel("Hijos:");
		lblCantHijos.setBounds(99, 138, 46, 22);
		lblCantHijos.setFont(new Font("Arial", Font.PLAIN, 18));

		//Crea y define etiqueta Departamento
		lblDpto = new JLabel("Departamento:");
		lblDpto.setBounds(29, 173, 155, 22);
		lblDpto.setFont(new Font("Arial", Font.PLAIN, 18));

		//Crea y define métodos de botón Salir
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 13));
		btnSalir.setBounds(339, 451, 70, 21);
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		//Agrega etiquetas, botones, etc.
		frmDarDeAlta.getContentPane().setLayout(null);
		frmDarDeAlta.getContentPane().add(btnIngresePersona);
		frmDarDeAlta.getContentPane().add(lblNombre);
		frmDarDeAlta.getContentPane().add(lblID);
		frmDarDeAlta.getContentPane().add(lblApellido);
		frmDarDeAlta.getContentPane().add(lblCantHijos);
		frmDarDeAlta.getContentPane().add(lblDpto);
		frmDarDeAlta.getContentPane().add(btnFecha);
		frmDarDeAlta.getContentPane().add(textFechaAct);
		frmDarDeAlta.getContentPane().add(textID);
		frmDarDeAlta.getContentPane().add(textApellido);
		frmDarDeAlta.getContentPane().add(textNombre);
		frmDarDeAlta.getContentPane().add(textCantHijos);
		frmDarDeAlta.getContentPane().add(textDptoResidencia);
		frmDarDeAlta.getContentPane().add(btnSalir);
		frmDarDeAlta.getContentPane().add(textResultados);

		//Botón Mostrar lista, correcto, muestra la lista
		btnmostrarLista = new JButton("Mostrar Lista");
		btnmostrarLista.setFont(new Font("Arial", Font.PLAIN, 13));
		btnmostrarLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textResultados.setText(String.valueOf(persona));
			}
		}
				);

		//Añade y define boton Mostrar Lista
		btnmostrarLista.setBounds(54, 451, 119, 21);
		frmDarDeAlta.getContentPane().add(btnmostrarLista);
		
		//Define y crea campo de texto Busqueda
		textBusqueda = new JTextField();
		textBusqueda.setFont(new Font("Arial", Font.PLAIN, 13));
		textBusqueda.setBounds(42, 500, 254, 19);
		frmDarDeAlta.getContentPane().add(textBusqueda);
		textBusqueda.setColumns(10);
		
		//crea y define etiqueta FechaNac
		lblFechanac = new JLabel("FechaNac:");
		lblFechanac.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFechanac.setBounds(56, 208, 102, 22);
		frmDarDeAlta.getContentPane().add(lblFechanac);
		
		//define y crea campo de texto FechaNacimiento
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setColumns(10);
		textFechaNacimiento.setBounds(177, 212, 119, 19);
		frmDarDeAlta.getContentPane().add(textFechaNacimiento);
		
		//Crea la barra del menu superior, donde esta borrar y compania
		JMenuBar menuBar = new JMenuBar();
		frmDarDeAlta.setJMenuBar(menuBar);

		//Crea y define botón borrar y sus métodos
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Arial", Font.PLAIN, 10));
		btnBorrar.addMouseListener(new MouseAdapter() {
			//Borra los campos de texto manualmente
			@Override
			public void mouseClicked(MouseEvent e) {
				textID.setText(String.valueOf(""));
				textNombre.setText("");
				textApellido.setText("");
				textDptoResidencia.setText("");
				textCantHijos.setText(String.valueOf(""));
				textFechaAct.setText(" ");
			}			
		});
		//añade el botón
		menuBar.add(btnBorrar);

		//Crea y define boton Ingresar vehiculo, tiene el método que abre una nueva ventana del tipo VehiculoVentana
		btnNewButton_1 = new JButton("Ingresar Veh\u00EDculo");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VehiculoVentana window = new VehiculoVentana();
				window.frmDarAltaVehculo.setVisible(true);

			}
		});
		//añade el botón
		menuBar.add(btnNewButton_1);

		//Añade boton verificar funcionamiento y devuelve la lista al derecho y al revés
		btnNewButton_2 = new JButton("Verificar Funcionamiento");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Vehiculo>listVeh=new ArrayList<Vehiculo>();

				Avion v1=new Avion(1,"A37","Pluna","avion",124,40);
				Avion v2=new Avion(2,"A73", "Dominican","avion",200,120);
				Barco b1=new Barco(3,"ASX7","Vilboard","barco",70,20);
				listVeh.add(v1);
				listVeh.add(v2);
				listVeh.add(b1);

				//imprime un mensaje con la lista
				JOptionPane.showInternalMessageDialog(null,"las listas funcionan bien:"+ "\n+"+ listVeh );
				//este for da vuelta la lista
				for(int i=0;i<listVeh.size();i++) {
					Collections.reverse(listVeh);

				}
				//imprime un mensaje con la lista invertida
				JOptionPane.showInternalMessageDialog(null,"las listas funcionan bien:"+ "\n+"+ listVeh );

			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 10));
		menuBar.add(btnNewButton_2);
	}
}













