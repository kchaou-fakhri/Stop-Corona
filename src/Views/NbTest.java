package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controleur.CovidControleur;

import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NbTest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	public NbTest() {
		super("Nombre des test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 204, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb1 = new JLabel("\r\nNombre de tests");
		
		lb1.setForeground(SystemColor.windowBorder);
		lb1.setBounds(19, 26, 140, 52);
		contentPane.add(lb1);
		
		textField = new JTextField();
		textField.setBounds(19, 89, 130, 52);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnTest = new JButton("Tester");
		btnTest .setBounds(19, 205, 130, 45);
		contentPane.add(btnTest );
		
		btnTest.addActionListener(new CovidControleur(this));
		
		setVisible(true);
		
		
	}
	
	public int getNbTest()
	{
		return Integer.parseInt(textField.getText());
	}
}
