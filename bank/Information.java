import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Information extends JFrame {
	private JPasswordField tpassword;
	private JLabel title, email,password,name,address,contactnum,age,info,account,balance,credit;
	private JTextField temail,tname,taddress,tcontactnum,tage,taccount;
	private JLabel sex;
	private JComboBox gender;
	private static final String[] names =
 { "Male","Female"};
	private	JButton submit,reset;
	
	 
		
public Information(){
	super("ADD INFO ::");
	Container con =getContentPane();
	con.setLayout(null);
	
	//Jlabel..................................
	title=new JLabel("::Open New Account::");
	account = new JLabel("Account no#");
	 email=new JLabel("Email:");
	password=new JLabel("Password:");
	name=new JLabel("Name:");
	address= new JLabel("Address:");
	contactnum=new JLabel("Contact no:");
	age =new JLabel("Age:");
	//credit = new JLabel("Credit");
	//balance
	
	 sex=new JLabel("Gender:");//checkbox label
	//info=new JLabel("Information");
	
	//JTextfield...................
	taccount =new JTextField(10);
	temail=new JTextField(10);
	tpassword=new JPasswordField(10);
	tname=new JTextField(10);
	taddress= new JTextField();
	tcontactnum=new JTextField(10);
	 tage=new JTextField (10);   

// button
         submit = new JButton("Submit");
        reset = new JButton("Reset");
	
	
	gender = new JComboBox( names );

//con.add(info);

	con.add(title);
        con.add(name);
        con.add(tname);
	con.add(sex);
	con.add( gender);
	con.add(age);
	con.add(tage);
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
        con.add(reset);
	
	arrangeComponents();

	        setSize(600,600);
        setVisible(true);
    
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	submit.addActionListener(new ActionListener(){
  
public void actionPerformed(ActionEvent ae){
	
String val7=taccount.getText();
String val6=temail.getText();
String val8=tpassword.getText();
String val1=tname.getText();
	String val4=taddress.getText();
	String val5=tcontactnum.getText();
	String val3= tage.getText();
	String val2=gender.getSelectedItem().toString();
	
	if (val1.equals("") ){
		JOptionPane.showMessageDialog(null,"Please Insert Name " );
		}
		
	else if (val2.equals("") ){
		JOptionPane.showMessageDialog(null,"Please Insert Gender " );
		}
		else if (val3.equals("") ){
		JOptionPane.showMessageDialog(null,"Please Insert Age " );
		}
		
		else if (val4.equals("") ){
		JOptionPane.showMessageDialog(null,"Please Insert Address " );
		}
		
		else if (val5.equals("") ){
		JOptionPane.showMessageDialog(null,"Please Insert Contact number" );
		}
		
		else if (val6.equals("") ){
		JOptionPane.showMessageDialog(null,"Please Insert Email Address " );
		}
		
		else if (val7.equals("") ){
		JOptionPane.showMessageDialog(null,"Please Insert Account Number" );
		}
		
		else if (val8.equals("") ){
		JOptionPane.showMessageDialog(null,"Please Insert Password " );
		}
		
	else{
String dbName ="jdbc:mysql://localhost:3306/ishti";
        String dbUserName = "root";
        String dbPassword = ""; 	
try{
Connection con = null;
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(dbName ,dbUserName , dbPassword );
Statement st = con.createStatement();
int i= st.executeUpdate("INSERT INTO information (name,gender,age,address,contact,email,accountnum,pass) VALUES ('"+val1+"','"+val2+"','"+val3+"','"+val4+"','"+val5+"','"+val6+"','"+val7+"','"+val8+"')");

	UserInfo u1 =new UserInfo();
		//String n= tname.getText();
	
		u1.setName(val1);
	//String a= tname.getText();
	u1.setAccount(val7);
	
	
	
	EnterBalance c1 =new EnterBalance(u1);
	//c1.setvisible(true);
	
	
	
	
	JOptionPane.showMessageDialog(null,"Data is successfully inserted into the database." );
	
	
st.close();
con.close();
}
catch(Exception e){
System.out.println(e);
}
}
}
});

	reset.addActionListener(new ActionListener(){
  
public void actionPerformed(ActionEvent ae){
	
String val7=taccount.getText();
String val6=temail.getText();
String val8=tpassword.getText();
String val1=tname.getText();
	String val4=taddress.getText();
	String val5=tcontactnum.getText();
	String val3= tage.getText();
	String val2=gender.getSelectedItem().toString();
	
	
	 tname.setText("");
	   tage.setText("");
	
tcontactnum.setText("");
	   temail.setText("");
	taddress.setText("");
	   tpassword.setText("");
	taccount.setText("");
	   
	
}
});












}




	
	


private void arrangeComponents(){
        title.setBounds(40, 20, 500, 25);
        name.setBounds(150, 20+25+20, 100, 25);
        tname.setBounds(150+100+10, 20+25+20, 250, 25);
	sex.setBounds(150, 20+25+20+25+20,100,25);
        gender.setBounds(150+100+10, 110, 100,25 );
	age.setBounds(150, 65+45+45,100,25);
	tage.setBounds(150+100+10, 155, 250,25);
	address.setBounds(150, 155+45,100,25);
	taddress.setBounds(150+100+10, 155+45, 250,25);
	contactnum.setBounds(150,200+45,100,25);
	tcontactnum.setBounds(150+100+10, 200+45,250,25);
	email.setBounds(150,245+45,100,25);
	temail.setBounds(150+100+10,245+45,250,25);
	account.setBounds(150,290+45,100,25);
	taccount.setBounds(150+100+10,290+45,250,25);
	password.setBounds(150, 335+45, 100, 25);
        tpassword.setBounds(150+100+10,380, 250, 25);
        submit.setBounds(150+100+10, 425+45, 100, 25);
        reset.setBounds(150+100+20+100, 425+45, 100, 25);
       
    }
	
	
	
	
	
	
	
	
	

	public static void main(String args[]){
		
		Information info =new Information();
		
		}
	}
