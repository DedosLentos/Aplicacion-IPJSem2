package aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Font;

public class PanelLog extends JFrame {
	//esta clase es el login de usuario, donde se solicita el usuario y contraseña

	private JPanel contentPane;
	public static JTextField usuarioTxt;
	public static JTextField passTxt;


	public PanelLog() {
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 20));
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\titof\\OneDrive\\Escritorio\\Cod2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usuario = new JLabel("Usuario:");
		usuario.setFont(new Font("Arial", Font.PLAIN, 18));
		usuario.setBounds(47, 24, 81, 20);
		contentPane.add(usuario);
		
		usuarioTxt = new JTextField();
		usuarioTxt.setBounds(138, 24, 177, 20);
		contentPane.add(usuarioTxt);
		usuarioTxt.setColumns(10);
		
		JLabel pass = new JLabel("Password:");
		pass.setFont(new Font("Arial", Font.PLAIN, 18));
		pass.setBounds(26, 58, 101, 30);
		contentPane.add(pass);
		
		passTxt = new JPasswordField();
		passTxt.setColumns(10);
		passTxt.setBounds(138, 67, 177, 21);
		contentPane.add(passTxt);
		
		//ver por que agrego esta linea... crea una instancia de DatosUsuario?
		final DatosUsuario data= new DatosUsuario();
		
		JButton entrar = new JButton("Entrar");
		entrar.setFont(new Font("Arial", Font.PLAIN, 13));
		entrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(data.probarPass()==1) {
					JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
					Principal panel = new Principal();
					panel.frmDarDeAlta.setVisible(true);
					dispose();
					}
					else {
					JOptionPane.showMessageDialog(null, "Error, usuario o contraseña incorrecta");
					}
				
			}
		});
		entrar.setBounds(68, 139, 89, 23);
		contentPane.add(entrar);
		
		JButton salir = new JButton("Salir");
		salir.setFont(new Font("Arial", Font.PLAIN, 13));
		salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				
			}
		});
		salir.setBounds(248, 139, 89, 23);
		contentPane.add(salir);
	}
}
