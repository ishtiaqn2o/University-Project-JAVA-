import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Welcome extends JFrame{
	private JLabel title;
	private	JButton Admin,User;
	
	public Welcome(){
		super(".::.Account Management System.::.");
		title= new JLabel(":::Welcome To Your Account:::");

		Admin = new JButton("Admin");
		
		Container con =getContentPane();
		con.setLayout( null);
		User= new JButton("User");
		con.add(title);
		con.add(Admin);
		con.add(User);
		
		arrangeComponents();
		
		
		setSize(450,450);
		setVisible(true);
      
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         Admin.addActionListener(new AdminLogin());
           User.addActionListener(new user());
		}
		
		private void arrangeComponents(){
        title.setBounds(150, 50,500, 100);
        Admin.setBounds(70,150,125, 25);
	User.setBounds(250,150,125, 25);

			  
		  }
		  	public class AdminLogin implements ActionListener {
        public void actionPerformed(ActionEvent e) {
		Login ad =new Login();
		ad.setVisible(true);
	
		
        }	
		}
	public class user implements ActionListener {
        public void actionPerformed(ActionEvent e) {
		UserLogin ad =new UserLogin();
		ad.setVisible(true);
	
		
        }	
		}	
	
		  	
	
		  
	public static void main(String args[]){
		
		Welcome c1 =new Welcome();
		
        
	}
}