import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Update extends JFrame implements  ActionListener{
	private JPasswordField tpassword;
	private JLabel title, email,password,address,contactnum,account;
	private JTextField temail,taddress,tcontactnum,taccount;

	private	JButton submit,cancel;
	
	 
		
public Update(){
	super("ADD INFO ::");
	Container con =getContentPane();
	con.setLayout(null);
	
	//Jlabel..................................
	title=new JLabel("::Update Account::");
	account = new JLabel("Account no#");
	 email=new JLabel("Email:");
	password=new JLabel("Password:");
	//name=new JLabel("Name:");
	address= new JLabel("Address:");
	contactnum=new JLabel("Contact no:");

	//credit = new JLabel("Credit");
	//balance
	
	 //sex=new JLabel("Gender:");//checkbox label
	//info=new JLabel("Information");
	
	//JTextfield...................
	taccount =new JTextField(10);
	temail=new JTextField(10);
	tpassword=new JPasswordField(10);
	//tname=new JTextField(10);
	taddress= new JTextField();
	tcontactnum=new JTextField(10);
	// tage=new JTextField (10);   

// button
         submit = new JButton("Submit");
        cancel = new JButton("Cancel");
	
	
	//gender = new JComboBox( names );

//con.add(info);

	con.add(title);
        //con.add(name);
        //con.add(tname);
	//con.add(sex);
	//con.add( gender);
	//con.add(age);
	//con.add(tage);
	con.add(address);
        con.add(taddress);
	con.add(contactnum);
        con.add(tcontactnum);
	con.add(email);
        con.add(temail);
	con.add(account);
	con.add(taccount);
        con.add(password);
        con.add(tpassword);
	con.add(submit);
        con.add( cancel );
	
	submit.addActionListener(this);
	
	arrangeComponents();

	        setSize(600,350);
        setVisible(true);
    
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	
}

	
	public void actionPerformed(ActionEvent event){
                String command = event.getActionCommand();
                
                    if(command.equals("Submit")){
                        String val1=taccount.getText();
                        String val2=taddress.getText();
		        String val3=tcontactnum.getText();
                        String val4=tpassword.getText();
			                            String val5=temail.getText();
                        
	                    
        String dbName ="jdbc:mysql://localhost:3306/ishti";
        String dbUserName = "root";
        String dbPassword = "";
    try{
    Connection con = null;
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection(dbName ,dbUserName , dbPassword );
    Statement st = con.createStatement();
    String qry ="UPDATE `ishti`.`information` SET `address` = '"+val2+"',`contact` = '"+val3+"',`email` = '"+val4+"',`pass` = '"+val5+"' WHERE `information`.`accountnum` = '"+val1+"'" ;

    int i = st.executeUpdate(qry); 
      JOptionPane.showMessageDialog(null,"Quantity is successfully updated" );   
    
    st.close();
    con.close();
        }
    catch(Exception e){
    System.out.println(e);
            }
        }

}
private void arrangeComponents(){
        title.setBounds(200,20 , 500, 20);
	
	account.setBounds(150, 40,100,20);
	taccount.setBounds(150+100+10,40, 250,20);
	
	address.setBounds(150, 60,100,25);
	taddress.setBounds(150+100+10,60, 250,20);
	contactnum.setBounds(150,90,100,25);
	tcontactnum.setBounds(150+100+10,90,250,25);
	email.setBounds(150,120,100,25);
	temail.setBounds(150+100+10,120,250,25);
	password.setBounds(150,150, 100, 25);
        tpassword.setBounds(150+100+10,150, 250, 25);
        submit.setBounds(150+100+10, 190, 100, 25);
        cancel.setBounds(150+100+20+100,190, 100, 25);
       
    }
	
	
	
	
	
	
	
	
	

	public static void main(String args[]){
		
		Update info =new Update();
		
		}
	}	




