import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
class ShowTransaction extends JFrame{
	
	
	private JLabel title,name,accnum,balance,retname,retaccnum,retbalance;
private JPanel topPanel;
private JTable table;
public JScrollPane scrollPane;
public JScrollPane scrollPane1,scrollPane2,scrollPane3,scrollPane4;
private String[] columnNames=new String[4];
String[][]dataValues;
    int rows = 0;
	Object data1[][];   
PreparedStatement ps;
	Connection con;
	ResultSet rs;
	Statement st;
	JLabel l1;
	String bn,ba,bc,mn,bid,mid,d1,d2;
	JScrollPane scroller;
JButton jb1;
public ShowTransaction(beans acc){
   setTitle("Show Transaction");
    setSize(500,500);
setDefaultCloseOperation (DISPOSE_ON_CLOSE);
title =new JLabel(":::   Show Transaction:::");
name	=new JLabel("name");
retname =new JLabel(".........");
accnum	=new JLabel("accnum");
retaccnum=new JLabel("........");
balance=new JLabel("name");	
	retbalance =new JLabel("........");
//retbalance.setBounds(150,200,100,20);
jb1=new JButton("show");

   	    	
		retaccnum.setText(acc.getAccount());
			try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ishti","root","");
		}catch(Exception e){}
		

		
		try {
			st = con.createStatement ();
		}
		catch (SQLException sqlex) {
 			JOptionPane.showMessageDialog (null, "A Problem Occurs While Loading Form.");
 			dispose ();	
	 	}
    
    	String value =retaccnum.getText();
    	
    	try{
    	
			
    	    rs=st.executeQuery("Select date,debit,credit from transaction where accountnum = '"+value+"'");
    	    	
    	while(rs.next())
    	{
    	 
    	  
    	  bid = rs.getString(1);
    	  bn = rs.getString(2);
    	  ba = rs.getString(3);
    	// bc = rs.getString(4);
    	//  mid = rs.getString(5);
    	 // mn = rs.getString(6);
    	 // d1 = rs.getString(7);
    	// d2 = rs.getString(8);	
    	  rows++;
    	
    	}  
}catch(Exception e)
    	{
    	}
    
    try{
    	dataValues=new String[rows][3];
				
				 columnNames=new String[]{"Date","Debit","Credit"};
				 rs=st.executeQuery("Select date,debit,credit from transaction where accountnum = '" +value+"'");
				
				for(int i1=0;i1<rows;i1++)
				{
						rs.next();
						for(int j1=0;j1<3;j1++)
						{
							dataValues[i1][j1]=rs.getString(j1+1);
						}
				}
				
    }
    catch(Exception e){
    }
    topPanel=new JPanel();

topPanel.setLayout(null);

getContentPane().add(topPanel);

table=new JTable();

scrollPane=new JScrollPane(table);

//scrollPane.setSize(300,300);
scrollPane.setBounds(0,250,500,240);
    
scrollPane1=new JScrollPane(jb1);
    scrollPane1.setSize(30,30);
    scrollPane1.setBounds(240,250,90,30);


scrollPane1.setBounds(75,20,150,30);
scrollPane2=new JScrollPane(title);
  // scrollPane2.setSize(100,30); 
scrollPane2.setBounds(230,200,150,30);
scrollPane3=new JScrollPane(retaccnum);
   scrollPane2.setSize(100,30); 
scrollPane2.setBounds(200,50,150,30);
     scrollPane3.setSize(100,30); 
scrollPane3.setBounds(200,100,150,30);
    scrollPane3.setVisible(false);
    topPanel.add(scrollPane);       

topPanel.add(scrollPane1);
topPanel.add(scrollPane2);
topPanel.add(scrollPane3);      
jb1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){
TableModel  model=new myTableModel();
   table.setModel(model);
}
}
);
}

public class myTableModel extends DefaultTableModel{
myTableModel(){
super(dataValues,columnNames);
}
public boolean isCellEditable(int row,int cols){
return true;
}


/*public static void main(String args[]){
ShowTransaction x=new ShowTransaction();
x.setVisible(true);
}  */
}
}
