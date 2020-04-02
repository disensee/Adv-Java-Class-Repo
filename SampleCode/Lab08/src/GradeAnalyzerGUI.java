import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Color;

public class GradeAnalyzerGUI extends JFrame {

	JFrame frmGradeAnalyzer;
	private JTextField txtEarnedPoints;
	private JTextField txtAvailablePoints;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeAnalyzerGUI window = new GradeAnalyzerGUI();
					window.frmGradeAnalyzer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GradeAnalyzerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGradeAnalyzer = new JFrame();
		frmGradeAnalyzer.setBounds(100, 100, 350, 280);
		frmGradeAnalyzer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGradeAnalyzer.getContentPane().setLayout(null);
		
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
		btnAddGrade.setBounds(6, 49, 145, 29);
		frmGradeAnalyzer.getContentPane().add(btnAddGrade);
		
		JButton btnClearGrades = new JButton("Clear Grades");
		btnClearGrades.setBounds(159, 49, 145, 29);
		frmGradeAnalyzer.getContentPane().add(btnClearGrades);
		
		JLabel lblGradesEarned = new JLabel("Grades Earned:");
		lblGradesEarned.setBounds(6, 90, 93, 16);
		frmGradeAnalyzer.getContentPane().add(lblGradesEarned);
		
		JLabel lblGradeSummary = new JLabel("Grade Summary:");
		lblGradeSummary.setBounds(159, 90, 107, 16);
		frmGradeAnalyzer.getContentPane().add(lblGradeSummary);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 118, 145, 131);
		frmGradeAnalyzer.getContentPane().add(scrollPane);
		
		JPanel pnGradeSummary = new JPanel();
		pnGradeSummary.setBackground(Color.WHITE);
		pnGradeSummary.setBounds(159, 118, 185, 131);
		frmGradeAnalyzer.getContentPane().add(pnGradeSummary);
		
		setLocationRelativeTo(null);
	}

}
