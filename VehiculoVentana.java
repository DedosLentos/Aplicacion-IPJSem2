package aplicacion;

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

	public JFrame frmDarAltaVehculo;
	protected Object frmDarAltaVehiculo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public ArrayList<Vehiculo>vehiculo=new ArrayList<Vehiculo>();
	private JTextField textResultado;
	private JButton btnSalir;
	private JButton btnMostrar;
	private JTextField textTipo;

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

	
	public VehiculoVentana() {
		initialize();
	}

	
	private void initialize() {
		frmDarAltaVehculo = new JFrame();
		frmDarAltaVehculo.setResizable(false);
		frmDarAltaVehculo.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\titof\\OneDrive\\Escritorio\\Pablo\\LTI\\Semestre I\\5-Programaci\u00F3n en Java\\Semana 1\\Cod2.png"));
		frmDarAltaVehculo.setTitle("Dar alta veh\u00EDculo");
		frmDarAltaVehculo.setBounds(100, 100, 459, 383);
		frmDarAltaVehculo.getContentPane().setLayout(null);
		
		JLabel lblIDVehiculo = new JLabel("ID:");
		lblIDVehiculo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblIDVehiculo.setBounds(135, 21, 44, 27);
		frmDarAltaVehculo.getContentPane().add(lblIDVehiculo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNombre.setBounds(104, 58, 85, 27);
		frmDarAltaVehculo.getContentPane().add(lblNombre);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Arial", Font.PLAIN, 18));
		lblColor.setBounds(124, 93, 65, 27);
		frmDarAltaVehculo.getContentPane().add(lblColor);
		
		textField = new JTextField();
		textField.setBounds(192, 25, 96, 19);
		frmDarAltaVehculo.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(192, 62, 96, 19);
		frmDarAltaVehculo.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(192, 99, 96, 19);
		frmDarAltaVehculo.getContentPane().add(textField_2);
		
		JButton btnVehiculo = new JButton("Ingresar Veh\u00EDculo");
		btnVehiculo.setFont(new Font("Arial", Font.PLAIN, 13));
		btnVehiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					int idVehiculo;
					String nombre;
					String color;
					String tipo;	
				
					idVehiculo = Integer.parseInt(textField.getText());			
					nombre = textField_1.getText();		
					color = textField_2.getText();		
					tipo=textTipo.getText();


					Vehiculo var=new Vehiculo(idVehiculo,nombre,color,tipo);
					vehiculo.add(var);
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textTipo.setText("");
					
					for (Vehiculo g: vehiculo)
						System.out.println(g);
					
				}catch(Exception ex) {
					if(textField.getText().equals("")|| textField_1.getText().equals("") || textField_2.getText().equals("")|| textTipo.getText().equals("")) {

						JOptionPane.showMessageDialog(null, "Verifique la información"); 
				}
				}
				
			}
		});
		btnVehiculo.setBounds(135, 180, 134, 21);
		frmDarAltaVehculo.getContentPane().add(btnVehiculo);
		
		textResultado = new JTextField();
		textResultado.setFont(new Font("Arial", Font.PLAIN, 13));
		textResultado.setBounds(20, 211, 402, 94);
		frmDarAltaVehculo.getContentPane().add(textResultado);
		textResultado.setColumns(10);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 13));
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		System.exit(0);
			}
			
		});
		btnSalir.setBounds(337, 315, 85, 21);
		frmDarAltaVehculo.getContentPane().add(btnSalir);
		
		btnMostrar = new JButton("Mostrar Veh\u00EDculo");
		btnMostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textResultado.setText(String.valueOf(vehiculo));
			}
		});
		btnMostrar.setFont(new Font("Arial", Font.PLAIN, 13));
		btnMostrar.setBounds(34, 315, 125, 21);
		frmDarAltaVehculo.getContentPane().add(btnMostrar);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTipo.setBounds(135, 132, 44, 27);
		frmDarAltaVehculo.getContentPane().add(lblTipo);
		
		textTipo = new JTextField();
		textTipo.setColumns(10);
		textTipo.setBounds(192, 138, 96, 19);
		frmDarAltaVehculo.getContentPane().add(textTipo);
	}
}
