package LibManage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PageZero extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageZero frame = new PageZero();
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
	public PageZero() {
		setUndecorated(true);    //to hide the undecorated part i.e. the empty portion of the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Central Library");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(153, 31, 281, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Admin login");
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnNewButton.setBounds(176, 101, 226, 64);
		contentPane.add(btnNewButton);
		
		JButton btnLibrarianLogin = new JButton("Librarian login");
		btnLibrarianLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login().setVisible(true);			}
		});
		btnLibrarianLogin.setBackground(new Color(255, 182, 193));
		btnLibrarianLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnLibrarianLogin.setBounds(176, 186, 226, 64);
		contentPane.add(btnLibrarianLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnExit.setBackground(new Color(152, 251, 152));
		btnExit.setBounds(176, 277, 226, 64);
		contentPane.add(btnExit);
	}
}
