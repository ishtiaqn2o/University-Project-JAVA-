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
	
	cost= new JLabel("Cost");
	tcost = new JTextField(10);
	submit = new JButton("Submit");
	con.add(title);
	con.add(date);
	con.add(cdate);
	
	con.add(cost);
	con.add(tcost);
       con.add(submit);
	
     
  setSize(600,400);
        setVisible(true);
	   title.setBounds(40, 20, 500, 25);
      
	 date.setBounds(150, 20+25+20+25+20, 100, 25);
        cdate.setBounds(150+100+10, 20+25+20+25+20, 150, 25);
        cost.setBounds(150,25+20+25+20+20+25+20,100,25);
        tcost.setBounds(150+100+10,20+25+20+25+20+25+20,150,25);
        submit.setBounds(150+100+10, 20+25+20+25+20+25+20+25+20,100, 25);
	  
	 	submit.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
String val1=cdate.getSelectedItem().toString();

		String val2=tcost.getText();
		//int val4 = Integer.parseInt(val3);
//String val4=tbalance.getText();
if(val2.equals("")){
JOptionPane.showMessageDialog(null,"Plese Enter Cost");	
}


else{

String dbName ="jdbc:mysql://localhost:3306/meal";
        String dbUserName = "root";
        String dbPassword = ""; 	
try{
Connection con= null;
Class.forName("com.mysql.jdbc.Driver");
 con = DriverManager.getConnection(dbName ,dbUserName , dbPassword );
Statement st = con.createStatement();
int i= st.executeUpdate("INSERT INTO cost (date,cost) VALUES ('"+val1+"','"+val2+"')");
	tcost.setText("");
	
JOptionPane.showMessageDialog(null, "  you have enterted  cost amount    " +val2+"   at the Date  "+val1+"");
st.close();
con.close();
}
catch(Exception e){
System.out.println(e);
}
}
}
});
					
			
	 
  }
       


  
public static void main(String args[]){
	Entercost cost  = new Entercost ();
	cost.setVisible(true);
	
	}


}