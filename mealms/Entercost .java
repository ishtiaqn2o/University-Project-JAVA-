import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


class Entercost extends JFrame{
	 private JLabel title,date,cost ;
	
	private DateComboBox cdate;
	private	JButton submit;
	private JTextField tcost;
public  Entercost(){
	super ("Cost ");
	Container con = getContentPane();
        con.setLayout(null);
	title = new JLabel("    ::     Enter Cost     ::");
	date = new JLabel("Date");
	cdate = new DateComboBox();
	
	cost= new JLabel("Cost")
	tcost = new JTextField(10);
	submit = new JButton("Submit");
	con.add(title);
	con.add(date);
	con.add(cdate);
	
	con.add(meal);
	con.add(tmeal);
       con.add(submit);
	
     
  setSize(600,400);
        setVisible(true);
	   title.setBounds(40, 20, 500, 25);
      
	 date.setBounds(150, 20+25+20+25+20, 100, 25);
        cdate.setBounds(150+100+10, 20+25+20+25+20, 150, 25);
        cost.setBounds(150,25+20+25+20+20+25+20,100,25);
        tcost.setBounds(150+100+10,20+25+20+25+20+25+20,150,25);
        submit.setBounds(150+100+10, 20+25+20+25+20+25+20+25+20,100, 25);
	  
	  
	  
       
	
		
public static void main(String args[]){
	Entercost cost  = new Entercost ();
	cost.setVisible(true);
	
	}


}