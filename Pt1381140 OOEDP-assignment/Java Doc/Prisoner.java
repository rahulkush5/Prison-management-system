
//package pms.prisoner;
// import pms.admin.*;
 import java.awt.*;
 import javax.swing.*;
 import javax.swing.border.*;
 import java.awt.event.*;
 import java.sql.*;
 import java.io.*;
 import java.util.Calendar;
 /**
 *The {@code Prisoner} class represents an actual prisoner and of its attributes and properties for Prison Management sysytem.
 * Prisoner page provides following functionalities :
 * <blockquote><pre>
 *      Add a Prisoner.
 *		Find a Prisoner.
 *		Release a Prisoner.
 *		Delete a Prisoner.
 *		Update Prisoner's Details.
 *		Genrate Reports of all Prisoner.
 * </pre></blockquote>      
 */
public class Prisoner extends JFrame implements ActionListener{
	/**
	*Button for {@code Submitting} the prisoner Form.
	*/
    private JButton btnAdd;
	/**
	*Button for {@code Cancel} the prisoner Form.
	*/
    private JButton btnCancel;
	/**
	*Button for {@code Clear} the prisoner Form.
	*/
    private JButton	btnClear;
	/**
	*Button for {@code upload Mugshot} in the prisoner Form.
	*/
    private JButton	btnUploadMugshot;
	/**
	*Button for {@code delete} the prisoner status.
	*/
    private JButton	btnDelete;
	/**
	*Button for {@code Update} the prisoner Information.
	*/
    private JButton	btnUpdate;
	/**
	*Button for {@code release} the prisoner.
	*/
    private JButton	btnRelease;
	/**
	*Scroll Pane for {@code Crime Discription Text Area} in prisoner Form.
	*/
    private JScrollPane sclCrimeDiscription;
	/**
	*Text Area for {@code Crime Discription } in prisoner Form.
	*/
    private JTextArea textCrimeDescription;
	/**
	*Label for {@code Book Date } in prisoner Form.
	*/
    private JLabel lblBookingDate;
	/**
	*Label for {@code Status } in prisoner Form.
	*/
    private JLabel	lblStatus;
	/**
	*Label for {@code Crime Discription } in prisoner Form.
	*/
    private JLabel	lblCrimeDescription;
	/**
	*Label for {@code Days to incarcerate Field } in prisoner Form.
	*/
    private JLabel	lblDaysToIncarcerate;
	/**
	*Label for {@code First Name } in prisoner Form.
	*/
    private JLabel	lblFirstName;
	/**
	*Label for {@code Select Warden } in prisoner Form.
	*/
    private JLabel	lblSelectWarden;
	/**
	*Label for {@code Header } in prisoner Form.
	*/
    private JLabel	lblHeader;
	/**
	*Label for {@code Hieght } in prisoner Form.
	*/
    private JLabel	lblHieght;	/**
	*Label for {@code ID } in prisoner Form.
	*/
    private JLabel	lblId;
	/**
	*Label for {@code Last Name } in prisoner Form.
	*/
    private JLabel	lblLastName;
	/**
	*Label for {@code Mugshot } in prisoner Form.
	*/
    private JLabel	lblMugshot;
	/**
	*Label for {@code Origin } in prisoner Form.
	*/
    private JLabel	lblOrigin;
	/**
	*Label for {@code Race } in prisoner Form.
	*/
    private JLabel	lblRace;
	/**
	*Label for {@code Release Date } in prisoner Form.
	*/
    private JLabel	lblReleaseDate;
	/**
	*Label for {@code Security Class } in prisoner Form.
	*/
    private JLabel	lblSecurityClass;
	/**
	*Label for {@code Sex } in prisoner Form.
	*/
    private JLabel	lblSex;
	/**
	*JPanel for {@code Buttons } in prisoner Form.
	*/
    private JPanel pnlButtons;
	/**
	*JPanel for {@code Conponents } in prisoner Form.
	*/
    private JPanel	pnlComponents;
	/**
	*JPanel for {@code Personal Information } in prisoner Form.
	*/
    private JPanel	pnlPersonalInformation;
	/**
	*JPanel for {@code Prisonal Information } in prisoner Form.
	*/
    private JPanel	pnlPrisonalInformation;
	/**
	*JRadioButton for {@code Female } in prisoner Form.
	*/
    private JRadioButton rbnFemale;
	/**
	*JRadioButton for {@code Male } in prisoner Form.
	*/
    private JRadioButton	rbnMale;
	/**
	*ButtonGroup for {@code Sex } in prisoner Form.
	*/
	private ButtonGroup gpSex;
	/**
	*JTextField for {@code Status } in prisoner Form.
	*/
    private JTextField txtStatus;
	/**
	*JRadioButton for {@code First Name } in prisoner Form.
	*/
    private JTextField	txtFirstName;
	/**
	*JRadioButton for {@code Height } in prisoner Form.
	*/
    private JTextField	txtHeight;
	/**
	*JRadioButton for {@code ID } in prisoner Form.
	*/
    private JTextField	txtId;
	/**
	*JRadioButton for {@code last Name } in prisoner Form.
	*/
    private JTextField	txtLastName;
	/**
	*JRadioButton for {@code Origin } in prisoner Form.
	*/
    private JTextField	txtOrigin;
	/**
	*JRadioButton for {@code Age } in prisoner Form.
	*/
    private JTextField	txtAge;
	/**
	*JRadioButton for {@code Count to Incarcerate } in prisoner Form.
	*/
    private JTextField	txtCountToIncarcerate;
	/**
	*String for {@code First Name } in prisoner Form.
	*/
	private String  firstName;
	/**
	*String for {@code Last Nmae } in prisoner Form.
	*/
	private String	lastName;
	/**
	*String for {@code Sex } in prisoner Form.
	*/
	private String	sex;
	/**
	*String for {@code Age } in prisoner Form.
	*/
	private String	age;
	/**
	*String for {@code Origin } in prisoner Form.
	*/
	private String	origin;
	/**
	*String for {@code Booking Date Complte } in prisoner Form.
	*/
	private String	bookDate;
	/**
	*String for {@code Release Year } in prisoner Form.
	*/
	private String  releaseDate;
	/**
	*String for {@code Crime Discription } in prisoner Form.
	*/
	private String	crimeDescription;
	/**
	*String for {@code Security Class } in prisoner Form.
	*/
	private String	securityClass;
	/**
	*String for {@code Status } in prisoner Form.
	*/
	private String	status;
	/**
	*String for {@code Days Count } in prisoner Form.
	*/
	private String	daysCount;
	/**
	*String for {@code Hieght } in prisoner Form.
	*/
	private String	height;
	/**
	*String for {@code Mugshot Path } in prisoner Form.
	*/
	private String	mugshotPath;
	/**
	*String for {@code Booking Day } in prisoner Form.
	*/
	private String	bookDay;
	/**
	*String for {@code Booking Month } in prisoner Form.
	*/
	private String	bookMonth;
	/**
	*String for {@code Booking Year } in prisoner Form.
	*/
	private String	bookYear;
	/**
	*String for {@code Release Day } in prisoner Form.
	*/
	private String	releaseDay;
	/**
	*String for {@code Release Month } in prisoner Form.
	*/
	private String	releaseMonth;
	/**
	*String for {@code Release Year } in prisoner Form.
	*/
	private String	releaseYear;
	/**
	*JcomboBox for {@code Booking Day } in prisoner Form.
	*/
    private JComboBox  cbxBookDay;
	/**
	*JcomboBox for {@code Booking Month } in prisoner Form.
	*/
    private JComboBox	cbxBookMonth;
	/**
	*JcomboBox for {@code Booking Year } in prisoner Form.
	*/
    private JComboBox	cbxBookYear;
	/**
	*JcomboBox for {@code Select Warden } in prisoner Form.
	*/
    private JComboBox	cbxSelectWarden;
	/**
	*JcomboBox for {@code Release Day } in prisoner Form.
	*/
    private JComboBox	cbxReleaseDay;
	/**
	*JcomboBox for {@code Release Month } in prisoner Form.
	*/
    private JComboBox	cbxReleaseMonth;
	/**
	*JcomboBox for {@code Release Year } in prisoner Form.
	*/
    private JComboBox	cbxReleaseYear;
	/**
	*JcomboBox for {@code Security Class } in prisoner Form.
	*/
    private JComboBox	cbxSecurityClass;
	private JScrollPane scrollCrimeDescription;
	private int id;
	private int	month;
	private int	day;
	private int	year;
	private int	allocatedWardenId;
	private int	allocationStatus;
	private int	holdId;
	static private int count=0;
	private JFileChooser chooser;
	private Calendar calRelease,calToday;
	private ImageIcon mugshot;
	private Connection connect;
	private Statement state;
	private String header;
	private AdminPage adminPage;

