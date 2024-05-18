package LibManage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ViewBooks extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static JTable table;
	JComboBox comboBox;
	JButton btnNewButton;
	ResultSet rs;
	static DefaultTableModel model;
	private JButton btnClear;
	private JButton btnBack;
	String pin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBooks frame = new ViewBooks("");
					model=(DefaultTableModel) table.getModel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewBooks(String pin) {
		this.pin=pin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CENTRAL LIBRARY");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(218, 21, 358, 42);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Search By", "Author", "Book Title", "Gerne", "language", "Publication", "Book ID"}));
		comboBox.setBounds(67, 84, 159, 35);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		textField.setBounds(236, 84, 367, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Enter some text to search!!!");
					}else {
					String sby = "";
					Conn c=new Conn();
					if(comboBox.getSelectedItem().equals("Author")) {
						sby="author";
					}else if(comboBox.getSelectedItem().equals("Book Title")) {
						sby="title";
					}else if(comboBox.getSelectedItem().equals("Gerne")) {
						sby="grene";
					}else if(comboBox.getSelectedItem().equals("language")) {
						sby="language";
					}
					else if(comboBox.getSelectedItem().equals("Publication")) {
						sby="publication";
					}else if(comboBox.getSelectedItem().equals("Regn no")) {
						sby="regnno";
					}else  {
						JOptionPane.showMessageDialog(null, "Select one option from the dropdown");
					}
					
					String query="select * from books where "+sby+" like '%"+textField.getText()+"%';";
					rs=c.s.executeQuery(query);
					
					while(rs.next()) {
						model.insertRow(model.getRowCount()	, new Object[] {
								rs.getString("bid"),rs.getString("title"),rs.getString("author"),rs.getString("qty")
						});
					}
				}}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnNewButton.setBounds(646, 84, 134, 35);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 263, 717, 297);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"book id", "title", "author", "available"
			}
		));
		scrollPane.setViewportView(table);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnClear.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnClear.setBounds(646, 142, 134, 35);
		contentPane.add(btnClear);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new LibrarianSection(pin).setVisible(true);
			}
		});
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnBack.setBounds(646, 203, 134, 35);
		contentPane.add(btnBack);
	}
}
