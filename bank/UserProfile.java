import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class UserProfile extends JFrame {
	private JPasswordField tpassword;
	private JLabel title, email,password,name,address,contactnum,age,info,account,balance,credit;
	private JLabel temail,tname,taddress,tcontactnum,tage,taccount;
	private JLabel sex,gender;

	
	 
		
public UserProfile(Bean3 user){
	super("::UserProfile ::");
	Container con =getContentPane();
	con.setLayout(null);
	
	//Jlabel..................................
	title=new JLabel("::Open New Account::");
	account = new JLabel("Account no#");
	 email=new JLabel("Email:");
	//password=new JLabel("Password:");
	name=new JLabel("Name:");
	address= new JLabel("Address:");
	contactnum=new JLabel("Contact no:");
	age =new JLabel("Age:");
	//credit = new JLabel("Credit");
	//balance
	
	 sex=new JLabel("Gender:");//checkbox label
	//info=new JLabel("Information");
	
	//JTextfield...................
	taccount =new JLabel(".....");
	temail=new JLabel(".........");
	//tpassword=new JLabel(".......");
	tname=new JLabel("........");
	taddress= new JLabel(".........");
	tcontactnum=new JLabel(".........");
	 tage=new JLabel (".............");   


	
	
	gender = new JLabel( "........." );

tname.setText(user.getName());
taddress.setText(user.getAddress());
tage.setText(user.getAge());
tcontactnum.setText(user.getContact());
temail.setText(user.getEmail());
gender.setText(user.getGender());


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
	
	
	
	arrangeComponents();

	setSize(500,500);
        setVisible(true);
    
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
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
	//password.setBounds(150, 335+45, 100, 25);
       // tpassword.setBounds(150+100+10,380, 250, 25);
       // submit.setBounds(150+100+10, 425+45, 100, 25);
      //  cancel.setBounds(150+100+20+100, 425+45, 100, 25);
       
    }
	
	
	
	
	
	
	
	
	
/*
	public static void main(String args[]){
		
		UserProfile u1=new UserProfile();
		
		
		}*/
	}