    /**
     * Creates new  Prisoner form and add all the components to the form
     */
	public Prisoner(AdminPage adminPage,String str){
		header=str;
		this.adminPage=adminPage;

        pnlComponents = new JPanel();
        pnlPersonalInformation = new JPanel();
        lblFirstName = new JLabel();
        txtFirstName = new JTextField();
        lblLastName = new JLabel();
        txtLastName = new JTextField();
        lblSex = new JLabel();
        rbnMale = new JRadioButton();
        rbnFemale = new JRadioButton();
        lblMugshot = new JLabel();
        lblRace = new JLabel();
        txtAge = new JTextField();
        lblOrigin = new JLabel();
        txtOrigin = new JTextField();
        lblHieght = new JLabel();
        txtHeight = new JTextField();
        btnUploadMugshot = new JButton();
        pnlPrisonalInformation = new JPanel();
        lblId = new JLabel();
        txtId = new JTextField();
        lblBookingDate = new JLabel();
        
        lblReleaseDate = new JLabel();
        lblDaysToIncarcerate = new JLabel();
        txtCountToIncarcerate = new JTextField();
        lblStatus = new JLabel();
        txtStatus = new JTextField();
        lblSecurityClass = new JLabel();
        cbxSecurityClass = new JComboBox();
        lblCrimeDescription = new JLabel();
		lblSelectWarden= new JLabel();
        
        scrollCrimeDescription = new JScrollPane();

        lblHeader = new JLabel();
        pnlButtons = new JPanel();
        btnAdd = new JButton();
        btnUpdate = new JButton();
		btnRelease= new JButton();
        btnDelete = new JButton();
        btnClear = new JButton();
        btnCancel = new JButton();
		gpSex=new ButtonGroup();
        textCrimeDescription = new JTextArea();
        cbxBookDay = new JComboBox();
        cbxBookMonth = new JComboBox();
        cbxBookYear = new JComboBox();
        cbxReleaseDay = new JComboBox();
        cbxReleaseMonth = new JComboBox();
        cbxReleaseYear = new JComboBox();
		cbxSelectWarden= new JComboBox();
		chooser = new JFileChooser();
		calRelease=Calendar.getInstance();
		calToday=Calendar.getInstance();
		   try{Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
	
            connect = DriverManager.getConnection("jdbc:odbc:PMS");
		   System.out.println("Connection established successfully");
            initComponents();
	        loadWarden();
			connect.close();
			loadId();
		   }catch(Exception e){}
	}

