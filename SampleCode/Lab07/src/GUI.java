import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class GUI {

	private JFrame frmRecursionLab;
	private JTextField txtNumInts;
	private JScrollPane scrollPane;
	private JList lstNums;
	private JLabel lblNumOutput;
	private JLabel lblIntRange;
	private JTextField txtRangeMin;
	private JLabel lblTo;
	private JTextField txtRangeMax;
	private JLabel lblSearchFor;
	private JTextField txtSearchFor;
	private JButton btnSearch;
	private JTextField txtSortTime;
	private JTextField txtSearchTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmRecursionLab.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRecursionLab = new JFrame();
		frmRecursionLab.setTitle("Recursion Lab");
		frmRecursionLab.setBounds(100, 100, 359, 465);
		frmRecursionLab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRecursionLab.getContentPane().setLayout(null);
		
		JLabel lblNumInts = new JLabel("# of Ints:");
		lblNumInts.setBounds(16, 20, 99, 16);
		frmRecursionLab.getContentPane().add(lblNumInts);
		
		txtNumInts = new JTextField();
		lblNumInts.setLabelFor(txtNumInts);
		txtNumInts.setBounds(77, 15, 273, 26);
		frmRecursionLab.getContentPane().add(txtNumInts);
		txtNumInts.setColumns(10);
		
		JButton btnGenerateNumbers = new JButton("Generate Ints");
		btnGenerateNumbers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateNumbers();
			}
		});
		btnGenerateNumbers.setBounds(16, 89, 334, 29);
		frmRecursionLab.getContentPane().add(btnGenerateNumbers);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 237, 157, 188);
		frmRecursionLab.getContentPane().add(scrollPane);
		
		lstNums = new JList();
		scrollPane.setColumnHeaderView(lstNums);
		
		lblNumOutput = new JLabel("# Output:");
		lblNumOutput.setLabelFor(lstNums);
		lblNumOutput.setBounds(16, 209, 61, 16);
		frmRecursionLab.getContentPane().add(lblNumOutput);
		
		lblIntRange = new JLabel("Int Range:");
		lblIntRange.setBounds(12, 48, 65, 16);
		frmRecursionLab.getContentPane().add(lblIntRange);
		
		txtRangeMin = new JTextField();
		lblIntRange.setLabelFor(txtRangeMin);
		txtRangeMin.setBounds(77, 43, 120, 26);
		frmRecursionLab.getContentPane().add(txtRangeMin);
		txtRangeMin.setColumns(10);
		
		lblTo = new JLabel("to");
		lblTo.setBounds(209, 48, 13, 16);
		frmRecursionLab.getContentPane().add(lblTo);
		
		txtRangeMax = new JTextField();
		lblTo.setLabelFor(txtRangeMax);
		txtRangeMax.setBounds(230, 43, 120, 26);
		frmRecursionLab.getContentPane().add(txtRangeMax);
		txtRangeMax.setColumns(10);
		
		lblSearchFor = new JLabel("Search For #:");
		lblSearchFor.setBounds(12, 171, 87, 16);
		frmRecursionLab.getContentPane().add(lblSearchFor);
		
		txtSearchFor = new JTextField();
		lblSearchFor.setLabelFor(txtSearchFor);
		txtSearchFor.setBounds(123, 166, 130, 26);
		frmRecursionLab.getContentPane().add(txtSearchFor);
		txtSearchFor.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(262, 166, 88, 29);
		frmRecursionLab.getContentPane().add(btnSearch);
		
		JPanel pnStatsPanel = new JPanel();
		pnStatsPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnStatsPanel.setBounds(185, 237, 157, 188);
		frmRecursionLab.getContentPane().add(pnStatsPanel);
		pnStatsPanel.setLayout(null);
		
		JLabel lblSortTime = new JLabel("Sort Time:");
		lblSortTime.setBounds(6, 6, 64, 16);
		lblSortTime.setHorizontalAlignment(SwingConstants.CENTER);
		pnStatsPanel.add(lblSortTime);
		
		txtSortTime = new JTextField();
		lblSortTime.setLabelFor(txtSortTime);
		txtSortTime.setEditable(false);
		txtSortTime.setBounds(6, 30, 130, 26);
		pnStatsPanel.add(txtSortTime);
		txtSortTime.setColumns(10);
		
		JLabel lblSearchTime = new JLabel("Search Time:");
		lblSearchTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchTime.setBounds(6, 98, 87, 16);
		pnStatsPanel.add(lblSearchTime);
		
		txtSearchTime = new JTextField();
		lblSearchTime.setLabelFor(txtSearchTime);
		txtSearchTime.setEditable(false);
		txtSearchTime.setBounds(6, 118, 130, 26);
		pnStatsPanel.add(txtSearchTime);
		txtSearchTime.setColumns(10);
		
		JLabel lblStats = new JLabel("Statistics:");
		lblStats.setBounds(192, 209, 79, 16);
		frmRecursionLab.getContentPane().add(lblStats);
	}
	
	private void generateNumbers() {
		int numOfInts = 0;
		Random rand = new Random();
		try {
			numOfInts = Integer.parseInt(txtNumInts.getText());
			if(numOfInts <= 0) {
				throw new NumberFormatException();
			}
		}
		catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Number of ints must be a valid positive number!");
		}
		
		Integer[] intArr = new Integer[numOfInts];
		for(int i = 0; i < intArr.length; i++) {
			intArr[i] = rand.nextInt(50)+1;
		}
		
		refreshNumbers(intArr);
		
	}
	
	private void refreshNumbers(Integer[] intArr) {
		lstNums.setListData(intArr);
		DefaultListCellRenderer renderer = (DefaultListCellRenderer)lstNums.getCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
	}
}
