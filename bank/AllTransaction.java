import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.io.IOException;
import java.util.Date.*;

public class AllTransaction extends JFrame 
{
	PreparedStatement ps;
	Connection con;
	ResultSet rs;
	Statement st;
	JLabel l1;
	String bn,ba,bc,mn,bid,mid,d1,d2;
	//int bid,mid;
	//Date d1,d2;
    int rows = 0;
	Object data1[][];
	JScrollPane scroller;
	JTable table;
	  
	  
    public AllTransaction()
    {
    	
     
            Container cp = getContentPane();
    		cp.setLayout(new BorderLayout());
   			
   			 setSize(600,600);
    		 setLocation(50,50);
   		     setLayout(new BorderLayout());
   			 setTitle("All Transaction");
   		
   	    	
		
			try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ishti","root","");
		}catch(Exception e){}
		

		
		try {
			st = con.createStatement ();	//Creating Statement Object.
		}
		catch (SQLException sqlex) {			//If Problem then Show the User a Message.
 			JOptionPane.showMessageDialog (null, "A Problem Occurs While Loading Form.");
 			dispose ();				//Closing the Form.
	 	}
    
    	
    	
    	try{
    	
			
    	    rs=st.executeQuery("SELECT * from transaction");
    	    	
    	while(rs.next())
    	{
    	 
    	  
    	  bid = rs.getString(1);
    	  bn = rs.getString(2);
    	  ba = rs.getString(3);
    	  bc = rs.getString(4);
    	  mid = rs.getString(5);
    	  //mn = rs.getString(6);
    	  //d1 = rs.getString(7);
    	// d2 = rs.getString(8);	
    	  rows++;
    	
    	}  
    		
    
    
    		
    		/*
				data1=new Object[rows][5];
				
				Object[] Colheads={"date","","BookAuthor","BookCat","Mid",};
				 rs=st.executeQuery("Select * from transaction");
				
				for(int i1=0;i1<rows;i1++)
				{
						rs.next();
						for(int j1=0;j1<5;j1++)
						{
							data1[i1][j1]=rs.getString(j1+1);
						}
				}
				JTable table=new JTable(data1,Colheads);
				int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
				int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
				
				JScrollPane jsp=new JScrollPane(table,v,h);
				
		
			 getContentPane().add(jsp);*/
		
    		}catch(Exception e)
    	{
    	}
    
    try{
    	data1=new Object[rows][5];
				
				Object[] Colheads={"Date","Accoun Number","Debit","Credit","Balance"};
				 rs=st.executeQuery("Select * from transaction");
				
				for(int i1=0;i1<rows;i1++)
				{
						rs.next();
						for(int j1=0;j1<5;j1++)
						{
							data1[i1][j1]=rs.getString(j1+1);
						}
				}
				JTable table=new JTable(data1,Colheads);
				int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
				int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
				
				JScrollPane jsp=new JScrollPane(table,v,h);
				
			
				getContentPane().add(jsp);
    }
    catch(Exception e){
    }
    	
    	
    	setVisible(true);
    	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    }
    public static void main(String args[])
    {
     AllTransaction frm = new AllTransaction();
       			 frm.setSize(600, 600);
       			 frm.setLocation(50,50);
	
       			/* BufferedImage image = null;
        try {
            image = ImageIO.read(frm.getClass().getResource("usericon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frm.setIconImage(image);*/
       			 frm.setVisible(true);
       			 frm.show();
    }
 }