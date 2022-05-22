package aplicacion;

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
	ArrayList<Persona> persona=new ArrayList<>();
	private JButton btnSalir;
	private JButton btnNewButton;
	private JButton btnBuscar;
	private JTextField textBusqueda;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblFechanac;
	private JTextField textFechaNacimiento;

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


	public Principal() {
		initialize();
	}


	private void initialize() {
		frmDarDeAlta = new JFrame();
		frmDarDeAlta.setResizable(false);
		frmDarDeAlta.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\titof\\OneDrive\\Escritorio\\Pablo\\LTI\\Semestre I\\5-Programaci\u00F3n en Java\\Semana 1\\Cod2.png"));
		frmDarDeAlta.setTitle("Dar de Alta");
		frmDarDeAlta.setBounds(100, 100, 492, 633);
		frmDarDeAlta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textNombre = new JTextField();
		textNombre.setBounds(177, 70, 119, 19);
		textNombre.setColumns(10);

		textApellido = new JTextField();
		textApellido.setBounds(177, 107, 119, 19);
		textApellido.setColumns(10);

		textID = new JTextField();
		textID.setBounds(177, 32, 119, 19);
		textID.setColumns(10);

		textFechaAct = new JTextField();
		textFechaAct.setBounds(177, 255, 119, 19);
		textFechaAct.setColumns(10);

		textCantHijos = new JTextField();
		textCantHijos.setBounds(177, 144, 119, 19);
		textCantHijos.setColumns(10);

		textDptoResidencia = new JTextField();
		textDptoResidencia.setBounds(177, 177, 119, 19);
		textDptoResidencia.setColumns(10);


		btnFecha = new JButton("Fecha Actual");
		btnFecha.setBounds(10, 252, 147, 25);
		btnFecha.setFont(new Font("Arial", Font.PLAIN, 13));
		btnFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LocalDate fecha =LocalDate.now();
				String ahora=String.valueOf(fecha);
				textFechaAct.setText(ahora);

			}
		});


		JTextPane textResultados = new JTextPane();
		textResultados.setBounds(10, 332, 457, 101);

		JButton btnIngresePersona = new JButton("Dar de alta");
		btnIngresePersona.setBounds(177, 297, 119, 25);
		btnIngresePersona.setFont(new Font("Arial", Font.PLAIN, 13));
		btnIngresePersona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {

					int idPersona;
					String nombre;
					String apellido;
					String dptoResidencia;
					byte cantHijos;
					LocalDate fechaNac;
					LocalDate fechaAct;
					
					idPersona = Integer.parseInt(textID.getText());			
					nombre = textNombre.getText();		
					apellido = textApellido.getText();		
					dptoResidencia = textDptoResidencia.getText();		
					cantHijos = (byte) Integer.parseInt(textCantHijos.getText());
					fechaNac=LocalDate.parse(textFechaNacimiento.getText());
					fechaAct=LocalDate.parse(textFechaAct.getText());
					

					Persona var=new Persona(idPersona,nombre,apellido,dptoResidencia,cantHijos,fechaNac,fechaAct);
					persona.add(var);
					
					textID.setText("");
					textNombre.setText("");
					textApellido.setText("");
					textDptoResidencia.setText("");
					textCantHijos.setText("");
					textFechaNacimiento.setText("");
					textFechaAct.setText("");
					
					
					for (Persona g: persona)
						System.out.println(g);

					
				}catch(Exception ex) {
					if(textID.getText().equals("")|| textFechaNacimiento.getText().equals("") || textNombre.getText().equals("") || textApellido.getText().equals("")||textDptoResidencia.getText().equals("")|| textCantHijos.getText().equals("")||textFechaAct.getText().equals("")) {

						JOptionPane.showMessageDialog(null, "Verifique la información"); 
					}

				}		
			}

		});

		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

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
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 13));
		btnBuscar.setBounds(317, 499, 119, 21);
		frmDarDeAlta.getContentPane().add(btnBuscar);


		lblID = new JLabel("ID:");
		lblID.setBounds(120, 32, 23, 27);
		lblID.setFont(new Font("Arial", Font.PLAIN, 18));

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(75, 64, 70, 27);
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(75, 101, 67, 27);
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 18));

		lblCantHijos = new JLabel("Hijos:");
		lblCantHijos.setBounds(99, 138, 46, 22);
		lblCantHijos.setFont(new Font("Arial", Font.PLAIN, 18));

		lblDpto = new JLabel("Departamento:");
		lblDpto.setBounds(29, 173, 155, 22);
		lblDpto.setFont(new Font("Arial", Font.PLAIN, 18));

		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 13));
		btnSalir.setBounds(339, 451, 70, 21);
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
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

		btnNewButton = new JButton("Mostrar Lista");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textResultados.setText(String.valueOf(persona));
			}
		}
				);
	

		btnNewButton.setBounds(54, 451, 119, 21);
		frmDarDeAlta.getContentPane().add(btnNewButton);

		textBusqueda = new JTextField();
		textBusqueda.setFont(new Font("Arial", Font.PLAIN, 13));
		textBusqueda.setBounds(42, 500, 254, 19);
		frmDarDeAlta.getContentPane().add(textBusqueda);
		textBusqueda.setColumns(10);
		
		lblFechanac = new JLabel("FechaNac:");
		lblFechanac.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFechanac.setBounds(56, 208, 102, 22);
		frmDarDeAlta.getContentPane().add(lblFechanac);
		
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setColumns(10);
		textFechaNacimiento.setBounds(177, 212, 119, 19);
		frmDarDeAlta.getContentPane().add(textFechaNacimiento);

		JMenuBar menuBar = new JMenuBar();
		frmDarDeAlta.setJMenuBar(menuBar);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Arial", Font.PLAIN, 10));
		btnBorrar.addMouseListener(new MouseAdapter() {
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
		menuBar.add(btnBorrar);

		btnNewButton_1 = new JButton("Ingresar Veh\u00EDculo");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VehiculoVentana window = new VehiculoVentana();
				window.frmDarAltaVehculo.setVisible(true);

			}
		});
		menuBar.add(btnNewButton_1);
		
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

				
				JOptionPane.showInternalMessageDialog(null,"las listas funcionan bien:"+ "\n+"+ listVeh );
				
				for(int i=0;i<listVeh.size();i++) {
					Collections.reverse(listVeh);
					
				}
				JOptionPane.showInternalMessageDialog(null,"las listas funcionan bien:"+ "\n+"+ listVeh );
				
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 10));
		menuBar.add(btnNewButton_2);
	}
}













