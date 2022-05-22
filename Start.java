package aplicacion;

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

	//Esta clase inicia el programa
	public static void main(String args[]) {
		PanelLog log = new PanelLog();
		log.setVisible(true);

		Principal inter = new Principal();
		inter.frmDarDeAlta.setVisible(false);

	}
}