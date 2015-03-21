
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class Form extends JFrame 
{
JButton ADD,RETRIEVE;
JPanel panel;
JLabel label1,label2;
final JTextField text1,text2;
Form()
{
Container con1 = getContentPane();
con1.setLayout(new FlowLayout());


label1 = new JLabel();
label1.setText("Employee Name:");
text1 = new JTextField(20);

label2 = new JLabel();
label2.setText("Employee Address:");
text2 = new JTextField(20);

ADD=new JButton("ADD");
//RETRIEVE=new JButton("RETRIEVE");


con1.add(label1);
con1.add(text1);
con1.add(label2);
con1.add(text2);
con1.add(ADD);

setTitle("FORM");
setSize(500,500);
setVisible(true);
ADD.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae){
String value1=text1.getText();
String value2=text2.getText();
String dbName ="jdbc:mysql://localhost:3306/test3";
        String dbUserName = "root";
        String dbPassword = ""; 	
try{
Connection con = null;
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(dbName ,dbUserName , dbPassword );
Statement st = con.createStatement();
int i= st.executeUpdate("Insert into employee(empName,empAddress) values('"+value1+"','"+value2+"')");
JOptionPane.showMessageDialog(null,"Data is successfully inserted into the database." );
st.close();
con.close();
}
catch(Exception e){
System.out.println(e);
}
}
});
}
public static void main(String args[]){
	Form f = new Form();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}