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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class BookEntry extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	JButton btnNewButton;
	private JTextField textField_7;
	String pin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookEntry frame = new BookEntry("");
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
	public BookEntry(String pin) {
		this.pin=pin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 643);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter The Book Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(152, 27, 458, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title of The Book :");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewLabel_1.setBounds(47, 82, 161, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Author :");
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(47, 138, 161, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Gerne :");
		lblNewLabel_1_2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(47, 246, 161, 32);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Publication :");
		lblNewLabel_1_3.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(47, 300, 161, 32);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Year of Publishing :");
		lblNewLabel_1_4.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewLabel_1_4.setBounds(47, 354, 161, 32);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_6 = new JLabel("Quantity :");
		lblNewLabel_1_6.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewLabel_1_6.setBounds(47, 409, 161, 32);
		contentPane.add(lblNewLabel_1_6);
		
		textField = new JTextField();
		textField.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		textField.setBounds(257, 82, 502, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		textField_1.setColumns(10);
		textField_1.setBounds(257, 138, 502, 32);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		textField_2.setColumns(10);
		textField_2.setBounds(257, 241, 502, 32);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		textField_3.setColumns(10);
		textField_3.setBounds(257, 300, 502, 32);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		textField_4.setColumns(10);
		textField_4.setBounds(257, 352, 502, 32);
		contentPane.add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		textField_6.setColumns(10);
		textField_6.setBounds(257, 409, 502, 32);
		contentPane.add(textField_6);
		
		btnNewButton = new JButton("CLEAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_6.setText("");
				textField_7.setText("");
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnNewButton.setBounds(313, 548, 167, 32);
		contentPane.add(btnNewButton);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title=textField.getText();
				String author=textField_1.getText();
				String gerne=textField_2.getText();
				String publication=textField_3.getText();
				String yop=textField_4.getText();
				Random random=new Random();
				String la=""+gerne.charAt(0);
				String bid="CL" + Math.abs((random.nextLong() % 70L) + 100L)+la.toUpperCase();
				String qty=textField_6.getText();
				String lang=textField_7.getText();
				
				try {
					if(title.equals("")) {
						JOptionPane.showMessageDialog(null, "Tile cannot be empty");
					}
					else {
						Conn c=new Conn();
						String query="insert into books values('"+title+"','"+author+"','"+gerne+"','"+publication+"','"+yop+"','"+bid+"','"+qty+"','"+lang+"')";
						c.s.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Book details entered succesfully!!!!");
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_6.setText("");
						textField_7.setText("");
					}
				}
				catch(Exception ex) {
					System.out.println("Error"+ex);
				}
				
				
			}
		});
		btnSave.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnSave.setBounds(592, 548, 167, 32);
		contentPane.add(btnSave);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Language");
		lblNewLabel_1_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewLabel_1_1_1.setBounds(47, 190, 161, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		textField_7.setColumns(10);
		textField_7.setBounds(257, 190, 502, 32);
		contentPane.add(textField_7);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new LibrarianSection(pin).setVisible(true);
			}
		});
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnBack.setBounds(65, 548, 167, 32);
		contentPane.add(btnBack);
	}

}
