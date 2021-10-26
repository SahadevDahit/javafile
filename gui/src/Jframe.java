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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jframe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframe frame = new Jframe();
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
	public Jframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(167, 30, 102, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lname = new JLabel("Last Name");
		lname.setForeground(Color.CYAN);
		lname.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lname.setBackground(Color.GREEN);
		lname.setBounds(24, 96, 94, 22);
		contentPane.add(lname);
		
		JLabel uname = new JLabel("UserName");
		uname.setForeground(Color.CYAN);
		uname.setFont(new Font("Tahoma", Font.ITALIC, 16));
		uname.setBackground(Color.GREEN);
		uname.setBounds(24, 162, 94, 22);
		contentPane.add(uname);
		
		JLabel pass = new JLabel("PassWord");
		pass.setForeground(Color.CYAN);
		pass.setFont(new Font("Tahoma", Font.ITALIC, 16));
		pass.setBackground(Color.GREEN);
		pass.setBounds(24, 198, 94, 22);
		contentPane.add(pass);
		
		final JLabel fname = new JLabel("First  Name");
		fname.setForeground(Color.CYAN);
		fname.setFont(new Font("Tahoma", Font.ITALIC, 16));
		fname.setBackground(Color.GREEN);
		fname.setBounds(24, 65, 94, 22);
		contentPane.add(fname);
		
		textField = new JTextField();
		textField.setBounds(128, 63, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 99, 200, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 132, 200, 20);
		contentPane.add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 201, 200, 20);
		contentPane.add(passwordField);
		
		JLabel mno = new JLabel("Phone No");
		mno.setForeground(Color.CYAN);
		mno.setFont(new Font("Tahoma", Font.ITALIC, 16));
		mno.setBackground(Color.GREEN);
		mno.setBounds(24, 129, 94, 22);
		contentPane.add(mno);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 163, 200, 20);
		contentPane.add(textField_3);
		
		 btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Enter First name");
				}
				else if(textField_1.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Enter Last name");
				}
				else if(textField_2.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Enter Mobile no");
				}
				else if(textField_3.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Enter username");
				}
				else if(passwordField.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Enter Password");
				}
				else {
				JOptionPane.showMessageDialog(null,"Successfully created");
			}
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(109, 264, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jfame2 s = new Jfame2();
				s.setVisible(true);
				
			}
		});
		btnCancel.setForeground(new Color(0, 0, 0));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancel.setBackground(Color.MAGENTA);
		btnCancel.setBounds(239, 264, 89, 23);
		contentPane.add(btnCancel);
	}
}
