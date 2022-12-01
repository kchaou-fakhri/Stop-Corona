package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.DAOPatients;
import Model.Patient;
import Model.Statistics;

import java.awt.Color;

public class Statistiques extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	
	
	public Statistiques( Map<String,Integer> listGouv,Map<String,Integer> listAge ) {
		setTitle("Statistiques des patients");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 440, 250);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		tabbedPane.addTab("Statistiques par Gouvernorat", null, panel, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 415, 200);
		panel.add(scrollPane);
		String [][] cont;
		cont = Remplir(listGouv);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			cont,
			new String[] {
				"Gouvernorat", "Nombre de patients"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(108);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		tabbedPane.addTab("Statistiques par tranche d'age", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 415, 200);
		panel_1.add(scrollPane_1);
		
		cont = Remplir(listAge);
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			cont,
			new String[] {
				"Tranche d'age", "Nombre de Patients"
			}
		));
		
		setVisible(true);
	}
	
	
	public String [][] Remplir ( Map<String, Integer> list)
	{
	String [][] t = new String [list.size()][2];

	int i = 0;
	for (Entry<String, Integer> entry : list.entrySet()) {
		String k = entry.getKey();
		Integer v = entry.getValue();
		t[i][0] = k;
		t[i][1] = String.valueOf(v) ;
		i++;
		System.out.println(k+ "    " + v);
	}
	
		

	return t;
	}
}
