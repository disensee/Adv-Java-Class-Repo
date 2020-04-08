import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class GPACalculator {

	JFrame frmGPACalculator;
	private JTextField txtCourseId;
	private JTextField txtCredits;
	private JComboBox cbGradeEarned;
	private JList lstGradesEntered;
	private HashMap<Integer, ClassGrade> classGradeMap = new HashMap<Integer, ClassGrade>();
	private HashMap<String, Double> gradeEarnedMap = new HashMap<String, Double>();
	private Integer key = 1;
	private JTextField txtCumulativeGpa;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GPACalculator window = new GPACalculator();
//					window.frmGPACalculator.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public GPACalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGPACalculator = new JFrame();
		frmGPACalculator.setBounds(100, 100, 393, 405);
		frmGPACalculator.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmGPACalculator.getContentPane().setLayout(null);
		
		JLabel lblCourseId = new JLabel("Course Id:");
		lblCourseId.setBounds(16, 16, 64, 16);
		frmGPACalculator.getContentPane().add(lblCourseId);
		
		txtCourseId = new JTextField();
		lblCourseId.setLabelFor(txtCourseId);
		txtCourseId.setBounds(138, 11, 90, 26);
		frmGPACalculator.getContentPane().add(txtCourseId);
		txtCourseId.setColumns(10);
		
		JLabel lblCredits = new JLabel("Credits:");
		lblCredits.setBounds(16, 49, 49, 16);
		frmGPACalculator.getContentPane().add(lblCredits);
		
		txtCredits = new JTextField();
		lblCredits.setLabelFor(txtCredits);
		txtCredits.setBounds(138, 44, 90, 26);
		frmGPACalculator.getContentPane().add(txtCredits);
		txtCredits.setColumns(10);
		
		JLabel lblGradeEarned = new JLabel("Grade Earned:");
		lblGradeEarned.setBounds(16, 86, 86, 16);
		frmGPACalculator.getContentPane().add(lblGradeEarned);
		
		
		gradeEarnedMap.put("A", 4.00);
		gradeEarnedMap.put("A/B", 3.50);
		gradeEarnedMap.put("B", 3.00);
		gradeEarnedMap.put("B/C", 2.50);
		gradeEarnedMap.put("C", 2.00);
		gradeEarnedMap.put("D", 1.00);
		gradeEarnedMap.put("F", 0.00);
		
		cbGradeEarned = new JComboBox();
		cbGradeEarned.setModel(new DefaultComboBoxModel(new String[] {"A","A/B","B","B/C","C","D","F"}));
		lblGradeEarned.setLabelFor(cbGradeEarned);
		cbGradeEarned.setBounds(138, 82, 90, 27);
		frmGPACalculator.getContentPane().add(cbGradeEarned);
		
		JButton btnAddGrade = new JButton("Add Grade");
		btnAddGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enterGrade();
			}
		});
		btnAddGrade.setBounds(16, 121, 100, 29);
		frmGPACalculator.getContentPane().add(btnAddGrade);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classGradeMap.clear();
				lstGradesEntered.setListData(classGradeMap.values().toArray());
				txtCourseId.grabFocus();
			}
		});
		btnClear.setBounds(128, 121, 100, 29);
		frmGPACalculator.getContentPane().add(btnClear);
		
		JLabel lblCumulativeGPA = new JLabel("Cumulative GPA:");
		lblCumulativeGPA.setBounds(16, 174, 110, 16);
		frmGPACalculator.getContentPane().add(lblCumulativeGPA);
		
		JLabel lblGradesEntered = new JLabel("Grades Entered:");
		lblGradesEntered.setBounds(16, 202, 100, 16);
		frmGPACalculator.getContentPane().add(lblGradesEntered);
		
		JLabel lblGradeScale = new JLabel("Grade Scale:");
		lblGradeScale.setBounds(277, 9, 76, 16);
		frmGPACalculator.getContentPane().add(lblGradeScale);
		
		JPanel pnGradeScale = new JPanel();
		pnGradeScale.setBackground(Color.WHITE);
		pnGradeScale.setBounds(277, 31, 100, 159);
		frmGPACalculator.getContentPane().add(pnGradeScale);
		pnGradeScale.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblCreditA = new JLabel("4.00   A");
		pnGradeScale.add(lblCreditA);
		
		JLabel lblCreditAB = new JLabel("3.50   A/B");
		pnGradeScale.add(lblCreditAB);
		
		JLabel lblCreditB = new JLabel("3.00   B");
		pnGradeScale.add(lblCreditB);
		
		JLabel lblCreditBC = new JLabel("2.50   B/C");
		pnGradeScale.add(lblCreditBC);
		
		JLabel lblCreditC = new JLabel("2.00   C");
		pnGradeScale.add(lblCreditC);
		
		JLabel lblCreditD = new JLabel("1.00   D");
		pnGradeScale.add(lblCreditD);
		
		JLabel lblCreditF = new JLabel("0.00   F");
		pnGradeScale.add(lblCreditF);
		
		JScrollPane scrlPnGradesEntered = new JScrollPane();
		lblGradesEntered.setLabelFor(scrlPnGradesEntered);
		scrlPnGradesEntered.setBounds(16, 230, 361, 136);
		frmGPACalculator.getContentPane().add(scrlPnGradesEntered);
		
		lstGradesEntered = new JList();
		scrlPnGradesEntered.setRowHeaderView(lstGradesEntered);
		
		txtCumulativeGpa = new JTextField();
		txtCumulativeGpa.setBackground(SystemColor.window);
		txtCumulativeGpa.setEditable(false);
		txtCumulativeGpa.setBounds(138, 169, 90, 26);
		frmGPACalculator.getContentPane().add(txtCumulativeGpa);
		txtCumulativeGpa.setColumns(10);
		
	}
	
	public void enterGrade() {
		try {
			String classId = txtCourseId.getText();
			int credits = Integer.parseInt(txtCredits.getText());
			double gradeEarned = gradeEarnedMap.get(cbGradeEarned.getSelectedItem());
			
			if(classId.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "Please enter a course ID.");
			}
			
			if(credits < 0) {
				throw new NumberFormatException();
			}
			
			ClassGrade classGrade = new ClassGrade(classId, credits, gradeEarned);
			refreshList(classGrade);
			
			calculateGpa();
			
			txtCourseId.setText("");
			txtCredits.setText("");
			cbGradeEarned.setSelectedIndex(0);
			
			txtCourseId.grabFocus();

		}
		catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Credits must be a positive integer.");
		}
	}
	
	private void refreshList(ClassGrade classGrade) {
		classGradeMap.put(key, classGrade);
		
		key++;
		
		lstGradesEntered.setListData(classGradeMap.values().toArray());
		lstGradesEntered.setVisibleRowCount(classGradeMap.size());
		DefaultListCellRenderer renderer = (DefaultListCellRenderer)lstGradesEntered.getCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);	
	}
	
	public void calculateGpa() {
		int credits = 0;
		double gradePoints = 0;
		for(ClassGrade cg : classGradeMap.values()) {
			credits += cg.getCredits();
			gradePoints += cg.getGradePoints();
		}
		
		txtCumulativeGpa.setText(String.format("%.2f", (gradePoints/credits)));
	}
	
}
