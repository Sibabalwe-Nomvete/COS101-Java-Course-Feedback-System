package swingex;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class signupPage extends JFrame {

	private JPanel contentPane;
	private JTextField userID;
	private JPasswordField pswd1;
	private JPasswordField pswdConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signupPage frame = new signupPage();
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
	public signupPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setUndecorated(true);	//Removes frame outline
		
		JLabel lblNewLabel = new JLabel("SIGNUP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(270, 11, 89, 28);
		contentPane.add(lblNewLabel);
		
		userID = new JTextField();
		userID.setBounds(270, 57, 135, 28);
		contentPane.add(userID);
		userID.setColumns(10);
		
		pswd1 = new JPasswordField();
		pswd1.setBounds(270, 100, 135, 28);
		contentPane.add(pswd1);
		
		pswdConfirm = new JPasswordField();
		pswdConfirm.setBounds(270, 139, 135, 24);
		contentPane.add(pswdConfirm);
		
		JButton btnDone = new JButton("DONE");
		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "guiSQLjava");
					String query = "insert into signUp(?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(userID.getText()));
					ps.setString(2, pswd1.getText());
					
					int i = ps.executeUpdate();
					JOptionPane.showMessageDialog(btnDone, i + "Record added succesfully!");
					ps.close();
					con.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				loginPage login = new loginPage();
				login.setVisible(true);
			}
		});
		btnDone.setBackground(new Color(255, 255, 255));
		btnDone.setBounds(295, 200, 89, 23);
		contentPane.add(btnDone);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnClose.setBackground(new Color(255, 255, 255));
		btnClose.setBounds(501, 366, 89, 23);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_1 = new JLabel("User ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(199, 60, 61, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(188, 103, 72, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm Password:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(128, 140, 132, 21);
		contentPane.add(lblNewLabel_3);
	}
}