    private void initComponents() {
        GridBagConstraints gridBagConstraints;


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(750, 660));

        pnlComponents.setLayout(new GridLayout(2, 1));

        pnlPersonalInformation.setBorder(BorderFactory.createTitledBorder(null, "Personal Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Agency FB", 2, 24), new Color(72, 72, 74))); // NOI18N
        pnlPersonalInformation.setLayout(new GridBagLayout());

        lblFirstName.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblFirstName.setText("First Name");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(lblFirstName, gridBagConstraints);

        txtFirstName.setText("");
        txtFirstName.setPreferredSize(new Dimension(90, 20));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(txtFirstName, gridBagConstraints);

        lblLastName.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblLastName.setText("Last Name");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(lblLastName, gridBagConstraints);

        txtLastName.setText("");
        txtLastName.setPreferredSize(new Dimension(90, 20));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(txtLastName, gridBagConstraints);

        lblSex.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblSex.setText("Sex");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(lblSex, gridBagConstraints);

        rbnMale.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        rbnMale.setText("Male");
        rbnMale.setSelected(true);

		gpSex.add(rbnMale);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(rbnMale, gridBagConstraints);

        rbnFemale.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        rbnFemale.setText("Female");
		gpSex.add(rbnFemale);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.04;
        gridBagConstraints.insets = new Insets(0, 0, 0, 28);
        pnlPersonalInformation.add(rbnFemale, gridBagConstraints);


		lblMugshot.setForeground(new Color(72, 72, 74));
        lblMugshot.setHorizontalAlignment(SwingConstants.CENTER);
        lblMugshot.setText("Upload image here");
        lblMugshot.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(72, 72, 74)));
        lblMugshot.setPreferredSize(new Dimension(150, 150));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.04;
        gridBagConstraints.insets = new Insets(0, 2, 0, 16);
        pnlPersonalInformation.add(lblMugshot, gridBagConstraints);

        lblRace.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblRace.setText("Age");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(lblRace, gridBagConstraints);

        txtAge.setText(" ");
        txtAge.setPreferredSize(new Dimension(90, 20));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.01;
        pnlPersonalInformation.add(txtAge, gridBagConstraints);

        lblOrigin.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblOrigin.setText("Origin");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.04;
        pnlPersonalInformation.add(lblOrigin, gridBagConstraints);

        txtOrigin.setPreferredSize(new Dimension(90, 20));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.01;
        pnlPersonalInformation.add(txtOrigin, gridBagConstraints);

        lblHieght.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblHieght.setHorizontalAlignment(SwingConstants.TRAILING);
        lblHieght.setText("Height");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        pnlPersonalInformation.add(lblHieght, gridBagConstraints);

        txtHeight.setPreferredSize(new Dimension(60, 20));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        pnlPersonalInformation.add(txtHeight, gridBagConstraints);

        btnUploadMugshot.setFont(new Font("Tahoma", 3, 12)); // NOI18N
        btnUploadMugshot.setText("Upload Mugshot");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(5, 0, 0, 23);
        pnlPersonalInformation.add(btnUploadMugshot, gridBagConstraints);
		btnUploadMugshot.addActionListener(this);

		chooser.setCurrentDirectory(new File("."));


        pnlComponents.add(pnlPersonalInformation);

        pnlPrisonalInformation.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prisonal Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 2, 24), new java.awt.Color(72, 72, 74)))); // NOI18N
        pnlPrisonalInformation.setPreferredSize(new java.awt.Dimension(60, 20));
        pnlPrisonalInformation.setLayout(new java.awt.GridBagLayout());

        lblId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblId.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pnlPrisonalInformation.add(lblId, gridBagConstraints);

        txtId.setMinimumSize(new java.awt.Dimension(90, 20));
        txtId.setPreferredSize(new java.awt.Dimension(60, 20));
		txtId.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlPrisonalInformation.add(txtId, gridBagConstraints);

        lblBookingDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblBookingDate.setText("Booking Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pnlPrisonalInformation.add(lblBookingDate, gridBagConstraints);

        lblReleaseDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblReleaseDate.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblReleaseDate.setText("Release Date");
        lblReleaseDate.setPreferredSize(new java.awt.Dimension(80, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        pnlPrisonalInformation.add(lblReleaseDate, gridBagConstraints);

        lblDaysToIncarcerate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDaysToIncarcerate.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDaysToIncarcerate.setText("Day to stay Incarcerate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pnlPrisonalInformation.add(lblDaysToIncarcerate, gridBagConstraints);

        txtCountToIncarcerate.setPreferredSize(new java.awt.Dimension(60, 20));
		txtCountToIncarcerate.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlPrisonalInformation.add(txtCountToIncarcerate, gridBagConstraints);

        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblStatus.setText("Status");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.9;
        gridBagConstraints.weighty = 1.3;
        pnlPrisonalInformation.add(lblStatus, gridBagConstraints);

        txtStatus.setPreferredSize(new java.awt.Dimension(90, 20));
		txtStatus.setEditable(false);
		txtStatus.setText("Incarcerated");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.2;
        pnlPrisonalInformation.add(txtStatus, gridBagConstraints);

        lblSecurityClass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSecurityClass.setText("Security Class");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 1.2;
        pnlPrisonalInformation.add(lblSecurityClass, gridBagConstraints);

		cbxSecurityClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low Risk", "High Risk" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.2;
        pnlPrisonalInformation.add(cbxSecurityClass, gridBagConstraints);

        lblCrimeDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCrimeDescription.setText("Crime Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weighty = 1.2;
        pnlPrisonalInformation.add(lblCrimeDescription, gridBagConstraints);

        scrollCrimeDescription.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollCrimeDescription.setAutoscrolls(true);
        scrollCrimeDescription.setHorizontalScrollBar(null);
        scrollCrimeDescription.setPreferredSize(new java.awt.Dimension(250, 80));

        textCrimeDescription.setColumns(20);
        textCrimeDescription.setRows(5);
        scrollCrimeDescription.setViewportView(textCrimeDescription);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        pnlPrisonalInformation.add(scrollCrimeDescription, gridBagConstraints);

        cbxBookDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        pnlPrisonalInformation.add(cbxBookDay, gridBagConstraints);

        cbxBookMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Month", "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        pnlPrisonalInformation.add(cbxBookMonth, gridBagConstraints);

        cbxBookYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Year", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        pnlPrisonalInformation.add(cbxBookYear, gridBagConstraints);

        cbxReleaseDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        pnlPrisonalInformation.add(cbxReleaseDay, gridBagConstraints);

        cbxReleaseMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Month", "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        pnlPrisonalInformation.add(cbxReleaseMonth, gridBagConstraints);

        cbxReleaseYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Year", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        pnlPrisonalInformation.add(cbxReleaseYear, gridBagConstraints);

		lblSelectWarden.setText("Select Warden");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        pnlPrisonalInformation.add(lblSelectWarden, gridBagConstraints);

        cbxSelectWarden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Warden ID" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        pnlPrisonalInformation.add(cbxSelectWarden, gridBagConstraints);


        pnlComponents.add(pnlPrisonalInformation);

        getContentPane().add(pnlComponents, java.awt.BorderLayout.CENTER);
        lblHeader.setFont(new Font("Tahoma", 3, 24)); // NOI18N
        lblHeader.setForeground(new Color(72, 72, 74));
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setText(header);
        lblHeader.setAlignmentY(5.0F);
        lblHeader.setPreferredSize(new Dimension(500, 100));
        getContentPane().add(lblHeader, BorderLayout.NORTH);

        pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

        btnAdd.setText("Submit");
		btnAdd.addActionListener(this);
        pnlButtons.add(btnAdd);

        btnUpdate.setText("Update");
        pnlButtons.add(btnUpdate);
		btnUpdate.addActionListener(this);
		btnUpdate.setEnabled(false);

		btnRelease.setText("Release");
        pnlButtons.add(btnRelease);
		btnRelease.addActionListener(this);
		btnRelease.setEnabled(false);

        btnDelete.setText("Delete");
        pnlButtons.add(btnDelete);
		btnDelete.addActionListener(this);
		btnDelete.setEnabled(false);

        btnClear.setText("Clear");
		btnClear.addActionListener(this);
        pnlButtons.add(btnClear);

        btnCancel.setText("Cancel");
		btnCancel.addActionListener(this);
        pnlButtons.add(btnCancel);

        getContentPane().add(pnlButtons, BorderLayout.PAGE_END);

        pack();
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
    }
	/**
	* method that works is called internally when any Button is pressed
	* and then it call method asociated with button pressed.
	*/ 
	  public void actionPerformed(ActionEvent e){
          firstName=txtFirstName.getText();
          lastName=txtLastName.getText();
		  if (rbnMale.isSelected())
		  {
			  sex=rbnMale.getText();
		  }
		  else 
		  sex=rbnFemale.getText();
		  origin=txtOrigin.getText();
		  age=txtAge.getText();
		  height=txtHeight.getText();
		  status=txtStatus.getText();	
		  securityClass=(String)cbxSecurityClass.getSelectedItem();
		   crimeDescription=textCrimeDescription.getText();
		   bookDate=cbxBookDay.getSelectedItem()+"/"+cbxBookMonth.getSelectedItem()+"/"+cbxBookYear.getSelectedItem();
		   releaseDate=(String)cbxReleaseDay.getSelectedItem()+"/"+(String)cbxReleaseMonth.getSelectedItem()+"/"+(String)cbxReleaseYear.getSelectedItem();
		 if(cbxSelectWarden.getSelectedIndex()!=0)
           allocatedWardenId=Integer.parseInt(((String)cbxSelectWarden.getSelectedItem()).substring(0,2));
			boolean flag=true;
		   if(e.getSource()==btnUploadMugshot){
			   uploadMugshot();
			}
		   if (e.getSource()==btnClear){
			   clear();
			   flag=false;
		   }
		   if(e.getSource()==btnCancel){
			   cancel();
			   flag=false;
		   }		   
				if(e.getSource()==btnAdd&& checkFieldValidation()){
					int check=JOptionPane.showConfirmDialog(null,"Are you sure to Add the Prisoner", "Confirmation Dialogue", JOptionPane.YES_NO_OPTION);
					if(check==0)
						add(); 
				}
				if (e.getSource()==btnUpdate&& checkFieldValidation()){
					int check=JOptionPane.showConfirmDialog(null,"Are you sure to Update the Prisoner's Details", "Confirmation Dialogue", JOptionPane.YES_NO_OPTION);
					if(check==0)
					update();
				}
				if(e.getSource()==btnDelete){
					int check=JOptionPane.showConfirmDialog(null,"Are you sure to Delete the Prisoner", "Confirmation Dialogue", JOptionPane.YES_NO_OPTION);
					if(check==0)
				   delete();
				}
				if (e.getSource()==btnRelease){
					int check=JOptionPane.showConfirmDialog(null,"Are you sure to release the Prisoner", "Confirmation Dialogue", JOptionPane.YES_NO_OPTION);
					if(check==0)
					release();	
				}
      }

	  private void add(){
        try{
			status="Incarcerated";
			securityClass=(String)cbxSecurityClass.getSelectedItem();
           Connection connect = DriverManager.getConnection("jdbc:odbc:PMS");
		   System.out.println("Connection established successfully in add() method at Prisoner Page");  
           Statement state = connect.createStatement();
           String sql = "insert into Prisoner_Details (First_Name,Last_Name,Sex,Age,Origin,Height,Status,Security_Class,Book_Date,Release_Date,Crime_Description,Mugshot,Allocated_Warden_Id) values ('" + firstName + "','" + lastName + "','" + sex + "','" + age + "','" + origin + "','" + height + "','" + status + "','" + securityClass + "','" + bookDate + "','" + releaseDate + "','" + crimeDescription + "','" + mugshotPath + "','" + allocatedWardenId + "')";
           state.execute(sql);
		   JOptionPane.showMessageDialog(null, "Prisoner added Successfully ");

		   sql = "select * from Warden_Details where ID= "+ allocatedWardenId +"";
           ResultSet rs=state.executeQuery(sql);
		   if(rs.next()){
		   int allocationStatus=rs.getInt("Allocation_Status");
		   allocationStatus++;
		   sql = "UPDATE Warden_Details set Allocation_Status= '" + allocationStatus + "' WHERE ID= "+allocatedWardenId+"";           
		   state.executeUpdate(sql);
		   System.out.println("Statement executed successfully ");
		   }
           state.close();
           connect.close();
		}
        catch (SQLException e) {
			System.out.println("Exception in add method at prisoner page"+e);

        }
		clear();
		dispose();
		adminPage.setVisible(true);
      }
	  private void update(){
			id=Integer.parseInt(txtId.getText());
        try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully in update() at prisoner");

           Connection connect = DriverManager.getConnection("jdbc:odbc:PMS");
		   System.out.println("Connection established successfully in update of prisoner");
           Statement state = connect.createStatement();                                                                                                                                                                                                                                                                                                             
           String sql = "UPDATE Prisoner_Details set First_Name= '" + firstName + "', Last_Name= '" + lastName + "', Sex= '" + sex + "', Age= '" + age + "', Origin= '" + origin + "', Height= '" + height + "', Status= '" + status + "', Security_Class= '" + securityClass + "',Book_Date= '" + bookDate + "', Release_Date= '" + releaseDate + "', Days_Count= '" + daysCount + "', Crime_Description= '" + crimeDescription + "', Mugshot= '" + mugshotPath + "' WHERE ID= "+id+"";           
		   state.executeUpdate(sql);
		   JOptionPane.showMessageDialog(null, "Record Updated Successfully");
		   System.out.println("Statement executed successfully of update at prisoner");
           state.close();
           connect.close();
		}
        catch (Exception e) {
			System.out.println("Exception in update method at Prisoner page"+e);
        }
		clear();
		dispose();
		adminPage.setVisible(true);
      }
    public void find(ResultSet rs){
		adminPage.setVisible(false);
	   btnAdd.setEnabled(false);

	   btnDelete.setEnabled(true);
	   btnUpdate.setEnabled(true);
	   try{
		txtId.setText(rs.getString("ID"));
		txtFirstName.setText(rs.getString("First_Name"));
		txtHeight.setText(rs.getString("Height"));
		lblMugshot.setText(null);
		lblMugshot.setIcon(new ImageIcon((String)rs.getObject("Mugshot")));
		
		txtLastName.setText(rs.getString("Last_Name"));
		txtOrigin.setText(rs.getString("Origin"));
		txtAge.setText(rs.getString("Age"));
		cbxSecurityClass.setSelectedItem(rs.getString("Security_Class"));

		txtStatus.setText(rs.getString("Status"));
		bookDate=rs.getString("Book_Date");
		releaseDate=rs.getString("Release_Date");
		if(bookDate.length()>6){
		bookDay=bookDate.substring(0,2);
		bookMonth=bookDate.substring(3,bookDate.length()-5);
		bookYear=bookDate.substring(bookDate.length()-4,bookDate.length());
		releaseDay=releaseDate.substring(0,2);
		releaseMonth=releaseDate.substring(3,releaseDate.length()-5);
		releaseYear=releaseDate.substring(releaseDate.length()-4,releaseDate.length());
		}
		textCrimeDescription.setText(rs.getString("Crime_Description"));
		cbxBookDay.setSelectedItem(bookDay);
		cbxBookMonth.setSelectedItem(bookMonth);
		cbxBookYear.setSelectedItem(bookYear);
		cbxReleaseDay.setSelectedItem(releaseDay);

		cbxReleaseMonth.setSelectedItem(releaseMonth);

		cbxReleaseYear.setSelectedItem(releaseYear);

		int hold=(int)countIncarcerateDays();
		 txtCountToIncarcerate.setText(""+hold+"");
		  holdId=rs.getInt("Allocated_Warden_Id");
		 rs.close();

		 connect = DriverManager.getConnection("jdbc:odbc:PMS");
		 state=connect.createStatement();
		 String sql="select * from Warden_Details where ID= "+ holdId +"";
		 ResultSet wd=state.executeQuery(sql);
		 if(wd.next())
		 cbxSelectWarden.setSelectedItem(""+holdId+" "+"Rank-"+wd.getString("Rank"));
		 if (hold<7)		 
			btnRelease.setEnabled(true);
	   }catch (Exception e) {
			System.out.println("Exception in find method at prisoner page"+e); 
			adminPage.setVisible(true);
		}
		setVisible(true);	
	}

	private void delete(){
		status="Deleted";
	    id=Integer.parseInt(txtId.getText());
        try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully in delete at prisoner");		   
           Connection connect = DriverManager.getConnection("jdbc:odbc:PMS");
		   System.out.println("Connection established successfull in delete at prisoner");
           Statement state = connect.createStatement();
           String sql = "UPDATE Prisoner_Details set Status= '"+ "Deleted" +"' WHERE ID= "+ id +"";
           state.execute(sql);
		   JOptionPane.showMessageDialog(null, "Record deleted Successfully");
		   System.out.println("Statement executed successfully in delete at Prisoner");
		   sql = "select * from Warden_Details where ID= "+ allocatedWardenId +"";
           ResultSet rs=state.executeQuery(sql);
		   if(rs.next()){
		   int allocationStatus=rs.getInt("Allocation_Status");
		   allocationStatus--;
		   sql = "UPDATE Warden_Details set Allocation_Status= '" + allocationStatus + "' WHERE ID= "+allocatedWardenId+"";           
		   state.executeUpdate(sql);
		   System.out.println("Statement executed successfully ");
           state.close();
           connect.close();
			clear();
			dispose();
			adminPage.setVisible(true);
		   }
		}
        catch (Exception e) {
			System.out.println("Exception in add method at prisoner page"+e);
			}
		dispose();
		adminPage.setVisible(true);
      }
	private void clear(){

		txtId.setText("");
		txtFirstName.setText("");
		txtHeight.setText("");		
		txtLastName.setText("");
		txtOrigin.setText("");
		txtAge.setText("");
		txtCountToIncarcerate.setText("");
		txtStatus.setText("");
		textCrimeDescription.setText("");
		cbxBookDay.setSelectedIndex(0);
		cbxBookMonth.setSelectedIndex(0);
		cbxBookYear.setSelectedIndex(0);
		cbxReleaseDay.setSelectedIndex(0);
		cbxReleaseMonth.setSelectedIndex(0);
		cbxReleaseYear.setSelectedIndex(0);
		lblMugshot.setIcon(null);
		lblMugshot.setText("Upload Mugshot here");
		cbxSelectWarden.setSelectedIndex(0);

	  }
	private void uploadMugshot(){
            try{
					int result = chooser.showOpenDialog(null);
               if (result == JFileChooser.APPROVE_OPTION){
                mugshotPath = chooser.getSelectedFile().getPath();    
				lblMugshot.setText(null);
				lblMugshot.setIcon(new ImageIcon(mugshotPath));
			   }
			}catch(Exception e){
				System.out.println("Exception in uploadMugshot method at Admin page"+e);
			}				
    }
	private void cancel(){
		adminPage.setVisible(true);
		this.dispose();
	}
	private void release(){
		status="Released";
	    id=Integer.parseInt(txtId.getText());
        try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
		   
           Connection connect = DriverManager.getConnection("jdbc:odbc:PMS");
		   System.out.println("Connection established successfully in find() at prisoner");
           Statement state = connect.createStatement();
           String sql = "UPDATE Prisoner_Details set Status= '"+ "Relesed" +"' WHERE ID= "+ id +"";
           state.execute(sql);
		   JOptionPane.showMessageDialog(null, "prisoner released Successfully ");
		   System.out.println("Statement executed successfully of find() at prisoner");
           state.close();
           connect.close();
			clear();
			dispose();
			adminPage.setVisible(true);
		}
        catch (Exception e) {
 			System.out.println("Exception in find() method at prisoner page"+e);
			dispose();
        }
      }
	  private void loadWarden(){
		int count=1;
		try{
		  Statement  stmt = connect.createStatement();
		  ResultSet rsWarden = stmt.executeQuery("Select * from Warden_Details where Status= '" + "Working" + "'");
		  System.out.println("statement executed in loadwarden at prisoner");
		  while(rsWarden.next()){			  
			if(rsWarden.getInt("Allocation_Status")<5){
			cbxSelectWarden.insertItemAt(rsWarden.getString("ID")+" "+"Rank-"+rsWarden.getString("Rank"),count);
			count++;
				}
			}
			System.out.println("statement finish execution in loadwarden at prisoner");

	  	stmt.close();
        connect.close();
	  }catch(Exception e){
	  		System.out.println("Exception in loadWarden method at prisoner page"+e);
		}
	  }
	  private boolean checkFieldValidation(){
		  boolean flag=false;
		  if(txtFirstName.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Fill the First Name field");
		  else if(txtLastName.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Fill the Last Name Field");
		  else if(txtAge.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Fill the Age Field");
		  else if(txtOrigin.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Fill the Origin Field");
		  else if(txtHeight.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Fill the Height Field");
		  else if(textCrimeDescription.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Fill the Crime Discription Field");
		  else if(cbxBookDay.getSelectedIndex()==0 ||  cbxBookMonth.getSelectedIndex()==0 || cbxBookYear.getSelectedIndex()==0)
			JOptionPane.showMessageDialog(null, "Please Selecte the All feilds of Booking Date Coulmn");
		  else if(cbxReleaseDay.getSelectedIndex()==0 ||cbxReleaseMonth.getSelectedIndex()==0 ||cbxReleaseYear.getSelectedIndex()==0)
			JOptionPane.showMessageDialog(null, "Please Selecte the All feilds of Release Date Coulmn");
		  else if(cbxSelectWarden.getSelectedIndex()==0)
			JOptionPane.showMessageDialog(null, "Please Selecte a warden from Select Warden Coulmn");
		  else if (mugshotPath=="")
			JOptionPane.showMessageDialog(null, "Please Selecte a mugshot from Upload Mugshot Coulmn");
		  else if(checkDateValidation())
			  return true;		

		  return flag;
	  }
	  double countIncarcerateDays(){
		int day,month,year;
		day=cbxReleaseDay.getSelectedIndex();
		month=cbxReleaseMonth.getSelectedIndex();
		year=Integer.parseInt((String)cbxReleaseYear.getSelectedItem());
	    Calendar dt1= Calendar.getInstance();
		Calendar dt2= Calendar.getInstance();
		dt2.set(year,month,day);
		double count1=dt2.getTimeInMillis(),count2=dt1.getTimeInMillis(),count;
		count1=count1/1000/60/60/24;
		count2=count2/1000/60/60/24;
		count=(int)count1-count2;
		return count;
		}
	boolean checkDateValidation(){
		boolean flag=false;
		if( cbxBookDay.getSelectedIndex()==31&&(cbxBookMonth.getSelectedIndex()==4 ||cbxBookMonth.getSelectedIndex()==6 ||cbxBookMonth.getSelectedIndex()==9 ||cbxBookMonth.getSelectedIndex()==11) )
            JOptionPane.showMessageDialog(null, "Selected Booking Date is an Invalid Date.Please Select day less then 31");
		else if(cbxBookMonth.getSelectedIndex()==2){
			int year=Integer.parseInt((String)cbxBookYear.getSelectedItem());
			if(year%4==0&&cbxBookDay.getSelectedIndex()>29)
			JOptionPane.showMessageDialog(null, "Selected Booking Date is an Invalid Date.Please Select day less then 29");
			else if(!(year%4==0)&&cbxBookDay.getSelectedIndex()>28)
				JOptionPane.showMessageDialog(null, "Selected Booking Date is an Invalid Date.Please Select day less then 28");
			else
				flag=true;		
		}
		else if( cbxReleaseDay.getSelectedIndex()==31&&(cbxReleaseMonth.getSelectedIndex()==4 ||cbxReleaseMonth.getSelectedIndex()==6 ||cbxReleaseMonth.getSelectedIndex()==9 ||cbxReleaseMonth.getSelectedIndex()==11) )
            JOptionPane.showMessageDialog(null, "Selected Release Date is an Invalid Date.Please Select day less then 31");
		else if(cbxReleaseMonth.getSelectedIndex()==2){
			int year=Integer.parseInt((String)cbxReleaseYear.getSelectedItem());
			if(year%4==0 && cbxReleaseDay.getSelectedIndex()>29)
			JOptionPane.showMessageDialog(null, "Selected Release Date is an Invalid Date.Please Select day less then 29");
			else if(!(year%4==0)&&cbxReleaseDay.getSelectedIndex()>28)
				JOptionPane.showMessageDialog(null, "Selected Release Date is an Invalid Date.Please Select day less then 28");
			else
				flag=true;
		}
		else
			flag=true;
		return flag;
	}
	private void loadId(){
		try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
           Connection connect = DriverManager.getConnection("jdbc:odbc:PMS");
		   System.out.println("Connection established successfully in loadId() at Prisoner");
           Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);
		   	String sql = "select ID from Prisoner_Details ";
            ResultSet rs=state.executeQuery(sql);
					int count=0;

				if(rs.last()){
					System.out.println("here check the last");
				int hold=Integer.parseInt(rs.getString("ID"));
				hold++;
				txtId.setText(hold+"");				
		    }					
		   System.out.println("Statement executed successfully at loadID() at prisoner");  
           state.close();
           connect.close();
		}catch (Exception e) {
			System.out.println("Exception in loadID method at prisoner page"+e);    
		}	
	}	
}			