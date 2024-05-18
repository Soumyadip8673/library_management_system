package LibManage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AdminSection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSection frame = new AdminSection();
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
	public AdminSection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Section");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(60, 24, 416, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Librarian");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(31, 107, 179, 51);
		contentPane.add(btnNewButton);
		
		JButton btnViewLibrarian = new JButton("View Librarian");
		btnViewLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewLibrarian.setBounds(31, 191, 179, 51);
		contentPane.add(btnViewLibrarian);
		
		JButton btnDeleteLibrarian = new JButton("Delete Librarian");
		btnDeleteLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeleteLibrarian.setBounds(276, 107, 179, 51);
		contentPane.add(btnDeleteLibrarian);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogOut.setBounds(276, 191, 179, 51);
		contentPane.add(btnLogOut);
	}

}
