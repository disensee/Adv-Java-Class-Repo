import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JFrame frmGradeLabInitial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
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
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Grade Analyzer");
		frmGradeLabInitial = new JFrame();
		frmGradeLabInitial.setBounds(100, 100, 450, 83);
		frmGradeLabInitial.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JButton btnGradeAnalyzer = new JButton("Grade Analyzer");
		btnGradeAnalyzer.setBounds(0, 0, 450, 29);
		btnGradeAnalyzer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frmGradeLabInitial.setVisible(false);
				GradeAnalyzerGUI gradeAnalyzer = new GradeAnalyzerGUI();
				gradeAnalyzer.frmGradeAnalyzer.setVisible(true);
			}
		});
		frmGradeLabInitial.getContentPane().setLayout(null);
		frmGradeLabInitial.getContentPane().add(btnGradeAnalyzer);
		
		JButton btnGpaCalculator = new JButton("GPA Calculator");
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


