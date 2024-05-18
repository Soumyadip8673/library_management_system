package LibManage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Signup_Emp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	JButton btnNewButton,btnSubmit;
	JRadioButton rdbtnMale,rdbtnFemale;
	String uid,pin;
	private JLabel lblCentralLibraryh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup_Emp frame = new Signup_Emp();
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
	public Signup_Emp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up Form for Librarians");
		lblNewLabel.setBounds(98, 10, 310, 28);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(28, 112, 64, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(28, 164, 64, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sex");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(28, 216, 64, 28);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Contact :");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(28, 271, 117, 28);
		contentPane.add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField.setBounds(155, 112, 284, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(155, 164, 284, 28);
		contentPane.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(155, 271, 284, 28);
		contentPane.add(textField_3);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMale.isSelected()) {
					rdbtnFemale.setSelected(false);
				}
			}
		});
		rdbtnMale.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnMale.setBounds(155, 216, 91, 28);
		contentPane.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnFemale.isSelected()) {
					rdbtnMale.setSelected(false);
				}
			}
		});
		rdbtnFemale.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnFemale.setBounds(348, 216, 91, 28);
		contentPane.add(rdbtnFemale);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Address");
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_3_1.setBounds(28, 330, 117, 28);
		contentPane.add(lblNewLabel_1_3_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(155, 330, 284, 28);
		contentPane.add(textField_2);
		
		btnNewButton = new JButton("CLEAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				rdbtnMale.setSelected(false);
				rdbtnFemale.setSelected(false);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(28, 398, 106, 28);
		contentPane.add(btnNewButton);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				String age=textField_1.getText();
				String inst=textField_3.getText();
				String addr=textField_2.getText();
				String sex="";
				if(rdbtnMale.isSelected()) {
					sex="male";
				}else if(rdbtnFemale.isSelected()){
					sex="female";
				}
				Random random=new Random();
				uid = "" + Math.abs((random.nextLong() % 800L)+3120000L);
		        pin = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
				
				
				try {
					if(name.equals("") || inst.equals("")) {
						JOptionPane.showMessageDialog(null, "all fields are required");
					}
					else {
						String query="insert into users values('"+uid+"','"+pin+"','"+name+"','"+age+"','"+inst+"','"+addr+"','"+sex+"');";
						Conn c=new Conn();
						c.s.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Thank you for register\nYour user id : "+uid+"\nYour default pin : "+pin);
						
//						textField.setText("");
//						textField_1.setText("");
//						textField_2.setText("");
//						textField_3.setText("");
//						rdbtnMale.setSelected(false);
//						rdbtnFemale.setSelected(false);
						setVisible(false);
						new LibrarianSection(pin).setVisible(true);
						
					}
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
				
						
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSubmit.setBounds(333, 404, 117, 28);
		contentPane.add(btnSubmit);
		
		lblCentralLibraryh = new JLabel("CENTRAL LIBRARY -2090H");
		lblCentralLibraryh.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentralLibraryh.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCentralLibraryh.setBounds(155, 44, 200, 17);
		contentPane.add(lblCentralLibraryh);
	}
}
