package LibManage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IssueBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String pin;
	
	JButton btnNewButton,btnBack,btnReturn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook("");
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
	public IssueBook(String pin) {
		this.pin=pin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ISSUE/RETURN BOOKS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(86, 25, 267, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblBookId = new JLabel("Book ID :");
		lblBookId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBookId.setBounds(25, 89, 144, 26);
		contentPane.add(lblBookId);
		
		JLabel lblStudentId = new JLabel("Student ID :");
		lblStudentId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblStudentId.setBounds(25, 139, 144, 26);
		contentPane.add(lblStudentId);
		
		JLabel lblStudentName = new JLabel("Student Name :");
		lblStudentName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblStudentName.setBounds(25, 194, 144, 26);
		contentPane.add(lblStudentName);
		
		JLabel lblStudentContact = new JLabel("Student Contact :");
		lblStudentContact.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblStudentContact.setBounds(25, 247, 144, 26);
		contentPane.add(lblStudentContact);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField.setBounds(179, 89, 248, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(179, 139, 248, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(179, 194, 248, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(179, 247, 248, 26);
		contentPane.add(textField_3);
		
		btnNewButton = new JButton("ISSUE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid=textField.getText();
				String sid=textField_1.getText();
				String sname=textField_2.getText();
				String scont=textField_3.getText();
				
				try {
					Conn c=new Conn();
					
					String query="";
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(319, 357, 108, 31);
		contentPane.add(btnNewButton);
		
		btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(255, 248, 220));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new LibrarianSection(pin).setVisible(true);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBack.setBounds(25, 357, 108, 31);
		contentPane.add(btnBack);
		
		btnReturn = new JButton("RETURN");
		btnReturn.setBackground(new Color(255, 0, 0));
		btnReturn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnReturn.setBounds(157, 357, 136, 31);
		contentPane.add(btnReturn);
	}
}
