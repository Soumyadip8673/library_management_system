package LibManage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrarianSection extends JFrame {

	private JPanel contentPane;
	JButton btnNewButton,btnViewBooks,btnViewIssuedBooks,btnLogOut;
	String pin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianSection frame = new LibrarianSection("");
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
	public LibrarianSection(String pin) {
		this.pin=pin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LIBRARIAN SECTION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(173, 29, 331, 67);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Add Books");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BookEntry(pin).setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnNewButton.setBounds(95, 157, 208, 67);
		contentPane.add(btnNewButton);
		
		btnViewBooks = new JButton("View Books");
		btnViewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ViewBooks(pin).setVisible(true);
			}
		});
		btnViewBooks.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnViewBooks.setBounds(373, 157, 208, 67);
		contentPane.add(btnViewBooks);
		
		JButton btnIssueBook = new JButton("Issue/Return ");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IssueBook(pin).setVisible(true);			}
		});
		btnIssueBook.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnIssueBook.setBounds(95, 267, 208, 67);
		contentPane.add(btnIssueBook);
		
		btnViewIssuedBooks = new JButton("View Issued Books");
		btnViewIssuedBooks.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnViewIssuedBooks.setBounds(373, 267, 208, 67);
		contentPane.add(btnViewIssuedBooks);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PageZero().setVisible(true);
			}
		});
		btnLogOut.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnLogOut.setBounds(238, 377, 208, 67);
		contentPane.add(btnLogOut);
	}

}
