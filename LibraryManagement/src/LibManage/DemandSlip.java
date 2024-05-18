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
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionEvent;

public class DemandSlip extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JButton btnSend,btnGet,btnNewButton;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemandSlip frame = new DemandSlip();
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
	public DemandSlip() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 294);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEMAND SLIP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblNewLabel.setBounds(155, 10, 165, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblTitle = new JLabel("Regn no :");
		lblTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblTitle.setBounds(28, 67, 82, 25);
		contentPane.add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author :");
		lblAuthor.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblAuthor.setBounds(28, 102, 74, 25);
		contentPane.add(lblAuthor);
		
		JLabel lblRegnNo = new JLabel("Book Title :");
		lblRegnNo.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblRegnNo.setBounds(28, 136, 105, 25);
		contentPane.add(lblRegnNo);
		
		textField = new JTextField();
		textField.setBounds(143, 70, 171, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 105, 229, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(143, 139, 229, 24);
		contentPane.add(textField_2);
		
		btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnNewButton.setBounds(39, 217, 110, 25);
		contentPane.add(btnNewButton);
		
		btnSend = new JButton("Request");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String regno=textField.getText();
				String author=textField_1.getText();
				String title=textField_2.getText();
				String userid=textField_3.getText();
				
				Date date=new Date();
				
				try {
					if(regno.equals("") || userid.equals("")) {
						JOptionPane.showMessageDialog(null, "regn no cannot be empty");
					}
					else {
					Conn c=new Conn();
					String query="insert into demandList values('"+regno+"','"+author+"','"+title+"','"+userid+"','"+date+"');";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "request for book successfully sent to admin");
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					}
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnSend.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnSend.setBounds(262, 217, 110, 25);
		contentPane.add(btnSend);
		
		JLabel lblUserId = new JLabel("User ID :");
		lblUserId.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUserId.setBounds(28, 171, 105, 25);
		contentPane.add(lblUserId);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(143, 173, 229, 24);
		contentPane.add(textField_3);
		
		btnGet = new JButton("Get");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String regno=textField.getText();
				try {
					if(regno.equals("")) {
						JOptionPane.showMessageDialog(null, "regn no cannot be empty");
					}else {
						Conn c=new Conn();
						String query="select * from books where regnno="+regno+";";
						rs=c.s.executeQuery(query);
						while(rs.next()) {
							textField_1.setText(rs.getNString("author"));
							textField_2.setText(rs.getNString("title"));
						}
					}
					
				}catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnGet.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnGet.setBounds(324, 67, 74, 25);
		contentPane.add(btnGet);
	}
}
