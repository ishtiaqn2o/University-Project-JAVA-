import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UserLogin extends JFrame implements ActionListener{
	
JLabel accnum,password,title;	
	JPasswordField tpassword;
	JTextField taccnum;
	 JButton userlogin;
	
	public UserLogin(){
		super("USER LOGIN::::");
		Container con = getContentPane();
		con.setLayout(null);
		title =new JLabel(":::::USER LOGIN:::: ");
		accnum = new JLabel("Account Number :");
		password = new JLabel("Password : ");
		tpassword = new JPasswordField(10);
		taccnum = new JTextField(10);
		 userlogin= new JButton("Login");
		
		con.add(title);
		con.add( accnum);
		con.add(taccnum);
		con.add(password );
		con.add(tpassword );
		con.add(userlogin);
		userlogin.addActionListener(this);
		title.setBounds(210,90,250,25);
		accnum.setBounds(120,140,150,25);
		taccnum.setBounds(250,140,160,25);
		password.setBounds(155,180,150,25);
		tpassword.setBounds(250,180,160,25);
		userlogin.setBounds(250,220,70,25);   
		
		setSize(550,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	 
		}
		     public void actionPerformed(ActionEvent event){
                   
        if(event.getActionCommand().equals("Login")){
            
            checkLogin();
	}
	}
        private void checkLogin(){
        String dbName ="jdbc:mysql://localhost:3306/ishti";
        String dbUserName = "root";
        String dbPassword = ""; 
        
        String q="select * from information where accountnum='"+taccnum .getText()+"' and pass='"+tpassword.getText()+"'";
        
        try{
        //connection to MySQLDatabase
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbName,dbUserName,dbPassword);
        //........................................................................................... 
        // connection to MS Access database
       /*      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");


			Connection con = DriverManager.getConnection("jdbc:odbc:test","root","");
        */
        //.........................................................................................
                 
        Statement stm=con.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE*/);
         
        ResultSet rs=stm.executeQuery(q); 
      
        if(rs.next()) // Checks if there is any Records or not, true if found
			{
			
                taccnum.setText("");
                tpassword.setText("");
				
				UserInfo u2 =new UserInfo();
		//String n= tname.getText();
	
		u2.setName(rs.getString("name"));
				
		u2.setAccount(rs.getString("accountnum"));		
				
			
		User c2 =new User(u2);
               // JOptionPane.showMessageDialog(null,"Hello, "+rs.getString("name"));
				
                }
        else{
            
            JOptionPane.showMessageDialog(null,"User Not Found");
        }
		

			rs.close();
			stm.close();
			con.close(); 
         
         
         
         
     }catch(Exception e){
            System.out.println(e);     
    }
    }
		     
	
    
    
    
    public static void main(String args[]){
                    UserLogin l = new UserLogin();
			     
			}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	