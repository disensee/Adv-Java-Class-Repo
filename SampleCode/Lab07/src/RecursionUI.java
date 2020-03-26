import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class RecursionUI {

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
	int[] intArr;
	int minValue;
	int maxValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecursionUI window = new RecursionUI();
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
	public RecursionUI() {
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
		scrollPane.setViewportView(lstNums);
		
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
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lstNums.clearSelection();
				searchNumbers(); 
			}
		});
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
		txtSortTime.setEditable(false);
		lblSortTime.setLabelFor(txtSortTime);
		txtSortTime.setBounds(6, 30, 130, 26);
		pnStatsPanel.add(txtSortTime);
		txtSortTime.setColumns(10);
		
		JLabel lblSearchTime = new JLabel("Search Time:");
		lblSearchTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchTime.setBounds(6, 98, 87, 16);
		pnStatsPanel.add(lblSearchTime);
		
		txtSearchTime = new JTextField();
		txtSearchTime.setEditable(false);
		lblSearchTime.setLabelFor(txtSearchTime);
		txtSearchTime.setBounds(6, 118, 130, 26);
		pnStatsPanel.add(txtSearchTime);
		txtSearchTime.setColumns(10);
		
		JLabel lblStats = new JLabel("Statistics:");
		lblStats.setBounds(192, 209, 79, 16);
		frmRecursionLab.getContentPane().add(lblStats);
	}
	
	private void generateNumbers() {
		Random rand = new Random();
		try {
			int numOfInts = Integer.parseInt(txtNumInts.getText());
			minValue = Integer.parseInt(txtRangeMin.getText());
			maxValue = Integer.parseInt(txtRangeMax.getText());
			
			if(numOfInts <= 0 || txtNumInts.getText() == "" || numOfInts > Integer.MAX_VALUE) {
				txtNumInts.grabFocus();
				throw new NumberFormatException();
			}
			if(minValue <= 0 || minValue >= Integer.MAX_VALUE - 1 || minValue > maxValue || txtRangeMin.getText() == "") {
				txtRangeMin.grabFocus();
				throw new NumberFormatException();
			}
			if(maxValue >= Integer.MAX_VALUE || maxValue <= 0 || txtRangeMax.getText() == "") {
				txtRangeMax.grabFocus();
				throw new NumberFormatException();
			}
			
			intArr = new int[numOfInts];
			for(int i = 0; i < intArr.length; i++) {
				intArr[i] = rand.nextInt((maxValue - minValue) + 1) + minValue;
			}
			
			
			long startTime = System.currentTimeMillis();
			intArr = Recursion.mergeSort(intArr);
			long endTime = System.currentTimeMillis();
			
			txtSortTime.setText(Long.toString(endTime - startTime) + "ms");
			refreshNumbers(intArr);
			
			
		}
		catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "All fields must contain a valid positive 32 bit integer.\nMinimum range value must be less than the maximum range value.");
		}

	}
	
	private void refreshNumbers(int[] intArr) {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for(int i : intArr) {
		intList.add(i);
		}
		
		lstNums.setListData(intList.toArray());
		lstNums.setVisibleRowCount(intArr.length);
		DefaultListCellRenderer renderer = (DefaultListCellRenderer)lstNums.getCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
	}
	
	private void searchNumbers() {
		
		try {
			if(intArr == null) {
				throw new NullPointerException();
			}
			int searchValue = Integer.parseInt(txtSearchFor.getText());
			if(searchValue < minValue || searchValue > maxValue) {
				throw new RangeException();
			}
			
			long startTime = System.currentTimeMillis();
			lstNums.setSelectedIndex(Recursion.binarySearch(intArr, 0, intArr.length -1, searchValue));
			long endTime = System.currentTimeMillis();
			lstNums.ensureIndexIsVisible(lstNums.getSelectedIndex());
			
			txtSearchTime.setText(Long.toString(endTime - startTime) + "ms");
			
			if(lstNums.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "Search value does not exist in integer list!");
			}

		}
		catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Please enter a valid positive integer");
		}
		catch(NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "Please generate a list of integers.");
		}
		catch(RangeException re) {
			JOptionPane.showMessageDialog(null, "Please enter a number within the defined range");
		}
	}
}

