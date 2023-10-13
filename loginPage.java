package swingex;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.SwingConstants;


public class loginPage extends JFrame {

	private JPanel contentPane;
	private JPasswordField pswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPage frame = new loginPage();
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
	public loginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		//setUndecorated(true);	//Removes frame outline
		contentPane.setLayout(null);
		
		JFormattedTextField userID = new JFormattedTextField();
		userID.setBounds(224, 76, 121, 23);
		contentPane.add(userID);
		
		JLabel lblNewLabel = new JLabel("COURSE FEEDBACK SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(157, 11, 262, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		pswd = new JPasswordField();
		pswd.setBounds(224, 139, 121, 24);
		contentPane.add(pswd);
		
		JButton Loginbtn = new JButton("LOGIN");
		Loginbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "guiSQLjava");
					String query = "insert into signUp(?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(userID.getText()));
					ps.setString(2, pswd.getText());
					
					ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        dispose();
                        JOptionPane.showMessageDialog(Loginbtn, "You have successfully logged in!");
                    } else {
                        JOptionPane.showMessageDialog(Loginbtn, "Wrong User ID & Password!");
                    }
     
					ps.close();
					con.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				mainPage main = new mainPage();
        		main.setVisible(true);
			}
		});

		Loginbtn.setForeground(new Color(255, 255, 255));
		Loginbtn.setBackground(new Color(0, 0, 0));
		Loginbtn.setBounds(249, 213, 89, 23);
		contentPane.add(Loginbtn);
		
		JButton SignUpbtn = new JButton("SIGNUP");
		SignUpbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//moves to signup page
				signupPage register = new signupPage();
				register.setVisible(true);
			}
		});
		SignUpbtn.setBackground(new Color(255, 255, 255));
		SignUpbtn.setBounds(249, 251, 89, 23);
		contentPane.add(SignUpbtn);
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(224, 60, 76, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(224, 123, 76, 16);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
