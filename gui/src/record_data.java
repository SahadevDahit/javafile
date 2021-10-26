import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;

public class record_data extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	public JPanel contentPane;
	public JTextField contact;
	public JTextField name;
	private JTable table;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					record_data frame = new record_data();
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
	public record_data() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = null;
					conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
							"root", "");
					String sql = "select * from stud1";
					PreparedStatement pst = conn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception e2) {
					System.out.println("Error to display data in table");

				}

			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 320);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(36, 96, 78, 31);
		contentPane.add(lblNewLabel);

		JLabel lblcontact = new JLabel("Contact");
		lblcontact.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblcontact.setBounds(36, 138, 78, 14);
		contentPane.add(lblcontact);

		contact = new JTextField();
		contact.setBounds(113, 137, 137, 20);
		contentPane.add(contact);
		contact.setColumns(10);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(113, 106, 137, 20);
		contentPane.add(name);

		JLabel lblLoginRegistration = new JLabel("Student information");
		lblLoginRegistration.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblLoginRegistration.setBounds(98, 11, 165, 31);
		contentPane.add(lblLoginRegistration);

		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id.getText().length() == 0 || name.getText().length() == 0 || contact.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Please fill the information");

				}

				if (id.getText().length() != 0 || name.getText().length() != 0 || contact.getText().length() != 0) {

					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn;
						conn = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
								"root", "");

						PreparedStatement pst = conn.prepareStatement("insert into stud1(Student_ID,Name,Contact) values(?,?,?)");
						String namee = name.getText();
						String contac = contact.getText();
						pst.setString(1, id.getText());
						pst.setString(2, namee);
						pst.setString(3, contac);
						int k = pst.executeUpdate();
						if (k > 0) {

							JOptionPane.showMessageDialog(null, "Record added sucessfully");
							id.setText("");
							name.setText("");
							contact.setText("");

						} else {
							JOptionPane.showMessageDialog(null, "error");

						}
					} catch (Exception e1) {
						System.out.println(e1);

					}

					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn;
						conn = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
								"root", "");
						String sql = "select * from stud1";
						PreparedStatement pst = conn.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e2) {
						System.out.println("Error to display data in table");

					}
				}

				else {
					JOptionPane.showMessageDialog(null, "You have left to fill the information");
				}
			}
		});

		add.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		add.setBounds(36, 181, 89, 23);
		contentPane.add(add);

		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = null;
		          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
							"root", "");
					
					PreparedStatement pst = conn.prepareStatement("update stud1 set Student_ID='"+id.getText()+"',Name='"+name.getText()+"',Contact = '"+contact.getText()+"' where Student_ID='"+id.getText()+"'");
					
					int k = pst.executeUpdate();
					if (k > 0) {

						JOptionPane.showMessageDialog(null, "Record Updated  sucessfully");
						id.setText("");
						name.setText("");
						contact.setText("");
						

					} else {
						JOptionPane.showMessageDialog(null, "error");

					}
					conn.close();
					pst.close();
				} catch (Exception e1) {
					System.out.println(e1);

				}

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn;
					conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
							"root", "");
					String sql = "select * from stud1";
					PreparedStatement pst = conn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println("Error to display data in table");

				}

			}
		});
		update.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		update.setBounds(143, 181, 89, 23);
		contentPane.add(update);

		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					DefaultTableModel dm = (DefaultTableModel) table.getModel();
					int ro = table.getSelectedRow();
					id.setText(dm.getValueAt(ro, 1).toString());

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = null;
					conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
							"root", "");
					PreparedStatement pst = conn.prepareStatement("delete from stud1 where Student_ID = ?");
					int id = Integer.parseInt(dm.getValueAt(ro, 0).toString());
					pst.setInt(1, id);
					int k = pst.executeUpdate();
					if (k > 0) {

						JOptionPane.showMessageDialog(null, "Record deleted sucessfully");
                         
						name.setText("");
						contact.setText("");

					} else {
						JOptionPane.showMessageDialog(null, "error");

					}
				} catch (Exception e1) {
					System.out.println(e1);

				}

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn;
					conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
							"root", "");
					String sql = "select * from stud1";
					PreparedStatement pst = conn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println("Error to display data in table");

				}

			}

		});
		delete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		delete.setBounds(36, 215, 89, 23);
		contentPane.add(delete);

		JButton cancel = new JButton("Exit");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JFrame frame = new JFrame("EXIT");
			if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to exit","EXIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
			}
		});
		cancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		cancel.setBounds(143, 217, 89, 23);
		contentPane.add(cancel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

			  }
			       
			   	});
		scrollPane.setBounds(292, 47, 232, 210);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	

		      try {
		        	
		        	
		            int ro = table.getSelectedRow();
		          	           
		             String stud=(table.getModel().getValueAt(ro,0)).toString();
		             
		            Connection conn;
			     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "");
		               PreparedStatement pst = conn.prepareStatement("select * from stud1 where Student_ID='"+stud+"'");
			   				
			       // ResultSet rs = pst.executeQuery();
			        String textField = (String) table.getValueAt(table.getSelectedRow(),1);  
			        String textField1 = (String) table.getValueAt(table.getSelectedRow(),2);  
			        id.setText(stud);
			        name.setText(textField);
			        contact.setText(textField1);
		        
		           pst.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		
		    }

				
				
			
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Contact" }));

		id = new JTextField();
		id.setColumns(10);
		id.setBounds(113, 65, 137, 20);
		contentPane.add(id);

		JLabel txtid = new JLabel("Stud ID");
		txtid.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		txtid.setBounds(36, 64, 78, 31);
		contentPane.add(txtid);
		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(1).setPreferredWidth(114);
		table.getColumnModel().getColumn(2).setPreferredWidth(124);
	}
}
