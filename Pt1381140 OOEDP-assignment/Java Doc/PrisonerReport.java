//package pms.admin;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class PrisonerReport extends JFrame implements ActionListener{
	DefaultTableModel model;
	JTable table;
	int rowHeight=45;
	int rowMargin=10;
	JPanel pnlTable,pnlHeader,pnlButtons;
	JLabel lblHeader;
	JScrollPane sclTable;
	JButton btnOk;

  public static void main(String[] argv) throws Exception {
	  PrisonerReport m= new PrisonerReport();    
  }
  public PrisonerReport(){
	  	 model = new DefaultTableModel();
		 table = new JTable(model);
	    pnlTable=new JPanel();
		pnlHeader=new JPanel();
	    lblHeader=new JLabel("Prisoner Reports");
		pnlButtons=new JPanel();
	    btnOk=new JButton("OK");

		initComponents();
  }
    private void initComponents() {
	
	btnOk.addActionListener(this);

	pnlTable.setLayout(new FlowLayout());
	pnlTable.setSize(1366,700);

	lblHeader.setFont(new Font("Arial Black",1,25));
	pnlHeader.setLayout(new FlowLayout());
	pnlHeader.add(lblHeader);

	pnlButtons.add(btnOk);

	table.setRowHeight(30);
	table.setFont(new Font("Arial Black",0,12));
	table.setAlignmentY(25);
	table.setEnabled(false);
	table.setSize(1366,700);
	
	model.addColumn("Serial NO.");
	model.addColumn("PRISONER ID");
	model.addColumn("NAME");
	model.addColumn("SECURITY LEVEL");
	model.addColumn("BOOK DATE");
	model.addColumn("RELEASE DATE");
	Object content[]=new Object[6];
	int count=1;

	try{
	  
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   Connection connect = DriverManager.getConnection("jdbc:odbc:PMS");
	  Statement  stmt = connect.createStatement();
	  ResultSet rs = stmt.executeQuery("Select * from Prisoner_Details where Status= '" + "Incarcerated" +"'");	  
	  while(rs.next()){
		  content[0]=count;
		  content[1]=rs.getString("ID");
		  content[2]=rs.getString("First_Name")+" "+rs.getString("Last_Name");
		  content[3]=rs.getString("Security_Class");
		  content[4]=rs.getString("Book_Date");
		  content[5]=rs.getString("Release_Date");
		   model.addRow(content); 
		   count++;
	  }
	  	stmt.close();
        connect.close();	  
    }catch(Exception e){
    }

    setSize(1366, 700);
	sclTable=new JScrollPane(table);
	sclTable.setSize(1366,700);
    pnlTable.add(sclTable);
	setLayout(new BorderLayout());
	add(pnlHeader,BorderLayout.NORTH);
	add(pnlButtons,BorderLayout.SOUTH);
	add(sclTable);

		try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Prisoner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prisoner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prisoner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prisoner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

	setVisible(true);
  }
  public void actionPerformed(ActionEvent e){
  dispose();}
}