import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GradeAnalyzer extends JFrame {

	private JFrame frmGradeLabInitial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeAnalyzer window = new GradeAnalyzer();
					window.frmGradeLabInitial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GradeAnalyzer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGradeLabInitial = new JFrame();
		frmGradeLabInitial.setBounds(100, 100, 450, 83);
		frmGradeLabInitial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGradeLabInitial.setTitle("Grade Analyzer");
		
		JButton btnGradeAnalyzer = new JButton("Grade Analyzer");
		btnGradeAnalyzer.setBounds(0, 0, 450, 29);
		btnGradeAnalyzer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frmGradeLabInitial.setVisible(false);
				GradeStatistics gradeAnalyzer = new GradeStatistics();
				gradeAnalyzer.frmGradeAnalyzer.setVisible(true);
			}
		});
		frmGradeLabInitial.getContentPane().setLayout(null);
		frmGradeLabInitial.getContentPane().add(btnGradeAnalyzer);
		
		JButton btnGpaCalculator = new JButton("GPA Calculator");
		btnGpaCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GPACalculator gpaCalculator = new GPACalculator();
				gpaCalculator.frmGPACalculator.setVisible(true);
			}
		});
		btnGpaCalculator.setBounds(0, 30, 450, 29);
		frmGradeLabInitial.getContentPane().add(btnGpaCalculator);
	}

}


//Here is how I did it...
//In my main GUI here is one of the actionListeners...
//frmGradeAnalyzer.dispose();
//				//launch the new form
//				GPAGradeAnalyzer gpaFrame = new GPAGradeAnalyzer();
//				gpaFrame.setVisible(true);
//
//and ...
//
//public class GPAGradeAnalyzer extends JFrame {


