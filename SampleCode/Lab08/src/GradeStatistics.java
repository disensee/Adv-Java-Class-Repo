import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class GradeStatistics extends JFrame {

	JFrame frmGradeAnalyzer;
	private JTextField txtEarnedPoints;
	private JTextField txtAvailablePoints;
	private JList lstGrades;
	private JPanel pnGradeSummary;
	private ArrayList<Grade> gradeList = new ArrayList<Grade>();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GradeAnalyzerGUI window = new GradeAnalyzerGUI();
//					window.frmGradeAnalyzer.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public GradeStatistics() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGradeAnalyzer = new JFrame();
		frmGradeAnalyzer.setBounds(100, 100, 350, 280);
		frmGradeAnalyzer.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmGradeAnalyzer.getContentPane().setLayout(null);
		frmGradeAnalyzer.setTitle("Grade Analyzer");
		
		JLabel lblEnterGrade = new JLabel("Enter Grade:");
		lblEnterGrade.setBounds(6, 16, 76, 16);
		frmGradeAnalyzer.getContentPane().add(lblEnterGrade);
		
		txtEarnedPoints = new JTextField();
		txtEarnedPoints.setBounds(85, 11, 66, 26);
		frmGradeAnalyzer.getContentPane().add(txtEarnedPoints);
		txtEarnedPoints.setColumns(10);
		
		JLabel lblOutOf = new JLabel("out of");
		lblOutOf.setBounds(152, 16, 43, 16);
		frmGradeAnalyzer.getContentPane().add(lblOutOf);
		
		txtAvailablePoints = new JTextField();
		txtAvailablePoints.setColumns(10);
		txtAvailablePoints.setBounds(193, 11, 66, 26);
		frmGradeAnalyzer.getContentPane().add(txtAvailablePoints);
		
		JLabel lblAvailablePoints = new JLabel("points");
		lblAvailablePoints.setBounds(261, 16, 43, 16);
		frmGradeAnalyzer.getContentPane().add(lblAvailablePoints);
		
		JButton btnAddGrade = new JButton("Add Grade");
		btnAddGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInputToList();
			}
		});
		btnAddGrade.setBounds(6, 49, 145, 29);
		frmGradeAnalyzer.getContentPane().add(btnAddGrade);
		
		JButton btnClearGrades = new JButton("Clear Grades");
		btnClearGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gradeList.clear();
				lstGrades.setListData(gradeList.toArray());
				pnGradeSummary.removeAll();
				pnGradeSummary.repaint();
				txtEarnedPoints.grabFocus();
			}
		});
		btnClearGrades.setBounds(159, 49, 145, 29);
		frmGradeAnalyzer.getContentPane().add(btnClearGrades);
		
		JLabel lblGradesEarned = new JLabel("Grades Earned:");
		lblGradesEarned.setBounds(6, 90, 93, 16);
		frmGradeAnalyzer.getContentPane().add(lblGradesEarned);
		
		JLabel lblGradeSummary = new JLabel("Grade Summary:");
		lblGradeSummary.setBounds(159, 90, 107, 16);
		frmGradeAnalyzer.getContentPane().add(lblGradeSummary);
		
		JScrollPane scrlPnGrades = new JScrollPane();
		scrlPnGrades.setBounds(6, 118, 145, 131);
		frmGradeAnalyzer.getContentPane().add(scrlPnGrades);
		
		lstGrades = new JList();
		scrlPnGrades.setViewportView(lstGrades);
		
		pnGradeSummary = new JPanel();
		pnGradeSummary.setBackground(Color.WHITE);
		pnGradeSummary.setBounds(159, 118, 185, 131);
		frmGradeAnalyzer.getContentPane().add(pnGradeSummary);
		pnGradeSummary.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
	}
	
	private void addInputToList() {
		try {
			int earnedPoints = Integer.parseInt(txtEarnedPoints.getText());
			int availablePoints = Integer.parseInt(txtAvailablePoints.getText());
			
			if(earnedPoints < 0 || availablePoints <= 0) {
				txtEarnedPoints.grabFocus();
				throw new GradeException("Point values must be a positive integer value.");
			}
			
			if(availablePoints < earnedPoints) {
				txtAvailablePoints.grabFocus();
				throw new GradeException("Extra credit is not allowed.");
			}
			
			refreshList(new Grade(earnedPoints, availablePoints));
			generateGradeSummary();
			
			txtEarnedPoints.setText("");
			txtAvailablePoints.setText("");
			
			txtEarnedPoints.grabFocus();
			
		}
		catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Point values must be a positive integer.");
		}
		catch (GradeException ge) {
			JOptionPane.showMessageDialog(null, ge.getMessage());
		}
		
	}
	
	private void refreshList(Grade grade) {
		gradeList.add(grade);
		
		lstGrades.setListData(gradeList.toArray());
		lstGrades.setVisibleRowCount(gradeList.size());
		DefaultListCellRenderer renderer = (DefaultListCellRenderer)lstGrades.getCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
	}
	
	private void generateGradeSummary() {		
		Grade avgGrade = new Grade(gradeList.get(0).getEarnedPoints(), gradeList.get(0).getAvailablePoints());
		Grade minGrade = new Grade(gradeList.get(0).getEarnedPoints(), gradeList.get(0).getAvailablePoints());
		Grade maxGrade = new Grade(gradeList.get(0).getEarnedPoints(), gradeList.get(0).getAvailablePoints());
		
		int totalEarnedPoints = 0;
		int totalAvailablePoints = 0;
		
		for(int i = 0; i < gradeList.size(); i++) {
			
			
			totalEarnedPoints += gradeList.get(i).getEarnedPoints();
			totalAvailablePoints += gradeList.get(i).getAvailablePoints();
			
			if(gradeList.get(i).getPercentage() < minGrade.getPercentage()) {
				minGrade = gradeList.get(i);
			}
			
			if(gradeList.get(i).getPercentage() > maxGrade.getPercentage()) {
				maxGrade = gradeList.get(i);
			}
		}

		avgGrade.setGrade(totalEarnedPoints, totalAvailablePoints);
		
		pnGradeSummary.removeAll();
		
		JLabel lblAvg = new JLabel();
		lblAvg.setText(String.format("Average Grade: %.2f%%", avgGrade.getPercentage()));
		pnGradeSummary.add(lblAvg);
		lblAvg.setAlignmentX(LEFT_ALIGNMENT);
		
		JLabel lblMax = new JLabel();
		lblMax.setText(String.format("Max Grade: %.2f%%", maxGrade.getPercentage()));
		pnGradeSummary.add(lblMax);
		lblMax.setAlignmentX(LEFT_ALIGNMENT);
		
		JLabel lblMin = new JLabel();
		lblMin.setText(String.format("Min Grade: %.2f%%", minGrade.getPercentage()));
		pnGradeSummary.add(lblMin);
		
		pnGradeSummary.revalidate();
		pnGradeSummary.repaint();
	}
}
