package aplicacion;
//Esta clase Sirve para iniciar el programa
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Start extends JFrame {
	public Start() {
	}
	//inicia la ventana de log
	public static void main(String args[]) {
		PanelLog log = new PanelLog();
		log.setVisible(true);
//cuando se ingresa correctamente el log, este código ejecuta la ventana Principal
		Principal inter = new Principal();
		inter.frmDarDeAlta.setVisible(false);
	}
}
	

