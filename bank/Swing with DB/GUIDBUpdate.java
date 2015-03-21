import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class GUIDBUpdate extends JFrame implements ActionListener{
    
    private JLabel id,oldPass,newPass;
    private JTextField tid;
    private JPasswordField oldTpass,newTpass;
    private JButton blogin;
    
    
    public GUIDBUpdate(){
        
        super("::SYSTEM LOGIN::");
        
        Container con = getContentPane();
        con.setLayout(null);
        
        id = new JLabel("User ID");
        con.add(id);
        tid = new JTextField();
        con.add(tid);
        pass = new JLabel("Password");
        con.add(pass);
        tpass = new JPasswordField();
        con.add(tpass);
        blogin = new JButton("Login");
        con.add(blogin);
        blogin.addActionListener(this);
        Insets insets = con.getInsets();
        
        id.setBounds(insets.left+50, insets.top+50, 100, 25);
        tid.setBounds(insets.left+160, insets.top+50, 100, 25);
        pass.setBounds(insets.left+50, insets.top+85, 100, 25);
        tpass.setBounds(insets.left+160, insets.top+85, 100, 25);
        blogin.setBounds(insets.left+270, insets.top+85, blogin.getPreferredSize().width, 25);
        
        setSize(400,200);
        setVisible(true);
        
        
    }
    
    public static void main(String args[]){
        GUIDBTest app =new GUIDBTest();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public void actionPerformed(ActionEvent event){
        
        if(event.getActionCommand().equals("Login")){
            
            checkLogin();
            
        }
        
    }
    
    private void checkLogin(){
        
        String dbName ="jdbc:mysql://localhost:3306/test";
        String dbUserName = "root";
        String dbPassword = ""; 
        
        String q="select * from user where id='"+tid.getText()+"' and pass='"+tpass.getText()+"'";
        
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
			
                tid.setText("");
                tpass.setText("");
                JOptionPane.showMessageDialog(null,"Hello, "+rs.getString("name"));
                
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
    
    
}