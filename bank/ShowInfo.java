import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
class ShowInfo extends JFrame{
private JPanel topPanel;
private JTable table;
public JScrollPane scrollPane;
public JScrollPane scrollPane1;
private String[] columnNames=new String[7];
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
public  ShowInfo(){
   setTitle("::User Info::");
    setSize(500,500);
setDefaultCloseOperation (DISPOSE_ON_CLOSE);
jb1=new JButton("Show");
jb1.setBounds(75,400,90,30);
   	    	
		
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
    
    	
    	
    	try{
    	
			
    	    rs=st.executeQuery("SELECT * from information");
    	    	
    	while(rs.next())
    	{
    	 
    	  
    	  bid = rs.getString(1);
    	  bn = rs.getString(2);
    	  ba = rs.getString(3);
    	  bc = rs.getString(4);
    	  mid = rs.getString(5);
    	 mn = rs.getString(6);
	d1 = rs.getString(7);
    	d2 = rs.getString(8);	
    	  rows++;
    	
    	}  
}catch(Exception e)
    	{
    	}
    
    try{
    	dataValues=new String[rows][8];
				
				 columnNames=new String[]{"Name","Gender","Age","Address","Contacnum","Email","Accountnum","Password"};
				 rs=st.executeQuery("Select * from information");
				
				for(int i1=0;i1<rows;i1++)
				{
						rs.next();
						for(int j1=0;j1<8;j1++)
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

scrollPane.setSize(490,240);

scrollPane1=new JScrollPane(jb1);

scrollPane1.setSize(200,200);

scrollPane1.setBounds(160,300,150,30);

topPanel.add(scrollPane);       

topPanel.add(scrollPane1);
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
}
public static void main(String args[]){
 ShowInfo x=new  ShowInfo();
x.setVisible(true);
}  
}
