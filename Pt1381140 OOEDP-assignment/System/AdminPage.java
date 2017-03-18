//package pms.admin;
//import pms.prisoner.*;
//import pms.warden.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 import java.sql.*;
/**
 * The {@code AdminPage} class represents Control page. It provides all the control 
 * that admin or highest Rank warden can access.
 * <p>
 * Admin Page has following Controls For Prisoner :
 * <blockquote><pre>
 *      Add a Prisoner.
 *		Find a Prisoner.
 *		Release a Prisoner.
 *		Delete a Prisoner.
 *		Update Prisoner's Details.
 *		Genrate Reports of all Prisoner.
 *     
 * </pre></blockquote>
 * <p>
 * Admin Page has following Controls For Warden :
 * <blockquote><pre>
 *      Add a Warden.
 *		Find a Warden.
 *		Delete a Warden.
 *		Update Warden's Details.
 *		Genrate Reports of all Warden.
 *     
 * </pre></blockquote>
 *
 */


 public class AdminPage extends JFrame {

    private ControlButton btnAddPrisoner,btnFindPrisoner,btnReleasePrisoner,btnDeletePrisoner;
    private ControlButton btnDisplayAllPrisoner,btnAddWarden,btnDisplayAllWarden,btnCheackWardenAllocation;
	private ControlButton btnDeleteWarden,btnFindWarden,btnLogout;
    private JLabel lblHeader,lblInformationHeader,lblInformation1,lblInformation2,lblInformation3;
	private JPanel pnlHeader,pnlBody,pnlFooter;
	private ImageIcon icon1,icon2,icon3,icon4,icon5,icon6,icon7,icon8,icon9,icon10,icon11,icon12;
	private LoginPage loginPage;
	/**
	* Constructer that calls another  admin page constructer .
	*/
	public AdminPage(LoginPage hold){
		this();
		loginPage=hold;		
	}
	/**
	* Constructer that creates admin page form and provides all the controls.
	*/
	public AdminPage(){

	    super("Admin Controls");
	    setSize(1366,768);
		setPreferredSize(new Dimension(1366, 768));
		setLayout(null);

        icon1 = new ImageIcon("images/xyz.jpg");
	    icon2 = new ImageIcon("images/addprisoner.jpg");
	    icon3 = new ImageIcon("images/findprisoner.jpg");
	    icon4 = new ImageIcon("images/releaseprisoner.jpg");
	    icon5 = new ImageIcon("images/deleteprisonerwarden.jpg");
		icon6 = new ImageIcon("images/displayprisoner.jpg");
		icon7 = new ImageIcon("images/addwarden.jpg");
		icon8 = new ImageIcon("images/displayAllWarden.jpg");
		icon9 = new ImageIcon("images/WardenAllocation.jpg");
		icon10 = new ImageIcon("images/deleteprisoner.jpg");
		icon11 =new ImageIcon("images/logout.jpg");
		icon12 = new ImageIcon("images/findWarden.jpg");

    	lblHeader=new JLabel(icon1);
		lblHeader.setBounds(123,50,790,72);
		add(lblHeader);

		btnAddPrisoner=new ControlButton(icon2,123,150,this);
		btnFindPrisoner=new ControlButton(icon3,353,150,this);
		btnReleasePrisoner=new ControlButton(icon4,583,150,this);
		btnDeletePrisoner=new ControlButton(icon5,813,150,this);
		btnDisplayAllPrisoner=new ControlButton(icon6,1043,150,this);
		btnAddWarden=new ControlButton(icon7,123,410,this);
		btnDisplayAllWarden=new ControlButton(icon8,353,410,this);
		btnCheackWardenAllocation=new ControlButton(icon9,583,410,this);
    	btnDeleteWarden=new ControlButton(icon10,813,410,this);
		btnFindWarden=new ControlButton(icon12,1043,410,this);
		btnLogout= new ControlButton(icon11,1220,20,100,50,this);

		//lblInformation
		lblInformationHeader=new JLabel();
		lblInformation1=new JLabel();
		lblInformation2=new JLabel();
		lblInformation3=new JLabel();
		lblInformationHeader.setBounds(50,650,400,25);
		lblInformationHeader.setFont(new Font("Tahoma", 1, 16));
		lblInformationHeader.setForeground(new Color(255,255,255));
		lblInformation1.setBounds(50,675,600,25);
		lblInformation1.setFont(new Font("Tahoma", 1, 16));
		lblInformation1.setForeground(new Color(255,255,255));
		lblInformation2.setBounds(600,675,700,25);
		lblInformation2.setFont(new Font("Tahoma", 1, 16));
		lblInformation2.setForeground(new Color(255,255,255));
		lblInformation3.setBounds(50,700,600,25);
		lblInformation3.setFont(new Font("Tahoma", 1, 16));
		lblInformation3.setForeground(new Color(255,0,0));
		add(lblInformationHeader);
		add(lblInformation1);
		add(lblInformation2);
		add(lblInformation3);
		setLayout(null);
		getContentPane().setBackground(new Color(72,72,74));

		pack();
		setResizable(false);
	
	}
	/**
	* method  that checks waden allocation and shows the status in Information bar.
	*/
	public boolean checkWardenAllocation(){
			int wardenCount,prisonerCount,highLevelPrisoner=0,lowLevelPrisoner=0,highRankWarden=0,lowRankWarden=0;
			boolean flag=false;
		 try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully in checkwardenAllocation at adminPage");
           Connection connect = DriverManager.getConnection("jdbc:odbc:PMS");
		   System.out.println("Connection established successfully in checkwardenAllocation at adminPage");
           Statement state = connect.createStatement();
           String sql1 = "select * from Prisoner_Details where Status= '" + "Incarcerated" + "'";
           ResultSet rsWarden,rsPrisoner=state.executeQuery(sql1);
		   while(rsPrisoner.next())
                {
			   		if(((String)rsPrisoner.getString("Security_Class")).equals("High Risk"))
						highLevelPrisoner=highLevelPrisoner+1;
					else
						lowLevelPrisoner=lowLevelPrisoner+1;
                }
		   rsPrisoner.close();

		    sql1 = "select * from Warden_Details where Status= '" + "Working" +"'";
			rsWarden=state.executeQuery(sql1);
		   while(rsWarden.next())
                {

			   		if(rsWarden.getInt("Rank")>=3)
					     highRankWarden=highRankWarden+1;
					else
						lowRankWarden=lowRankWarden+1;
                }

                lblInformationHeader.setText("Information Bar");
				lblInformation1.setText("Number of High Rank ="+highRankWarden+" "+"Number of Low Rank Warden ="+lowRankWarden);
				lblInformation2.setText("Number of Low Security Prisoners ="+lowLevelPrisoner+" "+"Number of High Security Prisoners ="+highLevelPrisoner);
				int hold=(highLevelPrisoner+1)/2-highRankWarden;
				if((highLevelPrisoner+1)/2>highRankWarden)
				lblInformation3.setText(hold+" "+"New High Rank Warden are Required");
				flag = true;
			rsWarden.close();
		   
           state.close();
           connect.close();
		}catch (Exception e) {
           System.out.print(e);
        }
		return flag;
	}
	private void logout(){
		loginPage.setVisible(true);
		this.dispose();
	}
	private void addPrisoner(){
		new Prisoner(this,"Add a Prisoner").setVisible(true);
		setVisible(false);	
	}
	private void findPrisoner(String str){
		new FindPrisoner(this,str);
	}
		private void findWarden(String str){
		new FindWarden(this,str);
	}
	private void addWarden(){
		new Warden(this,"Add a Warden").setVisible(true);
		setVisible(false);	
	}

	class ControlButton extends JButton implements ActionListener{ 
	ControlButton(Icon c,int x,int y,Container cnt){
		super(c);
		this.setBounds(x,y,200,230);
		cnt.add(this);
		addActionListener(this);
	}
	ControlButton(Icon c,int w,int x,int y,int z,Container cnt){
		super(c);
		this.setBounds(w,x,y,z);
		cnt.add(this);
		addActionListener(this);
	}
	/**
	* method that works is called internally when any Button is pressed
	* and then it call method asociated with button pressed.
	*/
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnFindPrisoner){
			findPrisoner("Find the Prisoner");
		}
		if(e.getSource()==btnAddPrisoner){
			addPrisoner();		
		}
		if(e.getSource()==btnLogout){
			logout();
		}
		if(e.getSource()==btnDeletePrisoner){
		findPrisoner("Delete a Prisoner");
		}
		if(e.getSource()==btnReleasePrisoner){
		findPrisoner("Release a Prisoner");
		}
		if(e.getSource()==btnDisplayAllPrisoner)
			new PrisonerReport();
		if(e.getSource()==btnDisplayAllWarden)
			new WardenReport();
		if(e.getSource()==btnFindWarden)
			findWarden("Find the Warden");
		if(e.getSource()==btnDeleteWarden)
			findWarden("Delete a Warden");
		if(e.getSource()==btnCheackWardenAllocation)
			checkWardenAllocation();
		if(e.getSource()==btnAddWarden)
			addWarden();
	 }	
    }
}  