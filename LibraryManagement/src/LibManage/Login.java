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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CENTRAL LIBRARY");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(138, 10, 296, 63);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USER NAME :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(62, 101, 132, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD :");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(62, 162, 132, 30);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textField.setBounds(204, 103, 298, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Signup_Emp().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(74, 290, 132, 30);
		contentPane.add(btnNewButton);
		
		JButton btnSignIn = new JButton("CLEAR");
		btnSignIn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSignIn.setBounds(228, 290, 132, 30);
		contentPane.add(btnSignIn);
		
		JButton btnClear = new JButton("SIGN IN");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid=textField.getText();
				String pin=passwordField.getText();
				
				String query="select * from users where uid='"+uid+"' and pin='"+pin+"';";
				Conn con=new Conn();
				try {
					
					
					ResultSet rs=con.s.executeQuery(query);
					if(rs.next()) {
						setVisible(false);
						new LibrarianSection(pin).setVisible(true);
					}
					else {
        				JOptionPane.showMessageDialog(null, "Incorrect uid or pin.\nPlease try again");
        			}
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
						
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnClear.setBounds(382, 290, 132, 30);
		contentPane.add(btnClear);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 16));
		passwordField.setBounds(204, 160, 298, 30);
		contentPane.add(passwordField);
	}
}
